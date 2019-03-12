package com.test.automation.testbase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;


/**
 * @author Narendra Marbate
 *
 * Acts as WebElement Repository and elements are retrieved by Getter methods
 */
public class ObjectRepoWE {

  /* WebElement Object Repo Login Page  */
  @FindBy(id = "user-name")
  @CacheLookup
  private static WebElement userNameTxtBox;

  @FindBy(id = "password")
  @CacheLookup
  private static WebElement passwordwordTxtBox;

  @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/input[3]")
  @CacheLookup
  private static WebElement loginButton;

  @FindBy(xpath = "//*[@id=\"header_container\"]/div[1]")
  @CacheLookup
  private static WebElement headerTextOnProductPage;

  /* WebElement Object Repo Product Page  */

  @FindBy(xpath = " //*[@id=\"item_2_title_link\"]/div")
  @CacheLookup
  private static WebElement onesieDescriptionId;

  @FindBy(xpath = " //*[@id=\"item_0_title_link\"]/div")
  @CacheLookup
  private static WebElement bikeLightDescriptionId;

  @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[5]/div[3]/button")
  @CacheLookup
  private static WebElement onesieAddToCartButton;

  @FindBy(xpath = "//*[@id='item_0_title_link']/following::button[@class='add-to-cart-button']")
  @CacheLookup
  private static WebElement bikeLightAddToCartButton;

  @FindBy(xpath = " //*[@id=\"shopping_cart_container\"]")
  @CacheLookup
  private static WebElement shoppingCartId;

  @FindBy(xpath = "//*['@id=shopping_cart_container']/a/span")
  @CacheLookup
  private static WebElement shoppingCartBadgeId;

  /* WebElement Object Repo Cart Page  */
  @FindBy(xpath = "//*[@id=\"contents_wrapper\"]/div[2]/text()")
  @CacheLookup
  private static WebElement cartPageSubtitle;

  @FindAll(@FindBy(xpath = ".//*[@class='inventory_item_name']"))
  @CacheLookup
  private static List<WebElement> elementName;

  public static WebElement getUserNameTxtBox() {
    return userNameTxtBox;
  }

  public static WebElement getPasswordwordTxtBox() {
    return passwordwordTxtBox;
  }

  public static WebElement getLoginButton() {
    return loginButton;
  }

  public static WebElement getHeaderTextOnProductPage() {
    return headerTextOnProductPage;
  }

  public static WebElement getOnesieDescriptionId() {
    return onesieDescriptionId;
  }

  public static WebElement getBikeLightDescriptionId() {
    return bikeLightDescriptionId;
  }

  public static WebElement getOnesieAddToCartButton() {
    return onesieAddToCartButton;
  }

  public static WebElement getBikeLightAddToCartButton() {
    return bikeLightAddToCartButton;
  }

  public static WebElement getShoppingCartId() {
    return shoppingCartId;
  }

  public static WebElement getShoppingCartBadgeId() {
    return shoppingCartBadgeId;
  }

  public static WebElement getCartPageSubtitle() {
    return cartPageSubtitle;
  }

  public static List<WebElement> getElementName() {
    return elementName;
  }
}
