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
public class TC26_CreateNewViewInTheContactPage extends BaseTest {
	
    ContactsPage cp;
	
	@Test
	void verifyCreateNewViewInTheContactPage(){
		
		loginToSalesForceApp();
		
		cp=new ContactsPage(getDriver());
		cp.clickOnContactsTab();
		
		cp.clickCreateNewView();
		Assert.assertTrue(cp.verifyCreateNewViewPageDispaled(getDriver()));
		String viewName=BaseTest.generateRandomString();
		String viewUniqueName=BaseTest.generateRandomString();
		
		cp.enterViewName(viewName);
		cp.enterViewUniqueName(viewUniqueName);
		
		cp.clickSaveBtn(getDriver());
	    Assert.assertTrue(cp.verifyCreatedNewViewNameDisplayedOnCantactsPage(viewName));
		
		
	}
	

}
