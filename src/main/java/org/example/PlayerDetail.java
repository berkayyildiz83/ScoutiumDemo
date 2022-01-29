package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlayerDetail {
    public WebDriver driver;
    By btnTakipEt = By.xpath("//span[contains(text(),'Takip Et')]");
    By btnTakipEdiliyor = By.xpath("//i[@class='unfollow-label']");

    public PlayerDetail(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement btnTakipEt() {

        return driver.findElement(btnTakipEt);

    }


}
