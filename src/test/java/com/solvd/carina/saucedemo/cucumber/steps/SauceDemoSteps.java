package com.solvd.carina.saucedemo.cucumber.steps;

import com.solvd.carina.saucedemo.gui.pages.LoginPage;
import com.solvd.carina.saucedemo.gui.pages.ProductListPage;
import com.zebrunner.carina.cucumber.CucumberRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SauceDemoSteps extends CucumberRunner {

    private LoginPage loginPage;
    private ProductListPage productListPage;

    @Given("I am on login page")
    public boolean i_am_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
        loginPage = new LoginPage(getDriver());
        loginPage.open();
        return loginPage.isPageOpened();
    }
    @When("I login with {string} and {string} credentials")
    public void i_login_with_and(String username, String pass) {
        loginPage.isPageOpened();
        productListPage = loginPage.login(username, pass);
        Assert.assertTrue(productListPage.isPageOpened());

    }
    @Then("page {string} should be open")
    public void page_should_be_open(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(productListPage.isPageOpened());
    }


}
