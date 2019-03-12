package com.test.automation.testbase;

import org.openqa.selenium.WebDriver;

/** @author Narendra Marbate
 * Managing driver actions
 */
public abstract class DriverManager {

  protected WebDriver driver;

  protected abstract void startService();

  protected abstract void stopService();

  protected abstract void createDriver();

  public void quitDriver() {
    if (null != driver) {
      driver.quit();
      driver = null;
    }
  }

  public WebDriver getDriver() {
    if (null == driver) {
      startService();
      createDriver();
    }
    return driver;
  }
}
