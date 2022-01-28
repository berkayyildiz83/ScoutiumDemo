package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShortListPage {
    public WebDriver driver;

    By btnTakipListesi = By.xpath("//li[3]/a/span");

    public ShortListPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement btnTakipListesi() {

        return driver.findElement(btnTakipListesi);

    }

    public void urlKontrol() {

        String url2 = driver.getCurrentUrl();
    }

    public void checkPlayerInList() {
        String PlayerName = driver.findElement(By.cssSelector("//span[@class='player-name']")).getAttribute("span");
        System.out.println(PlayerName);
    }
}
