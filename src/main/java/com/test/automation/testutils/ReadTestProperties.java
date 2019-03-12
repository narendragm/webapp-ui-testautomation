package com.test.automation.testutils;

import java.util.ResourceBundle;

/**
 * @author Narendra Marbate
 *
 * Acts as support util to read Properties file
 */
public class ReadTestProperties {

  public static ResourceBundle readResource(String filePath) {
    return ResourceBundle.getBundle(filePath);
  }

  public static String getPropertyValue(String propertyName, ResourceBundle resourceBundle) {
    String propertyValue = resourceBundle.getString(propertyName);
    return propertyValue;
  }
}
