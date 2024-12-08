package RemoteWebdriverClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteWebDriverClass {
	 static String username = "user_name";
	    static String accesskey = "access_key";
	    static RemoteWebDriver driver = null;
	    static String gridURL = "@hub.lambdatest.com/wd/hub";
	    static boolean status = false;
	
	    @Test
	private void login() {

		  DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName", "chrome");
	        capabilities.setCapability("version", "latest");
	        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one.
	        capabilities.setCapability("build", "JSExecutor-RemoteGrid");
	        capabilities.setCapability("name", "LambdaTestJavaSample");
	        
	        driver = new RemoteWebDriver(capabilities);
	        driver.get("https://www.facebook.com/");
		
		
	}

}
