package constants;

public class Constant {
	public static final String CONFIGEFILE = System.getProperty("user.dir")
			+ "//src//main//resources//config.properties";

	public static final String lp_verifyLoginWithValidCredentials = "login Failed for valid credantials.";
	public static final String Lp_verifyUserLoginWithInvalidUsernameAndInvalidPassword = "Alert message is not expected";
	public static final String Lp_verifyUserLoginWithValidUsernameAndInvalidPassword = "Alert message is not expected";
	public static final String Lp_verifyUserLoginWithInvalidUsernameAndValidPassword = "Alert message is not expected";

	public static final String Sp_verifyAddNewSubcategorywithValidDetails = "Subcategory is not added successfully";
	public static final String Sp_verifySearchListSubCategories = "Search results are not displayed as expected";
	public static final String Mp_verifyTheUserCanEditTheManageContact = "Delivery charge was not updated successfully";
	public static final String Sp_verifyInactiveTheSubcategory = "Could not change the product status";
	public static final String Sp_verifyUserCanDeletSubcategory = "Delecting is not possible";

	public static final String TEST_DATE_FILE = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\TestData\\TestData.xlsx";
	public static final String Cp_verifyUserCanSearchCategory = "Alert is not Displayed";
	public static final String Cp_verifyUserCanEditCategoryAndUploadImage = "Alert message is not expected";
	public static final String MFp_verifyUserCanEditFooterText = "Alert is not displayed";
	public static final String MNp_verifyUserCanAddNewManageNews = "Alert is not displayed";
	public static final String MNp_verifyUserCanSearchWithInvalidManageNews="Result displayed not as Expected ";
	public static final String MNp_verifyUserCanSearchWithValidManageNews="Result Not Found";
	public static final String MNp_verifyUserCanEditManageNews="Editing is not completed Successfull";
	
}
