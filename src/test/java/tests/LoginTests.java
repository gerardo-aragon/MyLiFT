package tests;

import base.BaseTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    @Parameters({"password", "ValidationMessage"})
    public void loginEmptyUsername(String password, String ValidationMessage){
        loginPage.setPasswordFieldField(password);
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.getValidation().contains(ValidationMessage),
                "that username and password");

    }

    @Test
    @Parameters({"username", "ValidationMessage"})
    public void loginEmptyPassword(String username, String ValidationMessage){
        loginPage.setUsernameField(username);
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.getValidation().contains(ValidationMessage),
                "that username and password");

    }

    @Test
    @Parameters({"ValidationMessage"})
    public void LoginEmptyFields(String ValidationMessage){
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.getValidation().contains(ValidationMessage),
                "that username and password");

    }

    @Test
    @Parameters({"username", "password", "title"})
    public void testSuccessfulLogin(String username, String password, String title){
        loginPage.setUsernameField(username);
        loginPage.setPasswordFieldField(password);
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(adminDashboardPage.getManageTittle().contains(title),
                "Manage Schools");

    }


}
