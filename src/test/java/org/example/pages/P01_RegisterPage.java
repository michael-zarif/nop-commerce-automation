package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_RegisterPage {

    // POM using Page Factory
    public P01_RegisterPage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(linkText = "Register")
    public WebElement registerLink;

    @FindBy(id = "gender-male")
    public WebElement genderMaleRadioButton;

    @FindBy(id = "FirstName")
    public WebElement firstNameTextBox;

    @FindBy(id = "LastName")
    public WebElement lastNameTextBox;

    @FindBy(name = "DateOfBirthDay")
    public WebElement dateOfBirthDay;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement dateOfBirthMonth;

    @FindBy(name = "DateOfBirthYear")
    public WebElement dateOfBirthYear;

    @FindBy(id = "Email")
    public WebElement emailTextBox;

    @FindBy(id = "Password")
    public WebElement passwordTextBox;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPasswordTextBox;

    @FindBy(id = "register-button")
    public WebElement registerButton;

    @FindBy(className = "result")
    public WebElement registerMessage;
}
