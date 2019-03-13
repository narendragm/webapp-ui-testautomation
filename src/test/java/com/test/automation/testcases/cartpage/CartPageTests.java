package com.test.automation.testcases.cartpage;

import com.test.automation.pageaction.CartPageActions;
import com.test.automation.testbase.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Narendra Marbate
 */
public class CartPageTests extends TestBase {

  /**
   * Test Name - Get Cart Page, validate expected Webelement exist and validate product added to the are correct one
   * - Validate that user is able get on Cart page
   * - Validate all expected WebElements are present on Cart page
   * - Validate product added to the Cart are present in the Cart
   */
  @Test(dependsOnMethods = {"com.test.automation.testcases.loginpage.LoginPageTests.loginWithValidCredentials",
          "com.test.automation.testcases.productpage.ProductPageTests.addItemsOnProductPageToCart"})
  public void validateItemsInCart() throws Exception {
    /* Set Test Message for test */
    pushTestReportingNotification(
            "Test Name - Get Cart Page, validate expected Webelement exist and validate product added to the are correct one");
    /* Initiate Login page action */
    CartPageActions cartPage = PageFactory.initElements(driver, CartPageActions.class);

    /* Verify products added to the Cart are correct */
    if (cartPage.verifyItemsInCart("Sauce Labs Onesie")) {
      System.out.println("Sauce Labs Onesie is available in cart");
    } else {
      Assert.fail("Expected item not found in Cart");
    }
    if (cartPage.verifyItemsInCart("Sauce Labs Bike Light")) {
      System.out.println("Sauce Labs Bike Light is  available in cart");
    } else {
      Assert.fail("Expected item not found in Cart");
    }
  }
}
