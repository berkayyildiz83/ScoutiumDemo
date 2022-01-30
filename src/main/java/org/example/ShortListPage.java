package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShortListPage {

    public WebDriver driver;
    WebDriverWait wait;

    By btnTakipListesi = By.cssSelector("a[href='/shortlist']");

    public ShortListPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement btnTakipListesi() {
        return driver.findElement(btnTakipListesi);
    }


    public void checkPlayersInList() {

        HomePage hp = new HomePage(driver);

        List<WebElement> values = driver.findElements(By.xpath("//tbody/tr/td/div/div/span[1]"));

        for (int i = 0; i < values.size(); i++) {
            if (values.size() == 0) {
                System.out.println("Takip Listesinde futbolcu mevcut değildir.");
            } else {
                System.out.println(values.get(i).getText() + " Futbolcusu Takip Listesinden silinmiştir.");
                String deletedPlayer = values.get(i).getText();
                driver.findElement(By.cssSelector("button[class='remove-shortlist v-btn theme--light']")).click();
                hp.searchBar().clear();
                hp.searchBar().sendKeys(deletedPlayer);


            }
        }

    }

    public void checkPlayerStatus() {

        List<WebElement> names = driver.findElements(By.xpath("//tbody/tr"));

        for (int a = 0; a < names.size(); a++) {
            String pNames = names.get(a).getText();
            String pName = driver.findElement(By.cssSelector("span[class='player-name']")).getText();

            if (pNames.equalsIgnoreCase(pName)) {
                driver.findElement(By.cssSelector("span[class='player-name']")).click();

                break;

            }
        }
    }


}
