package page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signinbutton;
	@FindBy(xpath = "//aside[@class='main-sidebar elevation-4 sidebar-light-dark']")
	WebElement homepage;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertmessage;

	public void enterusernameonusernamefield(String username) {
		usernamefield.sendKeys(username);

	}

	public void enterPasswordPasswordField(String password) {
		passwordfield.sendKeys(password);
	}

	public HomePage LoginUsingExcelData() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login Page");
		usernamefield.sendKeys(username);
		String password = ExcelUtility.readStringData(1, 1, "Login Page");
		passwordfield.sendKeys(password);
		signinbutton.click();
		return new HomePage(driver);

	}

	public HomePage clickOnLoginButton() {
		signinbutton.click();
		return new HomePage(driver);
	}

	public boolean isHomePageLoaded() {
		return homepage.isDisplayed();

	}

	public boolean getAlertMessage() {
		return alertmessage.isDisplayed();

	}

}
