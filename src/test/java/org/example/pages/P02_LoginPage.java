package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_LoginPage {

    // POM using Page Factory
    public P02_LoginPage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(linkText = "Log in")
    public WebElement loginLink;

    @FindBy(id = "Email")
    public WebElement emailTextbox;

    @FindBy(id = "Password")
    public WebElement passwordTextbox;

    @FindBy(className = "login-button")
    public WebElement loginButton;

    @FindBy(linkText = "My account")
    public WebElement myAccountTab;

    @FindBy(className = "message-error validation-summary-errors")
    public WebElement errorMessage;
}
