package page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubcategoryPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();
	FakerUtility fakerutility = new FakerUtility();

	public SubcategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newsubcategorybutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categorydropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategoryfield;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchfield;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement categorydropdownsearch;
	@FindBy(xpath = "//input[@class='form-control' and @type='text']")
	WebElement subcategorysearch;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchbutton;
	@FindBy(xpath = "//th[text()='Sub Category Name']")
	WebElement searchresult;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement alertmessagenotfound;

	@FindBy(xpath = "//tr[1]/td//span[@class='badge bg-success']")
	WebElement activefield;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertinactive;

	@FindBy(xpath = "//tr[16]//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement delectedelementfield;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertdelecting;

	public SubcategoryPage clickOnNewSubCategoryButton() {
		newsubcategorybutton.click();
		return this;
	}

	public SubcategoryPage clickOnCategoryDropDown() {
		pageutility.selectDropdownWithVisibleText(categorydropdown, "Toys");
		return this;

	}

	public SubcategoryPage enterSubCategoryField() {
		String subcategoryname = "Bike288" + pageutility.generateCurrentDateAndTime();
		subcategoryfield.sendKeys(subcategoryname);
		return this;
	}

	public SubcategoryPage clickOnSaveButton() {
		savebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {

		return alertmessage.isDisplayed();

	}

	// SEARCH

	public SubcategoryPage clickOnTheSearchOption() {
		searchfield.click();
		return this;
	}

	public SubcategoryPage clickOnCategoryDropDownToSearch() {
		pageutility.selectDropdownWithVisibleText(categorydropdownsearch, "Toys");
		return this;

	}

	public SubcategoryPage clickOnSubcategory() {
		String subcategoryname = "Bike1455";
		subcategorysearch.sendKeys(subcategoryname);
		return this;
	}

	public SubcategoryPage clickOnTheSearchButton() {
		searchbutton.click();
		return this;
	}

	public boolean isSearchResultDisplayed() {
		try {
			return searchresult.isDisplayed();
		} catch (NoSuchElementException e) {

		}
		return false;

	}

	// INACTIVE
	public SubcategoryPage clickJavaScriptExecutor() {
		pageutility.clickJavaScriptExecutor(activefield, driver);
		return this;

	}

	public boolean isAlertDisplayedForInactive() {

		return alertinactive.isDisplayed();

	}

	// DELECTING
	public SubcategoryPage clickOnTheDelectButton() {
		pageutility.clickJavaScriptExecutor(delectedelementfield, driver);
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean isAlertDisplayedForDelecting() {

		return alertdelecting.isDisplayed();

	}

}
