package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P04_SearchPage {

    // POM using Page Factory
    public P04_SearchPage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(className = "item-box")
    public List<WebElement> searchItems;

    @FindBy(css = "*[class='product-title']>a")
    public WebElement productLink;

    @FindBy(css = "div[class='sku']>span[class='value']")
    public WebElement productSku;
}
