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
        loginPage.btnGirisYap().click();
        homePage.searchBar().sendKeys("berkay yıldız");
        homePage.btnKesfet().click();
        searchResultPage.resultPlayer().click();
        searchResultPage.switchWindowChild();
        shortListPage.btnTakipListesi().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://scoutium.com/shortlist");
        shortListPage.checkPlayersInList();

    }

}
