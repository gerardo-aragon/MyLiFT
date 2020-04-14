package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Xpath for username field on Login page
    @FindBy(how = How.XPATH, using = "//*[@id='email']")
    private WebElement usernameField;

    //Xpath for password field on Login page
    @FindBy(how = How.XPATH, using = "//*[@id='password']")
    private WebElement passwordField;

    //Xpath for Login button on Login page
    @FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[2]/form/div[3]/input")
    private WebElement loginButton;

    //Xpath for Validation message on Login page
    @FindBy(how = How.XPATH, using = "/html/body/section[1]/div/p")
    private WebElement validationMessage;

    //Xpath for Forgot password link on Login page
    @FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[2]/p/a")
    private WebElement forgotPasswordLink;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver,this);
    }

    //Set username on Login Page
    public void setUsernameField(String username){
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameField.sendKeys(username);
    }

    //Set password on Login Page
    public void setPasswordFieldField(String password){
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
    }

    //Click on Login button
    public AdminDashboardPage clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.submit();
        return new AdminDashboardPage(driver);
    }

    //Get validation when username or password don't match with any valid user/password on DB
    public String getValidation(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/section[1]/div/p")));
        return validationMessage.getText();
    }

    //Click on Forgot password link to access reset password page
    public ResetPasswordPage clickForgotPasswordButton(){
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        forgotPasswordLink.click();
        return new ResetPasswordPage(driver);

    }

    //When teacher login on LiFT, it should show the teacher's dashboard
    public TeacherDashboardPage teacherClickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.submit();
        return new TeacherDashboardPage(driver);
    }


}
