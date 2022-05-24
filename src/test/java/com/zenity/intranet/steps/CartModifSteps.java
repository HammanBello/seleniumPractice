package com.zenity.intranet.steps;

import com.zenity.intranet.pageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertTrue;

public class CartModifSteps {
    float total=0;

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

    @When("User clicks on the basket icon of the products \"first product 1\", \"first product 2\", \"first product 3\" to add to the basket")
    public void userClicksOnTheBasketIconOfTheProductsToAddToTheBasket() {
 total = homePage.clickOnMultipleArticleCartLogo();

    }

    @Then("User should see the sum total of the prices of the items in the cart")
    public void userShouldSeeTheSumTotalOfThePricesOfTheItemsInTheCart() {
        homePage.observeProductTotalPrice(total);
    }
}
