/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarck.pages.ContactsPage;

/**
 * 
 */
public class TC28_MyContacts extends BaseTest {
	
    ContactsPage cp;
	
	@Test
	void verifyCreateNewViewInTheContactPage(){
		
		loginToSalesForceApp();
		
		cp=new ContactsPage(getDriver());
		cp.clickOnContactsTab();
		
		cp.selectMyContacts("My Contacts");
		
		if(CommonUtils.waitForTitleOfThePage(getDriver(), TitleConstants.CONTACTS_PAGE_TITLE)) {
		cp.clickGoBtn();
		}
	    Assert.assertTrue(cp.verifyAllContactsDispalyed());
		
		
	}

}
