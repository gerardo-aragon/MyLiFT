package base;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.AdminDashboardPage;
import pages.LoginPage;
import pages.ResetPasswordPage;
import pages.TeacherDashboardPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;


public class BaseTests {

    protected WebDriver driver;
    protected AdminDashboardPage adminDashboardPage;
    protected LoginPage loginPage;
    protected ResetPasswordPage resetPasswordPage;
    protected TeacherDashboardPage teacherDashboardPage;

    public Properties param;
    public TestLink testLink;
    public boolean testLinkEnabled;

    @Parameters({"paramFile", "enableTestLink", "projectName", "testPlanName", "suiteName",
            "testCasePath", "platform"})

    @BeforeMethod
    public void setUp(
            @Optional("") String paramFile,
            @Optional("") boolean enableTestLink,
            @Optional("") String projectName,
            @Optional("") String testPlanName,
            @Optional("") String suiteName,
            @Optional("") String testCasePath,
            @Optional("") String platform){
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

        testLinkEnabled = enableTestLink;
        if(testLinkEnabled){
            testLink = new TestLink(projectName, testPlanName);
            testLink.setTestSuite(suiteName);
            testLink.setTestCasePath(testCasePath);
            testLink.setPlatform(platform);
        }

    }

    public void updateTestLink(String testCaseName, ExecutionStatus status){
        if (testLinkEnabled){
            testLink.setTestCaseStatus(testCaseName, status);
        }
    }

    @AfterMethod
    public void TearDown() throws InterruptedException {
        //Destruimos la instancia
        Thread.sleep(3000);
        driver.quit();
    }


}
