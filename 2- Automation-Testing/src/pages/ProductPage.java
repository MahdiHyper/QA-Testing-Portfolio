package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {
	
	private By pageTitle = By.className("title");

	
	
	public boolean isPageTitleDisplayed() {
		
	    try {
	        String title = find(pageTitle).getText();
	        return title.equals("Products");
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	
	

}
