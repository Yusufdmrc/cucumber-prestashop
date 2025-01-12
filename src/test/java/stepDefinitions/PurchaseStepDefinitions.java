package stepDefinitions;

import Pages.PurchasePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.DriverFactory;

public class PurchaseStepDefinitions {

    WebDriver driver = DriverFactory.getDriver();
    PurchasePage purchasePage = new PurchasePage(driver);

    @Given("User configures item with {string}, {string}, {string}, and {string}")
    public void userConfiguresItemWith(String category, String color, String size, String quantity) {
        purchasePage.switchToFrame();
        purchasePage.configureItem(category, color, size, quantity);
    }

    @And("User adds the item to the cart")
    public void userAddsTheItemToTheCart() {
        purchasePage.addToCart();
    }

    @Then("Verify the item is successfully added to the cart")
    public void verifyTheItemIsSuccessfullyAddedToTheCart() {
        Assert.assertTrue(purchasePage.isItemAddedToCart(), "Item was not added to the cart!");
    }
}
