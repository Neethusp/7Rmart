package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import page.HomePage;
import page.LoginPage;
import page.SubcategoryPage;

public class SubCategoryTest extends Base {
	LoginPage login;
	HomePage home;
	SubcategoryPage subcategory;

	@Test
	public void verifyAddNewSubcategorywithValidDetails() throws IOException {
		login = new LoginPage(driver);
		home = login.LoginUsingExcelData();
		subcategory = home.clickOnSubcategory().clickOnNewSubCategoryButton().clickOnCategoryDropDown()
				.enterSubCategoryField().clickOnSaveButton();
		boolean actualresult = subcategory.isAlertDisplayed();
		Assert.assertTrue(actualresult, Constant.Sp_verifyAddNewSubcategorywithValidDetails);

	}

	@Test
	public void verifyUserCanSearchSubCategoryList() throws IOException {
		login = new LoginPage(driver);
		home = login.LoginUsingExcelData();
		subcategory = home.clickOnSubcategory().clickOnTheSearchOption().clickOnCategoryDropDownToSearch()
				.clickOnSubcategory().clickOnTheSearchButton();
		boolean actualresult = subcategory.isSearchResultDisplayed();
		Assert.assertTrue(actualresult, Constant.Sp_verifySearchListSubCategories);

	}

	@Test
	public void verifyUserCanChangeTheSubcategoryStatus() throws IOException {
		login = new LoginPage(driver);
		home = login.LoginUsingExcelData();
		subcategory = home.clickOnSubcategory().clickJavaScriptExecutor();
		boolean actualresult = subcategory.isAlertDisplayedForInactive();
		Assert.assertTrue(actualresult, Constant.Sp_verifyInactiveTheSubcategory);

	}

	@Test
	public void verifyUserCanDeletSubcategory() throws IOException {
		login = new LoginPage(driver);
		home = login.LoginUsingExcelData();
		subcategory = home.clickOnSubcategory().clickOnTheDelectButton();
		boolean actualresult = subcategory.isAlertDisplayedForDelecting();
		Assert.assertTrue(actualresult, Constant.Sp_verifyUserCanDeletSubcategory);
	}
}
