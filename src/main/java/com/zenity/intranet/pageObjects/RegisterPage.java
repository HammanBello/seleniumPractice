package com.zenity.intranet.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class RegisterPage extends Page{

    @FindBy(css = "nav h1")
    private WebElement ztrain_logo;
    @FindBy (id = "password_register")
    private WebElement passwordField;

    @FindBy (id = "confirm_password_register")
    private WebElement passwordConfirmField;

    @FindBy (id = "email_register")
    private WebElement emailField;

    @FindBy (id = "btn_register")
    private WebElement registerButton;


    public void goToRegisterPage() {
        driver.get(ENV.getUrl("/auth/register"));
    }

    public void register(String email, String password) {
        sendKeysSlowly(emailField, email);
        sendKeysSlowly(passwordField, password);
        sendKeysSlowly(passwordConfirmField, password);
    }
    public void registerButNoPsswdConfirm(String email, String password) {
        sendKeysSlowly(emailField, email);
        sendKeysSlowly(passwordField, password);
    }

    public boolean notHomePageVerification() {
        String S = driver.getCurrentUrl();
        if (!S.equals("https://ztrain-web.vercel.app/auth/home"))
            return true;
        else
            return false;

    }

    public void clickOnRegister() {
        clickOn(registerButton);
    }


    public boolean emailErrorMsgVerification() {

        try{
            WebElement errorMsg = this.driver.findElement(By.cssSelector("#style_content_form__yXJox > p:nth-child(3)"));
            System.out.println(errorMsg.getText());
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }



    public String getTitle() {
        return driver.getTitle();
    }

}


