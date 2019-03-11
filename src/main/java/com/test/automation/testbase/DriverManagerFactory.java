package com.test.automation.testbase;

/** @author NarendraMarbate */
public class DriverManagerFactory {

  public static DriverManager getManager(DriverType type) {

    DriverManager driverManager;

    switch (type) {
      case CHROME:
        driverManager = new ChromeDriverManager();
        break;
      /*case FIREFOX:
        driverManager = new FireFoxDriverManager();
        break;*/
      default:
        driverManager = new ChromeDriverManager();
        break;
    }
    return driverManager;
  }
}
