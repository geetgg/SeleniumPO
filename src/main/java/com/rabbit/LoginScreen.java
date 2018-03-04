package com.rabbit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginScreen {

     WebDriver driver;

    public LoginScreen(WebDriver driver){
        this.driver = driver;
    }

    public void setLoginName(String loginName) {
        WebElement logName = driver.findElement(By.id("login-username"));
        logName.click();
        logName.sendKeys(loginName);
    }

    public void setPassword(String password) {
        WebElement userPassword = driver.findElement(By.id("login-password"));
        userPassword.clear();
        userPassword.sendKeys(password);

    }


    public void clickLogbtn() {
        driver.findElement(By.id("btn-login")).click();  // click on Login button
    }

}
