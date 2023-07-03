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
    String baseUrl = "https://www.saucedemo.com/\n";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
    
    @Test
    public void userSholdLoginSuccessfullyWithValid(){

        //* Enter “standard_user” username
        driver.findElement(By.name("user-name")).sendKeys("standard_user");

        //* Enter “secret_sauce” password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //* Click on ‘LOGIN’ button
        driver.findElement(By.name("login-button")).click();

        //* Verify the text “PRODUCTS”
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//div[@class='header_secondary_container']//span[text()='Products']")).getText();

        //Assert
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        //* Enter “standard_user” username
        driver.findElement(By.name("user-name")).sendKeys("standard_user");

        //* Enter “secret_sauce” password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //* Click on ‘LOGIN’ button
        driver.findElement(By.name("login-button")).click();

        //* Verify that six products are displayed on page
        List<WebElement> products = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        int expected = 6;
        int actual = products.size();

        //Assert
        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
