package com.solvd.carina.saucedemo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractUIObject {

    @FindBy(className = "inventory_item_name")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//button[text()='Add to cart']")
    private ExtendedWebElement addToCartBtn;

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName(){
        return productName.getText();
    }

    public void clickOnAddToCart(){
        addToCartBtn.click();
    }
}
