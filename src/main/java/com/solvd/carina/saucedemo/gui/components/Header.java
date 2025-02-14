package com.solvd.carina.saucedemo.gui.components;

import com.solvd.carina.saucedemo.gui.pages.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(id = "shopping_cart_container")
    private ExtendedWebElement cartBtn;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPage openCart() {
        cartBtn.click();
        return new CartPage(driver);
    }
}
