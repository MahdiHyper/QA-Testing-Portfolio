package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private By pageTitle = By.cssSelector("span[data-test='title']");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartItems = By.className("cart_item");
    private By checkoutButton = By.id("checkout");
    private By backToShoppingButton = By.id("continue-shopping");
    private By removeButtons = By.cssSelector(".btn.btn_secondary.btn_small.cart_button");


    public boolean isCartTitleDisplayed() {
    	
        try {
            String title = find(pageTitle).getText();
            return title.equals("Your Cart");
        } catch (Exception e) {
            return false;
        }
    }


    public String getNumberOfProductsInBadge() {
    	
        try {
            return getText(cartBadge);
        } catch (Exception e) {
            return "0";
        }
    }

    public int getNumberOfActualProductsInList() {
    	
        List<WebElement> productsInList = driver.findElements(cartItems);
        return productsInList.size();
    }


    public CheckoutPage clickCheckoutButton() {
    	
        click(checkoutButton);
        return new CheckoutPage();
    }

    public ProductPage clickBackToShoppingButton() {
    	
        click(backToShoppingButton);
        return new ProductPage();
    }


    public void removeProductByIndex(int index) {
    	
        List<WebElement> removeButtonsList = driver.findElements(removeButtons);

        if (index >= 0 && index < removeButtonsList.size()) {
            removeButtonsList.get(index).click();
        }
    }
    
    
    
    
}



















