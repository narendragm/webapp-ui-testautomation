package com.test.automation.testbase;

/**
 * @author Narendra Marbate
 *
 * Driver type emun
 */
public enum DriverType {
  CHROME("chrome"),
  FIREFOX("firefox"),
  IE("ie"),
  SAFARI("safari");

  private String value;

  DriverType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
