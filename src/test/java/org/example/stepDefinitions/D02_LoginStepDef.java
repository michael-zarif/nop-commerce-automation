package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_LoginPage;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_LoginStepDef {
    P02_LoginPage loginPage = new P02_LoginPage();

    @Given("User go to login page")
    public void userGoToLoginPage() {
        loginPage.loginLink.click();
    }

    @When("User login with valid email {string} and password {string}")
    public void userLoginWithValidEmailAndPassword(String email, String password) {
        loginPage.emailTextbox.sendKeys(email);
        loginPage.passwordTextbox.sendKeys(password);
    }

    @When("User press on login button")
    public void userPressOnLoginButton() {
        loginPage.loginButton.click();
    }

    @Then("User login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert softAssert = new SoftAssert(); // using soft assertion
        String actualCurrentUrl = Hooks.driver.getCurrentUrl();
        softAssert.assertEquals(actualCurrentUrl, "https://demo.nopcommerce.com/", "Login was not successful");
        softAssert.assertTrue(loginPage.myAccountTab.isDisplayed(), "My account tab isn't displayed");
        softAssert.assertAll();
    }

    @When("User login with invalid {string} and {string}")
    public void userLoginWithAnd(String email, String password) {
        loginPage.emailTextbox.sendKeys(email);
        loginPage.passwordTextbox.sendKeys(password);
    }

    @Then("User could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        var validationMessageColor = loginPage.errorMessage.getCssValue("color"); // gets RGBA color
        validationMessageColor = Color.fromString(validationMessageColor).asHex(); // converts RGBA to Hex
        SoftAssert softAssert = new SoftAssert(); // using soft assertion
        softAssert.assertTrue(loginPage.errorMessage.getText().contains("Login was unsuccessful."), "No validation found");
        softAssert.assertEquals(validationMessageColor, "#e4434b", "Validation message color is not correct");
        softAssert.assertAll();
    }
}
