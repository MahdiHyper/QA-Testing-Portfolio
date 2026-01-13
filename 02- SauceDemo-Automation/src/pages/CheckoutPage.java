package pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private By checkoutTitle = By.className("title");
    

    public boolean isCheckoutPageDisplayed() {
    	
        try {
            String title = find(checkoutTitle).getText();
            return title.contains("Checkout");
        } catch (Exception e) {
            return false;
        }
    }
}