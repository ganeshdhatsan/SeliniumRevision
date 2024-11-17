package org.identifyingLocators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FindElementsFromDOM {

	/*
	 * we need to Interact with application components to handle 1st step , need to
	 * interact with elements How to interact - using locators , we have to identify
	 * the element first What are locators - 8 types 1.id * 2.name *
	 * 
	 * 3.Xpath * - tagName, id , name ,text, class etc
	 * xpath index starts with 1 not 0
	 * 
	 *  a).Relative Xpath - find element from current node 
	 *  1).normal Xpath - we use in 10 types 
	 *  2).Xpath Axes
	 * - relation
	 * 
	 * b).Absolute Xpath - find element from root node -- not preferable
	 * 
	 * 4.className 5.linkText 6.partialLinkText 7.tagNme 8.cssSelector
	 */

	@Test
	private void identifyElementsUsingID() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		/*
		 * using Id locator
		 */
//		driver.findElement(By.id("nav-hamburger-menu")).click();

		/*
		 * XPATH -- syntax -- //tagname[@attributename='attributevalue']
		 * 
		 * 
		 *
		 * using xpath locator -- relative xpath -- normal xpath any attribute, we can
		 * use for taking xpath from dom id,name,text,class etc
		 * 
		 * text -- black colour & no attribute
		 * 
		 * 
		 */
		driver.findElement(By.xpath("//a[contains(@id,'nav-hamburger-menu')]")).click();

//		driver.findElement(By.xpath("//i[contains(@class,'hm-icon nav-sprite')]")).click();

		/*
		 * Above click action , working fine without using Thread.sleep() most of the
		 * time but occasionally it doesn't work as expected so, Thread.sleep() used
		 * here
		 */

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a//div[text()='Fire TV']")).click();

		Thread.sleep(5000);

		WebElement amazonPrime = driver.findElement(By.xpath("//a[contains(text(),'Amazon Prime Video')]"));

		
		/*
		 * linktext()
		 */

		WebElement amazonPrime1 = driver.findElement(By.linkText("Amazon Prime Video"));
		

		/*
		 * partialLinktext()- instead of using entire text we can use partial text
		 */

		WebElement amazonPrimePartial = driver.findElement(By.partialLinkText("Prime"));

		// javascript executor

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[1].click()", amazonPrime, amazonPrime1);

// action class

//		Actions act = new Actions(driver);	
//		act.moveToElement(amazonPrime).click().perform();

		// expectedconditions

//		WebElement amazonPrime = driver.findElement(By.xpath("//a[contains(text(),'Amazon Prime Video')]"));
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(amazonPrime)).click();

		
		
	}

	
	@Test
	private void methods() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		/*
		 * className()
		 * this won't work because of compound class name ,To achieve we can go with CSSSelector
		 */
//		driver.findElement(By.className("_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy")).click();
		
//		driver.findElement(By.cssSelector("._42ft._4jy0._6lth._4jy6._4jy1.selected._51sy")).click();
		
		
		/*
		 * Type -01  using text with contains (not only for text ,applicable for all attributes )
		 */

		WebElement facebook1 = driver.findElement(By.xpath("//button[contains(@name,'login')]"));
		
		
		/*
		 * Type -02  using text with contains using * for tagname(not only for text ,applicable for all attributes )
		 */

		WebElement facebook2 = driver.findElement(By.xpath("//*[contains(@name,'login')]"));
		
		/*
		 * Type -03 using text without contains
		 */
		WebElement facebook3 = driver.findElement(By.xpath("//button[@name='login']"));
		
		/*
		 * Type -04  using starts-with (not only for text ,applicable for all attributes )
		 * 
		 */

		WebElement facebook4 = driver.findElement(By.xpath("//button[starts-with(@name,'login')]"));
		
		/*
		 * Type -05  using ends-with (not only for text ,applicable for all attributes )
		 * However, since ends-with is not supported in all XPath versions,
		 * you might need to adjust your approach based on the specific context. 
		 * If your environment supports XPath 2.0 or higher, you can use
		 */

