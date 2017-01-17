//AtLoginValidBack
package com.LinkedIn.testScripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.LinkedIn.objectPage.BasePage;
import com.LinkedIn.objectPage.LoginPage;
import com.LinkedIn.utilLibrary.GenericUtilLibrary;

public class AtLoginValidBack extends SuperTestNG{
    @Test
    public void loginValidBackTest() throws InvalidFormatException, IOException, InterruptedException{
    LoginPage lP = new LoginPage(driver); //create an instance of LoginPage
    BasePage bP = new BasePage(driver); //create an instance of BasePage
    
    String user = GenericUtilLibrary.getCellValue("./BrowserAndURL.xlsx", "Sheet1", 5, 1);
    String pass = GenericUtilLibrary.getCellValue("./BrowserAndURL.xlsx", "Sheet1", 5, 2);
    String exp  = GenericUtilLibrary.getCellValue("./BrowserAndURL.xlsx", "Sheet1", 5, 3);
    
    lP.login(user, pass);
    Actions action = new Actions(driver);
    bP.signOut(action);
    driver.navigate().back();
    Thread.sleep(3000); //wait for few second so that after pressing back previous page download properly then only we can get the title
    String act = driver.getTitle();
    bP.assertByTitle(exp, act);
    }
}