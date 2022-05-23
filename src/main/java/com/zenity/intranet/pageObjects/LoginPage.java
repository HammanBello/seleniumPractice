package com.zenity.intranet.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    @FindBy(id = "email_login")
    private WebElement emailField;

    @FindBy(id = "password_login")
    private WebElement passwordField;

    @FindBy(id = "btn_login")
    private WebElement loginButton;

    public void goToLoginPage() {
        driver.get(ENV.getUrl("/auth/login"));
    }

    public void login(String email, String password) {
        sendKeysSlowly(emailField, email);
        sendKeysSlowly(passwordField, password);
        clickOn(loginButton);
    }

}
