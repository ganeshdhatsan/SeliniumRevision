package WindowsHandling;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice1 {
	public void skipTab() {
		try {
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.pwc.in/");
			driver.manage().window().maximize();
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	        
			
		}
		catch(Exception e) {
//			e.printStackTrace();
			Assert.assertFalse(false, e.getMessage());
		}
	}

}
