/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarch.utils.ExcelUtils;

import com.tekarck.pages.LoginPage;
import com.tekarck.pages.UserMenuPage;

/**
 * 
 */
//@Listeners(SFDC_Listener.class)
public class TC02_ValidLoginToSalesForce extends BaseTest {

	LoginPage lp;
	UserMenuPage hp;

	// Launch App
//	@Test
	void launchApp(Method mName) {
		
		logger.info("INIDE THe CLASS :    "+this.getClass().getName());
		
		logger.info("Inside the method:    "+mName.getName());
	
		logger.info("launching the application");

		String expectedPagetitle = TitleConstants.LOGIN_PAGE_TITLE;
		boolean flag = CommonUtils.waitForTitleOfThePage(getDriver(), expectedPagetitle);
		Assert.assertTrue(flag);
		
		logger.info("Login Page title :"+expectedPagetitle);

	}

	/*
	 * Enter User Name clear password click on login btn Validate homepage title
	 */
	@Test
	void loginToSalesForceAppwithValidUserAndPwd(Method mName) throws InvalidFormatException, IOException {
		
		logger.info("Test case satrted here :    "+mName.getName());
		lp = new LoginPage(getDriver());


		String userName = ExcelUtils.readCellDataFromExcelFile("UserCreds", 1, 1);
		String password = ExcelUtils.readCellDataFromExcelFile("UserCreds", 1, 2);

		lp.setUserName(userName,getDriver());
		logger.info("Entered Username :"+userName);
		lp.setPassword(password,getDriver());
		logger.info("Entered  password :"+password);

		lp.clickLoginBtn(getDriver());
		logger.info("Clicked on login button");

		String expectedPageTitle = TitleConstants.HOME_PAGE_TITLE;

		boolean flag = CommonUtils.waitForTitleOfThePage(getDriver(), expectedPageTitle);
		Assert.assertTrue(flag);
		
		logger.info("After successfull login Home page title should be :"+expectedPageTitle);

	}

	/*
	 * Enter User Name clear password click on login btn Validate homepage title
	 */
//	@Test
	void loginToSalesForceAppForMultipleUsers(Method mName) throws InvalidFormatException, IOException {
		lp = new LoginPage(getDriver());
		hp = new UserMenuPage(getDriver());
		logger.info("Test case satrted here :    "+mName.getName());
		logger.info("Validating Login for multiple users");
		SoftAssert softAssert = new SoftAssert();
		
		String userName=null;
		String password=null;

		String[][] userCreds = ExcelUtils.readExcelFile("UserCreds");

		for (String[] row : userCreds) {

			for (int i = 0; i < row.length; i++) {
				 userName=row[i];
				 password=row[++i];
				
				lp.setUserName(userName,getDriver());
				logger.info("Entered Username :"+userName);
				lp.setPassword(password,getDriver());
				logger.info("Entered  password :"+password);
			}
			lp.clickLoginBtn(getDriver());
			logger.info("Clicked on login button");

			String expectedPageTitle = TitleConstants.HOME_PAGE_TITLE;
			boolean flag=CommonUtils.waitForTitleOfThePage(getDriver(), expectedPageTitle);
			
			if (flag) {
				softAssert.assertTrue(flag);
				logger.info("Successfull login to the appln SFDC for User Name and password :"+userName+"   "+password);
				hp.clickUserMenu();
				hp.clickLogOut();
			}
			else {
				softAssert.assertTrue(flag,"Failed to login for User Name and password :"+userName+"  "+password);
				
				logger.info("Failed to login for User Name and password :"+userName+"   "+password);
				logger.info("Error MSg :"+lp.getErrorMsg(getDriver()));
			}
		}
		softAssert.assertAll();
	}
	
	
	
	/**
	 * @param sMethodName
	 * @param userName
	 * @param password
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
//	@Test(dataProvider = "LoginDataProvider" , dataProviderClass = com.tekarch.utils.DataProviderClass.class)
	void loginToSalesForceAppUsingDataProviders(Method sMethodName, String userName,String password) throws InvalidFormatException, IOException {
		
        logger.info("INIDE THe CLASS ::    "+this.getClass().getName());
		
		logger.info("Inside the method ::    "+sMethodName.getName());
	
		logger.info("launching the application");

		String expectedPagetitle = TitleConstants.LOGIN_PAGE_TITLE;
		boolean isLoginPageTitleIsPresent = CommonUtils.waitForTitleOfThePage(getDriver(), expectedPagetitle);
		Assert.assertTrue(isLoginPageTitleIsPresent);
		
		logger.info("Login Page title  ::  "+expectedPagetitle);
		
		
		lp = new LoginPage(getDriver());
		hp = new UserMenuPage(getDriver());
		logger.info("Test case satrted here :    "+sMethodName .getName());
		logger.info("Validating Login for multiple users");
		
		lp.setUserName(userName,getDriver());
		logger.info("Entered Username :"+userName);
		lp.setPassword(password,getDriver());
		logger.info("Entered  password :"+password);
				
		
		lp.clickLoginBtn(getDriver());
		logger.info("Clicked on login button");

		String expectedPageTitle = TitleConstants.HOME_PAGE_TITLE;
		boolean isHomePageTitleIsPresent=CommonUtils.waitForTitleOfThePage(getDriver(), expectedPageTitle);

		if (isHomePageTitleIsPresent) {
				
		Assert.assertTrue(isHomePageTitleIsPresent);
		logger.info("Successfull login to the appln SFDC for User Name and password : : "+userName+"   "+password);
		hp.clickUserMenu();
		hp.clickLogOut();
}
		else {
			logger.info("Failed to login for User Name and password : : "+userName+"   "+password);
			logger.info("Error MSg :"+lp.getErrorMsg(getDriver()));
		    Assert.assertTrue(isHomePageTitleIsPresent,"Failed to login for User Name and password : : "+userName+"  "+password);
			}
	}

}
