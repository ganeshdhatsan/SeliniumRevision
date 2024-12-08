package Xpath_CssSelector_Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathAxes {
/*
 * defines the tree-relationship between current node and target node using relationship
 * 
 * main Hierarchy
 * 
 * <ancestor>
 *   <parent>
 *     <preceding-sibling>
 *     <preceding>  
 *     <child (Current Node)> self
 *     <following>
 *     <following-sibling>
 *       <descendant>
 *       
 *  Example 1
 *  
 *  <ancestor>
 *   <parent>
 *     <preceding-sibling>
 *     <preceding>  
 *     <child (Current Node)> self
 *     <following>
 *     <following-sibling>
 *      <descendant>
 *   <node1>
 *     <node 2>  (target)
 *     
 *     child -- parent -- following-sibling -- child
 *     
 *       
 * 	
 */
	
	private void practo(String doctorName) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.practo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		WebElement textbox = driver.findElement(By.cssSelector("input.c-omni-searchbox.c-omni-searchbox--small"));
		WebElement textbox = driver.findElement(By.cssSelector("input[placeholder*='Search doctors, clinics, hospitals, etc.']"));
		
		/*
		 * finding toolTip - using getAttribute()
		 */
		
		String tooltip = textbox.getAttribute("placeholder");
		System.out.println("toolTip : "+tooltip);
		textbox.click();
		textbox.clear();	
	    textbox.sendKeys("Dentist");
		WebElement dentist = driver.findElement(By.xpath("//span//div[text()='Dentist']"));
		dentist.click();
		
		//h2[contains(text(),'Dr. M. Phani Babu')]//following::button[contains(text(),'Book Clinic Visit')]
		WebElement bookAppointment = driver.findElement(By.xpath(""));
		bookAppointment.click();
	}
	
	public static void main(String[] args) {
		XpathAxes axes = new XpathAxes();
		axes.practo("Dr. M. Phani Babu");
	}
	

}
