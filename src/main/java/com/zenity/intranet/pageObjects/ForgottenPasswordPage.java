package com.zenity.intranet.pageObjects;

import com.zenity.intranet.pageObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.ExecutionException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ForgottenPasswordPage extends Page {


    @FindBy(id = "email_reset_pass")
    private WebElement emailField;

    @FindBy(id = "reset_password")
    private WebElement passwordField;

    @FindBy(id = "btn_reset_password")
    private WebElement resetBtn;


    public void reset(String email, String password) {
        longUntil(ExpectedConditions.urlContains("resetPassword"));
        waitForLoadingPage();
        longUntil(ExpectedConditions.visibilityOfAllElements());
        sendKeysSlowly(emailField, email);
        sendKeysSlowly(passwordField, password);
    }

    public void emailFieldCompletion(String email) {
        sendKeysSlowly(emailField, email);
    }

    public void clickOnReset() {
        clickOn(resetBtn);
    }


    public boolean psswdErrorMsgVerification() {

        try {
            WebElement errorMsg = this.driver.findElement(By.cssSelector("#style_card__HeEtb > form > p"));
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }


}


