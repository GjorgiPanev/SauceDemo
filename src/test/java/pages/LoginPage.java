package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private By username = By.id("user-name");
    private By password = By.name("password");
    private By loginBttn = By.id("login-button");
    private By title = By.xpath("//div[text()='Swag Labs']");
    private By hamburgerMenu = By.id("react-burger-menu-btn");
    private By logOut = By.cssSelector("[data-test='logout-sidebar-link']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String user) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        userNameField.sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLoginButton() {
        driver.findElement(loginBttn).click();
    }

    public void loginToSauceDemo(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLoginButton();
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public void openMenu() {
        driver.findElement(hamburgerMenu).click();
    }

    public void logOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logOutBtn = wait.until(ExpectedConditions.elementToBeClickable(logOut));
        logOutBtn.click();
    }
}
