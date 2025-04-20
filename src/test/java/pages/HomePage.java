package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    private By addToCartButtons = By.xpath("//button[text()='Add to cart']");
    private By cartButton = By.className("shopping_cart_link");
    private By productNames = By.className("inventory_item_name");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart(int index) {
        List<WebElement> buttons = driver.findElements(By.xpath("//button[contains(text(), 'Add to cart')]"));
        WebElement button = buttons.get(index);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    public void clickCart() {
        driver.findElement(cartButton).click();
    }

    public String getProductName(int index) {
        return driver.findElements(productNames).get(index).getText();
    }

    public int getItemsInCartCount() {
        List<WebElement> items = driver.findElements(By.className("cart_item"));
        return items.size();
    }

    public boolean isOnHomePage(){
        return driver.getCurrentUrl().contains("inventory");
    }
}
