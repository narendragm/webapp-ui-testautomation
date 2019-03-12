package com.test.automation.pageaction;

import com.test.automation.testbase.ObjectRepoWE;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author Narendra Marbate
 *
 * This class defines Product page page actions-
 * - Get on the Product page of test site
 * - Validate all expected Webelements are exist on Product page
 * - Validate expected products are available
 * - Add products to the Cart
 * - Validate product siccessfully added tot he Cart
 */
public class ProductPageActions {

  private WebDriver wedriver;

  public ProductPageActions(WebDriver webDriver){ this.wedriver = webDriver; }

  public void checkOnesieProductAvailable() {
    isProductAvailable(ObjectRepoWE.getOnesieDescriptionId(), "Sauce Labs Onesie");
  }

  public void addOnesieToCart() {
    addProductToCart(ObjectRepoWE.getOnesieAddToCartButton());
  }

  public void checkBikeLightProductAvailable() {
    isProductAvailable(ObjectRepoWE.getBikeLightDescriptionId(), "Sauce Labs Bike Light");
  }

  public void addBikeLightToCart() {
    addProductToCart(ObjectRepoWE.getBikeLightAddToCartButton());
  }

  public void isProductAvailable(WebElement webElement, String productName) {
    if (webElement.isDisplayed()) {
      System.out.println("Desc Available " + webElement.getAttribute("innerText"));
      Assert.assertEquals(productName, webElement.getAttribute("innerText"));
    } else System.out.println(productName + " is not Available");
  }

  public void addProductToCart(WebElement webElement) {
    if (webElement.isDisplayed() && webElement.isEnabled()) {
      webElement.click();
    } else System.out.println("Not able to add product to cart");
  }

  public void checkAndClickShoppingCart() {
    if (ObjectRepoWE.getShoppingCartId().isDisplayed() && ObjectRepoWE.getShoppingCartId().isEnabled()) {
      ObjectRepoWE.getShoppingCartId().click();
    } else System.out.println("Not able to click shopping cart");
  }

  public void validateShoppingCartBadge() {
    if (ObjectRepoWE.getShoppingCartBadgeId().isDisplayed()
        && ObjectRepoWE.getShoppingCartBadgeId().isEnabled()) {
      System.out.println("shopping Cart Badge is available");
    } else System.out.println("shopping Cart Badge is not available");
  }
}
