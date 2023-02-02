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
    @FindBy (className = "v-card__title")
    private WebElement verifyMessage;

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

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public void logout() {
        logoutButton.click();
    }
    public void signUp() {
        signUpButton.click();
    }




    //•	Verifikovati da se nakon pokušaja otvaranja /home rute, u url-u stranice javlja /login ruta
// (otvoriti sa driver.get home page i proveriti da li vas redirektuje na login)

}
