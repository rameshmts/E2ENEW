package utilities;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import Facebook.FacBkTest;


public class base {

	public Logger log = LogManager.getLogger(base.class.getName());
		public WebDriver driver;
		public Properties prop = new Properties();
	public WebDriver driverinit() throws IOException
	{
		
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\utilities\\data.properties");
		prop.load(fis);
		//String browname = System.getProperty("browser"); // to run from maven or jenkins
	String browname = prop.getProperty("browser"); // to get data from data.properties file
		String URL = prop.getProperty("URL");
		if(browname.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","src/main/java/webDrivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browname.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}
		
		else if(browname.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver","src/main/java/webDrivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		 
		else if(browname.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","src/main/java/webDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getscreenshot(String name, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		System.out.println(name);
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\reports\\"+name+".png";
		FileUtils.copyFile(src, new File(dest));
		//FileHandler.copy(src,new File(dest) );
		return dest;
		
		
		//robot class - another method to take screenshot
		//example - when an alert is open and we want to take screenshot

		/*Robot rb = new Robot();
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(screensize);
		BufferedImage sourcefile = rb.createScreenCapture(rectangle);
		File destinationfile = new File("F://new.png");
		ImageIO.write(sourcefile, "png", destinationfile);*/
	}
	
}
