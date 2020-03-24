package tests;

import base.BaseTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test(description = "LiFT-2 : Verify if user can access LiFT when username field is empty in the login form")
    @Parameters({"password", "ValidationMessage"})
    public void loginEmptyUsername(String password, String ValidationMessage){
        loginPage.setPasswordFieldField(password);
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.getValidation().contains(ValidationMessage),
                "that username and password");

    }

    @Test(description = "LiFT-3 : Verify if user can access LiFT when password field is empty in the login form")
    @Parameters({"username", "ValidationMessage"})
    public void loginEmptyPassword(String username, String ValidationMessage){
        loginPage.setUsernameField(username);
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.getValidation().contains(ValidationMessage),
                "that username and password");

    }

    @Test(description = "LiFT-4 : Verify if user can access LiFT when clicking login button with no values")
    @Parameters({"ValidationMessage"})
    public void loginEmptyFields(String ValidationMessage){
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.getValidation().contains(ValidationMessage),
                "that username and password");

    }

    @Test(description = "LiFT-5 : Verify if user can access to forgot password view.")
    @Parameters({"ResetPasswordTitle"})
    public void forgotPasswordAccess(String ResetPasswordTitle){
        resetPasswordPage = loginPage.clickForgotPasswordButton();
        assertTrue(resetPasswordPage.getResetPasswordTitle().contains(ResetPasswordTitle),
                 "RESET YOUR");

    }

    @Test(description = "Verify if user can access lift with an existing email and password.")
    @Parameters({"username", "password", "title"})
    public void testSuccessfulLogin(String username, String password, String title){
        loginPage.setUsernameField(username);
        loginPage.setPasswordFieldField(password);
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(adminDashboardPage.getManageTittle().contains(title),
                "Manage Schools");

    }


}
