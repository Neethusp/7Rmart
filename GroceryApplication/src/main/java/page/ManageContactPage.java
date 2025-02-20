package page;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtility;

public class ManageContactPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement editoption;
	@FindBy(xpath = "//input[@class='form-control' and@name='del_limit']")
	WebElement deliverychargelimitfield;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertsuccessfully;
	private @Nullable Object element;

	public ManageContactPage clickOnEditOption() {
		editoption.click();
		return this;
	}

	public ManageContactPage editTheDeliveryChargeLimitField() {
		deliverychargelimitfield.clear();
		deliverychargelimitfield.sendKeys("2088");
		return this;
	}

	public ManageContactPage clickJavaScriptExecutor() {
		pageutility.clickJavaScriptExecutor(updatebutton, driver);
		return this;

	}

	public boolean getUpdateDeliverCharge() {
		return alertsuccessfully.isDisplayed();

	}
}