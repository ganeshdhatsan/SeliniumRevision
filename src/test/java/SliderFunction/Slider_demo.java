package SliderFunction;

import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Slider_demo {

	@Test
	void validateSlide() {
		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		try {

			driver.get("https://www.fitpeo.com/");

			Actions ac = new Actions(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
//			WebElement element = driver.findElement(By.xpath("//input[@type='number']"));
//			js.executeScript("arguments[0].scrollIntoView(true);", element);
//
//			Thread.sleep(3000);
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
			}

			ac.sendKeys(textBox, "560").perform();
			
			driver.findElement(By.xpath("//p[text()='CPT-99091']//following::input[@type='checkbox']")).click();
			driver.findElement(By.xpath("//p[text()='CPT-99453']//following::input[@type='checkbox']")).click();
			driver.findElement(By.xpath("//p[text()='CPT-99454']//following::input[@type='checkbox']")).click();
			driver.findElement(By.xpath("//p[text()='CPT-99474']//following::input[@type='checkbox']")).click();

		} catch (Exception e) {
		}
	}

}
