/**
 * 
 */
package com.tekarck.testCases;



import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.tekarck.pages.AccountsPage;

/**
 * 
 */
public class TC13_MergeAccounts extends BaseTest {
	
	AccountsPage ap;

	@Test
	void verifyMergeAccounts() throws InterruptedException {
		
		loginToSalesForceApp();
		ap=new AccountsPage(getDriver());
		ap.clickAccountTab();
	    Assert.assertTrue(ap.verifyAccountPageDisplayed(getDriver()));
//	    Assert.assertTrue(ap.verifyUserNameDisplayedOnAccountPage(getDriver(),FileUtils.readPropertiesFile(FileConstants.USER_MENU_TEST_DATA, "username")));
		
	    /*
	     * Pre Requisites to merge accounts. Create 3 accounts with common string in it.
	     */
	    
	    List<String> accounts=new ArrayList<String>();
	    accounts.add("abc");
	    accounts.add("abcde");
	    accounts.add("abcdefg");
	    
	    ap.clickNewBtn(getDriver());
	    
	    
	    for(String s:accounts) {
		Assert.assertTrue(ap.verifyAccountEditPageDisplayed(getDriver()));
		ap.enterAccountName(s);
		ap.clickSaveAndNewBtn(getDriver());
	    }    
	    
	   
	    
	    ap.clickAccountTab();
	    Assert.assertTrue(ap.verifyAccountPageDisplayed(getDriver()));
	    
	    Assert.assertTrue(ap.verifyAccountsAreCreatd(getDriver(),accounts));
	    /*
	     * Pre requisites end here
	     */
	    
	    ap.clickMergeAccountsLink();
		Assert.assertTrue(ap.verifyMergeAccountPageDisplayed(getDriver()));
		ap.enterTextToFindAccountToMerge("abc");
		ap.clickFindAccountBtn();
		List<String> accountsToBeMerged=ap.mergeAccounts();
		System.out.println(accountsToBeMerged);
		Assert.assertTrue(ap.verifyMergeMyAccountsDisplayed(getDriver(),accountsToBeMerged));
		String mergedAccountName=ap.getMergedAccountName();
		ap.clickMergeBtn(getDriver());
		Assert.assertTrue(ap.verifyAccountPageDisplayed(getDriver()));
		
		
		/*
		 * Post Conditions to delete acoounts
		 */
		
		   System.out.println(mergedAccountName);
		   ap.slectAccountFromList(mergedAccountName);
		   
			Assert.assertTrue(ap.deleteAccount(mergedAccountName,getDriver()));
		  
		
		
		
	}
}
