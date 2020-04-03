package tests;

import base.BaseTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    //START OF ADMIN LOGIN

    @Test(description = "LiFT-2 : Verify if an administrator can access LiFT when username field is empty in the login form")
    @Parameters({"adminPassword", "ValidationMessage"})
    public void adminLoginEmptyUsername(String adminPassword, String ValidationMessage){
        loginPage.setPasswordFieldField(adminPassword);
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.getValidation().contains(ValidationMessage),
                "that username and password");

    }

    @Test(description = "LiFT-3 : Verify if an administrator can access LiFT when password field is empty in the login form")
    @Parameters({"adminUsername", "ValidationMessage"})
    public void adminLoginEmptyPassword(String adminUsername, String ValidationMessage){
        loginPage.setUsernameField(adminUsername);
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.getValidation().contains(ValidationMessage),
                "that username and password");

    }

    @Test(description = "LiFT-4 : Verify if an administrator can access LiFT when clicking login button with no values")
    @Parameters({"ValidationMessage"})
    public void adminLoginEmptyFields(String ValidationMessage){
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.getValidation().contains(ValidationMessage),
                "that username and password");

    }

    @Test(description = "Verify if an administrator can access LiFT with an existing email and password.")
    @Parameters({"adminUsername", "adminPassword", "manageSchoolsTitle"})
    public void adminSuccessfulLogin(String adminUsername, String adminPassword, String manageSchoolsTitle){
        loginPage.setUsernameField(adminUsername);
        loginPage.setPasswordFieldField(adminPassword);
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(adminDashboardPage.getManageTittle().contains(manageSchoolsTitle),
                "Manage Schools");

    }

    @Test(description = "LiFT-5 : Verify if an administrator can access to forgot password view.")
    @Parameters({"ResetPasswordTitle"})
    public void adminForgotPasswordAccess(String ResetPasswordTitle){
        resetPasswordPage = loginPage.clickForgotPasswordButton();
        assertTrue(resetPasswordPage.getResetPasswordTitle().contains(ResetPasswordTitle),
                 "RESET YOUR");

    }

    //END OF ADMIN LOGIN

    //START OF TEACHER LOGIN
    @Test(description = "LiFT-151 : Verify if a teacher can access LiFT when username field is empty in the login form")
    @Parameters({"teacherPassword", "ValidationMessage"})
    public void teacherLoginEmptyUsername(String teacherPassword, String ValidationMessage){
        loginPage.setPasswordFieldField(teacherPassword);
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.getValidation().contains(ValidationMessage),
                "that username and password");

    }

    @Test(description = "LiFT-152 : Verify if a teacher can access LiFT when password field is empty in the login form")
    @Parameters({"teacherUsername", "ValidationMessage"})
    public void teacherLoginEmptyPassword(String teacherUsername, String ValidationMessage){
        loginPage.setUsernameField(teacherUsername);
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.getValidation().contains(ValidationMessage),
                "that username and password");

    }

    @Test(description = "LiFT-153 : Verify if a teacher can access LiFT when clicking login button with no values")
    @Parameters({"ValidationMessage"})
    public void teacherLoginEmptyFields(String ValidationMessage){
        adminDashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.getValidation().contains(ValidationMessage),
                "that username and password");

    }

    @Test(description = "LiFT-156 : Verify if a teacher can access lift with an existing email and password.")
    @Parameters({"teacherUsername", "teacherPassword"})
    public void teacherSuccessfulLogin(String teacherUsername, String teacherPassword){
        loginPage.setUsernameField(teacherUsername);
        loginPage.setPasswordFieldField(teacherPassword);
        teacherDashboardPage = loginPage.teacherclickLoginButton();
    }

    @Test(description = "LiFT-154 : Verify if a teacher can access to forgot password view.")
    @Parameters({"ResetPasswordTitle"})
    public void teacherForgotPasswordAccess(String ResetPasswordTitle){
        resetPasswordPage = loginPage.clickForgotPasswordButton();
        assertTrue(resetPasswordPage.getResetPasswordTitle().contains(ResetPasswordTitle),
                "RESET YOUR");

    }


}
