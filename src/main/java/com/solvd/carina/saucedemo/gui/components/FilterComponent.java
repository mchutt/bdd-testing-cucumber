package com.solvd.carina.saucedemo.gui.components;

import com.solvd.carina.saucedemo.gui.enums.SortType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterComponent extends AbstractUIObject {

    @FindBy(xpath = "//option[@value='%s']")
    private ExtendedWebElement sortItemBy;

    public FilterComponent(WebDriver driver) {
        super(driver);
    }

    public void sortBy(SortType sortType){
        sortItemBy.format(sortType.getValue()).click();
    }

}
