package com.rabbit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    /**
     * Created by Geetika on 3/01/18.
     */

    static WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(26000, TimeUnit.MILLISECONDS);
    }

    @Test(groups = {"registration"}, priority = 1)
    public void registrationSuccessful() throws InterruptedException {
        driver.get("https://id.rabbit.co.th/register");
        driver.manage().window().maximize();

        RegistrationScreen registerScreen = new RegistrationScreen(driver);

        registerScreen.setFirstName("Geetika");
        registerScreen.setLastName("Girdhar");
        registerScreen.setEmailID("gg");
        registerScreen.setPhoneNumber("0999999999");
        registerScreen.setPassword("Test1234");
        registerScreen.setConfirmPass("Test1234");
        registerScreen.clickRegBtn();
        Assert.assertTrue(driver.getPageSource().contains("ยินดีต้อนรับ") || driver.getPageSource().contains("Welcome"));
        System.out.println("Registration Verification Test passed");
    }


    @Test(groups = {"registration"}, priority = 0)
    public void registrationFail() throws InterruptedException {
        driver.get("https://id.rabbit.co.th/register");
        driver.manage().window().maximize();
        RegistrationScreen registerScreen = new RegistrationScreen(driver);

        registerScreen.setFirstName("Geetika");
        registerScreen.setLastName("Girdhar");
        registerScreen.setEmailID("gg");
        registerScreen.clickRegBtn();
        Assert.assertFalse(driver.getPageSource().contains("ยินดีต้อนรับ") || driver.getPageSource().contains("Welcome"));
        System.out.println("Registration Failed due to missing information. ");

    }


    @AfterTest
    public void onComplete() {
        driver.quit();
    }
}