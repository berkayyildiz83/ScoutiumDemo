package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;
    WebDriverWait wait;

    By emailLogin = By.xpath("//span[contains(text(),'Want to login by e-mail.')]");
    By textEmail = By.cssSelector("input[type='email']");
    By textPassword = By.xpath("//input[@type='password']");
    By btnGirisYap = By.xpath("//form/div/div[4]/button/div");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement emailLogin() {

        return driver.findElement(emailLogin);
    }

    public WebElement textEmail() {

        return driver.findElement(textEmail);
    }

    public WebElement textPassword() {

        return driver.findElement(textPassword);
    }

    public WebElement btnGirisYap() {

        return wait.until(ExpectedConditions.elementToBeClickable(btnGirisYap));

    }
}
