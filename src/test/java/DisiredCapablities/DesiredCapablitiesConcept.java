package DisiredCapablities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

public class DesiredCapablitiesConcept {

	
	/*
	 * Purpose of DesiredCapabilities in Selenium DesiredCapabilities in Selenium is
	 * used to configure and set various options and features for the WebDriver
	 * session. It allows you to define specific browser and system properties such as
	 * 
	 * Browser Type: Which browser to use for your tests (e.g., Chrome, Firefox,
	 * Edge). Browser Version: The specific version of the browser (e.g., Chrome
	 * 77.0). Platform: The operating system on which the browser should run (e.g.,
	 * Windows, Linux, macOS). Browser Features: Capabilities that enable or disable
	 * specific browser features like JavaScript, logging, or performance metrics.
	 * Remote WebDriver: When you're running tests on remote machines or a Selenium
	 * Grid, DesiredCapabilities allows you to set up the properties needed to
	 * communicate with the remote server. The main purpose of DesiredCapabilities
	 * is to define browser-specific configurations that are necessary to execute
	 * automated tests in a consistent and controlled environment. This is
	 * especially important when running tests on different environments 
	 * (e.g., local vs. remote or across multiple browsers).
	 */
	
	/*
	 * // DesiredCapabilities Purposes: // Environment configuration: Set up the
	 * browser, platform, and version for tests. 
	 * // Test configuration: Define
	 * specific browser behaviors (e.g., JavaScript, screen resolution, proxy,
	 * etc.). // Remote testing: To Specify the configurations for remote grid
	 * testing (e.g., Selenium Grid, BrowserStack, Sauce Labs). 
	 * // Advanced logging
	 * and debugging: Enable features like network logs, visual recording, video
	 * recording, etc. 
	 * // Cross-browser and cross-platform compatibility: Ensure
	 * your application works across different browsers and operating systems.
	 */
	/*
	 * 1.Automation Grid (Selenium Grid or Cloud Services) When you're running tests
	 * on a Selenium Grid or cloud-based services like Sauce Labs or BrowserStack,
	 * DesiredCapabilities is necessary for passing configuration information to the
	 * hub or remote server that will manage the execution of your tests on
	 * different machines or environments.
	 * 
	 * 2.Cross-Browser Testing DesiredCapabilities enables cross-browser testing by
	 * allowing you to specify the browser and platform configurations. This helps
	 * ensure that your web application works consistently across multiple
	 * environments.
	 */
	
	
	/*
	 * Key Features You Can Set with DesiredCapabilities: browserName: Name of the
	 * browser (e.g., "chrome", "firefox", "edge"). version: Browser version.
	 * platform: Operating system (e.g., "Windows", "macOS", "Linux").
	 * javascriptEnabled: Enable or disable JavaScript (set to true or false).
	 * acceptSslCerts: Accept SSL certificates (set to true or false).
	 * screenResolution: Set the screen resolution of the browser window. proxy: Set
	 * up a proxy server for network communication. timezone: Specify the time zone
	 * for the browser session. geoLocation: Set the geo-location for the browser
	 * session. console: Capture console logs. network: Enable network logs. visual:
	 * Enable visual step-by-step screenshots. video: Enable video recording during the test.
	 */ 
	
	
	/*
	 * //To set the path of chrome driver
	 * capabilities.setCapability("chrome.driver", "path/to/chromedriver");
	 * 
	 * // Running tests on Chrome DesiredCapabilities chromeCapabilities =
	 * DesiredCapabilities.chrome(); chromeCapabilities.setCapability("browserName",
	 * "chrome");
	 * 
	 * // Running tests on Firefox DesiredCapabilities firefoxCapabilities =
	 * DesiredCapabilities.firefox();
	 * firefoxCapabilities.setCapability("browserName", "firefox");
	 */
	
	private static WebDriver driver;
	private static String username = "your_username"; // Replace with your username
	private static String accesskey = "your_accesskey"; // Replace with your access key
	private static String gridURL = "your_grid_url"; // Replace with your Selenium Grid URL or service (e.g.,
														// BrowserStack, Sauce Labs)

	// Setting up Desired Capabilities to run our test script
	@BeforeClass
	public static void setUp() throws Exception {

		// Creating a DesiredCapabilities object
		DesiredCapabilities capabilities = new DesiredCapabilities();

		/*
		 * Add chrome options in to desired capabilities We configure Chrome to launch
		 * with certain options (e.g., start maximized, disable notifications). We then
		 * set those options as part of the DesiredCapabilities.
		 */
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		/*
		 * Setting up the desired capabilities for the test Specify the Browser and
		 * Version
		 */
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("version", "77.0"); // Specify the browser version
		capabilities.setCapability("chrome.driver", "78.0"); // Specify Chrome driver version
		capabilities.setCapability("selenium_version", "4.0.0-alpha-2"); // Version of Selenium
		
		/* Define the Platform (Operating System) 
		 * */
		capabilities.setCapability("platform", "win10"); // Specify platform (Windows 10 in this case)
//		capabilities.setCapability("platform", "linux");
		capabilities.setCapability("build", "TestSampleApp");
		capabilities.setCapability("name", "TestJavaSample");

		
		/* Configure various Advanced Browser Features & Capabilities
		 *  */
		capabilities.setCapability("network", true); // Enable network logs
		capabilities.setCapability("visual", true); // Enable visual step-by-step screenshots
		capabilities.setCapability("video", true); // Enable video recording
		capabilities.setCapability("console", true); // Capture console logs

		/*
		 * Additional capabilities & Add Geo-location and Time Zone
		 */
		capabilities.setCapability("timezone", "UTC+05:30"); // Timezone for the browser session
		capabilities.setCapability("geoLocation", "IN"); // Geolocation for the browser
		
	
		try {
			// Initialize RemoteWebDriver with the grid URL and desired capabilities

			URL gridUrl = new URL(gridURL);

			driver = new RemoteWebDriver(gridUrl, capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
