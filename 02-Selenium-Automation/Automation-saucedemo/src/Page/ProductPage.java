package Page;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {
	
	private By pageTitleLocator = By.className("app_logo");
	
	public boolean isProductPageTitleDisplayed() {
		
		String pageTitle = getText(pageTitleLocator);
	    return pageTitle.contains("Swag Labs");
	}


}