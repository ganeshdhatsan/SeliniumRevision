package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public WebDriver driver;
	


	public void launchBrowser() {
		driver = new ChromeDriver();

	}

	public void launchUrl(String url) {
		driver.get(url);
	}

}
