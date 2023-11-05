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
public class TC04A_TestForgotPassword extends BaseTest {
	LoginPage lp;
	
	//Open <https://login.salesforce.com/> page in browser
	//Click on Forgot password
	//Provide <username> in salesforce forgot password page and click on contiue button
	
	@Test
	void forgotPwdLinkValidation(Method sMethodName) throws InvalidFormatException, IOException {
		
		logger.info("Inside the Class ::"+this.getClass().getName());
		logger.info("Inside the method ::"+sMethodName.getName());
		
		
		lp=new LoginPage(getDriver());
		
		lp.clickForgotPassword();
		logger.info("Clicked on forgot password");
		String userName=ExcelUtils.readCellDataFromExcelFile("UserCreds",1, 1);
		lp.setForgotPwdUserName(userName);
		logger.info("Entered User Name : : "+userName);
		lp.clickContinueBtn();
		logger.info("Clicked on Continue Btn");
		String expectedTitle=TitleConstants.CHECK_YOUR_PAGE_TITLE;
		
		boolean flag=CommonUtils.waitForTitleOfThePage(getDriver(), expectedTitle);
		logger.info("Checking for Forgot password page title : : "+expectedTitle);
		Assert.assertTrue(flag);
		logger.info("Navigated to forgot password page with title  : : "+expectedTitle);
	}

}
