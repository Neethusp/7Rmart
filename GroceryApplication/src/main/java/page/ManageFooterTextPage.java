package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageFooterTextPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();
	FakerUtility fakerutility = new FakerUtility();

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr[2]//i[@class='fas fa-edit']")
	WebElement editbutton;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement textarea;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertdisplayed;

	public ManageFooterTextPage clickOnTheEditButton() {
		editbutton.click();
		return this;
	}

	public ManageFooterTextPage enterAddressField() {
		textarea.clear();
		String address = fakerutility.generateAddress();
		textarea.sendKeys(address);
		return this;

	}

	public ManageFooterTextPage clickOnSubmitButton() {
		submitbutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertdisplayed.isDisplayed();
	}

}
