package com.zenity.intranet.pageObjects;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zenity.intranet.driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class HomePage extends Page {

    @FindBy(css = "nav h1")
    private WebElement ztrain_logo;
    @FindBy(css = "#style_popular_product_wrapper__z6J0h > div:nth-child(1) > div.style_card_body__QuFGN")
    private WebElement firsTArticle;
    @FindBy(css = "#style_card_wrapper__hrc1I > div > div.style_trash_product_cart__7Yzni")
    private WebElement deleteBtn;
    @FindBy (css = "#style_quantity_wrapper__2QMug > button:nth-child(3)")
    private WebElement plusBtn;
    @FindBy (id = "style_btn_add_cart__gTXM7")
    private WebElement addToCartButton;
    @FindBy (id = "style_content_cart_wrapper__mqNbf")
    private WebElement cartLogo;
    @FindBy (css = "#style_card_wrapper__hrc1I > div:nth-child(1) > div.style_quantity_wrapper__EFj5M > span.style_quantity__qJbQ3")
    private WebElement productQty;
    @FindBy (css = "#style_empty_cart_wrapper__23a1z > p")
    private WebElement emptyMsg;
    @FindBy (css = "#style_content_cart_wrapper__mqNbf > span")
    private WebElement cartBadge;


    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isZTrainLogoDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(this.ztrain_logo));
        return this.ztrain_logo.isDisplayed();
    }

    public void clickOnArticle() {
        clickOn(firsTArticle);
    }

    public void clickOnPlusBtn() {
        clickOn(plusBtn);
    }

    public void clickOnAddToCartBtn() {
        mediumUntil(visibilityOf(productQty));
        clickOn(addToCartButton);
    }
    public void clickOnCartLogo() {
        mediumUntil(visibilityOf(cartLogo));
        clickOn(cartLogo);
    }
    public Boolean observeProductQty() {
         mediumUntil(visibilityOf(productQty));
         if (productQty.getText().equals("2"))
         {
             System.out.println(productQty.getText());
             return true;
             }
        System.out.println(productQty.getText());
         return false;
    }

    public Boolean observeProductDeletion() {
        mediumUntil(visibilityOf(productQty));
        if (emptyMsg.getText().equals("Votre panier est vide"))
        {
            System.out.println(emptyMsg.getText());
            return true;
        }
        System.out.println(emptyMsg.getText());
        return false;
    }
    public void removeAllInCart() {
        longUntil(ExpectedConditions.urlContains("home"));
        waitForLoadingPage();
        longUntil(ExpectedConditions.visibilityOfAllElements());
        System.out.println(cartBadge.getText()+"iciiiiiiiiiiiiiiiiiiii");
        if (!cartBadge.getText().equals("0"))
        {
            System.out.println(cartBadge.getText()+"icoooooooooooooooooooooooo");
            mediumUntil(visibilityOf(cartLogo));
            clickOn(cartLogo);
            mediumUntil(visibilityOf(cartBadge));
            WebElement btnViderCart = this.driver.findElement(By.id("style_btn_trash_cart__ttfo9"));
            clickOn(btnViderCart);
            System.out.println(btnViderCart.getText());
        }
    }
    public void removeOneInCart() {
        WebElement btnDeleteAnElt = this.driver.findElement(By.cssSelector("#style_card_wrapper__hrc1I>div>div.style_trash_product_cart__7Yzni"));
        longUntil(ExpectedConditions.visibilityOf(btnDeleteAnElt));
            mediumUntil(visibilityOf(btnDeleteAnElt));
            clickOn(btnDeleteAnElt);
            System.out.println(btnDeleteAnElt.getText());

    }

}
