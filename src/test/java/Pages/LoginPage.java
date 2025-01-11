package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.Constants;
import util.ElementHelper;
import util.LoginHelper;

import java.time.Duration;

import static util.Constants.EXPLICIT_WAIT;

public class LoginPage {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    @FindBy(css = "div.user-info span.hidden-sm-down")
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
        usernameBox.sendKeys(LoginHelper.getUserName(username));
    }

    public void writePasswordForPasswordField(String password) {
        passwordBox.sendKeys(LoginHelper.getPassword(password));
    }

    public void clickLogin() {
        elementHelper.click(loginButton);
    }

    public void checkUnsuccessful() {
        elementHelper.checkNotVisible(signOutButton);
    }

    public void checkSuccessful() {
     elementHelper.checkVisible(signOutButton);
    }

    public void dontCredentialValidErrorMessage(String message) {
        elementHelper.checkVisible(errorMessage);
        Assert.assertEquals(errorMessage.getText(),message);
    }

    public void login(String username,String password){
        clickSignInButton();
        writeUsernameForUsernameField(username);
        writePasswordForPasswordField(password);
        clickLogin();
        checkSuccessful();
    }
}
