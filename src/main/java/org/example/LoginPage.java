package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;
    By emailLogin = By.xpath("//span[contains(text(),'E-Posta ile giriş yapmak istiyorum.')]");
    By textEmail = By.cssSelector("input[type='email']");
    By textPassword = By.xpath("//input[@type='password']");
    By btnGirisYap = By.xpath("//form/div/div[4]/button/div");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
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

        return driver.findElement(btnGirisYap);
    }
}
