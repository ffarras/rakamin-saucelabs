package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class product {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    String productName = "Sauce Labs Backpack";
    String productPrice = "29.99";

    @Given("User logged in and on Products page")
    public void userLoggedInOnProductsPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("User clicked one of the products")
    public void userClickedOneOfTheProducts() {
        driver.findElement(By.xpath("//div[contains(text(), '"+productName+"')]")).click();
    }

    @Then("User in Product Detail page")
    public void userInProductDetailPage() {
        String productNameDetail = driver.findElement(By.xpath("//div[contains(@class, 'inventory_details_name large_size')]")).getText();
        Assert.assertEquals(productName, productNameDetail);
        driver.close();
    }

    @When("User clicked Add to Cart for one of the product")
    public void userClickedAddToCartForOneOfTheProduct() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("User clicked Cart icon on the top right side")
    public void userClickedCartIconOnTheTopRightSide() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("User should see details of added product")
    public void userShouldSeeDetailsOfAddedProduct() {
        String productNameDetail = driver.findElement(By.xpath("//div[contains(@class, 'inventory_item_name')]")).getText();
        Assert.assertEquals(productName, productNameDetail);
        driver.close();
    }

    @And("User clicked Checkout button")
    public void userClickedCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("User input first name")
    public void userInputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Andi");
    }

    @And("User input last name")
    public void userInputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Mallarangeng");
    }

    @And("User input zip code")
    public void userInputZipCode() {
        driver.findElement(By.id("postal-code")).sendKeys("13456");
    }

    @And("User clicked Continue button")
    public void userClickedContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @And("User checked the product in checkout")
    public void userCheckedTheProductInCheckout() {
        String productNameDetail = driver.findElement(By.xpath("//div[contains(@class, 'inventory_item_name')]")).getText();
        String productPriceDetail = driver.findElement(By.xpath("//div[contains(@class, 'summary_subtotal_label')]")).getText();
        Assert.assertEquals(productName, productNameDetail);
        Assert.assertEquals("Item total: $"+productPrice, productPriceDetail);
    }

    @And("User clicked Finish button")
    public void userClickedFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("User should see checkout complete confirmation")
    public void userShouldSeeCheckoutCompleteConfirmation() {
        String completeMsg = driver.findElement(By.xpath("//h2[contains(@class, 'complete-header')]")).getText();
        Assert.assertEquals("Thank you for your order!", completeMsg);
        driver.close();
    }

    @And("User input (.*) as first name$")
    public void userInputFirstNameAsFirstName(String firstName) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
    }

    @And("User input (.*) as last name$")
    public void userInputLastNameAsLastName(String lastName) {
        driver.findElement(By.id("last-name")).sendKeys(lastName);
    }

    @And("User input (.*) as zip code$")
    public void userInputZipCodeAsZipCode(String zipCode) {
        driver.findElement(By.id("postal-code")).sendKeys(zipCode);
    }

    @Then("User should see alert (.*) must be filled$")
    public void userShouldSeeAlertAlertMessageMustBeFilled(String alertMessage) {
        String actualAlertMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(alertMessage, actualAlertMessage);
        driver.close();
    }
}
