package com.zenity.intranet.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.ExecutionException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends Page {

    @FindBy(css = "#__next > div > main > div.style_col_2__kzyDS > div > button")
    private WebElement googleBtn;
    @FindBy(id = "email_login")
    private WebElement emailField;

    @FindBy(css = "#style_content_form__yXJox > a")
    private WebElement forgotPaswwdLink;
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

    public void emailFieldCompletion(String email) {
        sendKeysSlowly(emailField, email);
    }

    public void clickOnPasswordfield() {
        clickOn(passwordField);
    }

    public void clickOnGoogleBtn() {
        clickOn(googleBtn);
    }

    public void clickOnForgottenPasswd() {
        clickOn(forgotPaswwdLink);
    }

    public boolean emailErrorMsgVerification() {

        try{
            WebElement errorMsg = this.driver.findElement(By.cssSelector("#style_content_form__yXJox > p"));
            System.out.println(errorMsg.getText());
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean observeGoogleAuth() {
        mediumUntil(visibilityOf(googleBtn));
        if (googleBtn.getText().equals("4"))
        {
            System.out.println(googleBtn.getText());
            return true;
        }
        System.out.println(googleBtn.getText());
        return false;
    }


}
