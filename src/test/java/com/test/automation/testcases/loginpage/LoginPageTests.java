package com.test.automation.testcases.loginpage;

import com.test.automation.listneners.ExtentTestManager;
import com.test.automation.testbase.ObjectRepoWE;
import com.test.automation.testbase.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/** @author Narendra Marbate */
public class LoginPageTests extends TestBase {

  /**
   * Test Name - Get Login Page, validate expected Webelement exist and perform login
   * Validate that user is able-
   * - Open the Login page of test site
   * - Validate all expected Webelements are exist on Login page
   * - Perform login and validate Log in is successful
   *
   * @param username
   * @param password
   * @throws Exception
   */
  @Test
  @Parameters({"username", "password"})
  public void loginWithValidCredentials(@Optional String username, @Optional String password)
      throws Exception {
    /* Set Test Message for test */
    ExtentTestManager.getTest()
        .setDescription(
            "Test Name - Get Login Page, validate expected Webelement exist and perform login");

    /* Initiate Login page action */
    PageFactory.initElements(driver, ObjectRepoWE.class);

    /* Get the Login page of test site and validate it opened successfully*/
    loginPageActions.getLoginPage();
    Assert.assertEquals("Swag Labs", driver.getTitle());

    /* Validate expected WebElemnt exist on page and perform enter username action */
    loginPageActions.enterUserName(username);

    /* Validate expected WebElemnt exist on page and perform enter password action */
    loginPageActions.enterPassword(password);

    /* Validate expected WebElemnt exist on page and perform submit action */
    loginPageActions.clickLoginButton();
  }
}
