package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.util.Random;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.source.tree.AssertTree;

import pages.CartPage;
import pages.ProductPage;

public class ProductTest extends BaseTest {

    private ProductPage productPage;

    @BeforeMethod
    public void setUpProductPage() {
    	
        productPage = loginPage.login("standard_user", "secret_sauce");
    }

    @Test(priority = 1)
    public void testIsTitleDisplayed() {
    	
        assertTrue(productPage.isPageTitleDisplayed(), 
            "Product page title must be displayed");
    }

    @Test(priority = 2)
    public void testAddAllProductsToCart() {
    	
        productPage.addAllProductsToCart();
        String numberOfProductsAdded = productPage.getNumberOfAddedProducts();

        assertEquals(numberOfProductsAdded, "6", 
            "Cart should have 6 products");
    }

    @Test(priority = 3)
    public void testAddRandomProductToCart() {
    	
        int numberOfAllProducts = productPage.getNumberOfAllProducts();

        Random rand = new Random();
        int randomNumber = rand.nextInt(numberOfAllProducts);

        productPage.addProductToCartByIndex(randomNumber);

        String numberInCartBadge = productPage.getNumberOfAddedProducts();

        assertEquals(numberInCartBadge, "1", 
            "Cart should have 1 product only");
    }

    @Test(priority = 4)
    public void testRemoveAllProductsFromCart() {
    	
        productPage.addAllProductsToCart();
        productPage.removeAllProductsFromCart();
        
        boolean isBadgeDisplayed = productPage.isCartBadgeDisplayed();

        assertFalse(isBadgeDisplayed, 
            "Cart badge should not be displayed after removing all products");
    }

    @Test(priority = 5)
    public void testSortPageByNameAZ() {
    	
        productPage.selectSortOption("Name (A to Z)");

        String productName = productPage.getProductNameByIndex(0);

        assertEquals(productName, "Sauce Labs Backpack", 
            "First product should be 'Sauce Labs Backpack'");
    }

    @Test(priority = 6)
    public void testSortPageByNameZA() {
    	
        productPage.selectSortOption("Name (Z to A)");

        String productName = productPage.getProductNameByIndex(0);

        assertEquals(productName, "Test.allTheThings() T-Shirt (Red)", 
            "First product should be 'Test.allTheThings() T-Shirt (Red)'");
    }

    @Test(priority = 7)
    public void testSortPageByPriceLowToHigh() {
    	
        productPage.selectSortOption("Price (low to high)");

        String productPrice = productPage.getProductPriceByIndex(0);

        assertTrue(productPrice.contains("7.99"), 
            "First product price should be $7.99");
    }
    
    
    @Test(priority = 8)
    public void testProductsCount() {
    	
        int count = productPage.getNumberOfAllProducts();
        assertEquals(count, 6, "Page should have 6 products");
    }
    
    @Test (priority = 9)
    public void testCartPageIsDisplayed() {
    	
    	CartPage cartPage = productPage.clickCart();
    	
    	assertTrue(cartPage.isCartTitleDisplayed() , "Cart page title 'Your Cart' should be displayed");
    	
    }
    
    
    
}









