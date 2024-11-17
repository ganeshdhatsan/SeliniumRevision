package WindowsHandling;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowsHandling {
	
	
	
	@Test
	private void handlePWC() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.pwc.in/");
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@alt='Facebook Follow']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
//		System.out.println("All windows upto facebook  : "+windowHandles1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@alt='X Follow']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
//		System.out.println("All windows upto X  : "+windowHandles2);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@alt='Linkedin Follow']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
//		System.out.println("All windows upto linkedin  : "+windowHandles3);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@alt='SocialFollow_Youtube']")).click();
		Set<String> windowHandles4 = driver.getWindowHandles();
//		System.out.println("All windows upto youtube  : "+windowHandles4);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@alt='Instagram Follow']")).click();
		Set<String> windowHandles5 = driver.getWindowHandles();
//		System.out.println("All windows upto instagram  : "+windowHandles5);
		Thread.sleep(1000);
		String parentWindow = driver.getWindowHandle();
		
		System.out.println("ParentWindow : "+parentWindow);
		
		Set<String> allWindows = driver.getWindowHandles();
		
		System.out.println("AllWindows : "+allWindows);
		
		//java 8
//		List<String> list = new ArrayList(allWindows);
//		
//		for (int i = 1; i < list.size(); i++) {
//		String value = list.get(i);
//			driver.switchTo().window(value);
//			Thread.sleep(2000);
//			driver.close();
//			
//		}
		
		
		
		//java 7
//		List<String> list1 = new ArrayList();
//		list1.addAll(allWindows);
		
		
		
		
//		for (String singleWindow : allWindows) {
//			
//			driver.switchTo().window(singleWindow);
//			
//			Thread.sleep(2000);
//			driver.close();
//			
//		}
		
	}
	
	@Test

private void handlePWC1() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.pwc.in/");
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//img[@alt='Linkedin Follow']")).click();
		
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			if(!string.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(string);
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@aria-label='Dismiss'])[2]")).click();
			}
			
		}
		
		
	}

	
}
