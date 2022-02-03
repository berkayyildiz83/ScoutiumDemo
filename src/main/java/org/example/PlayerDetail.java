package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class PlayerDetail {

    public WebDriver driver;
    WebDriverWait wait;

    By btnTakipEt = By.xpath("//span[contains(text(),'Takip Et')]");
    By btnTakipEdiliyor = By.xpath("//i[@class='unfollow-label']");

    public PlayerDetail(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void btnTakipEt() {
        Set<String> windows = driver.getWindowHandles(); //parent child ID
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnTakipEt)).isDisplayed();
            System.out.println("TEST PASSED");

        }
        catch (Exception e){
            wait.until(ExpectedConditions.elementToBeClickable(btnTakipEdiliyor)).isDisplayed();
            System.out.println("TEST FAILED");
        }
    }

}
