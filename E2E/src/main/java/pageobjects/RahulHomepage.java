package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RahulHomepage {
	public WebDriver driver;
	public RahulHomepage(WebDriver driver)
	{
		this.driver = driver;
		//constructor
	}
	
	By loginbtn = By.cssSelector("a[href*='sign_in']");
	By title = By.xpath("/html/body/app-root/div/app-home/div/section[2]/div[1]/div[1]/div[1]/h2");
	
	public WebElement loginbtn()
	{
		return driver.findElement(loginbtn);
	}

	public WebElement title()
	{
		return driver.findElement(title);
	}
}
