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
public class TC31_VerifyTheCancelButton extends BaseTest {

	
	 ContactsPage cp;
		
		@Test
		void VerifyTheCancelButton() {
			
			loginToSalesForceApp();
			
			cp=new ContactsPage(getDriver());
			cp.clickOnContactsTab();
			
			cp.clickCreateNewView();
			
			String viewName=BaseTest.generateRandomString();
			String viewUniqueName=BaseTest.generateRandomString();
			
			cp.enterViewName(viewName);
			cp.enterViewUniqueName(viewUniqueName);
			
			cp.clickCancelBtn();
			
			Assert.assertTrue(cp.verifyContactsHomePageIsDispalyed(getDriver()));
			
			Assert.assertTrue(cp.verifyNewViewNotCreated(viewName));
			
			
		}
}
