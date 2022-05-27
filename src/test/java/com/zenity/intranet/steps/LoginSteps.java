package com.zenity.intranet.steps;

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

    public LoginSteps(LoginPage loginPage, HomePage homePage) {
        this.homePage = homePage;
        this.loginPage = loginPage;
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
        assertTrue(homePage.isZTrainLogoDisplayed(), "This is not the passage");
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

    @When("The user click on <social_network> icon")
    public void theUserClickOnSocial_networkIcon() {
    }
}
