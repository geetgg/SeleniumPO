package rabbit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

public static void main (String[] args) throws Exception{
   WebDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    driver.get("https://id.rabbit.co.th/register");

    driver.manage().window().maximize();

    /*driver.findElement(By.id("first-name")).sendKeys("First Name");
    driver.findElement(By.id("last-name")).sendKeys("Last Name");
    driver.findElement(By.id("email")).sendKeys("Email");
    driver.findElement(By.id("phone")).sendKeys("Mobile Number");
    driver.findElement(By.id("password")).sendKeys("Password");
    driver.findElement(By.id("password-confirmation")).sendKeys("Confirm Password"); */

    WebElement fName = driver.findElement(By.id("first-name"));
    fName.click();
    fName.sendKeys("Geetika");

    WebElement lname = driver.findElement(By.id("last-name"));
    lname.clear();
    lname.sendKeys("Girdhar");

    WebElement eMail = driver.findElement(By.id("email"));
    eMail.clear();
    eMail.sendKeys("geetikag89@gmail.com");

    WebElement pNumber = driver.findElement(By.id("phone"));
    pNumber.clear();
    pNumber.sendKeys("0999999999");

    WebElement pass1 = driver.findElement(By.id("password"));
    pass1.clear();
    pass1.sendKeys("Test1234");

    WebElement pass2 = driver.findElement(By.id("password-confirmation"));
    pass2.clear();
    pass2.sendKeys("Test1234");


    driver.findElement(By.id("reg-submit-btn")).click();

 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

 //driver.close();

}
}
