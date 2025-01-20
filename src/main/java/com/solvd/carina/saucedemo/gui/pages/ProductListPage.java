package com.solvd.carina.saucedemo.gui.pages;

import com.solvd.carina.saucedemo.gui.components.Header;
import com.solvd.carina.saucedemo.gui.components.ProductCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListPage extends AbstractPage {

    @FindBy(id = "header_container")
    private Header header;

    @FindBy(className = "inventory_item")
    private List<ProductCard> productList;

    @FindBy(xpath = "//span[@data-test='title']")
    private ExtendedWebElement title;

    public ProductListPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    public List<ProductCard> getProductList() {
        return productList;
    }

    public Header getHeader() {
        return header;
    }
}
