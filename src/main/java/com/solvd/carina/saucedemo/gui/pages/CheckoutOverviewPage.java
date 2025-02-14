package com.solvd.carina.saucedemo.gui.pages;

import com.solvd.carina.saucedemo.gui.components.CartItemList;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends AbstractPage {

    @FindBy(className = "cart_list")
    private CartItemList cartItemList;

    @FindBy(className = "summary_subtotal_label")
    private ExtendedWebElement subTotal;

    @FindBy(id = "finish")
    private ExtendedWebElement finishBtn;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage clickOnFinishBtn() {
        finishBtn.click();
        return new CheckoutCompletePage(driver);
    }

    public Double getSubTotal() {
        return Double.parseDouble(subTotal.getText().substring(13));
    }

    public CartItemList getCartItemList() {
        return cartItemList;
    }
}
