package com.zenity.intranet.steps;

import com.zenity.intranet.pageObjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;

public class RegistrationStep {
    public RegistrationStep(RegisterPage registerPage) {
        this.registerPage = registerPage;
    }

    RegisterPage registerPage;

    @Given("The user is on Registration page")
    public void theUserIsOnSignUpPage() {
        registerPage.goToRegisterPage();
    }

    @And("The user fill {string}, {string} fields")
    public void theUserFillFields(String email, String password) {
        registerPage.registerButNoPsswdConfirm(email, password);
    }

    @And("the user leaves the \"confirmation password\" field blank")
    public void theUserLeavesTheFieldBlank() {
    }

    @When("The user click on \"Inscription\" button")
    public void theUserClickOnButton() {
        registerPage.clickOnRegister();

    }

    @Then("user receives error message due to empty confirm password field")
    public void userReceivesErrorMessageDueToEmptyConfirmPasswordField() {
        assertTrue(registerPage.emailErrorMsgVerification());
    }

    @And("enter an {string}, {string} and confirm password")
    public void enterAnAndConfirmPassword(String email , String password) {
        registerPage.register(email, password);
    }

    @Then("The user is not redirected to the Home Page")
    public void theUserIsNotRedirectedToTheHomePage() {
        assertTrue(registerPage.notHomePageVerification());
    }

    @And("The message \"email must be an email password must be longer than or equal to 8 characters\" is displayed")
    public void theMessageIsDisplayed() {

    }
}
