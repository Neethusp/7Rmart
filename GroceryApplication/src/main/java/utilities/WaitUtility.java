package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}

	public void waitForWebElementAlert(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void waitUntilElementIsVissible(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void waitUntilElementIsClickable(WebDriver driver,WebElement element)   //wait for element to be clickable
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitUntilElementText(WebDriver driver,WebElement element,String text)   //wait for elements Text
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	public void waitUntilElementIsInvisible(WebDriver driver,By locator)   //wait for element to disappear
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public void waitUntilElementIsSelected(WebDriver driver,WebElement element)  //wait for element to be selected
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
}
