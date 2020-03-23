package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AdminDashboardPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    protected WebDriver driver;
    protected AdminDashboardPage adminDashboardPage;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        //Iniciamos Chrome con la pantalla maximizada
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver(options);

        //Colocamos la url del sitio que queremos abrir
        driver.get("https://demo.mylift.io/?locale=en");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        adminDashboardPage = new AdminDashboardPage(driver);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void TearDown() throws InterruptedException {
        //Destruimos la instancia
        Thread.sleep(3000);
        driver.quit();
    }


}
