package tests;

import base.BaseTests;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {


    //START OF TEACHER LOGIN
    @Test(description = "LiFT-151 : Teacher can access LiFT when username textbox is empty")
    @Parameters({"teacherPassword", "ValidationMessage"})
    public void teacherLoginEmptyUsername(String teacherPassword, String ValidationMessage){

        try {
            loginPage.setPasswordFieldField(teacherPassword); //Set teacher password on Login page
            adminDashboardPage = loginPage.clickLoginButton(); //Click on Login button
            assertTrue(loginPage.getValidation().contains(ValidationMessage), //Obtain message validation
                    "that username and password");

            //Set the test case as passed
            updateTestLink("Access lift when username textbox is empty", ExecutionStatus.PASSED);

        } catch (Exception | AssertionError e){
            //Set the test case as failed
            updateTestLink("Access lift when username textbox is empty", ExecutionStatus.FAILED);
            throw e;
        }


    }

    @Test(description = "LiFT-152 : Teacher can access LiFT when password textbox is empty")
    @Parameters({"teacherUsername", "ValidationMessage"})
    public void teacherLoginEmptyPassword(String teacherUsername, String ValidationMessage){

        try {
            loginPage.setUsernameField(teacherUsername); //Set teacher username on Login page
            adminDashboardPage = loginPage.clickLoginButton(); //Click on login button
            assertTrue(loginPage.getValidation().contains(ValidationMessage), //Obtain message validation
                    "that username and password");

            //Set the test case as passed
            updateTestLink("Access lift when password textbox is empty", ExecutionStatus.PASSED);

        } catch (Exception | AssertionError e){
            //Set the test case as failed
            updateTestLink("Access lift when password textbox is empty", ExecutionStatus.FAILED);
            throw e;
        }


    }

    @Test(description = "LiFT-153 : Teacher can access LiFT when clicking login button with no values")
    @Parameters({"ValidationMessage"})
    public void teacherLoginEmptyFields(String ValidationMessage){

        try {
            adminDashboardPage = loginPage.clickLoginButton(); //Click on Login button
            assertTrue(loginPage.getValidation().contains(ValidationMessage), //Obtain message validation
                    "that username and password");

            //Set the test case as passed
            updateTestLink("Access lift when clicking login button with no values", ExecutionStatus.PASSED);

        } catch (Exception | AssertionError e){
            //Set the test case as failed
            updateTestLink("Access lift when clicking login button with no values", ExecutionStatus.FAILED);
            throw e;
        }

    }

    @Test(description = "LiFT-154 : Teacher can access to forgot password view")
    @Parameters({"ResetPasswordTitle"})
    public void teacherForgotPasswordAccess(String ResetPasswordTitle){

        try {
            resetPasswordPage = loginPage.clickForgotPasswordButton(); //Click on Forgot password link on Login page
            assertTrue(resetPasswordPage.getResetPasswordTitle().contains(ResetPasswordTitle),//Obtain message validation
                    "RESET YOUR");

            //Set the test case as passed
            updateTestLink("Access to forgot password view", ExecutionStatus.PASSED);

        } catch (Exception | AssertionError e){
            //Set the test case as failed
            updateTestLink("Access to forgot password view", ExecutionStatus.FAILED);
            throw e;
        }

    }

    @Test(description = "LiFT-156 : Teacher can access LiFT with an existing email and password.")
    @Parameters({"teacherUsername", "teacherPassword"})
    public void teacherSuccessfulLogin(String teacherUsername, String teacherPassword){

        try {
            loginPage.setUsernameField(teacherUsername); //Set teacher username on Login page
            loginPage.setPasswordFieldField(teacherPassword); //Set teacher password on Login page
            teacherDashboardPage = loginPage.teacherClickLoginButton(); //Click on login button

            //Set the test case as passed
            updateTestLink("User can access lift with an existing email and password", ExecutionStatus.PASSED);

        } catch (Exception | AssertionError e){
            //Set the test case as failed
            updateTestLink("User can access lift with an existing email and password", ExecutionStatus.FAILED);
            throw e;

        }
    }

    //END OF TEACHER LOGIN

}
