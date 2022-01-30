package org.example;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(org.example.Listeners.class)
public class TestCase extends BasePage {

    @Test
    public void PlayerUnfollowValidation() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        PlayerDetail playerDetail = new PlayerDetail(driver);
        ShortListPage shortListPage = new ShortListPage(driver);


        landingPage.clubLogin().click();
        loginPage.emailLogin().click();
        loginPage.textEmail().clear();
        loginPage.textEmail().sendKeys("test@scoutium.com");
        loginPage.textPassword().sendKeys("654321");
        Thread.sleep(2000);
        loginPage.btnGirisYap().click();
        Thread.sleep(2000);
        homePage.searchBar().sendKeys("berkay yıldız");
        Thread.sleep(2000);
        homePage.btnKesfet().click();
        Thread.sleep(2000);
        searchResultPage.resultPlayer().click();
        Thread.sleep(2000);
        searchResultPage.switchWindowChild();
        Thread.sleep(2000);
        driver.get("https://scoutium.com/shortlist");
        //shortListPage.btnTakipListesi().click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://scoutium.com/shortlist");
        shortListPage.checkPlayersInList();
        homePage.btnKesfet().click();
        shortListPage.checkPlayerStatus();


    }
}
