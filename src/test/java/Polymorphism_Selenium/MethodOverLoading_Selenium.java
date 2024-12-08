package Polymorphism_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MethodOverLoading_Selenium {
	WebDriver driver;

	@Test
	private void exampleForMethodOverLoadingInActionsClass() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		WebElement username = driver.findElement(By.id("email"));

		WebElement password = driver.findElement(By.id("pass"));

		Actions act = new Actions(driver);

		// Type-01 (WebElement + String)
		act.sendKeys(username, "java").perform();

		// Type-02 (WebElement + String +Enum)

		act.sendKeys(password, "kumar" + Keys.ENTER).perform();

		// Type-03 without Actions Class (String)

		username.sendKeys("kumar");

	}

	// sendkeys
	private void sendkeys(WebElement element, String text) {

		element.sendKeys(text);
	}

	private void sendkeys(String text, WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(text).perform();

	}

	private void sendkeys(String text) {
		Actions act = new Actions(driver);
		act.sendKeys(text).perform();

	}

	private void sendkeys(WebElement element, String text, Keys key) {
		element.sendKeys(text + key.ENTER);
	}

	private void sendkeys(WebElement element, String text1, Keys key, String text2) {
		element.sendKeys(text1, key.TAB, text2);

	}

     //click 
	private void click(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.click(element).perform();

	}

	private void click(WebElement element) {
		element.findElement(By.id(""));

		element.click();

	}

	// frames
	private void switchFrame(int indexNum) {
		driver.switchTo().frame(indexNum);

	}

	private void switchFrame(String value) {
		driver.switchTo().frame(value);

	}

	private void switchFrame(WebElement element) {
		driver.switchTo().frame(element);

	}

	private void find() {
		driver.findElement(By.xpath(""));

	}

}
