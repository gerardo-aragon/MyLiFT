package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeacherDashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Xpath to obtain the LiFT icon on teacher's dashboard
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/a[1]")
    private WebElement ProjectLibraryButton;


    public TeacherDashboardPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver,this);
    }

    //Xpath to obtain the LiFT icon on teacher's dashboard
    public String getLiFTLogo(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/a[1]")));
        System.out.println(ProjectLibraryButton);
        return ProjectLibraryButton.getText();
    }
}
