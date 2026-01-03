package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductPage;

public class ProductTest extends BaseTest {
	
	private ProductPage productPage;
	
	@BeforeMethod
	public void setUpProductPage() {
		
		productPage = loginPage.login("standard_user", "secret_sauce");
	}
	
	
	@Test (priority = 1)
	public void testIsTitleDisplayed () {
		
		assertTrue(productPage.isPageTitleDisplayed() , "Title is product page must showed");
	}
	
	@Test (priority = 2)
	public void testAddAllProductsToCart() {
		
		productPage.addAllProductsToCart();
		String NumberOfProductsAdded = productPage.getNumberOfAddedProducts();
		
		assertEquals(NumberOfProductsAdded, "6");
		
	}
	
	@Test (priority = 3)
	public void testAddRandomProductToCart () {
		
		int NumberOfAllProducts = productPage.getNumberOfAllProducts();
		
		Random rand = new Random();
		
		int randomNumber = rand.nextInt(NumberOfAllProducts);
		
		productPage.addProductToCartByIndex(randomNumber);
		
		String numberInCartBadge = productPage.getNumberOfAddedProducts();
		
		assertEquals(numberInCartBadge, "1" , "number of added products must  be '1' only ");
	}
	
	@Test (priority = 4)
	public void testRemoveAllProductsFromCart() {
		
		productPage.removeAllProductsFromCart();
		boolean isBadgeDisplayed = productPage.isCartBadgeDisplayed();
		
		assertFalse(isBadgeDisplayed , "the badge of cart should not displayed because all removed");
	}




}
