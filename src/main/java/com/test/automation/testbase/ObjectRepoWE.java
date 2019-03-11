package com.test.automation.testbase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ObjectRepoWE { 

    /* WebElement Object Repo Login Page  */
    @FindBy(id = "user-name")
    @CacheLookup
    public static  WebElement userNameTxtBox;

    @FindBy(id = "password")
    @CacheLookup
    public static  WebElement passwordwordTxtBox;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/input[3]")
    @CacheLookup
    public static  WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[1]")
    @CacheLookup
    public static  WebElement headerTextOnProductPage;

    /* WebElement Object Repo Product Page  */

    @FindBy(xpath = " //*[@id=\"item_2_title_link\"]/div")
    @CacheLookup
    public static  WebElement onesieDescriptionId;

    @FindBy(xpath = " //*[@id=\"item_0_title_link\"]/div")
    @CacheLookup
    public static  WebElement bikeLightDescriptionId;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[5]/div[3]/button")
    @CacheLookup
    public static  WebElement onesieAddToCartButton;

    @FindBy(xpath = "//*[@id='item_0_title_link']/following::button[@class='add-to-cart-button']")
    @CacheLookup
    public static  WebElement bikeLightAddToCartButton;

    @FindBy(xpath = " //*[@id=\"shopping_cart_container\"]")
    @CacheLookup
    public static  WebElement shoppingCartId;

    @FindBy(xpath = "//*['@id=shopping_cart_container']/a/span")
    @CacheLookup
    public static  WebElement shoppingCartBadgeId;

    /* WebElement Object Repo Cart Page  */
    @FindBy(xpath = "//*[@id=\"contents_wrapper\"]/div[2]/text()")
    @CacheLookup
    public static WebElement cartPageSubtitle;

    @FindAll(@FindBy(xpath = ".//*[@class='inventory_item_name']"))
    @CacheLookup
    public static List<WebElement> elementName;
}
