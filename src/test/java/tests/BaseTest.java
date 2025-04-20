package tests;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.*;

import java.io.FileReader;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected CartPage cartPage;

    protected String username;
    protected String password;

    @BeforeClass
    public void setupClass() throws Exception {
        JsonObject data = JsonParser.parseReader(new FileReader("src/test/java/data/user.json")).getAsJsonObject();
        username = data.get("username").getAsString();
        password = data.get("password").getAsString();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
