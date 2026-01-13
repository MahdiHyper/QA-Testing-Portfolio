package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    
    private By usernameTextbox = By.id("user-name");
    private By passwordTextbox = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    
    public void typeInUsernameField(String username) {
    	
        sendKeys(usernameTextbox, username);
    }

    public void typeInPasswordField(String password) {
    	
        sendKeys(passwordTextbox, password);
    }

    public ProductPage clickLogin() {
    	
        click(loginButton);
        return new ProductPage();
    }

    public ProductPage login(String username, String password) {
    	
        typeInUsernameField(username);
        typeInPasswordField(password);
        return clickLogin();
    }


    public String getErrorMessage() {
    	
        try {
            return find(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isErrorMessageDisplayed() {
    	
        try {
            return find(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}