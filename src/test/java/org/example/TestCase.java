package org.example;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(org.example.Listeners.class)
public class TestCase extends BasePage {

    @Test
    public void PlayerUnfollowValidation() throws InterruptedException {

        LandingPage lp = new LandingPage(driver);
        LoginPage lop = new LoginPage(driver);
        HomePage hp = new HomePage(driver);
        SearchResultPage sp = new SearchResultPage(driver);
        PlayerDetail pd = new PlayerDetail(driver);
        ShortListPage slp = new ShortListPage(driver);
        Actions act = new Actions(driver);

        lp.clubLogin().click();
        lop.emailLogin().click();
        lop.textEmail().clear();
        lop.textEmail().sendKeys("test@scoutium.com");
        lop.textPassword().sendKeys("654321");
        lop.btnGirisYap().click();
        hp.searchBar().sendKeys("berkay yıldız");
        hp.btnKesfet().click();
        sp.resultPlayer().click();
        sp.switchWindowChild();
        slp.btnTakipListesi().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://scoutium.com/shortlist");
        slp.checkPlayersInList();

    }

}
