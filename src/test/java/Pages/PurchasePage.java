package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ElementHelper;

import java.util.List;

public class PurchasePage {

    WebDriver driver;
    ElementHelper elementHelper;

    @FindBy(xpath = "//iframe[@id='framelive']")
    WebElement iframe;

    @FindBy(css = ".category a")
    List<WebElement> categories;

    @FindBy(css = ".color")
    List<WebElement> colors;

    @FindBy(id = "group_1")
    WebElement sizeDropdown;

    @FindBy(css = "#quantity_wanted")
    WebElement quantityInput;

    @FindBy(css = ".add-to-cart")
    WebElement addToCartButton;

    @FindBy(css = ".cart-content")
    WebElement successMessage;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public void switchToFrame() {
        elementHelper.checkVisible(iframe);
        driver.switchTo().frame(iframe);
    }

    public void configureItem(String category, String color, String size, String quantity) {

        for (WebElement cat : categories) {
            if (cat.getText().equalsIgnoreCase(category)) {
                elementHelper.click(cat);
                break;
            }
        }

        if (!color.equalsIgnoreCase("None")) {
            for (WebElement clr : colors) {
                if (clr.getAttribute("title").equalsIgnoreCase(color)) {
                    elementHelper.click(clr);
                    break;
                }
            }
        }

        if (!size.equalsIgnoreCase("None")) {
            elementHelper.click(sizeDropdown);
            List<WebElement> sizes = sizeDropdown.findElements(By.tagName("option"));
            for (WebElement s : sizes) {
                if (s.getText().equalsIgnoreCase(size)) {
                    elementHelper.click(s);
                    break;
                }
            }
        }

        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    public void addToCart() {
        elementHelper.click(addToCartButton);
    }

    public boolean isItemAddedToCart() {
        elementHelper.checkVisible(successMessage);
        return successMessage.isDisplayed();
    }
}
