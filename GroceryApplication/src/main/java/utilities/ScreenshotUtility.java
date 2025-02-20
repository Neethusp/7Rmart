package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	public void captureFailureScreenShot(WebDriver driver, String name) throws IOException {

		TakesScreenshot scrShot = (TakesScreenshot) driver;          //interface
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);     //getScreenshotAs= it is a method    OutputType= temporary file for saving 

		File f1 = new File(System.getProperty("user.dir") + "\\OutputScreenshots");    //user.dir = for current 
		if (!f1.exists()) {

			f1.mkdirs();  //creating folder 
		}
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		File finalDestination = new File(
				System.getProperty("user.dir") + "\\OutputScreenshots\\" + name + "_" + timeStamp + ".png");
		FileHandler.copy(screenShot, finalDestination);  //temp path to project folder //FileHandler.copy= method
	}
}