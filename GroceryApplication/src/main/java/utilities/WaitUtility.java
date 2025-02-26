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
	public static int fluentWaitDuration=3;
	public static int explicitWaitDuration = 5;
	public static int implicitWaitDuration = 10;
	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(fluentWaitDuration)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}

	public void fluentWaitElementsAlert(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(fluentWaitDuration)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForWebElementAlert(WebDriver driver) // explicit wait
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitUntilElementisVisisble(WebDriver driver, WebElement element)// explicit wait
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilAllElementInVisisble(WebDriver driver, WebElement element)// explicit wait
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitDuration));
		wait.until(ExpectedConditions.invisibilityOfAllElements(element));
	}

	public void waitUntilElementisClickable(WebDriver driver, WebElement element)// explicit wait
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilAttributeContains(WebDriver driver, WebElement element)// explicit wait
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitDuration));
		wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
	}
	
	public void implicitWait(WebDriver driver) //implicit wait
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitDuration));
	}
	public static void disableImplicitWait(WebDriver driver) //disables implicit wait
	{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }
}