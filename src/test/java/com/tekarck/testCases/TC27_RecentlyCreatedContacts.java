/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarck.pages.ContactsPage;

/**
 * 
 */
public class TC27_RecentlyCreatedContacts extends BaseTest {
	
    ContactsPage cp;
	
	@Test
	void verifyCreateNewViewInTheContactPage(){
		
		loginToSalesForceApp();
		
		cp=new ContactsPage(getDriver());
		cp.clickOnContactsTab();
		
		cp.selectRecentlyCreatedContacts("Recently Created");
		
	    Assert.assertTrue(cp.verifyRecenlyCeatedContactsAreDisplayed());
		
		
		
	}

}
