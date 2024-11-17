package AlertConcept;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertConcept {
	
	/**
	 * 
	 * Alert 
	 * 
	 * An Alert is a small message box that appears on the screen to give some kind of information
	 * or permission to perform that operation.
	 * 
	 * Without handling Alert we can't do any action the webpage
	 * 
	 * we can't inspect Alert window
	 * 
	 * 
	 */
	
	
	
	/**
	 * Types of Alert
	 * 
	 *  1.simple Alert - OK button
	 * 
	 *  2. confirm Alert - ok  & cancel button
	 *  
	 *  3. prompt Alert -- have to provide some prompt(type som info)
	 * 
	 * 
	 */

	
	/**
	 * How to handle Alert
	 * 
	 * step1 : first we have to switch to Alert window using driver.switchTo().alert();
	 * 
	 * accept()  -- to click OK Button
	 * 
	 * dismiss()  -- To click Cancel Button
	 * 
	 * getText() - to fetch text
	 * @throws InterruptedException 
	 * 
	 * 
	 * 
	 */
	
	@Test
	private void simpleAlert() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Alerts.html");
		
		driver.findElement(By.xpath("//a[text()='Alert with OK ']")).click();
		
		driver.findElement(By.cssSelector(".btn.btn-danger")).click();
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
	
	@Test
private void confirmAlert() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Alerts.html");
		
		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
		
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
//		alert.dismiss();

	}
	
	
	@Test
private void prompAlert1() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Alerts.html");
		
		driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
		
		driver.findElement(By.cssSelector(".btn.btn-info")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("alertBox");
		
		alert.accept();
		
	}
	
	@Test
private void prompAlert2() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Alerts.html");
		
		driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
		
		driver.findElement(By.cssSelector(".btn.btn-info")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		
		alert.sendKeys(text);
		
		alert.accept();
		
	

	}
	
	
	
	
	
}
