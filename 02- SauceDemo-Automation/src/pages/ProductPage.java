package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

	
	private By pageTitle = By.className("title");
	private By productsNames = By.className("inventory_item_name");
	private By productsPrices = By.className("inventory_item_price");
	private By productsAddButtons = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory");
	private By productsRemoveButtons = By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory");
	private By shoppingCartBadge = By.cssSelector("span[data-test='shopping-cart-badge']");
	private By shoppingCart = By.cssSelector("a[data-test='shopping-cart-link']");
	private By selectFilter = By.cssSelector("select[data-test='product-sort-container']");
	private By productCard = By.className("inventory_item");

	public boolean isPageTitleDisplayed() {
		
		try {
			String title = find(pageTitle).getText();
			return title.equals("Products");
		} catch (Exception e) {
			return false;
		}
	}


	public String getProductNameByIndex(int index) {
		
		List<WebElement> productsName = driver.findElements(productsNames);

		if (index >= 0 && index < productsName.size()) {
			return productsName.get(index).getText();
		}
		return "";
	}

	public String getProductPriceByIndex(int index) {
		
		List<WebElement> productsPrice = driver.findElements(productsPrices);

		if (index >= 0 && index < productsPrice.size()) {
			return productsPrice.get(index).getText();
		}
		return "";
	}
	
	public int getNumberOfAllProducts() {
		
		List<WebElement> allProducts = driver.findElements(productCard);
		
		return allProducts.size();
	}
	
	public void addProductToCartByIndex(int index) {
		
	    List<WebElement> productsAddButton = driver.findElements(productsAddButtons);
	    
	    if (index >= 0 && index < productsAddButton.size()) {
	        productsAddButton.get(index).click();
	    }
	}


	public void addAllProductsToCart() {
		
		List<WebElement> productsAddButton = driver.findElements(productsAddButtons);

		for (WebElement add : productsAddButton) {
			add.click();
		}
	}

	public void removeAllProductsFromCart() {
		
		List<WebElement> productsRemoveButton = driver.findElements(productsRemoveButtons);

		for (WebElement remove : productsRemoveButton) {
			remove.click();
		}
	}

	
	public boolean isCartBadgeDisplayed() {
		
		try {
			return find(shoppingCartBadge).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getNumberOfAddedProducts() {
		
		if (isCartBadgeDisplayed()) {
			return getText(shoppingCartBadge);
		}
		return "0";
	}


	public CartPage clickCart() {
		
		click(shoppingCart);
		return new CartPage();
	}


	public void selectSortOption(String option) {
		
		try {
			WebElement sort = find(selectFilter);
			Select select = new Select(sort);
			select.selectByVisibleText(option);
		} catch (Exception e) {
			System.out.println("Failed to select option: " + option);
		}
	}
	
	
}






































