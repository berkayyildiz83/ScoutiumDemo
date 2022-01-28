package org.example;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

import static jdk.jfr.internal.handlers.EventHandler.timestamp;

public class Listeners implements ITestListener {

    public WebDriver driver;
    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        protected void failed(Throwable e, Description description) {
            File screenshot = new File("C:\\Users\\BKY\\IdeaProjects\\ScoutiumDemo\\tools\\Screenshots" + timestamp() + ".png");
            File scrFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            driver.quit();
    }
}
