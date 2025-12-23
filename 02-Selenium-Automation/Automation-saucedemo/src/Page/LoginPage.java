package Page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

	private By usernameLocator = By.id("user-name");
	private By passwordLocator = By.id("password");
	private By loginLocator = By.id("login-button");
	private By errorMessageLocator = By.cssSelector("h3[data-test='error']");

	public void setUsername(String username) {
		
		set(usernameLocator, username);
	}

	public void setPassword(String password) {
		
		set(passwordLocator, password);
	}

	public void clickLoginButton() {
		
		click(loginLocator);
	}

	public ProductPage login(String username, String password) {
		
		setUsername(username);
		setPassword(password);
		clickLoginButton();
		return new ProductPage();
	}

	public String getErrorMessage() {
		
		return getText(errorMessageLocator);
	}

	public boolean isErrorMessageDisplayed() {
		
		try {
			return find(errorMessageLocator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
		
	}
}
