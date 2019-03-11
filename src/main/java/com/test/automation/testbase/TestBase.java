package com.test.automation.testbase;

import com.test.automation.pageaction.LoginPageActions;
import com.test.automation.pageaction.ProductPageActions;
import com.test.automation.testutils.ReadTestProperties;
import com.test.automation.testutils.ReusableFunctions;
import com.test.automation.testutils.TestConfig;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/** @author NarendraMarbate */
public class TestBase {

  public static final ResourceBundle TEST_PROPERTIES =
      ReadTestProperties.readResource(TestConfig.TEST_CONFIG_PROPERTIES_FILE.getValue());

  public static final ResourceBundle OR =
          ReadTestProperties.readResource(TEST_PROPERTIES.getString(TestConfig.OR_REPO_PATH.getValue()));

  public static final String TEST_SITE_URL = TEST_PROPERTIES.getString("Test_Site_URL");

  public static LoginPageActions loginPageActions;

  public static ProductPageActions productPageActions;

  public static DriverManager driverManager;

  public static WebDriver driver;

  @BeforeTest
  public void beforeTest() {
    driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    Reporter.log("DriverManager Initialized....", true);
    loginPageActions = new LoginPageActions(driverManager.getDriver());
    productPageActions = new ProductPageActions(driverManager.getDriver());
  }

  @BeforeMethod
  public void beforeMethod() {
    driver = driverManager.getDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    System.out.println(" beforeMethod() ");
  }

  @AfterMethod
  public void afterMethod(Method method, ITestResult result) {
    System.out.println(" afterMethod() ");
    if (ITestResult.SUCCESS == result.getStatus())
      ReusableFunctions.captureScreenShot(driver, method.getName());
  }

  @AfterTest
  public void afterTest() {
    System.out.println(" afterMethod() ");
    //ReusableFunctions.captureScreenShot(driver,result.getMethod().getMethodName());
    driverManager.quitDriver();
  }

    public WebDriver getDriver() {
        return driver;
    }
}
