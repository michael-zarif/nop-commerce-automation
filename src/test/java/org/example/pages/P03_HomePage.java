package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_HomePage {

    // POM using Page Factory
    public P03_HomePage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(id = "customerCurrency")
    public WebElement currencySelectList;

    @FindBy(className = "price actual-price")
    public List<WebElement> priceLabels;

    @FindBy(id = "small-searchterms")
    public WebElement searchTextbox;

    @FindBy(className = "button-1 search-box-button")
    public WebElement searchButton;

}
