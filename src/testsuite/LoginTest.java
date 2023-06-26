package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseURL = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “standard_user” username
        WebElement userNameLink = driver.findElement(By.id("user-name"));
        userNameLink.sendKeys("standard_user");

        // Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        // Verify the text “PRODUCTS”
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("Products text not displayed", expectedText, actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Enter “standard_user” username
        WebElement userNameLink = driver.findElement(By.id("user-name"));
        userNameLink.sendKeys("standard_user");
        // Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        // Verify that six products are displayed on page
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        System.out.println("Total products are : " + productList.size());
        // Verify the number of products are 6
        int expectedSize = 6;
        int actualSize = productList.size();
        Assert.assertEquals("Products size is not match ", expectedSize, actualSize);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

