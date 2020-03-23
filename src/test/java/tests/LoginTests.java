package tests;

import base.BaseTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    @Parameters({"username", "password", "title"})
    public void testSuccessfulLogin(String username, String password, String title){
        loginPage.setUsernameField(username);
        loginPage.setPasswordFieldField(password);
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(adminDashboardPage.getManageTittle().contains(title),
                "Manage Schools");

    }

    @Test
    @Parameters({"username", "password2", "title2"})
    public void testSuccessfulLogin2(String username, String password2, String title2){
        loginPage.setUsernameField(username);
        loginPage.setPasswordFieldField(password2);
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.getValidation().contains(title2),
                "that username and password");

    }


}
