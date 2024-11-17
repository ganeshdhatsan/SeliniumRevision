package Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	WebDriver driver;
	
	public void handleStaleException(By Locator,long time) {
		//step -01
		driver.navigate().refresh();
		//step -02
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		//step -03
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
		
	}
	
	public void handleStaleVisible(WebElement ele,long time) {
		//step -01
		driver.navigate().refresh();
		//step -02
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
		//step -03
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
		
	}
	
	public void handleStaleInvisible(WebElement ele,long time) {
		//step -01
		driver.navigate().refresh();
		//step -02
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		//step -03
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(ele)));
		
	}
	
	public WebElement handlePressence(By Locator,long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		return element;		
	}
	
	public List<WebElement> handlePressenceList(By Locator,long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locator));
		return elements;		
	}
	
	

}
