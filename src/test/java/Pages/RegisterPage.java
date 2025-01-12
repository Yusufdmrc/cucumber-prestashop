package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.ElementHelper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static util.Constants.EXPLICIT_WAIT;

public class RegisterPage {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    @FindBy(xpath = "//iframe[@id='framelive']")
    WebElement iframe;
    @FindBy(css = "div.user-info span.hidden-sm-down")
    WebElement signInButton;
    @FindBy(css = "a[data-link-action='display-register-form']")
    WebElement registrationButton;
    @FindBy(css = "label[for='field-id_gender-1']")
    WebElement mrTitle;
    @FindBy(css = "label[for='field-id_gender-2']")
    WebElement mrsTitle;
    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstNameInput;
    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastNameInput;
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailInput;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//input[@name='birthday']")
    WebElement birthdayInput;
    @FindBy(xpath = "//input[@name='customer_privacy']")
    WebElement customerPrivacyCheckbox;
    @FindBy(xpath = "//input[@name='psgdpr']")
    WebElement termsCheckbox;
    @FindBy(css = "button[type='submit']")
    WebElement registerButton;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        this.elementHelper = new ElementHelper(driver);
        PageFactory.initElements(driver, this);
    }


    public void navigatesToRegistrationPage() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        elementHelper.click(signInButton);
        elementHelper.click(registrationButton);
    }

    public void fillRegistrationFormWithRandomData() {
        Random random = new Random();

        String[] titles = {"Mr.", "Mrs."};
        String randomTitle = titles[random.nextInt(titles.length)];
        String randomFirstName = "John" + random.nextInt(1000);
        String randomLastName = "Doe" + random.nextInt(1000);
        String randomEmail = "user" + random.nextInt(1000) + "@example.com";
        String randomPassword = "Password" + random.nextInt(1000);

        Calendar calendar = Calendar.getInstance();
        int year = random.nextInt(50) + 1970; // 1970 ile 2020 arasında bir yıl
        int month = random.nextInt(12); // 0-11 (Ocak - Aralık)
        int day = random.nextInt(28) + 1; // 1-28 (Tüm aylarda geçerli)
        calendar.set(year, month, day);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String randomBirthday = dateFormat.format(calendar.getTime());

        if (randomTitle.equals("Mr.")) {
            elementHelper.click(mrTitle);
        } else {
            elementHelper.click(mrsTitle);
        }

        firstNameInput.sendKeys(randomFirstName);
        lastNameInput.sendKeys(randomLastName);
        emailInput.sendKeys(randomEmail);
        passwordInput.sendKeys(randomPassword);
        birthdayInput.sendKeys(randomBirthday);

        elementHelper.click(customerPrivacyCheckbox);
        elementHelper.click(termsCheckbox);
    }

    public void submitRegistrationForm() {
        elementHelper.click(registerButton);
    }

    public void verifyRegister() {
    }
}
