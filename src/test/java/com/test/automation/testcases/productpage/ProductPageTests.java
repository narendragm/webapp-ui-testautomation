package com.test.automation.testcases.productpage;

import com.test.automation.listneners.ExtentTestManager;
import com.test.automation.pageaction.ProductPageActions;
import com.test.automation.testbase.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * @author Narendra Marbate
 */
public class ProductPageTests extends TestBase {

  /**
   * Test Name - Get Product Page, validate expected Webelement exist and perform add expected products to cart
   * - Validate that user is able get on Product page
   * - Validate all expected WebElements are present on Product page
   * - Perform adding expected products to cart
   * - Validate product successfully added to Cart
   */
  @Test(dependsOnMethods = "com.test.automation.testcases.loginpage.LoginPageTests.loginWithValidCredentials")
  public void addItemsOnProductPageToCart() throws Exception {
    /* Set Test Message for test */
    pushTestReportingNotification(
            "Test Name - Get Product Page, validate expected Webelement exist and perform add expected products to cart");

    /* Initiate Product page action */
    productPageActions = PageFactory.initElements(driver, ProductPageActions.class);

    /* Validate all expected WebElement present and expected Product is available */
    productPageActions.checkOnesieProductAvailable();

    /* Add expected product to Cart  */
    productPageActions.addOnesieToCart();

    /* Validate all expected WebElement present and second expected Product is available */
    productPageActions.checkBikeLightProductAvailable();

    /* Add expected product to Cart  */
    productPageActions.addBikeLightToCart();

    /* Validate Shopping Cart Badge */
    productPageActions.validateShoppingCartBadge();

    /* Check and Clik on Shopping Cart */
    productPageActions.checkAndClickShoppingCart();
  }
}
