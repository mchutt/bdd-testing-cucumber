package com.solvd.carina.saucedemo.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {

    @FindBy(id = "first-name")
    private ExtendedWebElement firstNameInput;

    @FindBy(id = "last-name")
    private ExtendedWebElement lastNameInput;

    @FindBy(id = "postal-code")
    private ExtendedWebElement postalCodeInput;

    @FindBy(id = "continue")
    private ExtendedWebElement continueBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage typeFirstName(String firstName) {
        firstNameInput.type(firstName);
        return this;
    }

    public CheckoutPage typeLastName(String lastName) {
        lastNameInput.type(lastName);
        return this;
    }

    public CheckoutPage typePostalCode(String postalCode) {
        postalCodeInput.type(postalCode);
        return this;
    }

    public CheckoutOverviewPage clickContinue() {
        continueBtn.click();
        return new CheckoutOverviewPage(getDriver());
    }
}
