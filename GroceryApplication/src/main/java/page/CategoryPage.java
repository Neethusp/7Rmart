package page;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class CategoryPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility wait = new WaitUtility();
	FileUploadUtility fileupload = new FileUploadUtility();

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchfield;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement categoryfield;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchbutton;
	@FindBy(xpath = "//td[text()='Icecream']")
	WebElement alertdisplayed;

	@FindBy(xpath = "//tr[3]//i[@class='fas fa-edit' ]")
	WebElement elementfield;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imagefield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement isalertdisplayed;

	//SEARCH
	public CategoryPage clickOnTheSearchOption() {
		searchfield.click();
		return this;
	}

	public CategoryPage enterCategory() {
		categoryfield.sendKeys("Icecream");
		return this;
	}

	public CategoryPage clickOnTheSearchButton() {
		searchbutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertdisplayed.isDisplayed();

	}

	// UPLOADING_IMAGE

	public CategoryPage clickOnTheEditButton()

	{
		elementfield.click();
		return this;
	}

	public CategoryPage uploadingImage() {
		String file = System.getProperty("user.dir") + "\\src\\test\\resources\\Image\\jewellery.jpg";
		fileupload.fileuploadusingsendkeys(imagefield, file);
		return this;
	}

	public CategoryPage clickOnTheUpdateButton() {
		pageutility.clickJavaScriptExecutor(updatebutton, driver);
		return this;
	}

	public boolean isAlertDisplayedForUpdate() {
		return isalertdisplayed.isDisplayed();

	}
}
