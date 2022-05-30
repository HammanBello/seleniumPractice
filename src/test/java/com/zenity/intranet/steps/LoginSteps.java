package com.zenity.intranet.steps;

import com.zenity.intranet.pageObjects.ForgottenPasswordPage;
import com.zenity.intranet.pageObjects.HomePage;
import com.zenity.intranet.pageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

    private LoginPage loginPage;
    private HomePage homePage;

    private ForgottenPasswordPage forgottenPasswordPage;

    public LoginSteps(LoginPage loginPage, HomePage homePage, ForgottenPasswordPage forgottenPasswordPage) {
        this.homePage = homePage;
        this.loginPage = loginPage;
        this.forgottenPasswordPage = forgottenPasswordPage;
    }

    @Given("user is at the login page")
    public void userIsAtTheLoginPage() {
        loginPage.goToLoginPage();
    }

    @When("user is logging-in with {string} {string}")
    public void userIsLoggingInWithUsernamePassword(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("he should be at the home page")
    public void heShouldBeAtTheHomePage() {
        try{
            homePage.isZTrainLogoDisplayed();
            assertTrue(true );

        }catch (Exception e){
            System.out.println(e);
            assertTrue(false);
        }
        homePage.saveScreenShotPNG();
    }

    @Given("User is on homepage")
    public void userIsOnHomepage() {
        loginPage.goToLoginPage();
        loginPage.login("hambello30@gmail.com", "azertyuiop");
    }

    @And("The user fill the email's field with value {string}")
    public void theUserFillTheEmailSFieldWithValue(String email) {
        loginPage.emailFieldCompletion(email);
    }

    @When("the user clicks on the next field")
    public void theUserClicksOnTheNextField() {
        loginPage.clickOnPasswordfield();
    }

    @Then("An error appears to report invalid email syntax")
    public void anErrorAppearsToReportInvalidEmailSyntax() {
        assertTrue(loginPage.emailErrorMsgVerification());
    }

    @When("The user click on Google icon")
    public void theUserClickOnSocial_networkIcon() {
    loginPage.clickOnGoogleBtn();
    }

    @Then("The user is redirected to a Google Auth page where he types his google's {string} and {string}")
    public void theUserIsRedirectedToASocial_network(String email, String password) {
        loginPage.loginGoogleAuth(email,  password);
    }

    @And("The user click on \"mot de passe oublié\"")
    public void theUserClickOn() {
    loginPage.clickOnForgottenPasswd();
    }


    @And("The user fill the form with his an {string} and an invalid {string}")
    public void theUserFillTheFormWithHisAnAndAnInvalid(String email, String password) {
        forgottenPasswordPage.reset(email, password);
    }

    @When("The user click on \"Réinitialiser\" button")
    public void theUserClickOnButton() {
        forgottenPasswordPage.clickOnReset();
    }

    @Then("the message \"Le mot de passe doit avoir au moins 8 caractères\" is displayed")
    public void theMessageIsDisplayed() {
        forgottenPasswordPage.psswdErrorMsgVerification();
    }

}
