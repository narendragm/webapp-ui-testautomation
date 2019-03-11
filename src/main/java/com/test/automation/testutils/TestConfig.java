package com.test.automation.testutils;

public enum TestConfig {
  OR_REPO_PATH("OR_Properties_File_Path"),
  CHROME_DRIVER_LOCATION("Chrome_Driver_Path"),
  TEST_CONFIG_PROPERTIES_FILE("test_config");

  private String value;

  TestConfig(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
