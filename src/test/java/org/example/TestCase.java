package org.example;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCase extends BasePage {

    @BeforeTest
    public void initialize() throws Throwable {
        driver = InitializeDriver();
    }

    @Test
    public void TestCase() throws Throwable {


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
        Thread.sleep(2000);
        lop.btnGirisYap().click();
        Thread.sleep(2000);
        hp.searchBar().sendKeys("berkay yıldız");
        hp.btnKesfet().click();
        Thread.sleep(2000);
        sp.resultPlayer().click();
        Thread.sleep(2000);
        sp.switchWindowChild();
        Thread.sleep(2000);
        driver.get("https://scoutium.com/shortlist");
        Assert.assertEquals(driver.getCurrentUrl(), "https://scoutium.com/shortlist");
        slp.checkPlayersInList();


    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
