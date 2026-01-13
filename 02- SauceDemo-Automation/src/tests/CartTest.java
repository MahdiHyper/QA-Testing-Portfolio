package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.ProductPage;

public class CartTest extends BaseTest {

    private CartPage cartPage;
    private ProductPage productPage;

    @BeforeMethod
    public void setUpCartPage() {
    	
        productPage = loginPage.login("standard_user", "secret_sauce");
        cartPage = productPage.clickCart();
    }

    @Test(priority = 1)
    public void testIsCartPageTitleDisplayed() {
    	
        assertTrue(cartPage.isCartTitleDisplayed(), 
            "Cart page title should be displayed");
    }

    @Test(priority = 2)
    public void testEmptyCartHasNoProducts() {
    	
        int actualProducts = cartPage.getNumberOfActualProductsInList();
        
        assertEquals(actualProducts, 0, 
            "Empty cart should have 0 products");
    }

    @Test(priority = 3)
    public void testProductsNumberInBadgeMatchesList() {
    	
        productPage = cartPage.clickBackToShoppingButton();
        productPage.addProductToCartByIndex(0);
        cartPage = productPage.clickCart();
        
        String badgeNumber = cartPage.getNumberOfProductsInBadge();
        int actualProducts = cartPage.getNumberOfActualProductsInList();
        
        assertEquals(actualProducts, 1, 
            "Should have 1 product in cart");
        assertEquals(badgeNumber, "1", 
            "Badge should show 1");
    }

    @Test(priority = 4)
    public void testBackToShoppingButton() {
    	
        productPage = cartPage.clickBackToShoppingButton();

        assertTrue(productPage.isPageTitleDisplayed(), 
            "Product page should be displayed after clicking back");
    }

    @Test(priority = 5)
    public void testRemoveProductFromCart() {
    	

        productPage = cartPage.clickBackToShoppingButton();
        productPage.addProductToCartByIndex(0);
        cartPage = productPage.clickCart();
        
        cartPage.removeProductByIndex(0);
        
        int actualProducts = cartPage.getNumberOfActualProductsInList();
        assertEquals(actualProducts, 0, 
            "Cart should be empty after removing product");
    }
    
    
    
}





















