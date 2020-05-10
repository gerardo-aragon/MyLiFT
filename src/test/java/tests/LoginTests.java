package tests;

import base.BaseTests;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import junit.awtui.Logo;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {


    //START OF TEACHER LOGIN
    @Test(description = "LiFT-151 : Teacher can't access LiFT when username textbox is empty")
    @Parameters({"teacherPassword", "ValidationMessage"})
    public void teacherLoginEmptyUsername(String teacherPassword, String ValidationMessage){

        try {
            loginPage.setPasswordFieldField(teacherPassword); //Set teacher password on Login page
            adminDashboardPage = loginPage.clickLoginButton(); //Click on Login button
            assertTrue(loginPage.getValidation().contains(ValidationMessage), //Obtain message validation
                    "El testcase teacherLoginEmptyUsername falló");

            //Set the test case as passed
            updateTestLink("Teacher can't access LiFT when username textbox is empty", ExecutionStatus.PASSED);

        } catch (Exception | AssertionError e){
            //Set the test case as failed
            updateTestLink("Teacher can't access LiFT when username textbox is empty", ExecutionStatus.FAILED);
            throw e;
        }


    }

    @Test(description = "LiFT-152 : Teacher can't access LiFT when password textbox is empty")
    @Parameters({"teacherUsername", "ValidationMessage"})
    public void teacherLoginEmptyPassword(String teacherUsername, String ValidationMessage){

        try {
            loginPage.setUsernameField(teacherUsername); //Set teacher username on Login page
            adminDashboardPage = loginPage.clickLoginButton(); //Click on login button
            assertTrue(loginPage.getValidation().contains(ValidationMessage), //Obtain message validation
                    "El testcase teacherLoginEmptyUsername falló");

            //Set the test case as passed
            updateTestLink("Teacher can't access LiFT when password textbox is empty", ExecutionStatus.PASSED);

        } catch (Exception | AssertionError e){
            //Set the test case as failed
            updateTestLink("Teacher can't access LiFT when password textbox is empty", ExecutionStatus.FAILED);
            throw e;
        }


    }

    @Test(description = "LiFT-153 : Teacher can't access LiFT when clicking login button with no values")
    @Parameters({"ValidationMessage"})
    public void teacherLoginEmptyFields(String ValidationMessage){

        try {
            adminDashboardPage = loginPage.clickLoginButton(); //Click on Login button
            assertTrue(loginPage.getValidation().contains(ValidationMessage), //Obtain message validation
                    "El testcase teacherLoginEmptyUsername falló");

            //Set the test case as passed
            updateTestLink("Teacher can't access LiFT when clicking login button with no values", ExecutionStatus.PASSED);

        } catch (Exception | AssertionError e){
            //Set the test case as failed
            updateTestLink("Teacher can't access LiFT when clicking login button with no values", ExecutionStatus.FAILED);
            throw e;
        }

    }

    @Test(description = "LiFT-154 : Teacher can access to forgot password view")
    @Parameters({"ResetPasswordTitle"})
    public void teacherForgotPasswordAccess(String ResetPasswordTitle){

        try {
            resetPasswordPage = loginPage.clickForgotPasswordButton(); //Click on Forgot password link on Login page
            assertTrue(resetPasswordPage.getResetPasswordTitle().contains(ResetPasswordTitle),//Obtain message validation
                    "El testcase teacherForgotPasswordAccess falló");

            //Set the test case as passed
            updateTestLink("Teacher can access to forgot password view", ExecutionStatus.PASSED);

        } catch (Exception | AssertionError e){
            //Set the test case as failed
            updateTestLink("Teacher can access to forgot password view", ExecutionStatus.FAILED);
            throw e;
        }

    }

    @Test(description = "LiFT-156 : Teacher can access LiFT with an existing email and password.")
    @Parameters({"teacherUsername", "teacherPassword", "ProjectLibraryTextButton"})
    public void teacherSuccessfulLogin(String teacherUsername, String teacherPassword, String ProjectLibraryTextButton){

        try {
            loginPage.setUsernameField(teacherUsername); //Set teacher username on Login page
            loginPage.setPasswordFieldField(teacherPassword); //Set teacher password on Login page
            teacherDashboardPage = loginPage.teacherClickLoginButton(); //Click on login button
            assertTrue(teacherDashboardPage.getLiFTLogo().contains(ProjectLibraryTextButton),
                    "El testcase teacherSuccessfulLogin falló");

            //Set the test case as passed
            updateTestLink("Teacher can access LiFT with an existing email and password", ExecutionStatus.PASSED);

        } catch (Exception | AssertionError e){
            //Set the test case as failed
            updateTestLink("Teacher can access LiFT with an existing email and password", ExecutionStatus.FAILED);
            throw e;

        }
    }

    //END OF TEACHER LOGIN

}
