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
public class TC30_VerifyTheContactErrorMsg extends BaseTest {
	
	
   ContactsPage cp;
	
	@Test
	void VerifyTheContactErrorMsg() {
		
		loginToSalesForceApp();
		
		cp=new ContactsPage(getDriver());
		cp.clickOnContactsTab();
		
		cp.clickCreateNewView();
		
		Assert.assertTrue(cp.verifyCreateNewViewPageDispaled(getDriver()));
		String sViewUniqueName=BaseTest.generateRandomString();
		cp.enterViewUniqueName(sViewUniqueName);
		
		cp.clickSaveBtn(getDriver());
		
		Assert.assertTrue(cp.verifyErrorMsgDisplayed(getDriver()));
		
		
	}

}
