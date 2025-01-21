package com.solvd.carina.saucedemo.gui.pages;

import com.solvd.carina.saucedemo.gui.components.CartItemList;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(className = "cart_list")
    private CartItemList cartItemList;

    @FindBy(id = "checkout")
    private ExtendedWebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage clickOnCheckoutBtn() {
        checkoutBtn.click();
        return new CheckoutPage(driver);
    }

    public CartItemList getCartItemList() {
        return cartItemList;
    }

}
