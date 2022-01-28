package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebDriver driver;
    By searchBar = By.cssSelector("input[placeholder='Futbolcu veya Kulüp Ara...']");
    By btnKesfet = By.xpath("(//button[@type='button'])[1]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement searchBar() {

        return driver.findElement(searchBar);
    }

    public WebElement btnKesfet() {

        return driver.findElement(btnKesfet);
    }

}
