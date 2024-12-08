package WebDriverMethods;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;



public class DriverMethods {

	// driver initialization - selenium 3 -- webdriver manager dependency --
	// Bonicargia third part tool
	// browser launch -- selenium 4
	// url launch
	WebDriver driver;

	@Test
	private void launchUrl() {

		// selenium 3
//		
//		//Step-01
//		// driver initialization
//		WebDriverManager.chromedriver().setup();
//		
//		//Step-02
//		// browser launch 
//		WebDriver driver3 = new ChromeDriver();
//		
//		//Step-03
//		// url launch
//		driver3.get("https://www.facebook.com/");

		// selenium 4

		// Step-01
		// browser launch
		WebDriver driver4 = new ChromeDriver();// data binding

		WebDriver driver5 = new EdgeDriver();

		WebDriver driver6 = new FirefoxDriver();

		// Step-02
		// url launch
		driver4.get("https://www.facebook.com/");

		driver5.get("https://www.instagram.com/");

		driver6.get("https://www.youtube.com/");

	}

	@Test
	private void maxAndMinimize() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		// maximize
		driver.manage().window().maximize();

		Thread.sleep(10000);
		// minimize
		driver.manage().window().minimize();

	}

	@Test
	private void closeAndQuite() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		WebDriver driver1 = new ChromeDriver();

		Thread.sleep(10000);

		// This will open the new tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.facebook.com/");

		Thread.sleep(10000);

		// This will open the new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.instagram.com/");

		driver.close();// to close current window

		Thread.sleep(10000);
		driver.quit();// close the browser

		// different browser
		driver1.get("https://www.youtube.com/");

	}

	@Test
	private void manageDriver() throws InterruptedException {

		// Locators - used to identify the Element
		// Types of Locators -- By class - abstract methods
//		1.id *
//		2.name *
//		3.className
//		4.xpath
//		5.tagName
//		6.linkText
//		7.partial link text
//		8.CSSSelector
		
		
//		To identify the hyperlinks 
//		6.linkText
//		7.partial link text
//		hyperlinks always inside <a tag
//		link will be in href attribute


		try {
			driver = new ChromeDriver();

			driver.get("https://www.facebook.com/");

			
			//driver.manage
//			Thread.sleep(10000); // static wait

			// implicitlyWait is used to wait until element visible // dynamic wait
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// every 500 milli seconds

			driver.manage().window().maximize();
			
//			driver.manage().window().minimize();

			driver.manage().deleteAllCookies();
			

			WebElement email = driver.findElement(By.id("email"));
			email.sendKeys("ganesh");// to pass the String in text box

			WebElement password = driver.findElement(By.id("pass"));
			password.sendKeys("kumar");
			
			//To get current URL
			String currentUrl = driver.getCurrentUrl();
			System.out.println("currentUrl "+currentUrl);
			
			//To get Title of the web page
			String title = driver.getTitle();
			System.out.println("title "+title);
			
			//To get DOM - document object model in console
			String pageSource = driver.getPageSource();
			System.out.println("pageSource "+pageSource);
			
//			driver.close()
			
//			driver.quit();
			
			// This will open the new tab
//			driver.switchTo().newWindow(WindowType.TAB);

			// This will open the new window
			driver.switchTo().newWindow(WindowType.WINDOW);

			driver.navigate().to("https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNzE2OTc1ODEwLCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D");
			
			driver.navigate().refresh();
			
			Thread.sleep(10000);
			
			driver.navigate().back();
			Thread.sleep(10000);
			
			driver.navigate().forward();
			
			
			
	

		}
		
		catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException block");
			WebElement loginButton = driver.findElement(By.name("login"));
			loginButton.click();
//			e.printStackTrace();
		}
		
		catch (WebDriverException e) {
			System.out.println("WebDriverException block");

			WebElement loginButton = driver.findElement(By.name("login"));
			loginButton.click();
//			e.printStackTrace();
		}
		
		catch (Exception e) {
			System.out.println("Exception block");

			WebElement loginButton = driver.findElement(By.name("login"));
			loginButton.click();
//			e.printStackTrace();
		} 

	
//		finally {
//			System.out.println("finally block");
//			driver.quit();
//		}

	}

	@Test
	private void method() {
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

}
}