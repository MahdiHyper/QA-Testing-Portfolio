package automationexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationExerciseHelper {

	public WebDriver driver;
	Connection con;
	Statement stmt;
	ResultSet rs;

	Random rand = new Random();

	String firstName;
	String lastName;
	String email;
	String password = "Test@123";
	int randomNumberForEmail = rand.nextInt(223456);

	String websiteURL = "https://www.automationexercise.com/";

	public void theSetUp() throws SQLException {
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(websiteURL);

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/automation_test_data", "root", "abc123");
		stmt = con.createStatement();

		// Read from database
		String[] customerIDarray = { "5", "6", "7", "8" };
		int randomId = rand.nextInt(customerIDarray.length);
		String randomCustomer = customerIDarray[randomId];
		String queryToRead = "SELECT * FROM users WHERE id=" + randomCustomer;

		rs = stmt.executeQuery(queryToRead);

		while (rs.next()) {
			
			firstName = rs.getString("first_name");
			lastName = rs.getString("last_name");
			
		}

		email = firstName + lastName + randomNumberForEmail + "@gmail.com";
		
	}
	

	
}
















