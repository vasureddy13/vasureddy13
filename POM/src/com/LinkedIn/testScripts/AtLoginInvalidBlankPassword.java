//AtLoginInvalidBlankPassword
package com.LinkedIn.testScripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.LinkedIn.objectPage.BasePage;
import com.LinkedIn.objectPage.LoginPage;
import com.LinkedIn.utilLibrary.GenericUtilLibrary;

public class AtLoginInvalidBlankPassword extends SuperTestNG{
    @Test
    public void loginInvalidBlankPasswordTest() throws InvalidFormatException, IOException{
        LoginPage lP = new LoginPage(driver); //create an instance of LoginPage
        BasePage bP = new BasePage(driver); //create an instance of BasePage
        
        String user = GenericUtilLibrary.getCellValue("./BrowserAndURL.xlsx", "Sheet1", 4, 1);
        String exp  = GenericUtilLibrary.getCellValue("./BrowserAndURL.xlsx", "Sheet1", 4, 3);
        
        lP.emailAddress().sendKeys(user);
        boolean signIn = lP.signInButton().isEnabled();
        String act = ""+signIn;
        bP.assertByMsg(exp, act);
    }
}
