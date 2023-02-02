package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupPage;

public class SignupTests extends BaseTests {

    private HomePage homePage;
    private SignupPage signUpPage;
    private Faker faker;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        signUpPage = new SignupPage(driver, driverWait);
        faker = new Faker();
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.goToSignUpPage();
    }

    @Test
    public void urlVerificationTest() {
        driverWait.until(ExpectedConditions.urlContains("/signup"));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "signup");

    }

    @Test
    public void inputTypesCheckTest() {
        signUpPage.assertTypeAttribute(signUpPage.getEmailField(), "email");
        signUpPage.assertTypeAttribute(signUpPage.getPasswordField(), "password");
        signUpPage.assertTypeAttribute(signUpPage.getConfirmPasswordField(), "password");
    }

    @Test
    public void errorMessageEmailAlreadyExistsTest() {
        signUpPage.signUp("Test Test", "admin@admin.com", "123654", "123654");
        System.out.println(signUpPage.getErrorMessage().getText());
        Assert.assertTrue(signUpPage.getErrorMessage().getText().startsWith("E-mail already exists"));
        urlVerificationTest();
    }

    @Test
    public void validSignUp() {
        signUpPage.signUp("Stefana Bradas", faker.internet().emailAddress(), "ITBootcamp", "ITBootcamp");
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getVerifyMessage()));
        Assert.assertTrue(homePage.getVerifyMessage().getText().contains("IMPORTANT: Verify your account"));
    }


}
