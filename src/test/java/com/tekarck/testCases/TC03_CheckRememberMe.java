/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarch.utils.ExcelUtils;
import com.tekarck.pages.LoginPage;

/**
 * 
 */
public class TC03_CheckRememberMe extends BaseTest {
	
	LoginPage lp;
	
	
	/**
	 * Login to SFDC with remember username check box checked
	 * Log out of SFDC
	 * Check for Username field
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	void loginAndCheckRememberMe(Method sMethodName) throws InvalidFormatException, IOException {
		logger.info("Inside the Class   :: "+this.getClass().getName());
		logger.info("Inside the method   :: "+sMethodName.getName());
		lp=new LoginPage(getDriver());
		
		String userName=ExcelUtils.readCellDataFromExcelFile("UserCreds", 1, 1);
		String password=ExcelUtils.readCellDataFromExcelFile("UserCreds", 1, 2);
		
		lp.setUserName(userName,getDriver());
		
		logger.info("Entered User name   :: "+userName);
		
		lp.setPassword(password,getDriver());
		
		logger.info("Entered User name   :: "+password);
		
		lp.clickRememberMe();
		
		logger.info("Clicked On Remember Me");
		
		lp.clickLoginBtn(getDriver());
		
		logger.info("Clicked LOgin Btn");
		
		String expectedPageTitle=TitleConstants.HOME_PAGE_TITLE;
		
		
		boolean flag=CommonUtils.waitForTitleOfThePage(getDriver(), expectedPageTitle);
		Assert.assertTrue(flag);
		
		lp.clickLogoutBtn();
		logger.info("Clicked Logout Btn");
      
       String expecteSavedUserName=userName;
       String actualSavedUserName=lp.getSavedUserName(getDriver(),expecteSavedUserName);
		
		Assert.assertEquals(actualSavedUserName,expecteSavedUserName);
		
		logger.info("Entered User name present in the Uaser Name Text Box :: "+userName);
		
	}
	
	
	
	
	
	
	
	
	
	

}
