package Waits;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicWait {
	
	WebDriver driver;
	
	/**
	 * wait to stop or hold a action for some time
	 * 
	 * * Wait clasified mainly in to 2 types
	 * 
	 * 1.static wait - Hard wait
	 * 
	 * 1. Static wait -- hard wait Thread.sleep() -- Java -- time should be in milli
	 * seconds -- 1000 milli seconds = 1 second (Thread.sleep(10000))
	 * unconditionally stop the execution for the given time
	 * 
	 * Thread.sleep();
	 * 
	 * 
	 * 2. Dyanamic wait -- soft wait
	 * 
	 * A.Implicitly wait
	 * 
	 * B.Explicitly wait
	 * 
	 * A. Implicitly wait *
	 * 
	 * driver.manage().timeOuts().implicitlyWait(Duration.ofSeconds(20));
	 * driver.manage().timeOuts().implicitlyWait(Duration.ofMinutes(20));
	 * 
	 * Note mostly used for finding web element it is not specific , it is
	 * applicable for all the web element if its is declared in class level No need
	 * to write multiple times inside the method or class , only one time is enough
	 * default polling period is 500 milli seconds.
	 * 
	 * B. Explicitly wait it will wait until the given condition is satisfied
	 * default polling period is 500 milli seconds it is not applicale for all,it is
	 * applicable only for the specific element
	 * 
	 * 2 Types
	 * 
	 * a. WebDriver wait *
	 * 
	 * 
	 * b. Fluent wait
	 * 
	 * we can determine our default polling time
	 * 
	 * we can handle exceptions also
	 * 
	 */
	
	
	
	
	
	private void implicitWait() {
		
		/**Implicitly wait
		 * 
		 * implicitly wait means automatically it will wait until finding the elements for the given period.
	       it is a global wait and it is applicable for every element for the entire session.
	       the driver will wait and find the elements and will not throw the Exception(No such element Exception) for the given time.
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.manage().window().maximize();
		

		/**pageLoadTimeout
		 * 
		 * WebDriver waits for the web page to load completely.
		 * If it fails to load within the specified timeout duration, it throws a Timeout exception
		 * Default Timeout for Implicit Wait is 0 seconds. 
	       Default Timeout for Page Load is 300 seconds.
	       Default Timeout for Script Timeout is 30 seconds.
		 */
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

	}


	private void webDriverWait() {
		/**
		 * Explicit Waits are particularly useful when synchronizing test scripts for
		 * the specific conditions
		 * 
		 * It is only applicable for the specific element
		 * 
		 * * WebDriver Wait Examples of Exception for using WebDriverWait : Element Not
		 * Interactable, Element Not Clickable,Stale Element Reference Exception,No such
		 * Element Exception
		 */

		/**
		 * Implementation
		 */
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		WebElement element = driver.findElement(By.id("email"));

		List<WebElement> elements = driver.findElements(By.id("email"));

		By user = By.id("email");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(element));

		ExpectedConditions.elementToBeClickable(user);

		ExpectedConditions.elementToBeSelected(element);
		ExpectedConditions.elementToBeSelected(user);

		/**
		 * checks if the element is present and visible.
		 */
		ExpectedConditions.visibilityOf(element);
		ExpectedConditions.visibilityOfAllElements(elements);
		ExpectedConditions.visibilityOfAllElementsLocatedBy(user);

		/**
		 * when you need to confirm that an element is no longer present or visible
		 * (e.g., after submitting a form and waiting for a loading spinner to
		 * disappear).
		 */

		ExpectedConditions.invisibilityOf(element);
		ExpectedConditions.invisibilityOfAllElements(elements);
		ExpectedConditions.invisibilityOfElementLocated(user);

		/**
		 * Purpose: To wait until the specified element is present in the DOM. 
		 * Usage: This condition is particularly useful when you need to ensure that an
		 * element is present in the DOM before performing actions like interacting with it
		 * It helps to avoid NoSuchElementException that can
		 * occur if you try to interact with an element before it is added to the page.
		 * 
		 */
		ExpectedConditions.presenceOfElementLocated(user);
		ExpectedConditions.presenceOfAllElementsLocatedBy(user);
		
		/**
		 * * stale element reference exception means locator no longer attach with DOM while using same locator repeatedly
		 * 
		 * To hanle stale element reference exception 
		 * 1.referesh the DOM using driver.navigate().refresh();
		 * 2.catch block -- then driver.findelement -- To find the element
		 * 3.using web driver wait -- pre defined method -- ExpectedConditions.presenceOfElementLocated(user) or
		 * ExpectedConditions.visibilityOfElementLocated(name) 
		 * 4.using web driver wait  - use predefined method as - ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element))
		 * 5.page object model(POM)
		 */

		ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element));
		
		/**
		 * Purpose: To wait for an alert to appear before proceeding with further actions in your test.
		 * Alerts are modal dialogs that can interrupt the user's interaction with the page 
		 * and require interaction (e.g., accepting or dismissing) before the test can continue.
		 */

		ExpectedConditions.alertIsPresent();
		
		/**
		 * Purpose: To wait until a specific frame is present in the DOM and then automatically switch the WebDriver's context to that frame.
		 * This is crucial because Selenium needs to switch to the frame before interacting with elements inside it. 
		 * If you don’t switch to the frame first, Selenium won’t be able to interact with elements inside it.
		 */

		ExpectedConditions.frameToBeAvailableAndSwitchToIt("");
		ExpectedConditions.frameToBeAvailableAndSwitchToIt(element);
		ExpectedConditions.frameToBeAvailableAndSwitchToIt(1);

	}


	

}
