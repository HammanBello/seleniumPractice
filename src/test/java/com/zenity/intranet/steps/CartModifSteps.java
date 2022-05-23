package com.zenity.intranet.steps;

import com.zenity.intranet.pageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.testng.AssertJUnit.assertTrue;

public class CartModifSteps {

    private HomePage homePage;

    public CartModifSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @And("remove all in cart")
    public void RemoveAllInCart() {
        homePage.removeAllInCart();
    }


    @And("click on the product")
    public void clickOnTheProduct() {
        homePage.clickOnArticle();
    }

    @And("click on the + button to increase the quantity of this product in the cart")
    public void clickOnTheButtonToIncreaseTheQuantityOfThisProductInTheCart() {
        homePage.clickOnPlusBtn();
    }

    @And("click on the add to cart button")
    public void clickOnTheAddToCartButton() {
        homePage.clickOnAddToCartBtn();
    }


    @And("click on the shopping cart button at the top right")
    public void clickOnTheShoppingCartButtonAtTheTopRight() {
        homePage.clickOnCartLogo();
    }

    @Then("we observe that the basket has been updated")
    public void weObserveThatTheBasketHasBeenUpdated() {
        assertTrue ( homePage.observeProductQty());
        homePage.saveScreenShotPNG();
    }

    @And("click on the delete button to delete the product in the cart")
    public void clickOnTheDeleteButtonToDeleteTheProductInTheCart() {
        homePage.removeOneInCart();
    }


    @Then("we observe in the list that the basket is modified, the product has been deleted")
    public void weObserveInTheListThatTheBasketIsModifiedTheProductHasBeenDeleted() {
        assertTrue ( homePage.observeProductDeletion());
        homePage.saveScreenShotPNG();
    }
}
