package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;

    //Browsers
    public String chromedriverPath = "tools/chromedriver/chromedriver.exe";
    public String firefoxdriverPath = "tools/geckodriver/geckodriver.exe";
    public String dataPath = "tools/data.properties";


    public WebDriver InitializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
                dataPath);
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", firefoxdriverPath);
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("~~~~~~ FIREFOX ICIN TESTLER BAŞLADI ~~~~~");

        } else if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromedriverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("url");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("~~~~~~ CHROME ICIN TESTLER BAŞLADI ~~~~~");

        }
        return driver;


    }

    public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        String destFile = System.getProperty("user.dir") + "\\tools\\Screenshots\\" + testCaseName+".png ";
        FileUtils.copyFile(screenshot, new File(destFile));
        return destFile;

    }
}

