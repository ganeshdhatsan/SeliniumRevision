package JavascriptExecutor;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Javascript {

	WebDriver driver;

	/*
	 * Scroll Down & Up Types
	 */

	@Test
	private void scrollingTypes() throws InterruptedException, IOException {

//		id, name, linkText, patialLinktext,xpath,className,  tagname, cssSelector

		/*
		 * Type 1 using WebElements
		 */

		WebDriver driver = new ChromeDriver();

		driver.get("https://snapdeal.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement bottom = driver.findElement(By.xpath("//i[contains(@class,'neftbankIcon footerIconsImg')]"));

		WebElement top = driver.findElement(By.xpath("(//span[contains(@class,'catText')])[1]"));

		WebElement helpCentre = driver.findElement(By.xpath("//a[text()='Help Center']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", bottom, top);

		Thread.sleep(10000);

		js.executeScript("arguments[1].scrollIntoView();", bottom, top);

		/*
		 * scrolling using Actions class
		 */

		Actions act = new Actions(driver);

		act.scrollToElement(bottom).perform();

		/*
		 * Type 2 using Axis (X,Y) without Element
		 */

		js.executeScript("window.scrollBy(0,2000)");

		js.executeScript("window.scrollBy(0,-2000)");

		js.executeScript("arguments[1].scrollIntoView()", bottom, helpCentre);

		/*
		 * Type 2 a To find height of application return document.body.scrollHeight
		 * return document.documentElement.scrollHeight
		 */

		long totalHeight = (long) js.executeScript("return document.body.scrollHeight");
		System.out.println("length " + totalHeight); // 2300

		js.executeScript("window.scrollBy(0,2000)");

		/*
		 * Type 3 scrolling maximum height
		 */

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		Thread.sleep(10000);

		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	@Test
	private void scrollDownByActions() {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://snapdeal.com/");

		Actions act = new Actions(driver);
		
		act.keyDown(Keys.END).perform();
		
		
	}

	@Test
	private void otherJavaScriptActions() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demowebshop.tricentis.com/");

		WebElement check = driver.findElement(
				By.xpath("//label[text()='Very bad']//preceding-sibling::input[contains(@id,'pollanswers-4')]"));
//		check.click();

		/*
		 * click
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", check);

		WebElement news = driver.findElement(By.xpath("//input[contains(@id,'newsletter-email')]"));

//		news.sendKeys("hello");

		/*
		 * sendKeys
		 */

		js.executeScript("arguments[0].setAttribute('value','hello');", news);

		String attribute = news.getAttribute("name");
		System.out.println("web element attribute " + attribute);

		/*
		 * getAttribute
		 */

		String executeScript = js.executeScript("return arguments[0].getAttribute('name');", news).toString();
		System.out.println("executeScript attribute " + executeScript);

	}

	@Test
	private void Background_Border() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demowebshop.tricentis.com/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("location.reload()");

		WebElement news = driver.findElement(By.xpath("//input[contains(@id,'newsletter-email')]"));

		js.executeScript("arguments[0].setAttribute('value','hello')", news);

		js.executeScript("arguments[0].setAttribute('style','border:5px solid red;background:green');", news);

		/*
		 * for finding hidden elements
		 */
		WebElement element2 = driver.findElement(By.xpath("(//input[@name='keyword'])[1]"));

		js.executeScript("arguments[0].style.display='block'", element2);

		WebElement element = driver.findElement(By.cssSelector("Your CSS Selector"));

		// Get the background color using getCssValue() method
		String bgColor = element2.getCssValue("background-color");

		// Print the background color
		System.out.println("Background color: " + bgColor);

	}
	
	@Test
	private void findHiddenElement() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://snapdeal.com/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
	//	WebElement helpcentre = driver.findElement(By.xpath("//a[text()='Help Center']"));
		
		WebElement helpcentre = driver.findElement(By.cssSelector("a[href='/help']"));
		
		
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		js.executeScript("arguments[0].style.display='block'", helpcentre);
		
		Thread.sleep(10000);
		
		js.executeScript("arguments[0].click();", helpcentre);

//		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

		
	}

}
