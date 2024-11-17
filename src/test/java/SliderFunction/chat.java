package SliderFunction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class chat {

	@Test
	void test01() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		try {
			// Open the web application
			driver.get("https://www.fitpeo.com/revenue-calculator");

			// Locate the slider input element
			WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

			// Get the total range and current value of the slider
			int minValue = Integer.parseInt(slider.getAttribute("aria-valuemin"));
			int maxValue = Integer.parseInt(slider.getAttribute("aria-valuemax"));
			int currentValue = Integer.parseInt(slider.getAttribute("aria-valuenow"));
			int targetValue = 820;

			// Get the width of the slider container (slider's parent element)
			WebElement sliderContainer = driver.findElement(By.xpath("//span[contains(@class, 'MuiSlider-root')]"));
			int sliderWidth = sliderContainer.getSize().width;

			// Calculate the proportional offset based on the target value
			double proportionalOffset = ((double) (targetValue - minValue) / (maxValue - minValue)) * sliderWidth;
			int targetOffset = (int) Math.round(proportionalOffset);

			// Create Actions instance to interact with the slider
			Actions actions = new Actions(driver);

			// Calculate the current position of the slider thumb
			Point currentPosition = slider.getLocation();
			System.out.println("Current Slider Position: " + currentPosition);

			// Calculate the new position by moving the slider to the target offset
			// Move to the thumb location and drag to the calculated offset
			actions.clickAndHold(slider).moveByOffset(targetOffset, 0).release().perform();

			// Print the new position of the slider
			Point newPosition = slider.getLocation();
			System.out.println("New Slider Position: " + newPosition);

			// Verify if the text box value has been updated
			WebElement textBox = driver.findElement(By.xpath("//input[@type='number']"));
			String updatedValue = textBox.getAttribute("value");
			System.out.println("Updated Slider Value: " + updatedValue);

		} catch (Exception e) {

		}
	}

	@Test
	private void test02() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Open the web application
		driver.get("https://www.fitpeo.com/revenue-calculator");
		
		 WebElement slider = driver.findElement(By.xpath("//span[@data-index='0']"));

	        // Get the current value of the slider
	        int currentValue = Integer.parseInt(slider.getAttribute("value"));
	        System.out.println("currentValue "+currentValue);

	        // Move the slider to a new value (e.g. 75)
	        int newValue = 820;
	        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','820');", slider);

	        // Alternatively, you can use the Actions class to drag the slider
	        // Actions actions = new Actions(driver);
	        // actions.dragAndDropBy(slider, newValue - currentValue, 0).perform();



	}
}
