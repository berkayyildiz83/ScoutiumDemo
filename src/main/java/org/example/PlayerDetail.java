package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlayerDetail {

    public WebDriver driver;
    WebDriverWait wait;

    By btnTakipEt = By.xpath("//span[contains(text(),'Takip Et')]");
    By btnTakipEdiliyor = By.xpath("//i[@class='unfollow-label']");

    public PlayerDetail(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement btnTakipEt() {
        return driver.findElement(btnTakipEt);
    }

}
