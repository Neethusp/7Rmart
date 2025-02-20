package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageUtility {

    // Selects a dropdown value by visible text and returns the selected text
    public String selectDropdownWithValue(WebElement element, String value) {
        Select object = new Select(element);
        object.selectByValue(value);
        WebElement selectedElement = object.getFirstSelectedOption();
        return selectedElement.getText();
    }

    // Selects a dropdown value by index and returns the selected text
    public String selectDropdownWithIndex(WebElement element, int indexNumber) {
        Select object = new Select(element);
        object.selectByIndex(indexNumber);
        WebElement selectedElement = object.getFirstSelectedOption();
        return selectedElement.getText();
    }

    // Clicks an element using JavaScriptExecutor
    public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    // Scrolls to an element using JavaScriptExecutor
    public void clickJavaScriptExecutorByScroll(WebDriver driver, List<WebElement> elements, int index) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", elements.get(index));
    }

    // Generates a random number within a given limit
    public int random(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

    // Generates the current date and time in "ddMMyyhhmmss" format
    public String generateCurrentDateAndTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
        return formatter.format(date);

    }

    // Retrieves attribute value of an element
    public String getAttributeValue(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    // Scrolls down the page using JavaScriptExecutor
    public void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");
    }

    // Scrolls up the page using JavaScriptExecutor
    public void scrollUp(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500);");
    }
}