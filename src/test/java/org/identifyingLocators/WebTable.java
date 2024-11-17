package org.identifyingLocators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	
	private void W3Table(String company) throws InterruptedException {
		 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Thread.sleep(20000);
		
//		driver.findElement(By.xpath("//table[@id='customers']//tbody//tr[6]//td[2]"));
		
		WebElement element = driver.findElement(By.xpath("//table[@id='customers']//tbody//tr//td[contains(text(),'"+company+"')]//following-sibling::td[2]"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		
		
		String text = element.getText();
		
		System.out.println("Country : "+text);
		
	}
	
	public void cosmocode(String language){
		try{
        WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String element = driver.findElement(By.xpath("//table//tbody//tr//td[contains(text(),'"+language+"')]//preceding-sibling::td[1]")).getText();
//        driver.findElement(By
//		.xpath("//table//tbody//tr//td[contains(text(),'"+language+"')]//preceding-sibling::td[2]//child::input"))
//        .click();
		System.out.println("Currency:  "+element);
        
        
        
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		}
	
	public static void main(String[] args) throws InterruptedException {
		
		WebTable table = new WebTable();
//		table.W3Table("Magazzini Alimentari Riuniti");
		table.cosmocode("Dari Persian; Pashto");
	}
	

}
