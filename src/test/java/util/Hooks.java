package util;

import Pages.CookiePage;
import Pages.LoginPage;
import io.cucumber.java.*;
import org.openqa.selenium.*;
import java.util.Properties;

public class Hooks {

    WebDriver driver;
    Properties properties;
    private void initializeDriverAndHandleCookies() {
        String browser = System.getProperty("browser");
        String testEnv = System.getProperty("testEnv");
    }
    @Before("(not @SkipLogin)")
    public void before() {
        initializeDriverAndHandleCookies();
    }
    @Before("@SkipLogin")
    public void beforeSkipLogin(){
        initializeDriverAndHandleCookies();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Constants.CORRECT_EMAIL,Constants.CORRECT_PASSWORD);
    }
    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts=(TakesScreenshot) driver;

            byte[] src=ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src,"image/png","screnshot");
        }
    }
    @After
    public void after() {
        driver.quit();
    }
}
