package SeleniumArchitecture_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class SeleniumArchitech {
	
	@Test
	private void launching() {
		
		/*
		 * Selenium Webdriver 
		 * Selenium webdriver advantages
		 * Selenium WebDriver is a popular open-source Tool
		 * It is used to automate the testing for web applications
		 * Its supports different programming languages such as Java, JavaScript, C#, Python, etc.
		 * Its supports different browsers such as EDGE, CHROME, FIREFOX,SAFARI etc.
		 * if any suggestions doubts clarity needs we can get support from Selenium community
		 */
		
		/* Top Alternaters
		 * cypress   -- Cypress is also an open-source test automation platform
		 * playwrite -- Playwright is an open-source test automation library developed by Microsoft contributors.
		 * 
		 * TOSCA -- paid version
		 * low code platform
		 * in build methods
		 * 
		 * 
		 */
		
		/*
		 *  Selenium WebDriver Architecture
		 *  selenium 3 Architectture
		 *  version 3.141.59
		 *  
		 *  selenium 4 Architectture
		 *  oct 2021
		 *  current version 4.24.0 aug 2024
		 *  project version 4.18.1
		 */
		
		
		/*
		 * A vulnerability in a dependency is a security issue that can affect a software product.
		 * while choosing dependency , we have to avoid to select the vulnerable version
		 * 
		 */

		/*
		 * Type -1 
		 * 
		 */
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\Ganesh\\SeleniumRevisionGanesh\\Driver\\chrome_proxy.exe");
		
//		WebDriver driver = new ChromeDriver();
		
		
		/*
		 * Type 2 upto selenium 3 - using webdriver manager dependency by bonigarcia 
		 */
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.facebook.com/");
		
		/*
		 * Type -3  selenium 4
		 */
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		
	}

}
