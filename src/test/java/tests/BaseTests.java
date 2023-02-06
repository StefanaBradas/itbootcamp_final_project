package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public abstract class BaseTests {

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected final String BASEURL = "https://vue-demo.daniel-avellaneda.com/";


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASEURL);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
