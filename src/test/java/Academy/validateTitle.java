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

public class validateTitle extends base {
	public static Logger log = LogManager.getLogger(validateTitle.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized!");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page!");

	}

	@Test
	public void basePageNavigation() {

		LandingPage lp = new LandingPage(driver);

		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");

		log.info("Successfully validated Text message!");

	}

	@AfterTest
	public void teardown() {

		driver.close();
		driver = null;
		log.info("The Login Process is completed");

	}

}
