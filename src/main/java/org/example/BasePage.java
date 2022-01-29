package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BasePage {
    public static WebDriver driver;

    //Browsers
    public String chromedriverPath = "tools/chromedriver/chromedriver.exe";
    public String firefoxdriverPath = "tools/geckodriver/geckodriver.exe";
    public String dataPath = "tools/data.properties";

    @BeforeTest
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
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("~~~~~~ FIREFOX ICIN TESTLER BAŞLADI ~~~~~");

        } else if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromedriverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("~~~~~~ CHROME ICIN TESTLER BAŞLADI ~~~~~");

        }
        return driver;
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
