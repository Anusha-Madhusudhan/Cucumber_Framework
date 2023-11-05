/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarch.utils.ExcelUtils;

import com.tekarck.pages.LoginPage;
import com.tekarck.pages.UserMenuPage;

/**
 * 
 */
public class TC05_ValidateUserMenuDropDown extends BaseTest {
	
	LoginPage lp;
	
	UserMenuPage hp;
	
	  
	 
	/**
	 * Launch and Login 
	  Check for user menu for <username> drop down
	  Drop down with "My profile", "My Settings", "Developer Console","Logout" ,
	  "Switching to lightning Experience" is displayed
	 * 
	 * 
	 * 
	 * @param sMethodName
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	void validateUserMenuDropDown(Method sMethodName) throws InvalidFormatException, IOException {
		logger.info("Inside the Class ::"+this.getClass().getName());
		logger.info("Inside the method ::"+sMethodName.getName());
		lp=new LoginPage(getDriver());
		hp=new UserMenuPage(getDriver());
		
		String userName=ExcelUtils.readCellDataFromExcelFile("UserCreds",1,1);
		String password=ExcelUtils.readCellDataFromExcelFile("UserCreds",1,2);
		
		lp.setUserName(userName,getDriver());
		logger.info("Entered UserName :: "+userName);
		
		lp.setPassword(password,getDriver());
		
		logger.info("Entered password :: "+password);
		
		lp.clickLoginBtn(getDriver());
		
		logger.info("Clicked on Login Button ");
		
		hp.clickUserMenu();
		
		logger.info("Clicked on UserMenu  ");
		
	    List<String> actualMenuItems=hp.getUserMenuItems();
	    
	    logger.info("Validation for User Menu Items Started.... ");
	    
	    List<String> expectedMenuItems = new ArrayList<String>();

	    expectedMenuItems.add("My Profile");
	    expectedMenuItems.add("My Settings");
	    expectedMenuItems.add("Developer Console");
	    expectedMenuItems.add("Switch to Lightning Experience");
	    expectedMenuItems.add("Logout");
	    
	    int i = 0;
		boolean flag = false;
		for (String str : actualMenuItems) {

			if (str.equals(expectedMenuItems.get(i))) {
				i++;
				flag = true;
			} else {
				flag = false;
				break;
			}

		}
	   Assert.assertTrue(flag);
	   logger.info("All User menu items are present.... ");
	   logger.info("My Profile ,My Settings ,Developer Console , Switch to Lightning Experience, Logout");

		
	}

}
