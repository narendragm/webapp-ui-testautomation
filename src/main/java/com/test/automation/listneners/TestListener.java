package com.test.automation.listneners;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.testbase.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestBase implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    /* Before starting all tests, below method runs. */
    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("On Start method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
    }

    /*After ending all tests, below method runs.*/
    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("On Finish method " + iTestContext.getName());
        /*Do tier down operations for extentreports reporting!*/
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On TestStart method " +  getTestMethodName(iTestResult) + " start");
        /*Start operation for extentreports.*/
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("On TestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
        /*Extentreports log operation for passed tests.*/
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On TestFailure method " +  getTestMethodName(iTestResult) + " failed");

        /*Get driver from TestBase and assign to local webdriver variable.*/
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((TestBase) testClass).getDriver();

        /*Take base64Screenshot screenshot.*/
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
                getScreenshotAs(OutputType.BASE64);

        /*Extentreports log and screenshot operations for failed tests.*/
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On TestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
        /*Extentreports log operation for skipped tests.*/
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
