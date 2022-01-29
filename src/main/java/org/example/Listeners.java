package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BasePage implements ITestListener {

    public WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = null;
        String testMethodName = result.getMethod().getMethodName();
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {

        }
        try {
            getScreenshotPath(testMethodName, driver);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
