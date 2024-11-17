package SeleniumMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInitialization {

	private void Methods() {

		/**
		 * Driver Initialization
		 * 
		 */
		/**
		 * TYpe 01 - Java Project - Driver Initialization
		 * 
		 * download selenium library jar -3.141.59
		 * 
		 * download driver.exe file
		 * 
		 * add in to project
		 * 
		 * add buildpath for selenium library
		 * 
		 * using System.setProprty(). we have connect both selenium and driver
		 * 
		 * 
		 */
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\eclipse-workspace\\Ganesh\\SeleniumSetProperty\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/documentation/webdriver/");

		/**
		 * Type 02 - Maven Project - selenium 3 -Driver Initialization
		 * 
		 * using WebDriver Manager 3rd part dependency(bonigarcia) , we connected
		 * selenium lib and driver
		 * 
		 * <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
		 * --> <dependency> <groupId>io.github.bonigarcia</groupId>
		 * <artifactId>webdrivermanager</artifactId> <version>5.7.0</version>
		 * </dependency>
		 * 
		 * 
		 */

//		WebDriverManager.chromedriver().setup();

		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://www.selenium.dev/documentation/webdriver/");

		/**
		 * Type 03 - Maven Project - selenium 4 -Driver Initialization
		 * 
		 * add selenium 4 dependency
		 * 
		 * <dependency> <groupId>org.seleniumhq.selenium</groupId>
		 * <artifactId>selenium-java</artifactId> <version>4.20.0</version>
		 * </dependency>
		 */

		WebDriver driver2 = new ChromeDriver();
		driver2.get("https://www.selenium.dev/documentation/webdriver/");

	}

}
