package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		//constructor
	}
	
	By username = By.id("user_email");
	By password = By.id("user_password");
	By submitbtn = By.name("commit");
	
	public WebElement username()
	{
		return driver.findElement(username);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement submitbtn()
	{
		return driver.findElement(submitbtn);
	}
}

