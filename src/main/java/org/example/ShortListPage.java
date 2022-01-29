package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShortListPage extends HomePage{
    public WebDriver driver;

    By btnTakipListesi = By.cssSelector("a[href='/shortlist']");

    public ShortListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement btnTakipListesi() {

        return driver.findElement(btnTakipListesi);

    }

    public void checkPlayersInList() throws InterruptedException {
        List<WebElement> values=driver.findElements(By.xpath("//tbody/tr/td/div/div/span[1]"));


        for(int i=0;i<values.size();i++){
            if(values.size() == 0) {
                System.out.println("Takip Listesinde futbolcu mevcut değildir.");
            }
            else {
                System.out.println(values.get(i).getText() + "Futbolcusu Takip Listesinden silinmiştir.");
                String deletedPlayer = values.get(i).getText();
                driver.findElement(By.cssSelector("button[class='remove-shortlist v-btn theme--light']")).click();
                searchBar().clear();
                searchBar().sendKeys(deletedPlayer);
                btnKesfet().click();
                Thread.sleep(5000);
            }
        }





    }
}
