package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/h1")
    private WebElement welcomeMessage;
    @FindBy(className = "btnLogout")
    private WebElement logoutButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]/span")
    private WebElement signUpButton;
    @FindBy(className = "v-card__title")
    private WebElement verifyMessage;

    @FindBy(className = "btnAdmin")
    private WebElement adminPageButton;
    @FindBy(xpath = "/html/body/div/div[3]/div/a[1]/div[2]")
    private WebElement citiesButton;

    @FindBy(className = "btnLocaleActivation")
    private WebElement languageButton;

    @FindBy(className = "layout")
    private WebElement headline;

    @FindBy(xpath = "//*[@id=\"list-item-75\"]/div")
    private WebElement ES;

    @FindBy(xpath = "//*[@id=\"list-item-73\"]/div")
    private WebElement EN;

    @FindBy(xpath = "//*[@id=\"list-item-77\"]/div")
    private WebElement FR;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span/i")
    private WebElement myProfileButton;

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getWelcomeMessage() {
        return welcomeMessage;
    }

    public void goToLoginPage() {
        loginButton.click();
    }

    public void goToSignUpPage() {
        signUpButton.click();
    }

    public WebElement getVerifyMessage() {
        return verifyMessage;
    }

    public WebElement getHeadline() {
        return headline;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public WebElement getEN() {
        return EN;
    }

    public WebElement getFR() {
        return FR;
    }

    public WebElement getES() {
        return ES;
    }

    public void logout() {
        logoutButton.click();
    }

    public void signUp() {
        signUpButton.click();
    }

    public void goToAdminCitiesPage() {
        adminPageButton.click();
        citiesButton.click();
    }
    public void selectLanguage (WebElement language) {
        languageButton.click();
        language.click();
    }

    public void goToMyProfile () {
//        driverWait.until(ExpectedConditions.elementToBeClickable(myProfileButton));   // ZASTO MI SA OVA 2 WAITERA ME RADI??
//        driverWait.until(ExpectedConditions.visibilityOf(myProfileButton));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        myProfileButton.click();
    }

    public void logOut () {
        logoutButton.click();
    }

}
