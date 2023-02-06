package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTests {


    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
    }

    @Test
    public void unauthorisedHomeUrlVerificationTest() {
        driver.get(BASEURL + "home");
        Assert.assertEquals(driver.getCurrentUrl(), BASEURL + "login");
    }

    @Test
    public void unauthorisedProfileUrlVerificationTest() {
        driver.get(BASEURL + "profile");
        Assert.assertEquals(driver.getCurrentUrl(), BASEURL + "login");
    }

    @Test
    public void unauthorisedAdminCitiesUrlVerificationTest() {
        driver.get(BASEURL + "admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(), BASEURL + "login");
    }

    @Test
    public void unauthorisedAdminUsersUrlVerificationTest() {
        driver.get(BASEURL + "admin/users");
        Assert.assertEquals(driver.getCurrentUrl(), BASEURL + "login");
    }


}
