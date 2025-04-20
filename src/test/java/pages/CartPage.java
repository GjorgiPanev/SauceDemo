package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    private By checkoutBtn = By.id("checkout");
    private By titleConfirm = By.xpath("//span[text()='Checkout: Your Information']");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By titleOverview = By.xpath("//span[text()='Checkout: Overview']");
    private By productName = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }

    public String getCheckoutTitle() {
        return driver.findElement(titleConfirm).getText();
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterZipCode(String zip) {
        driver.findElement(zipCode).sendKeys(zip);
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void clickFinish() {
        driver.findElement(finishBtn).click();
    }

    public String getOverviewTitle() {
        return driver.findElement(titleOverview).getText();
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }
}
