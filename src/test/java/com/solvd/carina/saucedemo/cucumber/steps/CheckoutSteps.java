package com.solvd.carina.saucedemo.cucumber.steps;

import com.solvd.carina.saucedemo.gui.components.ProductCard;
import com.solvd.carina.saucedemo.gui.pages.*;
import com.solvd.carina.saucedemo.models.User;
import com.solvd.carina.saucedemo.utils.ConnectionFactory;
import com.zebrunner.carina.cucumber.CucumberRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Optional;

public class CheckoutSteps extends CucumberRunner {

    private LoginPage loginPage;
    private ProductListPage productListPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;
    private User user;

    @Given("I am on login page {int}")
    public void iAmOnLoginPage(int id) {
        user = getUserById(id);
        loginPage = new LoginPage(getDriver());
        loginPage.open();
    }

    @When("I fill in my username and password as credentials")
    public void iFillInMyUsernameAndPasswordAsCredentials() {
        loginPage.isPageOpened();
        productListPage = loginPage.login(user.getUsername(), user.getPassword());
        Assert.assertTrue(productListPage.isPageOpened());
    }

    @When("I add the products to the cart")
    public void iAddTheProductsToTheCart() {
        user.getUserOrderList()
                .forEach(userOrder -> addProductToCart(userOrder.getProductName()));
    }

    @When("I open cart page and click on checkout button")
    public void iOpenCartPageAndClickOnCheckoutButton() {
        checkoutPage = productListPage.getHeader()
                .openCart()
                .clickOnCheckoutBtn();
    }

    @When("I fill in my first name last name and zipCode and click on continue button")
    public void iFillInMyFirstNameLastNameAndZipCodeAndClickOnContinueButton() {
        checkoutOverviewPage = checkoutPage.typeFirstName(user.getFirstName())
                .typeLastName(user.getLastName())
                .typePostalCode(user.getZipCode())
                .clickContinue();
    }

    @When("I click on finish button")
    public void iClickOnFinishButton() {
        checkoutCompletePage = checkoutOverviewPage.clickOnFinishBtn();
    }

    @Then("A success message should be visible")
    public void aSuccessMessageShouldBeVisible() {
        Assert.assertTrue(checkoutCompletePage.isSuccessMessageVisible(),
                "Success message is not visible");
    }

    //helper methods
    private void addProductToCart(String name) {
        Optional<ProductCard> first = productListPage.getProductList().stream()
                .filter(productCard ->
                        name.equalsIgnoreCase(productCard.getProductName())
                )
                .findFirst();
        if (first.isPresent()) {
            first.get().clickOnAddToCart();
        } else throw new IllegalArgumentException("Product not found: " + name);
    }

    private User getUserById(int id) {
        return ConnectionFactory.getUserMapper().findById(id);
    }
}
