package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.base;

public class HomePage extends base {
	public static Logger log = LogManager.getLogger(HomePage.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text)
			throws InterruptedException, IOException {

		driver.get(prop.getProperty("url"));

		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();

		LoginPage lgp = new LoginPage(driver);
		lgp.getEmail().sendKeys(Username);
		lgp.getPassword().sendKeys(Password);
		System.out.println(text);
		log.info(text);

		lgp.getLogin().click();
		log.info("Login Error Page is loaded");

	}

	@AfterTest
	public void teardown() {

		driver.close();
		driver = null;
		log.info("The Login Process is completed");

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][3];

		data[0][0] = "nonRestrictedUser@qw.com";
		data[0][1] = "password123456";
		data[0][2] = "This is a nonRestricted User!";

		data[1][0] = "restrictedUser@qw.com";
		data[1][1] = "password12345678";
		data[1][2] = "This is a Restricted User!";

		return data;
	}

}
