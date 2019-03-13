package com.test.automation.testbase;

import com.test.automation.listneners.ExtentTestManager;
import com.test.automation.listneners.TestListener;
import com.test.automation.pageaction.LoginPageActions;
import com.test.automation.pageaction.ProductPageActions;
import com.test.automation.testutils.ReadTestProperties;
import com.test.automation.testutils.ReusableFunctions;
import com.test.automation.testutils.TestConfig;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
/**
 * @author Narendra Marbate
 *
 * Forms the base for test.
 * All initiations, Before, After methods, etc ate defined here
 */

@Listeners(TestListener.class )
public class TestBase {

  public static final ResourceBundle TEST_PROPERTIES =
      ReadTestProperties.readResource(TestConfig.TEST_CONFIG_PROPERTIES_FILE.getValue());

  public static final String TEST_SITE_URL = TEST_PROPERTIES.getString("Test_Site_URL");

  public static LoginPageActions loginPageActions;

  public static ProductPageActions productPageActions;

  public static DriverManager driverManager;

  public static WebDriver driver;

  @BeforeTest
  public void beforeTest() {
    driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
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
    //driverManager.quitDriver();
  }

  @AfterSuite
  public void afterSuite(){
    driverManager.stopService();
  }

    public WebDriver getDriver() {
        return driver;
    }

  public static void pushTestReportingNotification(String testObjectiveMessage){
    ExtentTestManager.getTest().setDescription(testObjectiveMessage);
  }

  public static String getDriverPath(String driverName){
    switch (driverName) {
      case "CHROME":
        driverName =
            System.getProperty("user.dir")
                + TestBase.TEST_PROPERTIES.getString(TestConfig.CHROME_DRIVER_LOCATION.getValue());
        driverName +=
            System.getProperty("os.name").toLowerCase().contains("windows")
                ? "chromedriver.exe"
                : "chromedriver";
        return driverName;

      case "firefox":
        driverName =
                System.getProperty("user.dir")
                        + TestBase.TEST_PROPERTIES.getString(TestConfig.CHROME_DRIVER_LOCATION.getValue());
        driverName +=
                System.getProperty("os.name").toLowerCase().contains("windows")
                        ? "geckodriver.exe"
                        : "geckodriver";
        return driverName;
      default:
        Reporter.log("No driver available for expected driver name", true);
        return null;
    }
  }
}
