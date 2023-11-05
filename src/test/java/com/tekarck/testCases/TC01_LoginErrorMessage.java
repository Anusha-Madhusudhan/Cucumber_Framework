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
//@Listeners(SFDC_Listener.class)
public class TC01_LoginErrorMessage extends BaseTest {
	
	LoginPage lp;
	
	
	/**
	 * @param Method name
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */
	@Test
	void validateLoginToTheApplnWithBlankPassword(Method name) throws IOException, InvalidFormatException {
		
		logger.info("Inside the Class ::"+this.getClass().getName());
		logger.info("Inside the method ::"+name.getName());
		String expectedPagetitle=TitleConstants.LOGIN_PAGE_TITLE;
		boolean isLoginPageTitleIsPresent=CommonUtils.waitForTitleOfThePage(getDriver(), expectedPagetitle);
		Assert.assertTrue(isLoginPageTitleIsPresent);
		logger.info("application launched with title :"+ expectedPagetitle);
		
		lp=new LoginPage(getDriver());
		String userNme=ExcelUtils.readCellDataFromExcelFile("UserCreds", 2, 1);
//		String password=ExcelUtils.readExcelFile("UserCreds", 2, 2);
		lp.setUserName(userNme,getDriver());
		logger.info("Entered Username :"+userNme);
		lp.setPassword("",getDriver());
		logger.info("Entered blank password :"+" ");
		lp.clickLoginBtn(getDriver());
		logger.info("Clicked on login button");
		
		String expectedErrorMsg="Please enter your password.";
		
		boolean isErrorMsgPresent=lp.isErrorMsgDisaplyed(getDriver(),expectedErrorMsg);
//		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		Assert.assertTrue(isErrorMsgPresent);
		
		logger.info("Got the error message  :"+expectedErrorMsg);
		logger.info("Login sholud not happen with blank password");
		

		
	}
	
	
	
	
	
	
	

}
