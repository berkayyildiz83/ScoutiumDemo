package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    By searchBar = By.cssSelector("input[placeholder='Futbolcu veya Kulüp Ara...']");
    By btnKesfet = By.xpath("(//button[@type='button'])[1]");

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement searchBar() {

        return wait.until(ExpectedConditions.elementToBeClickable(searchBar));
    }

    public WebElement btnKesfet() {
        return wait.until(ExpectedConditions.elementToBeClickable(btnKesfet));
    }

}
