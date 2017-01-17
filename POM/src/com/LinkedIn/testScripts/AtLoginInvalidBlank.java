//AtLoginInvalidBlank
package com.LinkedIn.testScripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.LinkedIn.objectPage.BasePage;
import com.LinkedIn.objectPage.LoginPage;
import com.LinkedIn.utilLibrary.GenericUtilLibrary;

public class AtLoginInvalidBlank extends SuperTestNG {
    @Test
    public void loginInvalidBlankTest() throws InvalidFormatException, IOException{
        LoginPage lP = new LoginPage(driver); //create an instance of LoginPage
        BasePage bP = new BasePage(driver); //create an instance of BasePage

        String exp  = GenericUtilLibrary.getCellValue("./BrowserAndURL.xlsx", "Sheet1", 3, 3);
        
        boolean signIn = lP.signInButton().isEnabled();
        String act = ""+signIn;
        bP.assertByTitle(exp, act);
    }
}
