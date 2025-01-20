package com.solvd.carina.saucedemo.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends AbstractPage {

    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    private ExtendedWebElement successMessage;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessMessageVisible() {
        return successMessage.isVisible();
    }
}
