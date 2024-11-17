package Robot_Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RobotClass {

	/**
	 * Importance of Robot class
       Uploading a file is easy when we use the robot class
       It can simulate and handle the mouse and keyboard functions
       It can handle pop-ups as well
	 */
	
	
	/**
	 * Methods to implement the Robot class
       To implement the Robot class, we require a few methods 

       1.KeyPress()
       2.KeyRelease()
       
       
       3.MouseMove()
       4.MousePress()
       5.MouseRelease()
	 * @throws AWTException 
	 */
	
	@Test
	private void keyPressAndkeyRelease() throws AWTException {
	
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
//		driver.findElement(By.id("email")).sendKeys("robot");
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
//		driver.findElement(By.id("pass")).sendKeys("java");
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
//		driver.findElement(By.name("login")).click();
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		

	}
	
	@Test
	private void method() throws AWTException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		
		Robot robot = new Robot();
		
		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
	
	
}
