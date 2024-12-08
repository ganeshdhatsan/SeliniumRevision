package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebElementMethods {

	/*
	 * Selenium webdriver
	 * 
	 * Search Contex I - super interface
	 * 
	 * WebDriver Child Interface, Webelement Child Interface
	 * 
	 * Takesscreenshot(I) javascriptexecutor(I)
	 * 
	 * chromedriver(C) edgedriver(C) firefoxdriver(C)
	 */

	@Test
	private void method() {

		WebDriver driver = new ChromeDriver();

		WebElement element = driver.findElement(By.id(""));

		/*
		 * To clear the text box
		 */

		element.clear();

		/*
		 * To click , radio button, check box and all other clickable actions
		 */
		element.click();

		/*
		 * To find single or collection of webelements
		 */

		driver.findElement(By.id(""));

		element.findElement(By.id(""));

		driver.findElements(By.id(""));

		element.findElements(By.id(""));

		/*
		 * To Take Screenshot
		 */

		TakesScreenshot ts1 = (TakesScreenshot) driver;

		TakesScreenshot ts2 = (TakesScreenshot) element;

		ts1.getScreenshotAs(OutputType.FILE);

		element.getScreenshotAs(OutputType.FILE);

		/*
		 * getTagName
		 */

		WebElement element2 = driver.findElement(By.id(""));

		String tagName = element2.getTagName();

		/*
		 * getText() -to fetch the text
		 */

		WebElement element3 = driver.findElement(By.xpath("//a[contains(text(),'ganesh.kumar1@wipro.com')]"));

		String text = element3.getText();// ganesh.kumar1@wipro.com

		/*
		 * getAttribute()
		 */

		WebElement element4 = driver.findElement(By.xpath("//a[contains(text(),'ganesh.kumar1@wipro.com')]"));

		String text4 = element4.getAttribute("value");// ganesh.kumar1@wipro.com

		/*
		 * small-searchterms
		 * 
		 */

		WebElement element5 = driver.findElement(By.id("small-searchterms"));

		boolean displayed = element5.isDisplayed(); // true or false

		boolean enabled = element5.isEnabled();// true or false

		boolean selected = element5.isSelected(); // for check box

		/*
		 * sendkeys
		 */
		WebElement element6 = driver.findElement(By.xpath("//a[contains(text(),'ganesh.kumar1@wipro.com')]"));

		boolean displayed1 = element5.isDisplayed(); // true or false

		boolean enabled1 = element5.isEnabled();// true or false
		
		element6.click();
		element6.clear();
		element6.sendKeys("java");

	}

}
