package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
	
	WebDriver driver;
	
	public Page(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement login;

		
	public WebElement getUserName() {
		return userName;
	}



	public WebElement getPassword() {
		return password;
	}


	public WebElement getLogin() {
		return login;
	}


	public void login(String value1,String value2) {
		getUserName().sendKeys(value1);
		getPassword().sendKeys(value2);
		getLogin().click();
	}
	
	
	
	
}