//		WebElement facebook5 = driver.findElement(By.xpath("//button[ends-with(@name,'login')]"));
		
		
		/*
		 * Type-06  using index
		 */
			
		WebElement facebook6 = driver.findElement(By.xpath("(//button[starts-with(@name,'login')])[1]"));
		
		/*
		 * Type-07 by adding 2 different xpath only the content of []
		 */
		
		WebElement facebook7 = driver.findElement(By.xpath("//button[@name='login'][@data-testid='royal_login_button']"));
		
		/*
		 * Type-08 using or operator
		 */
		
		WebElement facebook8 = driver.findElement(By.xpath("//button[@name='login' or @data-testid='royal_login_button']"));
		
		/*
		 * Type-09 using and operator
		 */
		
		WebElement facebook9 = driver.findElement(By.xpath("//button[@name='login' and @data-testid='royal_login_button']"));
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[7].click()", facebook1,facebook2,facebook3,facebook4,facebook6,facebook7,facebook8,facebook9);

	}
	private void tagName() {

		/*
		 * Tagname
		 * To handle webtables 
		 */
		
		
		/*
		 * 
<table>
 <thead>
  <tr>  table row -- heading row
   <th>  table head-- heading column
 <tbody>
  <tr>  table row
   <td>   table data
		 */
		
		/*
		 * Heading
		 * 
		 * //table[@id='countries']//thead//tr//th[2]
		 * 
		 * Body
		 * 
		 * //table[@id='countries']//tbody//tr[2]//td[3]
		 * 
		 * Body - Heading
		 * 
		 * //table[@class='tsc_table_s13']//tbody//tr[1]//th[1]
		 *
		 */
		
	}
	
	@Test
	private void cssSelector() {
		
		
		/*
		 * CSS (Cascading Style Sheets) Selectors in Selenium are used to identify and locate web elements
		 * CSS is a preferred locator strategy and it is simpler to write and faster as compared to XPath.
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("ganesh");
		
		
		/*
		 *  CSSSelector for id is #
		 */
		//Type -01
//		driver.findElement(By.cssSelector("#email")).sendKeys("ganesh");
		
		//Type-02
//		driver.findElement(By.cssSelector("input#email")).sendKeys("ganesh");
		
		/*
		 *  CSSSelector for class is .
		 *  use . for every space in class value also
		 */
		
		//type -01
		
//		driver.findElement(By.cssSelector(".inputtext._55r1._6luy")).sendKeys("ganesh");
		
		//type -02
		
//		driver.findElement(By.cssSelector("input.inputtext._55r1._6luy")).sendKeys("ganesh");
		
		/*
		 * for Attribute
		 * 
		 */
//		driver.findElement(By.cssSelector("input[placeholder='Email address or phone number']")).sendKeys("ganesh");
		
		/*
		 *  combine more than one attribute at a time using css selector
		 */
		
//		driver.findElement(By.cssSelector("input#email[placeholder='Email address or phone number']")).sendKeys("ganesh");		
//		driver.findElement(By.cssSelector("input.inputtext._55r1._6luy[placeholder='Email address or phone number']")).sendKeys("ganesh");
		
		/*
		 *  contains for attributes
		 */
//		driver.findElement(By.cssSelector("input[class*='inputtext']")).sendKeys("ganesh");		
//		driver.findElement(By.cssSelector("input[data-testid*='email']")).sendKeys("ganesh");
		
		/*
		 *  starts with for attributes
		 */
//		driver.findElement(By.cssSelector("input[class^='inputtext']")).sendKeys("ganesh");
//		driver.findElement(By.cssSelector("input[data-testid^='royal']")).sendKeys("ganesh");
		
		/*
		 *  ends with for attributes
		 */
//		driver.findElement(By.cssSelector("input[class$='_6luy']")).sendKeys("ganesh");
//		driver.findElement(By.cssSelector("input[data-testid$='email']")).sendKeys("ganesh");
		
		
		/*
		 * 
		 * javascript  -- 1 %
		 * html  -- 99 %
		 * xml
		 * json
		 * txt
		 * 
		 * DOM - Document Object Model
		 */
		 // library -- contains multiple jars 
		// jar contains pre defined methods
		
		/*Xpath
		 * XPath stands for XML Path Language. It is a query-based syntax for XML schema and HTML documents 
and testers use to traverse elements within the document

Advantages of XPath
XPath supports all major test automation libraries(selenium,cyprus,playwright,appium) and programming languages
It provides bidirectional flow which means traversal can be both forward and backward
Supports both XML and HTML documents
XPath selector is compatible with old-age browsers as well as modern browsers
XPath locator provides Axes and methods. You can use them to solve complex locator problems

Disadvantages of XPath
The performance of the XPath varies from application to application.
XPath locators are comparatively slow, which can affect the overall performance of the test suite.
It cannot solve the modern world shadow DOM problem.
XPath is associated with more than one element in the DOM tree, 
and it will break if new element-level changes are introduced.

cssSelector

CSS (Cascading Style Sheets) Selectors in Selenium are used to identify and locate web elements

Advantages of CSS Selectors over XPath
CSS Selectors are faster in comparison with XPath.
These selectors are more readable and easier 
CSS selectors are compatible with all modern browsers.
CSS selectors are more reliable because it is mostly tied to single HTML element.

Disadvantages of CSS Selectors over XPath
CSS is unidirectional
it allows node traversal from parent to child only. 
When there are complex scenarios, it is difficult to construct locators.
CSS selectors don’t provide methods to handle complex element locators as we have the Axes method in XPath.
You cannot construct the selectors based on visible text.
		 */
		
		
		
		
	}
}
