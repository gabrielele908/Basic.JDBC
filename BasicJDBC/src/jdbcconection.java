import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class jdbcconection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

// TODO Auto-generated method stub

		String host = "localhost";
		String port = "3306";

		try ( Connection conn= DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/demo?serverTimezone=UTC", "root", "root")) {
			
			Statement s = conn.createStatement();

			ResultSet rs = s.executeQuery("select * from credentials where senario ='A'");

			while (rs.next())

			{
				//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir" + "\\BrowserDriver\\geckodriver"));
				System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();

				driver.get("https://login.salesforce.com");
				driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));
				driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));

			}

			//...

		} catch (Exception e) {
			e.printStackTrace();
		}
	//	Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root", "root");

		

	}

}