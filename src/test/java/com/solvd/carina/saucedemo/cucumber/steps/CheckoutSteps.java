package com.solvd.carina.saucedemo.cucumber.steps;

import com.solvd.carina.saucedemo.gui.components.CartItem;
import com.solvd.carina.saucedemo.gui.enums.SortType;
import com.solvd.carina.saucedemo.models.UserOrder;
import com.solvd.carina.saucedemo.services.UserService;
import com.solvd.carina.saucedemo.gui.pages.*;
import com.solvd.carina.saucedemo.models.User;
import com.solvd.carina.saucedemo.utils.ISortingHelper;
import com.zebrunner.carina.cucumber.CucumberRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutSteps extends CucumberRunner implements ISortingHelper {

    public static final int USER_ID = 1;
    private User user;
    private LoginPage loginPage;
    private ProductListPage productListPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;
    private final UserService userService = new UserService();

    @Given("I am on login page")
    public void amOnLoginPage() {
        loginPage = new LoginPage(getDriver());
        loginPage.open();
    }

    @When("I log in with credentials from database")
    public void logInWithCredentialsFromDatabase() {
        user = userService.getUserById(USER_ID);
        productListPage = loginPage.login(user.getUsername(), user.getPassword());
    }

    @Then("Product list page is opened")
    public void productListPageIsOpened() {
        Assert.assertTrue(productListPage.isPageOpened(), "Product list page is not opened!");
    }

    @When("I make order")
    public void makeOrder() {
        checkoutCompletePage = proceedToCheckout(user).clickOnFinishBtn();
    }

    @Then("I have successful order notification")
    public void haveSuccessfulOrderNotification() {
        Assert.assertTrue(checkoutCompletePage.isSuccessMessageVisible(), "Success message is not visible!");
    }


    //2
    @When("I log in as {int} user")
    public void logInAsUserIdUser(int userId) {
        user = userService.getUserById(userId);
        productListPage = loginPage.login(user.getUsername(), user.getPassword());
    }

    @When("I proceed to checkout")
    public void proceedToCheckout() {
        checkoutOverviewPage = proceedToCheckout(user);
    }

    @Then("I have correct total price")
    public void haveCorrectTotalPrice() {
        double totalPriceBeforeTax = checkoutOverviewPage.getCartItemList().getAllItems().stream()
                .mapToDouble(CartItem::getPrice)
                .reduce(0, Double::sum);
        Assert.assertEquals(totalPriceBeforeTax, checkoutOverviewPage.getSubTotal(), "Total price does not match");
    }


    //3
    @When("I add product to cart")
    public void addProductToCart() {
        productListPage.addProductToCart(user.getFirstOrder().getProductName());
    }

    @Then("I have a product in my cart")
    public void haveAProductInMyCart() {
        boolean isPresent = productListPage.getHeader().openCart().getCartItemList()
                .isProductPresentByName(user.getFirstOrder().getProductName());
        Assert.assertTrue(isPresent, "Product is not present in my cart!");
    }


    //4
    @When("I sort the products by price")
    public void sortTheProductsByPrice() {
        productListPage.openFilterComponent().sortBy(SortType.PRICE_LOW_TO_HIGH);
    }

    @Then("I verify product sorting correctly")
    public void verifyProductSortingCorrectly() {
        boolean isProductListSorted = isProductListSorted(productListPage.getProductList(), SortType.PRICE_LOW_TO_HIGH);
        Assert.assertTrue(isProductListSorted, "Product list is not sorted by price in ascending order");
    }


    // Helper methods
    private void addProductsToCart(List<String> list) {
        list.forEach(p -> productListPage.addProductToCart(p));
    }

    private List<String> extractProductNames(List<UserOrder> list) {
        return list.stream().map(UserOrder::getProductName).collect(Collectors.toList());
    }

    private CheckoutOverviewPage proceedToCheckout(User user) {
        addProductsToCart(extractProductNames(user.getUserOrderList()));
        return productListPage.getHeader().openCart()
                .clickOnCheckoutBtn()
                .typeFirstName(user.getFirstName())
                .typeLastName(user.getLastName())
                .typePostalCode(user.getZipCode())
                .clickContinue();
    }

}
