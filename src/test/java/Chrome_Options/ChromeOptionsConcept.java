package Chrome_Options;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class ChromeOptionsConcept {
	WebDriver driver;

	@Test
	private void headlessDriver_Chrome() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();

		// To Enables headless mode
		options.addArguments("--headless");

        // To run incognito mode
		options.addArguments("--incognito");
		
		// Disable notifications
		options.addArguments("--disable-notifications");

		// To Set window resolution for screenshots quality(optional)
		options.addArguments("--window-size=1920x1080");

		// Start the browser maximized
		options.addArguments("--start-maximized");


		driver = new ChromeDriver(options);
		Thread.sleep(5000);
		driver.get("https://www.facebook.com/");

	}

	@Test
	private void headlessDriver_Firefox() throws InterruptedException {

		FirefoxOptions options = new FirefoxOptions();

		// To Enables headless mode
		options.addArguments("--headless");

		// To Set window resolution for screenshots quality(optional)
		options.addArguments("--window-size=1920x1080");

		// Set custom window size
		options.addArguments("--width=1280", "--height=1024");

		// Disable notifications
		options.addArguments("--disable-notifications");

		driver = new FirefoxDriver(options);
		Thread.sleep(5000);
		driver.get("https://www.facebook.com/");

	}

	@Test
	public void testExample() {
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("java");
		driver.findElement(By.id("pass")).sendKeys("selenium");
		driver.findElement(By.name("login")).click();
		driver.quit();
	}

}
