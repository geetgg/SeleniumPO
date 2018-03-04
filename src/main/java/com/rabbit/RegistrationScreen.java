package com.rabbit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;


public class RegistrationScreen {

    WebDriver driver;

    public RegistrationScreen(WebDriver driver){
        this.driver = driver;
    }


    public void setFirstName(String strUserName) {
        WebElement fName = driver.findElement(By.id("first-name"));
        fName.click();
        fName.sendKeys(strUserName);
    }

    public void setLastName(String lastName) {
        WebElement lname = driver.findElement(By.id("last-name"));
        lname.clear();
        lname.sendKeys(lastName);
    }

    public void setEmailID(String emailID) {
        WebElement eMail = driver.findElement(By.id("email"));
        eMail.clear();
        Random random = new Random();
        Integer number = random.nextInt(1000000);
        eMail.sendKeys(emailID + number.toString() + "@gmail.com");
    }

    public void setPhoneNumber(String phoneNumber) {
        WebElement pNumber = driver.findElement(By.id("phone"));
        pNumber.clear();
        pNumber.sendKeys(phoneNumber);
    }

    public void setPassword(String password) {

        WebElement pass1 = driver.findElement(By.id("password"));
        pass1.clear();
        pass1.sendKeys(password);
    }

    public void setConfirmPass(String confPassword) {
        WebElement pass2 = driver.findElement(By.id("password-confirmation"));
        pass2.clear();
        pass2.sendKeys(confPassword);
    }

    public void clickRegBtn() throws InterruptedException {
        driver.findElement(By.id("reg-submit-btn")).click();
        Thread.sleep(3000);
    }
}