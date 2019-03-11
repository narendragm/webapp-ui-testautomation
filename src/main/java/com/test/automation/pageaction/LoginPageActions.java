package com.test.automation.pageaction;

import com.test.automation.testbase.ObjectRepoWE;
import com.test.automation.testbase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Narendra Marbate
 * This class defines Login page actions-
 * - Open the Login page of test site
 * - Validate all expected Webelements are exist on Login page
 * - Perform login and validate Log in is successful
 */
public class LoginPageActions {
  WebDriver driver;

  public LoginPageActions(WebDriver driver) {
    this.driver = driver;
  }

  public void enterUserName(String username) {
    if (username == null) {
      setUserNameTxtBox(TestBase.TEST_PROPERTIES.getString("username"));
    } else {
      setUserNameTxtBox(username);
    }
  }

  public void setUserNameTxtBox(String username) {
    if (ObjectRepoWE.userNameTxtBox.isDisplayed()) {
      Assert.assertEquals("Username", ObjectRepoWE.userNameTxtBox.getAttribute("placeholder"));
      ObjectRepoWE.userNameTxtBox.sendKeys(username);
    } else System.out.println("username Text box is not Available ");
  }

  public void enterPassword(String password) {
    if (password == null) {
      setPasswordwordTxtBox(TestBase.TEST_PROPERTIES.getString("password"));
    } else {
      setPasswordwordTxtBox(password);
    }
  }

  public void setPasswordwordTxtBox(String password) {
    if (ObjectRepoWE.passwordwordTxtBox.isDisplayed()) {
      Assert.assertEquals("Password", ObjectRepoWE.passwordwordTxtBox.getAttribute("placeholder"));
      ObjectRepoWE.passwordwordTxtBox.sendKeys(password);
    } else System.out.println("username Text box is not Available ");
  }

  public void clickLoginButton() {
    if (ObjectRepoWE.loginButton.isDisplayed() && ObjectRepoWE.loginButton.isEnabled()) ObjectRepoWE.loginButton.click();
    else System.out.println("Login button not Working");
    Assert.assertEquals("Swag Labs", ObjectRepoWE.headerTextOnProductPage.getAttribute("innerText"));
  }

  public void getLoginPage() {
    driver.get(TestBase.TEST_SITE_URL);
    Assert.assertEquals("Swag Labs", driver.getTitle());
  }
}
