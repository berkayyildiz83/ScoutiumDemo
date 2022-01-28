package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;
    By clubLogin = By.cssSelector("div[class='header__login']");

    public LandingPage(WebDriver driver) {
        this.driver=driver;
    }

    public void HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clubLogin() {
        return driver.findElement(clubLogin);

    }
}

