package com.test.automation.testutils;

import java.util.ResourceBundle;

public class ReadTestProperties {

  public static ResourceBundle readResource(String filePath) {
    return ResourceBundle.getBundle(filePath);
  }

  public static String getPropertyValue(String propertyName, ResourceBundle resourceBundle) {
    String propertyValue = resourceBundle.getString(propertyName);
    return propertyValue;
  }
}
