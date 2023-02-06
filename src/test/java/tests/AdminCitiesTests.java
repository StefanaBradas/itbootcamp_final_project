package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AdminCitiesPage;

public class AdminCitiesTests extends BaseTests {

    private AdminCitiesPage adminCitiesPage;
    private Faker faker;
    private String city;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
        faker = new Faker();
        city = faker.address().city();
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.goToLoginPage();
        loginPage.login("admin@admin.com", "12345");
        homePage.goToAdminCitiesPage();

    }

    @Test
    public void citiesListVerificationTest() {
        Assert.assertEquals(driver.getCurrentUrl(), BASEURL + "admin/cities");
        Assert.assertTrue(adminCitiesPage.getLogOutButton().isDisplayed());
    }

    @Test(priority = 1)
    public void createNewCityTest() {
        adminCitiesPage.createNewCity(city);
        Assert.assertTrue(adminCitiesPage.getPopUpMassage().getText().contains("Saved successfully"));
    }


    @Test(priority = 2)
    public void editCityTest() {
        adminCitiesPage.editCity(city);
        Assert.assertTrue(adminCitiesPage.getPopUpMassage().getText().contains("Saved successfully"));
    }

    @Test(priority = 3)
    public void searchCityTest() {
        adminCitiesPage.searchCity(city + " - edited");
    }

    @Test(priority = 4)
    public void deleteCityTest() {
        adminCitiesPage.deleteCity(city);
        Assert.assertTrue(adminCitiesPage.getPopUpMassage().getText().contains("Deleted successfully"));
    }

    @AfterMethod
    public void afterMethod() {
        adminCitiesPage.logout();
    }

}
