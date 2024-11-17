package Waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWait {
	
	WebDriver driver;
	
	/**
	 * Wait clasified mainly in to 2 types
	 * 
	 * 1.static wait - Hard wait
	 * 
	 * Thread.sleep();
	 * 
	 * When you call Thread.sleep(), the current thread is paused, 
	 * and it will not execute any further code until the specified time elapses.
	 * After the sleep duration, the thread resumes execution from where it left off.
	 * 
	 * milliseconds: The number of milliseconds (1/1000th of a second) for which the thread should be paused.
       InterruptedException: This exception is thrown if another thread interrupts the current thread while it is sleeping.
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
	private void threadSleep() throws InterruptedException {
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		Thread.sleep(60000);

		driver.manage().window().maximize();
	}

}
