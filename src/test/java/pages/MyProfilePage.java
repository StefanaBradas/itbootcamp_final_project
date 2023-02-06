package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfilePage extends BasePage {


    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement nameField;
    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneField;
    @FindBy(name = "country")
    private WebElement countryField;

    @FindBy(name = "urlTwitter")
    private WebElement twitterField;
    @FindBy(name = "urlGitHub")
    private WebElement gitHubField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[3]/span/div/div/div[1]/div[2]/div/button")
    private WebElement deletePhoneButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div/button")
    private WebElement deleteCityButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")
    private WebElement saveButton;

   @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
   private WebElement popUpMessage;

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getPhoneField() {
        return phoneField;
    }

    public WebElement getCountryField() {
        return countryField;
    }

    public WebElement getTwitterField() {
        return twitterField;
    }

    public WebElement getGitHubField() {
        return gitHubField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public Faker getFaker() {
        return faker;
    }

    @FindBy(name = "city")
    private WebElement cityField;
    private Faker faker = new Faker();


    public MyProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getPopUpMessage() {
        return popUpMessage;
    }

    public void editProfile(String name, String phone, String city, String country, String twitter, String github) {

        nameField.click();
        nameField.sendKeys(Keys.CONTROL + "a");
        nameField.sendKeys(Keys.DELETE);
        nameField.sendKeys(name);

        deletePhoneButton.click();
        phoneField.sendKeys(phone);

        deleteCityButton.click();
        cityField.sendKeys(Keys.CONTROL + "a");
        cityField.sendKeys(Keys.DELETE);
        cityField.sendKeys(city);
        cityField.sendKeys(Keys.ENTER);

        countryField.click();
        countryField.sendKeys(Keys.CONTROL + "a");
        countryField.sendKeys(Keys.DELETE);
        countryField.sendKeys(country);

        twitterField.click();
        twitterField.sendKeys(Keys.CONTROL + "a");
        twitterField.sendKeys(Keys.DELETE);
        twitterField.sendKeys(twitter);

        gitHubField.click();
        gitHubField.sendKeys(Keys.CONTROL + "a");
        gitHubField.sendKeys(Keys.DELETE);
        gitHubField.sendKeys(github);

        saveButton.click();
        driverWait.until(ExpectedConditions.visibilityOf(popUpMessage));

    }

}





