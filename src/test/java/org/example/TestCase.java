package org.example;

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
        /*WebElement BY = driver.findElement(By.xpath("(//span[contains(text(),'Berkay Yıldız')])[1]"));
        Assert.assertEquals("Berkay Yıldız", "Berkay" );*/
        Thread.sleep(2000);
        sp.switchWindow();
        sp.closeWindow();
        slp.btnTakipListesi().click();
        slp.urlKontrol();
        Assert.assertEquals("url2", "https://scoutium.com/shortlist");
        slp.checkPlayerInList();
        pd.checkTakip();
        pd.btnTakipEt().click();

    }

    @AfterTest
    public void teardown() {
        //driver.quit();
    }
}
