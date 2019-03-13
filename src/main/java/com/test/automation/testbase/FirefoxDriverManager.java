package com.test.automation.testbase;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class FirefoxDriverManager extends DriverManager {

  @Override
  public void startService() {
    File file = new File(TestBase.getDriverPath(DriverType.FIREFOX.getValue()));
    file.setExecutable(true);
    System.setProperty(
        "webdriver.gecko.driver", file.toString());
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
