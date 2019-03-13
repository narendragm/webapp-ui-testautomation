package com.test.automation.testutils;


import org.openqa.selenium.WebDriver;

public class ReusableFunctions {

  /**
   * Call this function to Captures screenshot wherever needed
   * @param ldriver
   */
  public static void captureScreenShot(WebDriver ldriver, String PageName) {
    /*String workingDir = System.getProperty("user.dir");
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
    }*/
  }
}
