package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.Constants;
import util.ElementHelper;

import java.time.Duration;

import static util.Constants.EXPLICIT_WAIT;

public class LoginPage {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    WebElement signInButton;
    @FindBy(id = "field-email")
    WebElement usernameBox;
    @FindBy(id="field-password")
    WebElement passwordBox;
    @FindBy(id = "submit-login")
    WebElement loginButton;
    @FindBy(xpath = "//li[@class='alert alert-danger']")
    WebElement errorMessage;
    @FindBy(xpath = "//a[@class='logout hidden-sm-down']")
    WebElement signOutButton;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        this.elementHelper = new ElementHelper(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickSignInButton() {
        String expectedUrl = Constants.TEST_URL;
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        elementHelper.click(signInButton);
    }
    public void writeUsernameForUsernameField(String username) {
        usernameBox.sendKeys(username);
    }

    public void writePasswordForPasswordField(String password) {
        usernameBox.sendKeys(password);
    }

    public void clickLogin() {
    }

    public void checkUnsuccessful() {
    }

    public void checkSuccessful() {
    }

    public void dontCredentialValidErrorMessage(String message) {
    }
}
