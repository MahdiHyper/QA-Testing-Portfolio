package automationexercise;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.TestUtils;

public class AutomationExerciseTests extends AutomationExerciseHelper {

	TestUtils utils;

	@BeforeTest
	public void setUp() throws SQLException {
		
		theSetUp();
		
		utils = new TestUtils(driver);
		
	}
	
	@AfterMethod
	public void takeScreenshotWhenFail(ITestResult result) throws IOException {
		
		//take screenshoy when the Test fail
		
		if (result.getStatus() == ITestResult.FAILURE) {
            String testName = result.getName();
            utils.takeScreenshot(testName);
            
        }
	}
	
	@AfterClass
	public void TearDown() {
		
		driver.quit();
	}
	
	

	@Test(priority = 1)
	public void homepageAccessibilityTest() throws IOException, InterruptedException {
		
		Assert.assertTrue(driver.getTitle().contains("Automation Exercise"), "Homepage should load");
		
	}

	@Test(priority = 2)
	public void userRegistrationTest() throws InterruptedException {
		
		
		WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
		signupLoginBtn.click();
		Thread.sleep(500);

		WebElement nameField = driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
		WebElement emailField = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));

		nameField.sendKeys(firstName);
		emailField.sendKeys(email);

		WebElement signupButton = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
		signupButton.click();
		Thread.sleep(1000);

		WebElement genderRadio = driver.findElement(By.id("id_gender1"));
		genderRadio.click();

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys(password);

		WebElement dayDropdown = driver.findElement(By.id("days"));
		Select daySelect = new Select(dayDropdown);
		daySelect.selectByValue("17");

		WebElement monthDropdown = driver.findElement(By.id("months"));
		Select monthSelect = new Select(monthDropdown);
		monthSelect.selectByValue("6");

		WebElement yearDropdown = driver.findElement(By.id("years"));
		Select yearSelect = new Select(yearDropdown);
		yearSelect.selectByValue("1998");

		WebElement firstNameField = driver.findElement(By.id("first_name"));
		WebElement lastNameField = driver.findElement(By.id("last_name"));
		WebElement address1Field = driver.findElement(By.id("address1"));
		WebElement countryDropdown = driver.findElement(By.id("country"));
		WebElement stateField = driver.findElement(By.id("state"));
		WebElement cityField = driver.findElement(By.id("city"));
		WebElement zipcodeField = driver.findElement(By.id("zipcode"));
		WebElement mobileField = driver.findElement(By.id("mobile_number"));

		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		address1Field.sendKeys("Test Address 123");

		Select countrySelect = new Select(countryDropdown);
		countrySelect.selectByValue("India");

		stateField.sendKeys("Test State");
		cityField.sendKeys("Test City");
		zipcodeField.sendKeys("12345");
		mobileField.sendKeys("0790000000");

		WebElement createAccountBtn = driver.findElement(By.cssSelector("button[data-qa='create-account']"));
		createAccountBtn.click();
		Thread.sleep(500);

		Assert.assertTrue(driver.getPageSource().contains("Account Created"), "Account should be created");

		WebElement continueBtn = driver.findElement(By.cssSelector("a[data-qa='continue-button']"));
		continueBtn.click();
		Thread.sleep(500);
		
	}


	@Test(priority = 3)
	public void productSearchTest() throws InterruptedException, IOException {
		
		driver.navigate().to("https://www.automationexercise.com/products");

		WebElement searchField = driver.findElement(By.id("search_product"));
		searchField.sendKeys("T-shirt");

		WebElement searchButton = driver.findElement(By.id("submit_search"));
		searchButton.click();
		Thread.sleep(1000);

		utils.scrollPageAndScreenShot(200, "search_results");

		Assert.assertTrue(driver.getCurrentUrl().contains("T-shirt"), "Search results should display");
		
	}

	@Test(priority = 4)
	public void viewingProductDetailsTest() throws InterruptedException, IOException {
		
		driver.navigate().to("https://www.automationexercise.com/product_details/28");

		Assert.assertTrue(driver.getCurrentUrl().contains("product_details"), "Product details should display");
		
	}

	@Test(priority = 5)
	public void addingProductToCartTest() throws InterruptedException {
		
		WebElement quantityField = driver.findElement(By.id("quantity"));
		quantityField.clear();
		quantityField.sendKeys("2");

		WebElement addToCartBtn = driver.findElement(By.cssSelector("button[class='btn btn-default cart']"));
		addToCartBtn.click();
		Thread.sleep(1000);

		WebElement continueShoppingBtn = driver.findElement(By.cssSelector("button[data-dismiss='modal']"));
		continueShoppingBtn.click();
		Thread.sleep(500);
		
	}

	@Test(priority = 6)
	public void viewingCartTest() throws InterruptedException, IOException {
		
		WebElement cartLink = driver.findElement(By.linkText("Cart"));
		cartLink.click();
		Thread.sleep(1000);

		utils.scrollPageAndScreenShot(500, "cart_view");

		Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Cart should display");
	
	}

	@Test(priority = 7)
	public void verifyCartQuantityTest() {
		
		WebElement quantityElement = driver.findElement(By.cssSelector("button[class='disabled']"));
		Assert.assertEquals(quantityElement.getText(), "2", "Quantity should be 2");
	
	}

	@Test(priority = 8)
	public void proceedToCheckoutTest() throws InterruptedException, IOException {
		
		
		WebElement checkoutBtn = driver.findElement(By.linkText("Proceed To Checkout"));
		checkoutBtn.click();
		Thread.sleep(1000);

		utils.scrollPageAndScreenShot(0, "checkout_page");

		Assert.assertTrue(driver.getCurrentUrl().contains("checkout"), "Checkout page should display");
		
		
	}

	@Test(priority = 9)
	public void contactFormSubmissionTest() throws InterruptedException, IOException {
		
		
		driver.get(websiteURL);
		Thread.sleep(500);

		WebElement contactLink = driver.findElement(By.linkText("Contact us"));
		contactLink.click();
		Thread.sleep(500);

		WebElement nameField = driver.findElement(By.cssSelector("input[data-qa='name']"));
		WebElement emailField = driver.findElement(By.cssSelector("input[data-qa='email']"));
		WebElement subjectField = driver.findElement(By.cssSelector("input[data-qa='subject']"));
		WebElement messageField = driver.findElement(By.cssSelector("textarea[data-qa='message']"));

		nameField.sendKeys(firstName);
		emailField.sendKeys(email);
		subjectField.sendKeys("Test Subject");
		messageField.sendKeys("This is a test message");

		WebElement submitBtn = driver.findElement(By.cssSelector("input[data-qa='submit-button']"));
		submitBtn.click();

		driver.switchTo().alert().accept();
		Thread.sleep(1000);

		utils.scrollPageAndScreenShot(100, "contact_form");
		
	}

	@Test(priority = 10)
	public void subscriptionTest() throws InterruptedException, IOException {
		
		
		driver.get(websiteURL);
		Thread.sleep(500);

		utils.scrollPageAndScreenShot(10000, "footer");

		WebElement subscribeField = driver.findElement(By.id("susbscribe_email"));
		subscribeField.sendKeys(email);

		WebElement subscribeBtn = driver.findElement(By.id("subscribe"));
		subscribeBtn.click();
		Thread.sleep(2000);

		Assert.assertTrue(driver.getPageSource().contains("You have been successfully subscribed"),
				"Subscription should succeed");
		
		
	}

	@Test(priority = 11)
	public void viewingCategoryProductsTest() throws InterruptedException, IOException {
		
		WebElement womenCategory = driver.findElement(By.cssSelector("a[href='#Men']"));
		womenCategory.click();
		Thread.sleep(1000);

		WebElement dressSubcategory = driver.findElement(By.cssSelector("a[href='/category_products/6']"));
		dressSubcategory.click();
		Thread.sleep(1000);

		utils.scrollPageAndScreenShot(500, "category_products");

		Assert.assertTrue(driver.getCurrentUrl().contains("6"), "Category should display");
		
	}

	@Test(priority = 12)
	public void viewingBrandProductsTest() throws InterruptedException, IOException {
		
		
		WebElement productsLink = driver.findElement(By.linkText("Products"));
		productsLink.click();
		Thread.sleep(500);

		WebElement brandLink = driver.findElement(By.cssSelector("a[href='/brand_products/Babyhug']"));
		brandLink.click();
		Thread.sleep(1000);

		//utils.scrollPageAndScreenShot(500, "brand_products");

		Assert.assertTrue(driver.getCurrentUrl().contains("Babyhug"), "Brand should display");
		
	}

	@Test(priority = 13)
	public void scrollUpTest() throws InterruptedException, IOException {
		
		
		utils.scrollPageAndScreenShot(2000, "bottom");

		WebElement scrollUpBtn = driver.findElement(By.id("scrollUp"));
		scrollUpBtn.click();
		Thread.sleep(1000);

		utils.scrollPageAndScreenShot(0, "top");
		
	}

	@Test(priority = 14)
	public void logoutTest() throws InterruptedException {
		
		WebElement logoutLink = driver.findElement(By.linkText("Logout"));
		logoutLink.click();
		Thread.sleep(1000);

		Assert.assertTrue(driver.getCurrentUrl().contains("login"), "User should be logged out");
		
		
	}
	
	
	
	
	
}






























