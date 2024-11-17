package Actions_Selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClass {

	private void me() {
		String given = "vuygj(njhbj(n m";
		String ans = given.split("(")[1];

	}

	/**
	 * 
	 * Actions : Mouse Actions in Selenium:
	 * 
	 * 1. click() : performs click action 3 2. doubleClick(): Performs double click
	 * onthe element 3. clickAndHold():Performs long click on the mouse without
	 * releasing it 4. dragAndDrop(): Drags the element from one point and drops to
	 * another 5. moveToElement(): Shifts the mouse pointer to the center of the
	 * element 6. contextClick(): To Perform right-click on the mouse 7.
	 * ScrollToElement() : To perform scrolling functions but not recommended
	 * 
	 * 
	 * 
	 * Keyboard Actions in Selenium:
	 * 
	 * Keys
	 * 
	 * keyUp(): Performs key release // examples : shift,fn, ctrl,alt
	 * keyDown():Performs keypress without release
	 * 
	 * 
	 * sendKeys(): Sends a series of keys to the element
	 * 
	 * 
	 */

	@Test

	private void mouseHoverandClickFunction() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://snapdeal.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

		WebElement homeKitchen = driver.findElement(By.xpath("//span[text()='Home & Kitchen']"));

		Actions act = new Actions(driver);

		/**
		 * If we want to do a single function using actions class use perform()
		 * 
		 * If we want to do a multiple function using actions at a time use
		 * build().perform();
		 */

		// MouseHover
		act.moveToElement(homeKitchen).perform();

//		act.moveToElement(homeKitchen).build().perform();

//		act.moveToElement(homeKitchen).click().build().perform();

		// Click
//		act.click(homeKitchen).perform();

	}

	@Test
	private void doubleClick() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

		WebElement homeKitchen = driver.findElement(
				By.xpath("//h2[text()='Facebook helps you connect and share with the people in your life.']"));

		Actions act = new Actions(driver);

		act.doubleClick(homeKitchen).perform();

	}

	@Test
	private void rightClick() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

		WebElement username = driver.findElement(By.id("email"));

		Actions act = new Actions(driver);

		act.contextClick(username).perform();

	}

	@Test
	private void method() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.spicejet.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		////input[@id='ctl00_mainContent_ddl_originStation1_CTXT']
		List<String> li = new ArrayList<String>();
		/*
		 * find the name of product of great indian festival
		 */
		List<WebElement> festival = driver
				.findElements(By.xpath("//span[text()='Great Indian Festival']/preceding::h2"));
		for (WebElement webElement : festival) {
			String text = webElement.getText();
			li.add(text);
		}
		////a[@value='BLR']
		/*
		 * by the product name to finding the price of each product
		 */
		for (int i = 0; i < li.size(); i++) {
			
			String nameofpro = li.get(i);
			System.out.println(nameofpro);
			WebElement pricewebref = driver.findElement(
					By.xpath("//span[text()='" + nameofpro + "']/following::span[@class='a-price-whole']"));
				System.out.println(pricewebref.getText());
		}

	}

	@Test
	private void clickAndHoldandDragAndDrop() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Static.html");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

		Actions act = new Actions(driver);

		WebElement src1 = driver.findElement(By.id("angular"));
		WebElement src2 = driver.findElement(By.id("mongo"));
		WebElement src3 = driver.findElement(By.id("node"));
		WebElement tgt = driver.findElement(By.id("droparea"));

		act.dragAndDrop(src1, tgt).perform();
		Thread.sleep(1000);
		act.dragAndDrop(src2, tgt).perform();
		Thread.sleep(1000);
		act.dragAndDrop(src3, tgt).perform();

		// move element using direction

		/**
		 * Sometimes, chaining Actions may not behave as expected if the element isn't
		 * properly interacted with before dragging. Using clickAndHold() and
		 * moveByOffset() can help in cases where dragAndDropBy() fails.
		 */

		Point location = tgt.getLocation(); // (439, 475)
		System.out.println(location);

		// Get the Y offset between src1 and the target element
		int srcY = src1.getLocation().getY();
		int tgtY = tgt.getLocation().getY();
		int yOffset = tgtY - srcY;

		// For dragging vertically, ensure the xOffset is 0 and move only in y-direction
		act.clickAndHold(src1).moveByOffset(0, yOffset).release().perform();
		Thread.sleep(1000);

		act.clickAndHold(src2).moveByOffset(0, yOffset).release().perform();
		Thread.sleep(1000);

		act.clickAndHold(src3).moveByOffset(0, yOffset).release().perform();

	}

	private void clickAndHold() throws InterruptedException {
		/**
		 * slider moving actions can be done through clickandhold method
		 * 
		 */

		/**
		 * Slider Manipulation Scenario: Testing sliders, such as price filters or
		 * volume control. Example: Moving a slider to a certain position
		 * 
		 * 
		 */

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.fitpeo.com/");

		Actions ac = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

//					WebElement element = driver.findElement(By.xpath("//input[@type='number']"));
//					js.executeScript("arguments[0].scrollIntoView(true);", element);
		//
//					Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

		ac.clickAndHold(slider).perform();
		ac.dragAndDropBy(slider, 94, 0).perform();

		WebElement Slider_textBox = driver.findElement(By.xpath("//input[@type='number']"));
		Slider_textBox.click();

		ac.keyDown(Keys.BACK_SPACE).perform();
		ac.keyUp(Keys.BACK_SPACE).perform();

		ac.sendKeys(Slider_textBox, "0").perform();

		Thread.sleep(3000);

		WebElement textBox = driver.findElement(By.xpath("//input[@type='number']"));
		textBox.click();
		for (int i = 0; i < 3; i++) {
			ac.keyDown(Keys.BACK_SPACE).perform();
			ac.keyUp(Keys.BACK_SPACE).perform();

			ac.sendKeys(textBox, "560").perform();
		}
		driver.findElement(By.xpath("//p[text()='CPT-99091']//following::input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//p[text()='CPT-99453']//following::input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//p[text()='CPT-99454']//following::input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//p[text()='CPT-99474']//following::input[@type='checkbox']")).click();

	}

	@Test
	private void senkeysAndKeyDownKeyUp() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		WebElement username = driver.findElement(By.id("email"));

		WebElement password = driver.findElement(By.id("pass"));

		Actions act = new Actions(driver);

//		act.sendKeys(username, "java").perform();

		act.keyDown(Keys.SHIFT).sendKeys(username, "facebook").keyUp(Keys.SHIFT).perform();

		act.sendKeys(password, "kumar" + Keys.ENTER).perform();

	}

}
