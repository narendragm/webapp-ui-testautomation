package com.test.automation.testbase;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

  @Override
  public void startService() {
    System.setProperty(
        "webdriver.gecko.driver", TestBase.getDriverPath(DriverType.FIREFOX.getValue()));
  }

  @Override
  public void stopService() {
    driver.quit();
    driver = null;
  }

  @Override
  public void createDriver() {
    driver = new FirefoxDriver();
  }
}
