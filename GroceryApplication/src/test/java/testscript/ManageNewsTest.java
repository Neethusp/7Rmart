package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import page.HomePage;
import page.LoginPage;
import page.ManageNewsPage;

public class ManageNewsTest extends Base {
	LoginPage login;
	HomePage home;
	ManageNewsPage managenewspage;

	@Test
	public void verifyUserCanAddNewManageNews() throws IOException {
		login = new LoginPage(driver);
		home = login.LoginUsingExcelData();
		managenewspage=home.clickOnManageNews().clickOnTheNewButton().enterNewManageNews().clickOnTheSaveButton();
		boolean actualResult = managenewspage.isAlertDisplayed();
		Assert.assertTrue(actualResult, Constant.MNp_verifyUserCanAddNewManageNews);
	}
	@Test
	public void verifyUserCanSearchWithInvalidManageNews() throws IOException {
		login = new LoginPage(driver);
		home = login.LoginUsingExcelData();
		managenewspage=home.clickOnManageNews().clickOnTheSearchOption().enterNewsTitle().clickOnTheSearchButton();
		boolean actualResult= managenewspage.isSearchDisplayed();
		Assert.assertTrue(actualResult, Constant.MNp_verifyUserCanSearchWithInvalidManageNews);
		
	}
	@Test
	public void verifyUserCanSearchWithValidManageNews() throws IOException {
		login = new LoginPage(driver);
		home = login.LoginUsingExcelData();
		managenewspage=home.clickOnManageNews().clickOnTheSearchOption().entervalidTitle().clickOnTheSearchButton();
		boolean actualResult= managenewspage.isValidSearchDisplayed();
		Assert.assertTrue(actualResult,Constant.MNp_verifyUserCanSearchWithValidManageNews);
	
	}  
	@Test
	public void verifyUserCanEditManageNews() throws IOException {
		login = new LoginPage(driver);
		home = login.LoginUsingExcelData();
		managenewspage=home.clickOnManageNews().clickOnTheEditButton().clearTheTextAndAddNewTitle().clickOnTheUpdateButton();
		boolean actualResult = managenewspage.isAlertDisplayedSuccessfully();
		Assert.assertTrue(actualResult,Constant.MNp_verifyUserCanEditManageNews);
}
}