package SeleniumMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WebDriverMethods {

	/**
	 * SearchContext - SuperInterface WebDriver - Interface WebElement - Interface
	 * JavascriptExecutor - Interface TakesScreenshot - Interface
	 * 
	 */

	/**
	 * WebDriver - Methods
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	 */

	@Test
	private void webdriverMethods() throws InterruptedException, IOException, AWTException {

		WebDriver driver = new ChromeDriver();

		/**
		 * driver.get("https://www.facebook.com/");
		 * driver.switchTo().newWindow(WindowType.TAB);
		 * driver.get("https://www.facebook.com/");
		 * driver.switchTo().newWindow(WindowType.TAB);
		 * driver.get("https://www.facebook.com/"); Thread.sleep(1000);
		 */
		// close vs quite
		
//		driver.close() closes only the current window. The WebDriver session remains active.
//		driver.quit() method closes all windows and ends the WebDriver session.

		// get() vs navigate().to()

//		driver.get() & driver.navigate().to() both methods are used to open an URL 
//		driver.get() will wait untill the whole page gets loaded, one page load done then only control will move to next step
//		but driver.navigate().to() not wait untill the whole page gets loaded
//		and It maintains the browser history and cookies, so we can use forward and backward

//		driver.get("https://www.facebook.com/");
//		driver.navigate().to("https://www.facebook.com/");
	
//		
//		Thread.sleep(1000);
//		driver.navigate().back();
//		Thread.sleep(1000);
//		driver.navigate().forward();
//		Thread.sleep(1000);
//		driver.navigate().refresh();
//		
//		driver.getCurrentUrl();// to take the current url
//		driver.getTitle(); // to take current page title
//		driver.getPageSource(); // to take dom structure

//		driver.get("https://www.facebook.com/");
//		String windowHandle = driver.getWindowHandle(); // to get current window's id
//		System.out.println("windowHandle "+windowHandle);

//		driver.get("https://www.facebook.com/");
//		driver.switchTo().newWindow(WindowType.WINDOW);
//		driver.switchTo().newWindow(WindowType.WINDOW);
//		driver.switchTo().newWindow(WindowType.WINDOW);
//		Set<String> windowHandles = driver.getWindowHandles();// to get all available window's ids
//		
//		for (String windowId : windowHandles) {
//			
//			System.out.println("Window Handles "+windowId);
//			
//		}

		// findElement vs findElements
		
//		driver.get("https://www.facebook.com/"); 
//		
//		List<WebElement> elements = driver.findElements(By.xpath("//img"));
//		
//		System.out.println(elements.size());
//		
//		for (WebElement webElement : elements) {
//			System.out.println(webElement.getText());
//		}
		
		
//		driver.get("https://demowebshop.tricentis.com/login");
////		WebElement element = driver.findElement(By.xpath("//div//input[@type='submit']"));
////		System.out.println(element);
//		
////		Thread.sleep(1000);
//		List<WebElement> elements = driver.findElements(By.xpath("//div//input[@type='submit']"));
//		System.out.println(elements);
		
//
//		WebElement element =driver.findElement(By.id("emai"));// to find a single elements
//		System.out.println(element);
		// we can use findElements for single element
//		List<WebElement> elements =driver.findElements(By.id("emai"));
//        System.out.println(elements);
		
//	    driver.get("https://www.icc-cricket.com/");
////		
//		Thread.sleep(5000);  // sync issue 
////
////		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='si-table swiper-slide']"));// to find a
////																											// multiple																									// elements
////		System.out.println(elements.size());
//		
//		WebElement elementt = driver.findElement(By.xpath("//div[@class='si-table swiper-slide']"));
//
//	    System.out.println(elementt.getText());
		
		/**
		 * manage()
		 */
		
		driver.manage().deleteAllCookies();
		
		/**Implicitly wait
		 * 
		 * implicitly wait means automatically it will wait until finding the elements for the given period.
           it is a global wait and it is applicable for every element for the entire session.
           the driver will wait and find the elements and will not throw the Exception(No such element Exception) for the given time.
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		/**pageLoadTimeout
		 * 
		 * WebDriver waits for the web page to load completely.
		 * If it fails to load within the specified timeout duration, it throws a Timeout exception
		 * Default Timeout for Implicit Wait is 0 seconds. 
           Default Timeout for Page Load is 300 seconds.
           Default Timeout for Script Timeout is 30 seconds.
		 */
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		
		/**
		 * switchTo()
		 */
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.switchTo().alert(); //To handle alert
		
		driver.switchTo().frame(1);// To switch to frame
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
		driver.switchTo().window("");
		
		
		/**
		 * WebElement
		 */
		
		/*
		 * UI Testing -> User Interface Testing
		 * GUI Testing -> Graphical user Interface Testing
		 */
		
		/**
		 * UI Tesing
		 */
		
		WebElement element = driver.findElement(By.xpath(""));	
		List<WebElement> elements=element.findElements(By.xpath(""));
		boolean displayed = element.isDisplayed();
		boolean enabled = element.isEnabled();
		boolean selected = element.isSelected();// only for check box & radio button
		element.click();
		element.clear();
		element.sendKeys("");// to pass text
		String attribute = element.getAttribute("value");
		Object screenshotAs = element.getScreenshotAs(null);// to take screenshot of the specific element
		String tagName = element.getTagName();// to get tagname 
		String text = element.getText();//to get text of the element
		String domAttribute = element.getDomAttribute("");
		String domProperty = element.getDomProperty("");
			
		/**
		 * GUI Testing
		 */
		Point location = element.getLocation();
		Rectangle rect = element.getRect();
		SearchContext shadowRoot = element.getShadowRoot();
		Dimension size = element.getSize();

		/**
		 * TakesScreenshot
		 */
		TakesScreenshot shot = (TakesScreenshot)driver;
		
		File src = shot.getScreenshotAs(OutputType.FILE);// to take screentshot of the entire page
		File dest = new File("");
		FileUtils.copyFile(src, dest);
		
		/**
		 * JavaScriptExecutor
		 */
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
	    js.executeScript("arguments[0].click()", element);
	
		/**
		 *  Actions - Interface
		 *  Robot - java class
		 *  Alert - Interface
		 *  select - Class
		 */
	    
	    Actions act = new Actions(driver); 
	    
        Alert alert = driver.switchTo().alert();
	    
	    Select select = new Select(element);
	    
	    Robot robo = new Robot();
	    
	    
	    
	    
	    
	    
		
		
	}

}
