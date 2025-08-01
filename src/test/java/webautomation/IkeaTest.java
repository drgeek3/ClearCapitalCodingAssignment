package webautomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class IkeaTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.ikea.com/us/en/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testLoggingIntoApplication() {

        //First page: Type sofa and press Enter
        WebElement searchBox = driver.findElement(By.id("ikea-search-input"));
        searchBox.sendKeys("sofa" + Keys.ENTER);

        //Click the add to cart button for the first item. Probably protected from automation so had to force the click.
        List<WebElement> addToCart1 = driver.findElements(By.cssSelector(".plp-btn--icon-emphasised"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addToCart1.get(0));

        //Second page: Clear search box, type table, and press Enter.
        driver.findElement(By.cssSelector(".search-box-search__clear")).click();
        WebElement searchBoxPg2 = driver.findElement(By.id("ikea-search-input"));
        searchBoxPg2.sendKeys("table" + Keys.ENTER);

        //Wait for "table" to appear in search results before moving on
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedCondition<Boolean>) driver -> driver.findElement(By.tagName("h1")).getText().contains("table"));

        //Click the add to cart button for the 3rd item on the page
        List<WebElement> addToCart2 = driver.findElements(By.cssSelector(".plp-btn--icon-emphasised"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addToCart2.get(2));

        //Click the shopping cart button at the top of the page
        WebElement shoppingCart = driver.findElement(By.cssSelector(".js-shopping-cart-icon"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", shoppingCart);

        //Shopping Cart: Open the discount code box
        driver.findElement(By.cssSelector(".cart-ingka-accordion-item-header--medium")).click();

        //Send the 15 character random code and click the apply button
        WebElement discountCode = driver.findElement(By.id("discountcode-input"));
        discountCode.sendKeys("randomstringo15");
        driver.findElement(By.cssSelector(".cart-ingka-btn--primary._button_3mtui_14")).click();

        //Check to make sure the reject phrase is present after licking the button
        String actualResult = driver.findElement(By.id("discount-code__error")).getText();
        String expectedResult = "Please enter a valid discount code.";
        Assert.assertEquals(actualResult,expectedResult);
    }
}
