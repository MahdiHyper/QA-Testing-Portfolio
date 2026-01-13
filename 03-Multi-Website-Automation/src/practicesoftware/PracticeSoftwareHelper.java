package practicesoftware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PracticeSoftwareHelper {

	public WebDriver driver;
	Connection con;
	Statement stmt;
	ResultSet rs;

	Random rand = new Random();

	String firstName;
	String lastName;
	String email;
	String address;
	String city;
	String password = "Mahdi@#246";
	int randomNumberForEmail = rand.nextInt(86421);
	int randomNumberForUserName = rand.nextInt(246824);

	String websiteURL = "https://practicesoftwaretesting.com/";

	public void theSetUp() throws SQLException {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(websiteURL);

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","abc123");
		stmt = con.createStatement();

		String[] customerIDarray = { "112", "114", "119", "121" };
		int randomId = rand.nextInt(customerIDarray.length);
		String randomCustomer = customerIDarray[randomId];
		String queryToRead = "SELECT * FROM customers WHERE customerNumber=" + randomCustomer;

		rs = stmt.executeQuery(queryToRead);

		while (rs.next()) {
			
			firstName = rs.getString("contactFirstName").trim();
			lastName = rs.getString("contactLastName").trim();
			email = firstName + randomNumberForEmail + "@gmail.com";
			address = rs.getString("addressLine1");
			city = rs.getString("city");
		}

	}

	
}