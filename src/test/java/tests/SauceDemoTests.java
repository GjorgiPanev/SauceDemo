package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.String;
import java.time.Duration;

public class SauceDemoTests extends BaseTest {

    @Test
    public void completeSauceDemoFlow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Log in
        loginPage.loginToSauceDemo(username, password);
        //Verify that user is on the right page after login
        Assert.assertEquals(loginPage.getTitleText(), "Swag Labs");
        Assert.assertTrue(homePage.isOnHomePage());

        //Add product to cart
        homePage.clickAddToCart(0);
        String addedProduct = homePage.getProductName(0);
        homePage.clickCart();
        //Verify cart content
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
        Assert.assertEquals(homePage.getItemsInCartCount(), 1);
        Assert.assertTrue(homePage.getProductName(0).contains(addedProduct));
        //Continue to checkout
        cartPage.clickCheckout();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header_secondary_container")));
        //Verify checkout content
        Assert.assertEquals(cartPage.getCheckoutTitle(), "Checkout: Your Information");

        cartPage.enterFirstName("Gjorgi");
        cartPage.enterLastName("Hello");
        cartPage.enterZipCode("1000");
        cartPage.clickContinue();

        //Assert.assertEquals(cartPage.getOverviewTitle(), "Checkout: Overview");
        Assert.assertTrue(cartPage.getProductName().contains(addedProduct));

        cartPage.clickFinish();
        //Logout
        loginPage.openMenu();
        loginPage.logOut();
        Assert.assertEquals(loginPage.getTitleText(), "Swag Labs");
    }
}
