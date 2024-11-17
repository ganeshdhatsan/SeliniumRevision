package com.switchcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClass {

	WebDriver driver;
	
	public void browerLaunch(String browserName,String description) {

		switch (browserName.toUpperCase()) {
		case "CHROME":
			driver = new ChromeDriver();
			System.out.println(description);
			break;
		case "EDGE":
			driver = new EdgeDriver();
			System.out.println(description);
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			System.out.println(description);
			break;
		case "SAFARI":
			driver = new SafariDriver();
			System.out.println(description);
			break;

		default:
			break;
		}

	}

}
