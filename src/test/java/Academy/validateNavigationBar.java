package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.base;

public class validateNavigationBar extends base {
	public static Logger log = LogManager.getLogger(validateNavigationBar.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() {

		LandingPage lp = new LandingPage(driver);

		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("The Navigation Bar is captured!");

	}

	@AfterTest
	public void teardown() {

		driver.close();
		driver = null;
		log.info("The validation of Navigation Bar is completed!");

	}

}
