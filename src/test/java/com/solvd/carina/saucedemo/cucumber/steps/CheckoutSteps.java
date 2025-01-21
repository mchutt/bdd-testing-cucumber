package com.solvd.carina.saucedemo.cucumber.steps;

import com.solvd.carina.saucedemo.gui.components.CartItem;
import com.solvd.carina.saucedemo.gui.pages.*;
import com.solvd.carina.saucedemo.models.User;
import com.solvd.carina.saucedemo.models.UserOrder;
import com.solvd.carina.saucedemo.utils.ConnectionFactory;
import com.zebrunner.carina.cucumber.CucumberRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutSteps extends CucumberRunner {

    public static final int USER_ID = 1;
    private User user;
    private ProductListPage productListPage;
    private CheckoutCompletePage checkoutCompletePage;
    private LoginPage loginPage;
    private List<String> productNames;

    @Given("I am on login page")
    public void iAmOnLoginPage() {
        loginPage = new LoginPage(getDriver());
        loginPage.open();
    }

    @When("I log in with credentials from database")
    public void iLogInWithCredentialsFromDatabase() {
        user = getUserById(USER_ID);
        productListPage = loginPage.login(user.getUsername(), user.getPassword());
    }

    @Then("Product list page is opened")
    public void productListPageIsOpened() {
        Assert.assertTrue(productListPage.isPageOpened(), "Product list page is not opened!");
    }

    @When("I make order and proceed to checkout")
    public void iMakeOrderAndProceedToCheckout() {
        user.getUserOrderList()
                .forEach(userOrder -> productListPage.addProductToCart(userOrder.getProductName()));
        checkoutCompletePage = productListPage.getHeader().openCart()
                .clickOnCheckoutBtn()
                    .typeFirstName(user.getFirstName())
                    .typeLastName(user.getLastName())
                    .typePostalCode(user.getZipCode())
                .clickContinue()
                .clickOnFinishBtn();
    }

    @Then("I have successful order notification")
    public void iHaveSuccessfulOrderNotification() {
        Assert.assertTrue(checkoutCompletePage.isSuccessMessageVisible(), "Success message is not visible!");
    }

    // Second scenario
    @When("I log in as {int} user")
    public void iLogInAsUserIdUser(int userId) {
        user = getUserById(userId);
        productListPage = loginPage.login(user.getUsername(), user.getPassword());
    }

    @When("I add several products to cart")
    public void iAddProductToCart() {
        productNames = user.getUserOrderList().stream().map(UserOrder::getProductName).collect(Collectors.toList());
        productNames.forEach(productName -> productListPage.addProductToCart(productName));
    }

    @Then("I have products in my cart in my cart")
    public void iHaveProductsInMyCart() {
        List<String> itemNames = productListPage.getHeader().openCart().getAllItems()
                .stream()
                .map(CartItem::getItemName)
                .collect(Collectors.toList());
        Assert.assertEquals(itemNames, productNames, "Products are not present in my cart!");
    }

    // Helper methods
    protected User getUserById(int id) {
        return ConnectionFactory.getUserMapper().findById(id);
    }

}
