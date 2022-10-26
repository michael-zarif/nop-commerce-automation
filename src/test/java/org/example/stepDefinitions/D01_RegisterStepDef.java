package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_RegisterPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_RegisterStepDef {
    P01_RegisterPage registerPage = new P01_RegisterPage();

    @Given("User go to register page")
    public void registerWithValidData(){ registerPage.registerLink.click(); }

    @When("User selects gender type")
    public void userSelectGenderType() { registerPage.genderMaleRadioButton.click(); }

    @When("User enters first name {string} and last name {string}")
    public void userEntersFirstNameAndLastName(String firstName, String lastName) {
        registerPage.firstNameTextBox.sendKeys(firstName);
        registerPage.lastNameTextBox.sendKeys(lastName);
    }

    @When("User enters date of birth {string} {string} {string}")
    public void userEntersDateOfBirth(String day, String month, String year) {
        Select dateOfBirthDay = new Select(registerPage.dateOfBirthDay);
        Select dateOfBirthMonth = new Select(registerPage.dateOfBirthMonth);
        Select dateOfBirthYear = new Select(registerPage.dateOfBirthYear);
        dateOfBirthDay.selectByVisibleText(day);
        dateOfBirthMonth.selectByVisibleText(month);
        dateOfBirthYear.selectByVisibleText(year);
    }

    @When("User enters email {string}")
    public void userEntersEmail(String email) {
        registerPage.emailTextBox.sendKeys(email);
    }

    @When("User fills Password fields {string}")
    public void userFillsPasswordFields(String password) {
        registerPage.passwordTextBox.sendKeys(password);
        registerPage.confirmPasswordTextBox.sendKeys(password);
    }

    @When("User clicks on register button")
    public void userClicksOnRegisterButton() { registerPage.registerButton.click(); }

    @Then("Successful registration message {string} is displayed")
    public void successfulRegistrationMessageIsDisplayed(String expectedRegisterMessage) {
        SoftAssert softAssert = new SoftAssert(); // using soft assertion
        String actualRegisterMessage = registerPage.registerMessage.getText();
        String actualRegisterMessageColor = registerPage.registerMessage.getCssValue("color");
        softAssert.assertTrue(actualRegisterMessage.contains(expectedRegisterMessage), "Registration not complete");
        softAssert.assertEquals(actualRegisterMessageColor, "rgba(76, 177, 124, 1)", "Registration message color isn't correct");
        softAssert.assertAll();
    }
}
