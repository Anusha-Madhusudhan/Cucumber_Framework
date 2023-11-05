/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarch.utils.ExcelUtils;
import com.tekarck.pages.LoginPage;

/**
 * 
 */
public class TC04B_InvalidUserNameAndPassword extends BaseTest {
	
	LoginPage lp;
	
	
	
	/**
	 * Launch the application
	   Enter Wrong USerName
	   Enter wrong PWd
	   Click Login
	   Validate error message
	 * 
	 * @param sMethodName
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	void loginToAppWithInvalidCreds(Method sMethodName) throws InvalidFormatException, IOException {
		logger.info("Inside the Class ::"+this.getClass().getName());
		logger.info("Inside the method ::"+sMethodName.getName());
		lp=new LoginPage(getDriver());
		
		String userName=ExcelUtils.readCellDataFromExcelFile("UserCreds",4, 1);
		String password=ExcelUtils.readCellDataFromExcelFile("UserCreds",4, 2);
		
		lp.setUserName(userName,getDriver());
		logger.info("Inside the method :: "+ userName);
		
		lp.setPassword(password,getDriver());
		
		logger.info("Inside the method :: "+ password);
		
		lp.clickLoginBtn(getDriver());
		
		logger.info("Clicked loin Btn....");
		
		String expectedErr="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		boolean isExpectedErrorMsgPresent=lp.isErrorMsgDisaplyed(getDriver(),expectedErr);
		
//		Assert.assertEquals(actualError, expectedErr);
		
		Assert.assertTrue(isExpectedErrorMsgPresent);
		
		logger.info("Got The error message.... :: "+expectedErr);
	}
	

}
