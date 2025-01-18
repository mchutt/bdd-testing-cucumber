package com.solvd.carina.saucedemo.gui.pages;

import com.solvd.carina.saucedemo.gui.components.ProductComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListPage extends AbstractPage {

    @FindBy(className = "inventory_item")
    private List<ProductComponent> productList;

    @FindBy(xpath = "//span[@data-test='title']")
    private ExtendedWebElement title;

    public ProductListPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    public List<ProductComponent> getProductList() {
        return productList;
    }

}
