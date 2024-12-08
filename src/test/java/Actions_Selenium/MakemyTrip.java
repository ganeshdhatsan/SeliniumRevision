package Actions_Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
public class MakemyTrip {
	   	    @Test
	    private void makemyTrip() throws InterruptedException {
	    	 WebDriver driver = new ChromeDriver();

	         // Maximize the browser window
	         driver.manage().window().maximize();

	         // Navigate to MakeMyTrip's website
	         driver.get("https://www.makemytrip.com");

	         // Implicit wait to handle dynamic elements
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	         // Handle initial popup or overlay (if present)
	         try {
	             WebElement closePopup = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
	             closePopup.click();
	             System.out.println("Popup closed successfully.");
	         } catch (Exception e) {
	             System.out.println("No popup detected.");
	         }

	         // Click on the departure date field to open the calendar
	         WebElement departureDateField = driver.findElement(By.xpath("//span[text()='Departure']"));
//	         departureDateField.click();
	         
	         JavascriptExecutor js = (JavascriptExecutor) driver;
	         js.executeScript("arguments[0].click();", departureDateField);
	         
//	         js.executeScript("arguments[0].scrollIntoView(true);", departureDateField);
//	         departureDateField.click();
	         
//	         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	         WebElement departureDateField1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Departure']")));
//	         departureDateField1.click();

	         // Add a short wait to allow the calendar to appear
	         Thread.sleep(2000);

	         // Define the date to select (e.g., 15th of the next month)
	         String targetMonthYear = "December 2024";
	         String targetDay = "15";

	         // Navigate through the calendar to find the correct month and year
	         while (true) {
	             WebElement displayedMonthYear = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']"));
	             String displayedText = displayedMonthYear.getText();

	             if (displayedText.equalsIgnoreCase(targetMonthYear)) {
	                 break; // Correct month and year found
	             } else {
	                 // Click on the next button to navigate to the next month
	                 WebElement nextButton = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
	                 nextButton.click();
	             }
	         }

	         // Select the target day from the calendar
	         WebElement targetDate = driver.findElement(By.xpath("//div[contains(@aria-label, '" + targetMonthYear + "')]//p[text()='" + targetDay + "']"));
	         targetDate.click();

	         // Add a wait to observe the selection
	         Thread.sleep(2000);

	         // Close the browser
	         driver.quit();
		}
	}



