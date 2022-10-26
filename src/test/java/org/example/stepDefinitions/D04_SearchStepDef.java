package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.example.pages.P04_SearchPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_SearchStepDef {
    P03_HomePage homePage = new P03_HomePage();
    P04_SearchPage searchPage = new P04_SearchPage();

//    @Given("User go to home page")
//    public void userGoToHomePage(){ }

    @When("User searches for {string}")
    public void userSearchesFor(String product) {
        homePage.searchTextbox.sendKeys(product);
        homePage.searchButton.click();
    }

    @When("User opens product page")
    public void userOpensProductPage() {
        searchPage.productLink.click();
    }

    @Then("User is navigated to {string} search results page")
    public void userIsNavigatedToSearchResultsPage(String product) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="), "Search failed");
        softAssert.assertTrue(searchPage.searchItems.size() > 0);
        for (WebElement searchItem : searchPage.searchItems) {
            softAssert.assertTrue(searchItem.getText().toLowerCase().contains(product));
        }
        softAssert.assertAll();
    }

    @Then("User finds the {string} keyword in the product page")
    public void userFindsTheKeywordInTheProductPage(String product) {
        Assert.assertTrue(searchPage.productSku.getText().contains(product), "Search result is incorrect");
    }
}
