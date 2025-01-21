package com.solvd.carina.saucedemo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItem extends AbstractUIObject {

    @FindBy(className = "inventory_item_name")
    private ExtendedWebElement itemName;

    @FindBy(xpath = ".//button[text()='Remove']")
    private ExtendedWebElement removeBtn;

    @FindBy(className = "inventory_item_price")
    private ExtendedWebElement itemPrice;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public void removeFromCart() {
        removeBtn.click();
    }

    public Double getPrice() {
        return Double.parseDouble(itemPrice.getText().substring(1));
    }
}
