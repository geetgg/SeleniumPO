package rabbit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    /**
     * Created by Geetika on 3/01/18.
     */

    //static WebDriver driver;
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://id.rabbit.co.th/login");

        driver.manage().window().maximize();

        //login page
        WebElement username = driver.findElement(By.id("login-username"));
        username.clear();
        username.sendKeys("geetikag89@gmail.com");

        WebElement userpassword = driver.findElement(By.id("login-password"));
        userpassword.clear();
        userpassword.sendKeys("Test1234");

        driver.findElement(By.id("btn-login")).click();  // click on Login button

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //Click on My Details
        WebElement menu = driver.findElement(By.xpath("//*[@id=\"sub-navbar\"]/ul/li[4]"));
        Actions builder = new Actions((driver));
        builder.moveToElement(menu).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, 2);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"sub-navbar\"]/ul/li[4]/ul/li[4]/a")));

        WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"sub-navbar\"]/ul/li[4]/ul/li[4]/a"));
        menuOption.click();

        driver.findElement(By.xpath("//*[@id=\"my-details\"]/div[2]/a")).click();


        driver.findElement(By.id("address-tab")).click(); // Click on Address tab

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Update Address

        driver.findElement(By.id("home-address")).sendKeys("Base Park");

        driver.findElement(By.id("home-village-building")).sendKeys("East");

        driver.findElement(By.id("home-soi")).sendKeys("77");

        driver.findElement(By.id("home-street")).sendKeys("Sukhumvit");


        Select provincedropdown = new Select(driver.findElement(By.id("home-province")));
        provincedropdown.selectByValue("3");

        Select districtdropdown = new Select(driver.findElement(By.id("home-district")));
        districtdropdown.selectByValue("63");

        Select subdistrictDropdown = new Select(driver.findElement(By.id("home-subdistrict")));
        subdistrictDropdown.selectByValue("301");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"address\"]/form/div[8]/div/button")).click();
    }


        @Test
        public void positiveTest() {
            Assert.assertTrue(driver.getPageSource().contains("ข้อมูลถูกอัพเดตแล้ว!") || driver.getPageSource().contains("Details updated!"));
            System.out.println("Test to update address passed");

        }
    }
}


