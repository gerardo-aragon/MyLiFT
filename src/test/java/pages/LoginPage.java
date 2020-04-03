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

    @FindBy(how = How.XPATH, using = "//*[@id='email']")
    private WebElement usernameField;
    @FindBy(how = How.XPATH, using = "//*[@id='password']")
    private WebElement passwordField;
    @FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[2]/form/div[3]/input")
    private WebElement loginButton;
    @FindBy(how = How.XPATH, using = "/html/body/section[1]/div/p")
    private WebElement validationMessage;
    @FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[2]/p/a")
    private WebElement forgotPasswordLink;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver,this);
    }

    public void setUsernameField(String username){
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameField.sendKeys(username);
    }

    public void setPasswordFieldField(String password){
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
    }

    public AdminDashboardPage clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.submit();
        return new AdminDashboardPage(driver);
    }

    public String getValidation(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/section[1]/div/p")));
        return validationMessage.getText();
    }


    public ResetPasswordPage clickForgotPasswordButton(){
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        forgotPasswordLink.click();
        return new ResetPasswordPage(driver);

    }

    public TeacherDashboardPage teacherclickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.submit();
        return new TeacherDashboardPage(driver);
    }


}
