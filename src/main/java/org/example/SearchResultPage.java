package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class SearchResultPage {
    public WebDriver driver;
    By resultPlayer = By.xpath("(//span[contains(text(),'Berkay Yıldız')])[1]");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement resultPlayer() {

        return driver.findElement(resultPlayer);
    }

    public void switchWindowChild() throws InterruptedException {
        Set<String> windows = driver.getWindowHandles(); //parent child ID
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        Thread.sleep(2000);
        try {
            driver.findElement(By.cssSelector("span[class='unfollow-button-text-container']")).isDisplayed();
        } catch (Exception e) {
            driver.findElement(By.xpath("//span[contains(text(),'Takip Et')]")).click();
        }

        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(parentId);
    }

}
