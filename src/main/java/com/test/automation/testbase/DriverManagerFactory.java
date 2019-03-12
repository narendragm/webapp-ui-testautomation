package com.test.automation.testbase;

/**
 * @author Narendra Marbate
 *
 * Get the tyoe of Driver needed
 * Test in this projects are built only for Chrome driver
 */
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
