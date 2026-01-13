package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.ProductPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testSuccessLogin() {
    	
        ProductPage productPage = loginPage.login("standard_user", "secret_sauce");
        
        assertTrue(productPage.isPageTitleDisplayed(), 
            "Product page must be displayed with correct title");
    }

    @Test(priority = 2)
    public void testEmptyUsername() {
    	
        loginPage.login("", "secret_sauce");
        
        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains("Username is required"), 
            "Error message must contain 'Username is required'");
    }

    @Test(priority = 3)
    public void testEmptyPassword() {
    	
        loginPage.login("standard_user", "");
        
        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains("Password is required"), 
            "Error message must contain 'Password is required'");
    }

    @Test(priority = 4)
    public void testWrongPassword() {
    	
        loginPage.login("standard_user", "wrong_password");
        
        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains("do not match"), 
            "Error message must contain 'do not match'");
    }

    @Test(priority = 5)
    public void testLockedOutUser() {
    	
        loginPage.login("locked_out_user", "secret_sauce");
        
        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains("locked out"), 
            "Error message must contain 'locked out'");
    }
    
    @Test(priority = 6)
    public void testIntentionalFailure_WrongAssertion() {
    	
        loginPage.login("standard_user", "secret_sauce");
        
        //خطأ عمداً عشان يوخذ سكرين
        assertTrue(false, "This test is designed to fail for screenshot demo");
    }

    @Test(priority = 7)
    public void testIntentionalFailure_WrongExpectedValue() {
    	
        ProductPage productPage = loginPage.login("standard_user", "secret_sauce");
        
        String productName = productPage.getProductNameByIndex(0);
        
        //خطأ عمداً عشاان يوخذ سكرين
        assertEquals(productName, "Wrong Product Name", 
            "This test is designed to fail for screenshot demo");
    }




}





















































