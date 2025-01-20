package com.solvd.carina.saucedemo.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends AbstractPage {

    @FindBy(id = "finish")
    private ExtendedWebElement finishBtn;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage clickOnFinishBtn() {
        finishBtn.click();
        return new CheckoutCompletePage(driver);
    }
}
