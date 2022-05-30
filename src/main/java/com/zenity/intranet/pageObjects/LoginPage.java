package com.zenity.intranet.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

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

    public void loginGoogleAuth(String email, String password) {

        String parent=driver.getWindowHandle();
        Set<String> s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();

        while(I1.hasNext()) {

            String child_window = I1.next();


            if (!parent.equals(child_window)) {
                shortUntil(ExpectedConditions.urlContains("home"));
                waitForLoadingPage();
                shortUntil(ExpectedConditions.visibilityOfAllElements());
                driver.switchTo().window(child_window);

                System.out.println(driver.switchTo().window(child_window).getTitle()+"est le nom de la nouvelle fenetre");
                WebElement emailfield = this.driver.findElement(By.id("identifierId"));
                sendKeysSlowly(emailfield,email);
                WebElement nextBtn = this.driver.findElement(By.cssSelector("#identifierNext > div > button"));
                clickOn(nextBtn);
                shortWait.until(visibilityOfAllElements());
                WebElement passwordField = this.driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input"));
                sendKeysSlowly(passwordField,password);
                clickOn(nextBtn);
                driver.switchTo().window(parent);
            }
        }





        driver.switchTo().window(parent);


    }


}
