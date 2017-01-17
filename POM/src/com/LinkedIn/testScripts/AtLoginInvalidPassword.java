//AtLoginInvalidPassword
package com.LinkedIn.testScripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.LinkedIn.objectPage.BasePage;
import com.LinkedIn.objectPage.LoginPage;
import com.LinkedIn.utilLibrary.GenericUtilLibrary;

public class AtLoginInvalidPassword extends SuperTestNG{

    @Test
    public void loginInvalidPasswordTest() throws InvalidFormatException, IOException{
        LoginPage lP = new LoginPage(driver); //create an instance of LoginPage
        BasePage bP = new BasePage(driver); //create an instance of BasePage
        
        String user = GenericUtilLibrary.getCellValue("./BrowserAndURL.xlsx", "Sheet1", 2, 1);
        String pass = GenericUtilLibrary.getCellValue("./BrowserAndURL.xlsx", "Sheet1", 2, 2);
        String exp  = GenericUtilLibrary.getCellValue("./BrowserAndURL.xlsx", "Sheet1", 2, 3);
        
        lP.login(user, pass);
        String act = bP.errMsg();
        bP.assertByMsg(exp, act);
    } 
}