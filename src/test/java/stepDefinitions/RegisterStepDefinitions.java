package stepDefinitions;

import Pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class RegisterStepDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    RegisterPage registerPage = new RegisterPage(driver);


    @Given("User navigates to the registration page")
    public void userNavigatesToTheRegistrationPage() {
        registerPage.navigatesToRegistrationPage();
    }

    @When("User fills the registration form with random data")
    public void userFillsTheRegistrationFormWithRandomData() {
        registerPage.fillRegistrationFormWithRandomData();
    }

    @And("User submits the registration form")
    public void userSubmitsTheRegistrationForm() {
        registerPage.submitRegistrationForm();
    }

    @Then("Verify the account is successfully created")
    public void verifyTheAccountIsSuccessfullyCreated() {
        registerPage.verifyRegister();
    }
}
