package com.LinkedIn.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SuperTestNG {
    WebDriver driver;
    
    @BeforeMethod
    public void openBrowser(){
        String url = "https://www.linkedin.com/";
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    
}