package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewsPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div/div[1]/section/div[1]/a[1]")
	WebElement newfield;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement enterfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertdisplayed;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchfield;
	@FindBy(xpath = "//input[@class='form-control']") 
	WebElement newtitle;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']") 
	WebElement searchbutton;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']") 
	WebElement resultnotfound;
    @FindBy(xpath = "//td[text()='50% discount is announced for all the Product-New Year Special']") 
    WebElement resultfound;
    @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/edit?edit=3284&page_ad=1']")
    WebElement editbutton;
    @FindBy(xpath = "//textarea[@name='news']") 
    WebElement textarea;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement updatebutton;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement alertsuccessfull;
    
    //For adding new News
	public ManageNewsPage clickOnTheNewButton() {
		pageutility.clickJavaScriptExecutor(newfield, driver);
		return this;
	}

	public ManageNewsPage enterNewManageNews() {
		enterfield.sendKeys("Enjoy 50% off this Valentine's Week");
		return this;
	}

	public ManageNewsPage clickOnTheSaveButton() {
		savebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertdisplayed.isDisplayed();

	}
	
	//For searching invalid News
	public ManageNewsPage clickOnTheSearchOption()
	{
		searchfield.click();
		return this;
	}
	public ManageNewsPage enterNewsTitle()
	{
		newtitle.sendKeys("InvalidSearch");
		return this;
	}
	public ManageNewsPage clickOnTheSearchButton()
	{
		pageutility.clickJavaScriptExecutor(searchbutton, driver);
		return this;	
		
	}
	public boolean isSearchDisplayed()
	{
		return resultnotfound.isDisplayed();
		
	}
	// For searching valid news
	public ManageNewsPage entervalidTitle()
	{
		newtitle.sendKeys("50% discount");
		return this;
	}
	public ManageNewsPage clickOnTheSearch()
	{
		searchbutton.click();
		return this;	
	}
	public boolean isValidSearchDisplayed()
	{
		return resultfound.isDisplayed();
	} 
	
	//Edit
	public ManageNewsPage clickOnTheEditButton()
	{
		pageutility.clickJavaScriptExecutor(editbutton, driver);
		return this;
	}
	public ManageNewsPage clearTheTextAndAddNewTitle()
	{
		textarea.clear();
		textarea.sendKeys("Limited stock,unlimited savings! Shop now!.......");
		return this;
	}
	public ManageNewsPage clickOnTheUpdateButton()
	{
		waitutility.implicitWait(driver);
		updatebutton.click();
		return this;
	}
	public boolean isAlertDisplayedSuccessfully()
	{
		return alertsuccessfull.isDisplayed();
		 
	}
	
}
