package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AdminDashboardPage;
import pages.LoginPage;
import pages.ResetPasswordPage;
import pages.TeacherDashboardPage;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    protected WebDriver driver;
    protected AdminDashboardPage adminDashboardPage;
    protected LoginPage loginPage;
    protected ResetPasswordPage resetPasswordPage;
    protected TeacherDashboardPage teacherDashboardPage;

    @BeforeMethod
    public void setUp(){
        //Iniciamos Chrome con la pantalla maximizada
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver(options);

        //Colocamos la url del sitio que queremos abrir
        driver.get("https://liftstaging.mylift.io/?locale=en");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        adminDashboardPage = new AdminDashboardPage(driver);
        loginPage = new LoginPage(driver);
        resetPasswordPage = new ResetPasswordPage(driver);
        teacherDashboardPage = new TeacherDashboardPage(driver);
    }

    @AfterMethod
    public void TearDown() throws InterruptedException {
        //Destruimos la instancia
        Thread.sleep(3000);
        driver.quit();
    }


}
