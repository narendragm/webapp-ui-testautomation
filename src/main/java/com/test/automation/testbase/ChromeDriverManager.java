package com.test.automation.testbase;

import com.test.automation.testutils.TestConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/** @author Narendra Marbate
 * Initializing Chrome Driver by doing lookup at right Driver location
 */
public class ChromeDriverManager extends DriverManager {

  private ChromeDriverService chromeDriverService;

  @Override
  public void startService() {
    File file = new File( TestBase.getDriverPath(DriverType.CHROME.toString()));
    file.setExecutable(true);
    if (null == chromeDriverService) {
      try {
        chromeDriverService =
            new ChromeDriverService.Builder()
                .usingDriverExecutable(file)
                .usingAnyFreePort()
                .build();
        chromeDriverService.start();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void stopService() {
    if (null != chromeDriverService && chromeDriverService.isRunning()) {
      chromeDriverService.stop();
      chromeDriverService = null;
    }
  }

  @Override
  public void createDriver() {
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("test-type", "allow-outdated-plugins");
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    driver = new ChromeDriver(chromeDriverService, options);
  }
}
