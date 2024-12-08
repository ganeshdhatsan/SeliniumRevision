package SeleniumArchitecture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Architecture {
	
	
	/*
	 * selenium have mainly 2 versions
	 * 
	 * selenium 3 & 4
	 * 
	 * selenium 3 -- 3.141.59
	 * 
	 * 
	 *The system setProperty method has two attributes – “propertyName” and “value.” The propertyName represents the name of the browser-specific driver, and the value points to the path of that browser driver.

       The java.lang.System.setProperty() method sets the system property indicated by the specified key.

       Syntax:

       public static String setProperty(String key, String value)
       
       java.lang.System.setProperty();
	 * 
	 * String key == To mentined driver (chromeDriver or edgeDriver or firefoxDriver )
	 * 
	 * String value == To pass the location path of corresponding driver
	 * 
	 * 1st step ()
	 * 
	 * add  webdrivermanager dependency for initializing driver setup
	 * 
	 * provider  bonigarcia 3rd party
	 * 
	 * <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
          <dependency>
           <groupId>io.github.bonigarcia</groupId>
           <artifactId>webdrivermanager</artifactId>
            <version>5.9.1</version>
             </dependency>

	 * 
	 * WebDriverManager.chromeDriver().setup();
	 * WebDriverManager.edgeDriver().setup();
	 * WebDriverManager.firefoxDriver().setup();
	 * 
	 * 2nd step
	 * 
	 * WebDriver driver = new ChromeDriver();
	 * WebDriver driver = new ChromeDriver();
	 * WebDriver driver = new ChromeDriver();
	 * 
	 * selenium 4 -- 4.0 - 4.22.0 june
	 * 
	 * WebDriver driver = new ChromeDriver();
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	@Test
	private void method() {
		// selenium code using java 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		
//		https://www.browserstack.com/guide/architecture-of-selenium-webdriver
//			w3c = wwwc = world wide web consortium == protocol == rule & regulation
//			https =  Hypertext transfer protocol secure (HTTPS)= == protocol == rule & regulation

	}
	
	

}




