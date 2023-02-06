package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends BaseTests {

    private Faker faker;


    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
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
        Assert.assertEquals(driver.getCurrentUrl(), BASEURL + "login");
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
        Assert.assertEquals(driver.getCurrentUrl(), BASEURL + "home");
    }

    @Test
    public void logoutTest() {
        loginPage.login("admin@admin.com", "12345");
        homePage.logout();
        urlVerificationTest();
        driver.get(BASEURL + "login");
        urlVerificationTest();
    }
}
