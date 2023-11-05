/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.teckarck.constants.FileConstants;
import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarch.utils.FileUtils;
import com.tekarck.pages.MySettingPage;
import com.tekarck.pages.UserMenuPage;

/**
 * 
 */
public class TC07_MySettings extends BaseTest {

	UserMenuPage hp;
	MySettingPage mySettingPage;

	@Test
	void mySetting() throws InterruptedException, IOException {
		hp = new UserMenuPage(getDriver());
		
		mySettingPage = new MySettingPage(getDriver());

		loginToSalesForceApp();

		hp.clickUserMenu();
		hp.clickMySettings();
		String expectedText="My Settings";
		Assert.assertTrue(mySettingPage.verifyMySettingPageDisplayed(expectedText,getDriver()));

		
		mySettingPage.clickPersonalLink();
		mySettingPage.clickLoginHistory();
		Assert.assertTrue(mySettingPage.clickDownloadLogin(getDriver()));
		
		getDriver().navigate().back();
		
		Assert.assertTrue(mySettingPage.verifyMySettingPageDisplayed(expectedText,getDriver()));
		
		Assert.assertTrue(mySettingPage.verifyFileDownloaded());

		mySettingPage.clickDispalyAndLayoutLink();
		mySettingPage.clickCustomizeTabs();
		mySettingPage.selectSalesForceChatter("Salesforce Chatter");
		if (!mySettingPage.selectReportTab("Reports")) {

			mySettingPage.clickAddBtn();
		}

		mySettingPage.clickSaveBtn();
//		Assert.assertTrue(mySettingPage.verifyReportsAddedToTabMenu("Reports"));
		
		
      

		// Email

		mySettingPage.clickEmail();
		mySettingPage.clickEmailSettings();
		String emailName=FileUtils.readPropertiesFile(FileConstants.USER_MENU_TEST_DATA, "emailName");
		String emailAddress=FileUtils.readPropertiesFile(FileConstants.USER_MENU_TEST_DATA, "emailAddress");
		
		mySettingPage.setEmailName(emailName);
		mySettingPage.setEmailAddress(emailAddress);
		mySettingPage.selectAutomaticBCC();
		mySettingPage.clickSaveBtn();

		Assert.assertTrue(mySettingPage.verifyEmailUpdation(getDriver()));

		String expectedTitle = TitleConstants.MY_EMAIL_SETTINGS_TITLE;

		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(getDriver(), expectedTitle));
		
		
        

		// Calender reminder

		mySettingPage.clickCalenderAndRamainder();
		mySettingPage.clickActivityRemainder();
		mySettingPage.clickOpenTestRemainder(getDriver());
		Assert.assertTrue(mySettingPage.verifyThePopUpWindow(getDriver()));

	}

	
}
