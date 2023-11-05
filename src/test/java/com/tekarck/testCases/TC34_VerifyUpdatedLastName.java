/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.teckarck.constants.FileConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarch.utils.FileUtils;
import com.tekarck.pages.MyProfilePage;
import com.tekarck.pages.UserMenuPage;

/**
 * 
 */
public class TC34_VerifyUpdatedLastName extends BaseTest {
	
	
	MyProfilePage myProfilePage;
	UserMenuPage ump;
	
	
	
	@Test
	void VerifyUpdatedLastName() throws IOException {
		
		ump=new UserMenuPage(getDriver());
		
		
		loginToSalesForceApp();
		
		ump.clickUserMenu();
		
		ump.clickMyProfile();
		
		myProfilePage=new MyProfilePage(getDriver());
		
		CommonUtils.waitForElementClickable(getDriver(), myProfilePage.getProfilePage());
		
		Assert.assertTrue(myProfilePage.isMyProfilePageIsVisible());
		
		Assert.assertTrue(myProfilePage.clickEditMyProfile(getDriver()));
		
		myProfilePage.switchFrame(getDriver());
		
		myProfilePage.clickAboutTab();
		
		String lastName=FileUtils.readPropertiesFile(FileConstants.USER_MENU_TEST_DATA, "lastName2");
		
		myProfilePage.setLastName(lastName);
		
		myProfilePage.clickSaveAll(getDriver());
		
		Assert.assertTrue(myProfilePage.verifyEditedLastName(lastName));
		
		Assert.assertTrue(ump.verifyUserNameOnUserMenuBtn(lastName));
		
	}

}
