package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {

    public WebDriver driver;
    WebDriverWait wait;

    By clubLogin = By.cssSelector("div[class='header__login']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement clubLogin() {
        return driver.findElement(clubLogin);

    }
}

