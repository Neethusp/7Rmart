package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import page.HomePage;
import page.LoginPage;
import page.ManageFooterTextPage;

public class ManageFooterTextTest extends Base {
	LoginPage login;
	HomePage home;
	ManageFooterTextPage managefooter;

	@Test
	public void verifyUserCanEditFooterText() throws IOException {
		login = new LoginPage(driver);
		home = login.LoginUsingExcelData();
		managefooter= home.clickOnManageFooterText().clickOnTheEditButton().enterAddressField().clickOnSubmitButton();
		boolean actualResult = managefooter.isAlertDisplayed();
		Assert.assertTrue(actualResult, Constant.MFp_verifyUserCanEditFooterText);

	}
}
