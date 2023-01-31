package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTests {

    private LoginPage loginPage;
    private HomePage homePage;


    @BeforeClass
    public void beforeClass () {
        super.beforeClass();
        loginPage = new LoginPage(driver,driverWait);
        homePage = new HomePage(driver,driverWait);
    }

    @BeforeMethod
    public void beforeMethod () {
        super.beforeMethod();
        homePage.goToLoginPage();
    }

    @Test
    public void urlVerification () {
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"login");
    }

    @AfterClass
    public void afterClass () {
        super.afterClass();
    }



    //Test #1: Visits the login page
    //assert:
    //•	Verifikovati da se u url-u stranice javlja ruta /login
    //
    //
    //Test #2: Checks input types
    //assert:
    //•	Verifikovati da polje za unos emaila za atribut type ima vrednost email
    //•	Verifikovati da polje za unos lozinke za atribut type ima vrednost password




}
