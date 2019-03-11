package com.test.automation.testutils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ReusableFunctions {

  /**
   * Just call this method to get screenshot when ever you want
   *
   * @param ldriver
   */
  public static void captureScreenShot(WebDriver ldriver, String PageName) {
    String workingDir = System.getProperty("user.dir");
    File src = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
    try {

      FileUtils.copyFile(
          src,
          new File(
                  workingDir+"\\src\\test\\resources\\screenshot\\"
                  + PageName
                  + "_"
                  + System.currentTimeMillis()
                  + ".png"));
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
