package com.zenity.intranet.steps;

import com.zenity.intranet.pageObjects.HomePage;
import com.zenity.intranet.pageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

    @When("User scroll to the bottom of the page")
    public void userScrollToTheBottomOfThePage() {
    homePage.scrollToBottomOfHomePage();
    }

    @Then("user have to see an article with a {float}")
    public void userHaveToSeeAnArticleWithA(float arg0) {
        assertTrue ( homePage.controlOfDotedPrices());
        homePage.saveScreenShotPNG();
    }

    @When("User click on a product")
    public void userClickOnAProduct() {
        homePage.clickOnArticle();
    }

    @Then("Spawn a popup on the page with description of the article and the exact price")
    public void spawnAPopupOnThePageWithDescriptionOfTheArticleAndTheExactPrice() {
        assertTrue ( homePage.observeProductPopUp());
        homePage.saveScreenShotPNG();
    }
}
