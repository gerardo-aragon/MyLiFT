package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResetPasswordPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "/html/body/section/div/h2")
    private WebElement ResetPasswordTitle;

    public ResetPasswordPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver,this);
    }

    public String getResetPasswordTitle(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/section/div/h2")));
        return ResetPasswordTitle.getText();
    }
}
