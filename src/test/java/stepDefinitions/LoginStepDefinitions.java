package stepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class LoginStepDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("User click sign in button on homepage")
    public void userClickSignInButtonOnHomepage() {
        loginPage.clickSignInButton();
    }

    @And("Click sign in button")
    public void clickSignInButton() {
        loginPage.clickLogin();
    }

    @And("write {string} for username field")
    public void writeForUsernameField(String username) {
        loginPage.writeUsernameForUsernameField(username);

    }

    @And("write {string} for password field")
    public void writeForPasswordField(String password) {
        loginPage.writePasswordForPasswordField(password);
    }

    @Then("Check the {string} message that authentication was not successful")
    public void checkTheMessageThatAuthenticationWasNotSuccessful(String message) {
        loginPage.dontCredentialValidErrorMessage(message);
    }

    @Then("Check Successful login")
    public void checkSuccessfulLogin() {
        loginPage.checkSuccessful();
    }

    @Then("Check unsuccessful login")
    public void checkUnsuccessfulLogin() {
        loginPage.checkUnsuccessful();
    }
}
