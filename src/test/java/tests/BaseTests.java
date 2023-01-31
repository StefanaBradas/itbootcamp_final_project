package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import javax.xml.ws.soap.Addressing;
import java.time.Duration;

public abstract class BaseTests {

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected final String baseUrl = "https://vue-demo.daniel-avellaneda.com/";

    public BaseTests(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    //•	baseUrl - url stranice https://vue-demo.daniel-avellaneda.com
    //•	beforeClass - gde se podesava drajver sa implicitnim cekanjem
    // i cekanjem za ucitavanje stranice i kreiraju svi pagevi potrebni za testiranje
    //•	aftterClass - gde se gasi stranica
    //•	beforeMethod - gde se pre svakog testa ucitava baseUrl stranica

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


}
