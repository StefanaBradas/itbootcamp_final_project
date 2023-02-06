package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyProfilePage;
import pages.SignupPage;

public class ProfileTests extends BaseTests {

    private MyProfilePage myProfilePage;
    private Faker faker;
    private String name;
    private String phone;
    private String city;
    private String country;
    private String twitter;
    private String github;


    private SignupPage signupPage;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        myProfilePage = new MyProfilePage(driver, driverWait);
        signupPage = new SignupPage(driver, driverWait);
        faker = new Faker();
        name = faker.name().fullName();
        phone = faker.phoneNumber().phoneNumber();
        city = "New York";
        country = faker.address().country();
        twitter = "https://" + faker.internet().url();
        github = "https://" + faker.internet().url();
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.goToLoginPage();
        loginPage.login("admin@admin.com", "12345");
        homePage.goToMyProfile();
    }


    @Test
    public void editMyProfileTest() {
        myProfilePage.editProfile(name, phone, city, country, twitter, github);

        Assert.assertTrue(myProfilePage.getPopUpMessage().getText().contains("Profile saved successfuly"));
        Assert.assertEquals(myProfilePage.getNameField().getAttribute("value"), name);
        Assert.assertEquals(myProfilePage.getPhoneField().getAttribute("value"), phone);
        Assert.assertEquals(myProfilePage.getCityField().getAttribute("value"), city);
        Assert.assertEquals(myProfilePage.getCountryField().getAttribute("value"), country);
        Assert.assertEquals(myProfilePage.getTwitterField().getAttribute("value"), twitter);
        Assert.assertEquals(myProfilePage.getGitHubField().getAttribute("value"), github);
    }

}
