/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarck.pages.HomePage;
import com.tekarck.pages.UserMenuPage;

/**
 * 
 */
public class TC35_VerifyTabCustomizationTab extends BaseTest {
	
	HomePage hp;
	UserMenuPage ump;
	
	
	@Test
	void VerifyTabCustomizationTab() {
		
		loginToSalesForceApp();
		
		hp=new HomePage(getDriver());
		ump=new UserMenuPage(getDriver());
		
		hp.clickOnPlusSign(getDriver());
		Assert.assertTrue(hp.verifyAllTabPageDisplayed(getDriver()));
		hp.clickCustomizeTabBtn();
		String tabToBeRemoved="Chatter";
		Assert.assertTrue(hp.verifyCustomizeTabPageDisplayed(getDriver()));
		
		/*
		 * Pre condition check weather Tab to be removed present in the selected tab list
		 */
		
		boolean isTabPresentInSelectedTabList=hp.verifyTabToBeRemovedPresentInSelectedList(tabToBeRemoved);
		
		if(isTabPresentInSelectedTabList==false) {
			hp.selectTabFromAvailableTabList(tabToBeRemoved);
			hp.clickAddBtn();
			hp.clickSaveBtn();
			Assert.assertTrue(hp.verifyAllTabPageDisplayed(getDriver()));
			Assert.assertFalse(hp.vrifyRemovedTabPresentOnTheTabBar(tabToBeRemoved));
			Assert.assertTrue(hp.verifyAllTabPageDisplayed(getDriver()));
			hp.clickCustomizeTabBtn();
			Assert.assertTrue(hp.verifyCustomizeTabPageDisplayed(getDriver()));
		
		}
		hp.selectTabFromSelectedTabList(tabToBeRemoved);
		hp.clickOnRemoveBtn();
		Assert.assertTrue(hp.verifyRemovedTabAvailableInAvailableTab(tabToBeRemoved));
		hp.clickSaveBtn();
		Assert.assertTrue(hp.verifyAllTabPageDisplayed(getDriver()));
		Assert.assertTrue(hp.vrifyRemovedTabPresentOnTheTabBar(tabToBeRemoved));
		ump.clickUserMenu();
		ump.clickLogOut();
		
		
		loginToSalesForceApp();
		
		Assert.assertTrue(hp.vrifyRemovedTabPresentOnTheTabBar(tabToBeRemoved));
		
		/*
		 * POST CONDITIONS code starts here
		 * 
		 * adding Tab - code should be here
		 */
		hp.clickOnPlusSign(getDriver());
		Assert.assertTrue(hp.verifyAllTabPageDisplayed(getDriver()));
		hp.clickCustomizeTabBtn();
		String tabTobeAdded=tabToBeRemoved;
		hp.selectTabFromAvailableTabList(tabTobeAdded);
		hp.clickAddBtn();
		hp.clickSaveBtn();
		Assert.assertTrue(hp.verifyAllTabPageDisplayed(getDriver()));
		Assert.assertFalse(hp.vrifyRemovedTabPresentOnTheTabBar(tabTobeAdded));
		
		/*
		 * POST CONDITIONS code ends here
		 */
		
	}

}
