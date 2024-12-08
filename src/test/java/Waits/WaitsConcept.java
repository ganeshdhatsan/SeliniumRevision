package Waits;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitsConcept {

	WebDriver driver;
	
	/**
	 * 
 Wait means Selenium provides a default waiting time for WebDriver to find elements 
 before throwing a NoSuchElementException.

Implicitly waits applies globally to all findElement() and findElements() calls in the corresponding page.
If the element is found within the specified time, 
WebDriver proceeds next action without waiting for the full duration.
If the element is not found, WebDriver polls the DOM repeatedly until the given time expires.

Explicit Wait can be used for complex conditions, 
such as waiting for specific elements to be visible, clickable or meet certain criteria.

Recommendation: Prefer Explicit Wait because of more flexible and as it offers more control 
and avoids unnecessary waiting compared to globally applied Implicit Wait.
	 */

	/**
	 * Wait clasified mainly in to 2 types
	 * 
	 * 1.static wait - Hard wait
	 * 
	 * Thread.sleep();
	 * 
	 * 
	 * 2.dynamic wait
	 * 
	 * A.Implicitly wait
	 * 
	 * B.Explicitly wait
	 * 
	 * 1.WebDriver wait 2.Fluent wait
	 * 
	 * 
	 */

	/**
	 * Static wait or Hard wait- Thread.sleep() It is from Java. available in
	 * java.lang package .It will throw the exception called
	 * InterruptedException(Checked Exception) Checked Exception - throw exception
	 * in compile time It will stop the execution for the given period, In Real time
	 * , It is not recommended. If no way , then only we should use Thread.sleep()
	 * It allows value only in milliseconds
	 * 
	 * Example : 5 seconds - 5000 milliseconds
	 * 
	 * Thread.sleep(5000);
	 * 
	 * @throws InterruptedException
	 * 
	 */

	/**
	 * NoSuch Element exception
	 * 
	 * 1.locator wrong 2.sync issue - to resolve sync issue - waits concept
	 * 3.different window 4.elements in frames
	 * 
	 */

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

	@org.testng.annotations.Test
	private void threadSleep() throws InterruptedException {
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		Thread.sleep(60000);

		driver.manage().window().maximize();
	}

	@org.testng.annotations.Test
	private void implicitWait() {

		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.manage().window().maximize();

	}

	private void webdriverWaitcon() {
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.id("email"));
		By name = By.id("email");

		/*
		 * WebDriver Wait Examples of Exception for using WebDriverWait : Element Not
		 * Interactable, Element Not Clickable,Stale Element Reference Exception,No such
		 * Element Exception
		 */

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		/*
		 * visiblity of
		 */
		WebElement until = wait.until(ExpectedConditions.visibilityOf(element));

		WebElement until2 = wait.until(ExpectedConditions.visibilityOfElementLocated(name));

		/*
		 * invisibilityOf
		 */
		wait.until(ExpectedConditions.invisibilityOf(element));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(name));

		/*
		 * presence of element
		 */

		WebElement until3 = wait.until(ExpectedConditions.presenceOfElementLocated(name));

		/*
		 * stale element reference exception means locator no longer attach with DOM
		 * 
		 * To hanle stale element reference exception 1.referesh -- catch block -- then
		 * driver.findelement -- element handle 2.using web driver wait -- pre defined
		 * method -- ExpectedConditions.presenceOfElementLocated(user),
		 * ExpectedConditions.visibilityOfElementLocated(name) 3.using web driver wait
		 * we can use predefined method as -
		 * ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)) 4.page
		 * object model
		 */
		WebElement until4 = wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));

		/*
		 * element to be clickable
		 */
		WebElement until1 = wait.until(ExpectedConditions.elementToBeClickable(element));

		/*
		 * elementToBeSelected
		 */
		wait.until(ExpectedConditions.elementToBeSelected(element));

		until1.click();
		until1.clear();
		until1.sendKeys("ganesh");

	}

	private void webDriverWait() {
		/**
		 * Explicit Waits are particularly useful when synchronizing test scripts for
		 * the specific conditions
		 * 
		 * It is only applicable for the specific element
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
		 * Purpose: To wait until the specified element is present in the DOM. Usage:
		 * This condition is particularly useful when you need to ensure that an element
		 * is present in the DOM before performing actions like interacting with it It
		 * helps to avoid NoSuchElementException that can occur if you try to interact
		 * with an element before it is added to the page.
		 * 
		 */
		ExpectedConditions.presenceOfElementLocated(user);
		ExpectedConditions.presenceOfAllElementsLocatedBy(user);

		/**
		 * * stale element reference exception means locator no longer attach with DOM
		 * while using same locator repeatedly
		 * 
		 * To hanle stale element reference exception 1.referesh the DOM using
		 * driver.navigate().refresh(); 2.catch block -- then driver.findelement -- To
		 * find the element 3.using web driver wait -- pre defined method --
		 * ExpectedConditions.presenceOfElementLocated(user) or
		 * ExpectedConditions.visibilityOfElementLocated(name) 4.using web driver wait -
		 * use predefined method as -
		 * ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)) 5.page
		 * object model(POM)
		 */

		ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element));

		/**
		 * Purpose: To wait for an alert to appear before proceeding with further
		 * actions in your test. Alerts are modal dialogs that can interrupt the user's
		 * interaction with the page and require interaction (e.g., accepting or
		 * dismissing) before the test can continue.
		 */

		ExpectedConditions.alertIsPresent();

		/**
		 * Purpose: To wait until a specific frame is present in the DOM and then
		 * automatically switch the WebDriver's context to that frame. This is crucial
		 * because Selenium needs to switch to the frame before interacting with
		 * elements inside it. If you don’t switch to the frame first, Selenium won’t be
		 * able to interact with elements inside it.
		 */

		ExpectedConditions.frameToBeAvailableAndSwitchToIt("");
		ExpectedConditions.frameToBeAvailableAndSwitchToIt(element);
		ExpectedConditions.frameToBeAvailableAndSwitchToIt(1);

	}

	@Test
	private void method() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://netbanking.hdfcbank.com/netbanking/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// switch to the frame
		driver.switchTo().frame("login_page");

		driver.findElement(By.name("fldLoginUserId")).sendKeys("18483655");

		driver.findElement(By.xpath("//a[@onclick='return fLogon();']")).click();

		Thread.sleep(5000);

		driver.switchTo().frame("login_page");

		// find the text box and write to it
		driver.findElement(By.className("input_password")).sendKeys("123456");

		// switch back to main window
		driver.switchTo().defaultContent();

		driver.findElement(By.id("email")).sendKeys("");

	}

}
