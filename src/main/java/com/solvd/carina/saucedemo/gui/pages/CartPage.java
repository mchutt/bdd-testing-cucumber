package com.solvd.carina.saucedemo.gui.pages;

import com.solvd.carina.saucedemo.gui.components.CartItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(className = "cart_item")
    private List<CartItem> itemList;

    @FindBy(id = "checkout")
    private ExtendedWebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<CartItem> getAllItems() {
        return itemList;
    }

    public CheckoutPage clickOnCheckoutBtn() {
        checkoutBtn.click();
        return new CheckoutPage(driver);
    }

}
