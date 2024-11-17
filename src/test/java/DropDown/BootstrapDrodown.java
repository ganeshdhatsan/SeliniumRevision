package DropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BootstrapDrodown {

	@Test
	private void LandT() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.lntecc.com/");
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

		Actions act = new Actions(driver);

		WebElement src1 = driver.findElement(By.id("angular"));


	}
	
	
	
	
}
