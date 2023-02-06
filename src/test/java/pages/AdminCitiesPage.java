package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {


    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span")
    private WebElement newItemButton;
    @FindBy(id = "name")
    private WebElement cityName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]/span")
    private WebElement saveButton;
    @FindBy(className = "btnLogout")
    private WebElement logOutButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement popUpMassage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")
    private WebElement searchedCityName;

    @FindBy(id = "search")
    private WebElement search;

    @FindBy(xpath = "//*[@id=\"edit\"]/span")
    private WebElement editButton;
    @FindBy(name = "name")
    private WebElement nameForEdit;

    @FindBy(className = "btnSave")
    private WebElement editSaveButton;

    @FindBy(xpath = "//*[@id=\"delete\"]/span")
    private WebElement deleteCityButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]")
    private WebElement deleteButton;


    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getPopUpMassage() {
        return popUpMassage;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public void createNewCity(String city) {
        driverWait.until(ExpectedConditions.elementToBeClickable(newItemButton));
        newItemButton.click();
        cityName.sendKeys(city);
        saveButton.click();
    }

    public void searchCity(String city) {
        search.sendKeys(city);
    }

    public void editCity(String city) {
        searchCity(city);
        driverWait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButton.click();
        nameForEdit.sendKeys(" - edited");
        editSaveButton.click();
    }

    public void deleteCity(String city) {
        searchCity(city);
        deleteCityButton.click();
        deleteButton.click();
        driverWait.until(ExpectedConditions.visibilityOf(popUpMassage));
    }

    public void logout() {
        logOutButton.click();
    }
}
