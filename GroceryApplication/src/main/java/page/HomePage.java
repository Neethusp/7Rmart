package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {

	WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public HomePage(WebDriver driver)// constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// initElements=initialise all web elements

	}

	@FindBy(xpath = "//li//p[text()='Sub Category']")
	WebElement subcategory;
	@FindBy(xpath = "//li//p[text()='Manage Contact']")
	WebElement managecontact;
	@FindBy(xpath = "//li//p[text()='Manage News']")
	WebElement managenews;
	@FindBy(xpath = "//p[text()='Manage Category']")
	WebElement category;
	@FindBy(xpath = "//p[text()='Manage Footer Text']")
	WebElement managefootetext;

	public SubcategoryPage clickOnSubcategory() {
		subcategory.click();
		return new SubcategoryPage(driver);
	}

	public ManageContactPage clickOnManageContact() {
		managecontact.click();
		return new ManageContactPage(driver);
	}

	public ManageNewsPage clickOnManageNews() {
		managenews.click();
		return new ManageNewsPage(driver);
	}

	public CategoryPage clickOnCategory() {
		pageutility.clickJavaScriptExecutor(category, driver);
		return new CategoryPage(driver);

	}

	public ManageFooterTextPage clickOnManageFooterText() {
		managefootetext.click();
		return new ManageFooterTextPage(driver);

	}

}