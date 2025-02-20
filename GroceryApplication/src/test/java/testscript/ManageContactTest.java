package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import page.HomePage;
import page.LoginPage;
import page.ManageContactPage;
import page.SubcategoryPage;

public class ManageContactTest extends Base {
	LoginPage login;
	HomePage home;
	SubcategoryPage sc;
	ManageContactPage managecontact;

	@Test
	public void verifyTheUserCanEditTheManageContact() throws IOException {
		login = new LoginPage(driver);
		home = login.LoginUsingExcelData();
		managecontact= home.clickOnManageContact().clickOnEditOption().editTheDeliveryChargeLimitField().clickJavaScriptExecutor();
		boolean actualresult = managecontact.getUpdateDeliverCharge();
		Assert.assertTrue(actualresult, Constant.Mp_verifyTheUserCanEditTheManageContact);
	}
}
