package automationcore;

import org.testng.annotations.Test;

import constants.Constant;
import utilities.ScreenshotUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Base {
	        Properties prop;
			FileInputStream fs;
	public WebDriver driver;
	  
	  @BeforeMethod(alwaysRun=true)
	  @Parameters("browser")
	  public void initialiseBrowser(String browser) throws Exception
	  { 
		    prop = new Properties();
		    fs = new FileInputStream(Constant.CONFIGEFILE);
		    prop.load(fs);
		    if(browser.equalsIgnoreCase("Chrome")) 
		    {
		    	driver = new ChromeDriver();
		    }
		    else if(browser.equalsIgnoreCase("Edge")) 
		    {
		    	driver = new EdgeDriver();
		    }
		    else if(browser.equalsIgnoreCase("Firefox")) 
		    {
		    	driver = new FirefoxDriver();
		    }
		    else
		    {
		    	throw new Exception("invalid browser");
		    }
		    
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
	  }

	  @AfterMethod(alwaysRun=true)
	  public void driverQuit(ITestResult itestresult) throws IOException  {
		  if(itestresult.getStatus()==ITestResult.FAILURE)
		  {
			  ScreenshotUtility screenshot = new ScreenshotUtility();
			  screenshot.captureFailureScreenShot(driver, itestresult.getName());
		  }
		 // driver.quit(); 
		  }

}