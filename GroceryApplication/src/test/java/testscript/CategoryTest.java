package testscript;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Locale.Category;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import page.CategoryPage;
import page.HomePage;
import page.LoginPage;

public class CategoryTest extends Base {

	LoginPage login;
	HomePage home;
	CategoryPage categorypage;

	@Test
	public void verifyUserCanSearchCategory() throws IOException {
		login = new LoginPage(driver);
		home = login.LoginUsingExcelData();
		categorypage=home.clickOnCategory().clickOnTheSearchOption().enterCategory().clickOnTheSearchButton();
		boolean actualResult = categorypage.isAlertDisplayed();
		Assert.assertTrue(actualResult, Constant.Cp_verifyUserCanSearchCategory);
	}

	@Test
	public void verifyUserCanEditCategoryAndUploadImage() throws IOException, AWTException {
		login = new LoginPage(driver);
		home = login.LoginUsingExcelData();
		categorypage=home.clickOnCategory().clickOnTheEditButton().uploadingImage().clickOnTheUpdateButton();
		boolean actualResult = categorypage.isAlertDisplayedForUpdate();
		Assert.assertTrue(actualResult, Constant.Cp_verifyUserCanEditCategoryAndUploadImage);
	}
}
