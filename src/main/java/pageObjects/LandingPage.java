package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.xpath("//section[@id='content']/div/div/h2");
	By navBar = By.cssSelector("nav.navbar-collapse.collapse");

	public WebElement getLogin() {
		return driver.findElement(signin);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}

}
