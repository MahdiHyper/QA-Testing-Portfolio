package practicesoftware;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.TestUtils;

public class PracticeSoftwareTests extends PracticeSoftwareHelper {

	TestUtils utils;

	@BeforeTest
	public void setUp() throws SQLException {
		
		theSetUp();
		utils = new TestUtils(driver);
		
	}
	
	@AfterMethod
	public void takeScreenshotWhenFail(ITestResult result) throws IOException {
		
		//take screenshoy when fail
		
		if (result.getStatus() == ITestResult.FAILURE) {
            String testName = result.getName();
            utils.takeScreenshot(testName);
        }
	}

	@Test(priority = 1)
	public void homepageAccessibilityTest() throws IOException, InterruptedException {
		
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Practice Software Testing"), "Homepage should load");
		
	}

	@Test(priority = 2)
	public void userRegistrationTest() throws InterruptedException {
		
		WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		signInLink.click();
		Thread.sleep(1000);

		WebElement registerTab = driver.findElement(By.linkText("Register your account"));
		registerTab.click();
		Thread.sleep(1000);

		WebElement firstNameField = driver.findElement(By.id("first_name"));
		WebElement lastNameField = driver.findElement(By.id("last_name"));
		WebElement dobField = driver.findElement(By.id("dob"));
		WebElement addressField = driver.findElement(By.id("street"));
		WebElement postcodeField = driver.findElement(By.id("postal_code"));
		WebElement cityField = driver.findElement(By.id("city"));
		WebElement stateField = driver.findElement(By.id("state"));
		WebElement countryDropdown = driver.findElement(By.id("country"));
		WebElement phoneField = driver.findElement(By.id("phone"));
		WebElement emailField = driver.findElement(By.id("email"));
		WebElement passwordField = driver.findElement(By.id("password"));

		firstNameField.sendKeys(getFirstName());
		lastNameField.sendKeys(getLastName());
		dobField.sendKeys("1990-01-01");
		addressField.sendKeys(getAddress());
		postcodeField.sendKeys("12345");
		cityField.sendKeys(getCity());
		stateField.sendKeys("State");

		Select countrySelect = new Select(countryDropdown);
		countrySelect.selectByIndex(1);

		phoneField.sendKeys("962770000000");
		emailField.sendKeys(getEmail());
		passwordField.sendKeys(getPassword());

		WebElement registerButton = driver.findElement(By.cssSelector("button[data-test='register-submit']"));
		registerButton.click();
		Thread.sleep(2000);

		Assert.assertTrue(driver.getCurrentUrl().contains("login"),
				"Should redirect to Login Page");
	
	}

	@Test(priority = 3)
	public void userLoginTest() throws InterruptedException {
		
		WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		signInLink.click();
		Thread.sleep(1000);

		WebElement emailField = driver.findElement(By.id("email"));
		WebElement passwordField = driver.findElement(By.id("password"));

		emailField.sendKeys(getEmail());
		passwordField.sendKeys(getPassword());

		WebElement loginButton = driver.findElement(By.cssSelector("input[data-test='login-submit']"));
		loginButton.click();
		Thread.sleep(2000);

		Assert.assertTrue(driver.getPageSource().contains("My account") 
				|| driver.getCurrentUrl().contains("account"),
				"User should be logged in");
		
	}

	@Test(priority = 4)
	public void productSearchTest() throws InterruptedException, IOException {
		
		driver.findElement(By.id("Layer_1")).click();
		
		WebElement searchField = driver.findElement(By.cssSelector("input[data-test='search-query']"));
		searchField.sendKeys("hammer");

		WebElement searchButton = driver.findElement(By.cssSelector("button[data-test='search-submit']"));
		searchButton.click();
		Thread.sleep(2000);

		utils.scrollPageAndScreenShot(400, "search_results");

		Assert.assertTrue(driver.getPageSource().contains("Hammer") 
				|| driver.getPageSource().contains("hammer"),
				"Search results should display");
		
	}

	@Test(priority = 5)
	public void filteringSearchResultsTest() throws InterruptedException, IOException {
		
		WebElement sortDropdown = driver.findElement(By.cssSelector("select[data-test='sort']"));
		Select selectedSort = new Select(sortDropdown);
		selectedSort.selectByIndex(1);
		Thread.sleep(2000);

		utils.scrollPageAndScreenShot(500, "filtered_results");
		
	}

