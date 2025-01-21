package com.solvd.carina.saucedemo.gui.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartItemList extends AbstractUIObject {

    @FindBy(className = "cart_item")
    private List<CartItem> itemList;

    public CartItemList(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isProductPresentByName(String name) {
        return itemList.stream()
                .anyMatch(cartItem -> name.equalsIgnoreCase(cartItem.getItemName()));
    }

    public List<CartItem> getAllItems() {
        return itemList;
    }
}
