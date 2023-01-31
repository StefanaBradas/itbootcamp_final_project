package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    @FindBy (id = "email")
    private WebElement emailFiled;

    @FindBy (id = "password")
    private WebElement passwordField;

    @FindBy (xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span")
    private WebElement loginButton;
    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement errorMessage;


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getEmailFiled() {
        return emailFiled;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public void login (String email, String password) {
        emailFiled.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }


}
