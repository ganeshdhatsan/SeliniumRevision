package TakesScreenshotConcept;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TaksScreenshotConcept {
	
	/**
	 * Takes Scrrenshot
	 * 
	 * while automating something goes wrong, it helps to show visual representation of the exact anomaly.
	 * 
	 * 
	 */
	
	/**
	 *  Methods
	 *  
	 *  getSceenshotAs(OutputType.FILE)
	 *  
	 *  getSceenshotAs(OutputType.Base64)
	 *  
	 */
	
	/**
	 * How to use
	 * 
	 * Step 1 : downcast WebDriver to TakesScreenshot
	 * step 2: using ref call the method
	 * @throws IOException 
	 */
	
	@Test
	private void getSnapshotUsingTakesScreenshotAsFile() throws IOException {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir")+"\\Screenshots\\fileShot.png");
		
		FileUtils.copyFile(src, dest);
		
	
	}
	@Test
private void getSnapshotUsingTakesScreenshotASBase64() throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		
		Thread.sleep(1000);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		
		 byte[] decodedBytes = Base64.getDecoder().decode(base64);
		
		File dest = new File(System.getProperty("user.dir")+"\\Screenshots\\fileShot64.png");
		
		FileOutputStream stream = new FileOutputStream(dest);
		stream.write(decodedBytes);
		
	
	}
	
	
	@Test
	private void getSnapshotUsingWebElement() throws IOException {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		
		WebElement login = driver.findElement(By.name("login"));
		
		File src = login.getScreenshotAs(OutputType.FILE);
		
       File dest = new File(System.getProperty("user.dir")+"\\Screenshots\\fileShotWebelement.png");
		
		FileUtils.copyFile(src, dest);
		
		

	}
	
	@Test
	private void parentFolder() {
		
		 File file = new File(System.getProperty("user.dir")+"\\Screenshots\\fileShotWebelement.png");
		File parentDir = file.getParentFile();
		System.out.println("parent "+parentDir);
        if (!parentDir.exists()) {
            boolean mkdirs = parentDir.mkdirs();
        }
	}

}
