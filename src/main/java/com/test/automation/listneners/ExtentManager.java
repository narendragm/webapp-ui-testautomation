package com.test.automation.listneners;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * @author Narendra Marbate
 *
 * Setting up HTML reporting path
 */
public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
      extent =
          new ExtentReports(
              workingDir + "\\src\\test\\resources\\testreports\\ExtentReportResults.html", true);
        }
        return extent;
    }
}
