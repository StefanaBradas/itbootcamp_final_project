package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignupPage extends BasePage{
    @FindBy (id = "name")
    private WebElement nameField;
    @FindBy (id = "email")
    private WebElement emailField;
    @FindBy (id = "password")
    private WebElement passwordField;
    @FindBy (id = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span")
    private WebElement signMeUpButton;
    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]")
    private WebElement errorMessage;


    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public WebElement getSignMeUpButton() {
        return signMeUpButton;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public void signUp (String name, String email, String password, String confirmPassword) {
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        signMeUpButton.click();
    }



    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public void assertTypeAttribute (WebElement webElement, String attributeValue) {
       Assert.assertEquals(webElement.getAttribute("type"), attributeValue);
    }


}