	@Test(priority = 6)
	public void viewingProductDetailsTest() throws InterruptedException, IOException {
		
		WebElement firstProduct = driver.findElement(By.cssSelector("h5[data-test='product-name']"));
		firstProduct.click();
		Thread.sleep(2000);

		utils.scrollPageAndScreenShot(600, "product_details");

		Assert.assertTrue(driver.getPageSource().contains("Add to cart"), "Product details should display");
		
	}

	@Test(priority = 7)
	public void addingProductToCartTest() throws InterruptedException {
		
		WebElement addToCartButton = driver.findElement(By.id("btn-add-to-cart"));
		addToCartButton.click();
		Thread.sleep(2000);

		Assert.assertTrue(driver.getPageSource().contains("Product added"), "Product should be added to cart");
		
	}

	@Test(priority = 8)
	public void viewingCheckout() throws InterruptedException, IOException {
		
		WebElement cartIcon = driver.findElement(By.id("lblCartCount"));
		cartIcon.click();
		Thread.sleep(2000);

		utils.scrollPageAndScreenShot(400, "checkout_view");

		Assert.assertTrue(driver.getCurrentUrl().contains("checkout"), "checkout page should display");
		
	}


	@Test(priority = 9)
	public void removingItemFromCartTest() throws InterruptedException {
		
		WebElement removeButton = driver.findElement(By.cssSelector(".btn.btn-danger"));
		removeButton.click();
		Thread.sleep(2000);

		Assert.assertTrue(driver.findElement(By.className("ng-star-inserted")).getText().contains("empty") 
				|| driver.getPageSource().contains("0 items"),
				"Cart should be empty");
		
	}

	@Test(priority = 10)
	public void proceedToCheckoutTest() throws InterruptedException, IOException {
		
		driver.get(websiteURL);
		Thread.sleep(500);

		WebElement firstProduct = driver.findElement(By.cssSelector("h5[data-test='product-name']"));
		firstProduct.click();
		Thread.sleep(1000);

		WebElement addToCartButton = driver.findElement(By.id("btn-add-to-cart"));
		addToCartButton.click();
		Thread.sleep(1000);

		WebElement cartIcon = driver.findElement(By.id("lblCartCount"));
		cartIcon.click();
		Thread.sleep(1000);

		WebElement checkoutButton = driver.findElement(By.cssSelector("button[data-test='proceed-1']"));
		checkoutButton.click();
		Thread.sleep(1000);
		
		WebElement checkoutButton2 = driver.findElement(By.cssSelector("button[data-test='proceed-2']"));
		checkoutButton2.click();
		Thread.sleep(1000);

		utils.scrollPageAndScreenShot(300, "checkout_page");

		Assert.assertTrue(driver.getCurrentUrl().contains("checkout"), "Checkout page should display");
		
	}

	@Test(priority = 11)
	public void completePurchaseSubmissionTest() throws InterruptedException, IOException {

		WebElement sendButton = driver.findElement(By.cssSelector("button[data-test='proceed-3']"));
		sendButton.click();
		Thread.sleep(2000);
		
		Select selectPaymentMethod = new Select(driver.findElement(By.id("payment-method")));
		selectPaymentMethod.selectByValue("cash-on-delivery");
		
		WebElement confirmButton = driver.findElement(By.cssSelector("button[data-test='finish']"));
		confirmButton.click();
		
		WebElement successMessage = driver.findElement(By.cssSelector("div[data-test='payment-success-message']"));
		
		Assert.assertEquals(true, successMessage.isDisplayed());
	}

	@Test(priority = 12)
	public void viewingAccountInformationTest() throws InterruptedException, IOException {
		
		WebElement menuLink = driver.findElement(By.id("menu"));
		menuLink.click();

		
		WebElement myAccountLink = driver.findElement(By.linkText("My account"));
		myAccountLink.click();
		Thread.sleep(2000);
		
		WebElement profileButton = driver.findElement(By.cssSelector("a[data-test='nav-profile']"));
		profileButton.click();
		Thread.sleep(1000);


		utils.scrollPageAndScreenShot(400, "account_info");

		Assert.assertTrue(driver.getCurrentUrl().contains("profile"), "Account page should display");
		
	}


	@Test(priority = 13)
	public void loggingOutTest() throws InterruptedException {
		
		WebElement menuLink = driver.findElement(By.id("menu"));
		menuLink.click();

		
		WebElement signOutLink = driver.findElement(By.linkText("Sign out"));
		signOutLink.click();
		Thread.sleep(2000);

		Assert.assertTrue(driver.getPageSource().contains("Sign in"), "User should be logged out");
	}
	
}
















