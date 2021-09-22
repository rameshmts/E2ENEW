package FramewrkScratch.E2E;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.LoginPage;
import pageobjects.RahulHomepage;
import utilities.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.*;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

public class newTest extends base {

		
     public WebDriver driver;
	@Test(dataProvider="dataprov")
	public void basepagenavi(String username, String password) throws IOException
	{
		
		driver = driverinit();
		driver.get(prop.getProperty("URL"));
		RahulHomepage rh = new RahulHomepage(driver);
//		String tt = rh.title().getText();
		Assert.assertEquals(rh.title().getText(), "Featured Course");
		rh.loginbtn().click();
		LoginPage lp = new LoginPage(driver);
		lp.username().sendKeys(username);
		log.info("User name is entered");
		lp.password().sendKeys(password);
		log.info("Password is entered");
		lp.submitbtn().click();
		log.info("Submit button is clicked");
		driver.quit();	
	}
	
	@DataProvider
	public String[][] dataprov()
	{
		
	
		String data[][] = {{"aaa@gmail.com","bbb"},{"ccc@gmail.com","ddd"}};
		return data;
	}
}

