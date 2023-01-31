package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTests {

    private LoginPage loginPage;
    private HomePage homePage;
    private Faker faker;


    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        faker = new Faker();
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.goToLoginPage();
    }

    @Test
    public void urlVerificationTest() {
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "login");
    }

    @Test
    public void inputTypesCheckTest() {
        Assert.assertEquals(loginPage.getEmailFiled().getAttribute("type"), "email");
        Assert.assertEquals(loginPage.getPasswordField().getAttribute("type"), "password");
    }

    @Test
    public void errorMassageUserDoesNotExistTest() {
        loginPage.login(faker.internet().emailAddress(), faker.internet().password());
        Assert.assertTrue(loginPage.getErrorMessage().getText().startsWith("User does not exists"));
        urlVerificationTest();

    }

    @Test
    public void errorMessageWrongPasswordTest() {
        loginPage.login("admin@admin.com", faker.internet().password());
        Assert.assertTrue(loginPage.getErrorMessage().getText().startsWith("Wrong password"));
        urlVerificationTest();
    }

    @Test
    public void validLoginTest() {
        loginPage.login("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getWelcomeMessage()));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "home");
    }

    @Test
    public void logoutTest() {
        loginPage.login("admin@admin.com", "12345");
        homePage.logout();
        urlVerificationTest();
        driver.get(baseUrl+"login");
        urlVerificationTest();
    }

//Test #6: Logout
//assert:
//•	Verifikovati da je dugme logout vidljivo na stranici
//•	Verifikovati da se u url-u stranice javlja /login ruta

//•	Verifikovati da se nakon pokušaja otvaranja /home rute, u url-u stranice javlja /login ruta
// (otvoriti sa driver.get home page i proveriti da li vas redirektuje na login)




}
