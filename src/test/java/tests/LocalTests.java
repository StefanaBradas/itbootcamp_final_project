package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class LocalTests extends BaseTests {


    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
    }

    @Test
    public void esLanguageSetUpTest() {
        homePage.selectLanguage(homePage.getES());
        Assert.assertTrue(homePage.getHeadline().getText().startsWith("Página de aterrizaje"));
    }

    @Test
    public void enLanguageSetUpTest() {
        homePage.selectLanguage(homePage.getEN());
        Assert.assertTrue(homePage.getHeadline().getText().startsWith("Landing"));
    }

    @Test
    public void frLanguageSetUpTest() {
        homePage.selectLanguage(homePage.getFR());
        Assert.assertTrue(homePage.getHeadline().getText().startsWith("Page d'atterrissage"));
    }

}
