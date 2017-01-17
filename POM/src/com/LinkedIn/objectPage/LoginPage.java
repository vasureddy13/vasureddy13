//LoginPage
package com.LinkedIn.objectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    
    @FindBy(id="session_key-login")  //used id locator here because its best in performance, you can use other locators as well
    @CacheLookup
        private WebElement emailAddress;
    
    @FindBy(id="session_password-login")
    @CacheLookup
        private WebElement password;
    
    @FindBy(id="signin")
    @CacheLookup
        private WebElement signInButton;
    
    public WebElement emailAddress(){
        return emailAddress;
    }
    
    public WebElement password(){
        return password;
    }
    
    public WebElement signInButton(){
        return signInButton;
    }
    
    public LoginPage(WebDriver driver){  //create a constructor to invoke the page factory to initialize/load all the webelements present in page class 
        this.driver = driver;
        PageFactory.initElements(driver, this); //here 'this' is the keyword to invoke the same class members
    } 
    
    public void login(String user, String pass){
        signInButton.click();
        emailAddress.sendKeys(user);
        password.sendKeys(pass);
        signInButton.click();
    }
    
    
    

}