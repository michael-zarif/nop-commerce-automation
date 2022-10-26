package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class D03_CurrenciesStepDef {
    P03_HomePage homePage = new P03_HomePage();

    @Given("User go to home page")
    public void userGoToHomePage() {}

    @When("User selects {string} currency")
    public void userSelectsCurrency(String currency) {
        Select currencySelectList = new Select(homePage.currencySelectList);
        currencySelectList.selectByVisibleText(currency);
    }

    @Then("Price Labels currency is changed to {string}")
    public void priceLabelsCurrencyIsChangedTo(String arg0) {
        List<WebElement> priceLabels = homePage.priceLabels;
        for (WebElement priceLabel : priceLabels) {
            Assert.assertTrue(priceLabel.getText().contains("€"));
        }
    }
}
