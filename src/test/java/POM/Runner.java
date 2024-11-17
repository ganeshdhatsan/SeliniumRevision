package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Runner  {
	
	WebDriver driver;
	

	@Test
	private void loginFunc() {

		driver=new ChromeDriver();

		driver.get("https://www.facebook.com/");
		
		Page p = new Page(driver);

		p.login("ganesh", "kumar");

	}

}
