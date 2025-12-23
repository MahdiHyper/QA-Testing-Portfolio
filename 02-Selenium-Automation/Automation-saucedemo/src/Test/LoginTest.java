package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import Page.ProductPage;

public class LoginTest extends BaseTest {
	

	@Test(priority = 1)
	public void testSuccessfulLogin() {
		
		ProductPage productPage = loginPage.login("standard_user", "secret_sauce");

		Assert.assertTrue(productPage.isProductPageTitleDisplayed(), "Login failed - Product page not displayed");
	}

	@Test(priority = 2)
	public void testLoginWithWrongPassword() {
		
		loginPage.login("standard_user", "wrong_password");

		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
	}

	@Test(priority = 3)
	public void testLoginWithEmptyUsername() {
		
		loginPage.login("", "secret_sauce");

		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
		Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"));
	}

	@Test(priority = 4)
	public void testLoginWithEmptyPassword() {
		
		loginPage.login("standard_user", "");

		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
		Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"));
	}
}