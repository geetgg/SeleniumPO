package com.rabbit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UpdateAddressScreen {

    WebDriver driver;

    public UpdateAddressScreen(WebDriver driver){
        this.driver = driver;
    }

    public void setHomeAddress(String homeAddress) {
        driver.findElement(By.id("home-address")).clear();
        driver.findElement(By.id("home-address")).sendKeys(homeAddress);
    }

    public void setVillageBuilding(String village) {
        driver.findElement(By.id("home-village-building")).clear();
        driver.findElement(By.id("home-village-building")).sendKeys(village);
    }

    public void setSoi(String soi) {
        driver.findElement(By.id("home-soi")).clear();
        driver.findElement(By.id("home-soi")).sendKeys(soi);
    }

    public void setStreet(String street) {
        driver.findElement(By.id("home-street")).clear();
        driver.findElement(By.id("home-street")).sendKeys(street);
    }

    public void setProvince(String value) {
        Select provinceDropDown = new Select(driver.findElement(By.id("home-province")));
        provinceDropDown.selectByValue(value);
    }

    public void setDistrict(String value) {
        Select districtDropDown = new Select(driver.findElement(By.id("home-district")));
        districtDropDown.selectByValue(value);
    }

    public void setSubDist(String value) {
        Select subDistrictDropdown = new Select(driver.findElement(By.id("home-subdistrict")));
        subDistrictDropdown.selectByValue(value);
    }

    public void clickUpdatebtn() {
        driver.findElement(By.xpath("//*[@id=\"address\"]/form/div[8]/div/button")).click(); //Click Save

    }
}





