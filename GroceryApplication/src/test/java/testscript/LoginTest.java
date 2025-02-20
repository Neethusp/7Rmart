package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import freemarker.template.utility.Constants;
import page.LoginPage;

public class LoginTest extends Base {
	@Test
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() {
		LoginPage login = new LoginPage(driver);
		String username = "admin88";
		String password = "admin";
		login.enterusernameonusernamefield(username);
		login.enterPasswordPasswordField(password);
		login.clickOnLoginButton();
		boolean expectedResult = login.getAlertMessage();
		Assert.assertTrue(expectedResult, Constant.Lp_verifyUserLoginWithInvalidUsernameAndValidPassword);

	}

	@Test
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() {
		LoginPage login = new LoginPage(driver);
		String username = "admin";
		String password = "admin01";
		login.enterusernameonusernamefield(username);
		login.enterPasswordPasswordField(password);
		login.clickOnLoginButton();
		boolean expectedResult = login.getAlertMessage();
		Assert.assertTrue(expectedResult, Constant.Lp_verifyUserLoginWithValidUsernameAndInvalidPassword);

	}

	@Test(dataProvider = "dataprovider1")
	public void verifyUserLoginWithInvalidUsernameAndInvalidPassword(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterusernameonusernamefield(username);
		login.enterPasswordPasswordField(password);
		login.clickOnLoginButton();
		boolean expectedResult = login.getAlertMessage();
		Assert.assertTrue(expectedResult, Constant.Lp_verifyUserLoginWithInvalidUsernameAndInvalidPassword);
	}

	@DataProvider(name = "dataprovider1")
	public Object[][] dpmethod1() {
		return new Object[][] { { "admin12", "12admu" }, { "1admin", "ghy66" }, { "1admin88", "ghy66ad" } };

	}

	@Test(groups = "smoke")
	public void verifyUserLoginWithValidUsernameAndValidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		login.LoginUsingExcelData();
		boolean expectedResult = true;
		boolean actualResult = login.isHomePageLoaded();
		Assert.assertEquals(actualResult, expectedResult, Constant.lp_verifyLoginWithValidCredentials);

	}
}