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

    public void switchWindow() {
        Set<String> windows = driver.getWindowHandles(); //parent child ID
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

    }

    public void closeWindow(){
        driver.close();
    }
}
