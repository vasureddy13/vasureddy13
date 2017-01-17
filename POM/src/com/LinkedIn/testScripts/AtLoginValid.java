//AtLoginValid
package com.LinkedIn.testScripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.LinkedIn.objectPage.BasePage;
import com.LinkedIn.objectPage.LoginPage;
import com.LinkedIn.utilLibrary.GenericUtilLibrary;

public class AtLoginValid extends SuperTestNG{
    @Test()
    public void loginValidTest() throws InvalidFormatException, IOException{
        LoginPage lP = new LoginPage(driver); //create an instance of LoginPage
        BasePage bP = new BasePage(driver); //create an instance of BasePage
        
        String user = GenericUtilLibrary.getCellValue("./BrowserAndURL.xlsx", "Sheet1", 1, 1);
        String pass = GenericUtilLibrary.getCellValue("./BrowserAndURL.xlsx", "Sheet1", 1, 2);
        String exp  = GenericUtilLibrary.getCellValue("./BrowserAndURL.xlsx", "Sheet1", 1, 3);
        
        lP.login(user, pass);
        String act = driver.getTitle();
        bP.assertByTitle(exp, act);
    }
}