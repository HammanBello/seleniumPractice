package com.zenity.intranet.steps;

import com.zenity.intranet.pageObjects.HomePage;
import com.zenity.intranet.pageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.testng.AssertJUnit.assertTrue;

public class CommandSteps {

    private LoginPage loginPage;
    private HomePage homePage;

    public CommandSteps(LoginPage loginPage, HomePage homePage) {
        this.loginPage = loginPage;
        this.homePage = homePage;
    }

    @And("User clicks on button \"Commander\"")
    public void userClicksOnButton() {
        homePage.clickOnCommandButton();
    
    }

    @Then("The order validation pop-up should appear")
    public void theOrderValidationPopUpShouldAppear() {
        assertTrue ( homePage.observeOrderPopUp());
        homePage.saveScreenShotPNG();
    }
}
