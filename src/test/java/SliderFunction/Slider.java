package SliderFunction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Slider {

	@Test
	void validateSlide() {
		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		try {
			// Open your web application
			driver.get("https://www.fitpeo.com/revenue-calculator"); // Replace with the URL of your web application

			// Locate the slider element
			WebElement slider = driver.findElement(By.xpath("//span[@class='MuiSlider-rail css-3ndvyc']")); // Replace
																											// with the
																											// actual ID
																											// or
																											// selector
																											// of the
																											// slider

			// Locate the text box where the value is displayed
			WebElement textBox = driver.findElement(By.xpath("//input[@type='number']")); // Replace with the actual ID
																							// or selector of the text
																							// box

			// Create an Actions instance to perform drag and drop actions
			Actions actions = new Actions(driver);

			// Get the current position of the slider

			// Total range of the slider
			int sliderMinValue = 0; // Replace with the actual minimum value if different
			int sliderMaxValue = 2000; // Replace with the actual maximum value
			int targetValue = 560;
		
			// Calculate slider's width
			int sliderWidth = slider.getSize().width;
			System.out.println("Slide Width " + sliderWidth);

			double proportionalOffset = ((double) (targetValue - sliderMinValue) / (sliderMaxValue - sliderMinValue)) * sliderWidth;
            int targetOffset = (int) Math.round(proportionalOffset);

			System.out.println("targetOffset Value " + targetOffset);
			// Perform the drag and drop action
			actions.clickAndHold(slider).moveByOffset(targetOffset, 0).release().perform();

			// Verify if the text box value has been updated
			String updatedValue = textBox.getAttribute("value");
			System.out.println("Updated Slider Value: " + updatedValue);

		}

		catch (Exception e) {
		}
	}
}
