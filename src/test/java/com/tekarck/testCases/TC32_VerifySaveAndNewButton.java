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
public class TC32_VerifySaveAndNewButton extends BaseTest {
	
	 ContactsPage cp;
		
		@Test
		void VerifySaveAndNewButton() {
			
			loginToSalesForceApp();
			
			cp=new ContactsPage(getDriver());
			cp.clickOnContactsTab();
			Assert.assertTrue(cp.verifyContactsHomePageIsDispalyed(getDriver()));
			cp.clickNewBtn();
			String lastName=BaseTest.generateRandomString();
			cp.enterLastName(lastName);
			cp.clickAccountSearchImg(getDriver());
			cp.clickSaveAndNewBtn();
			Assert.assertTrue(cp.verifyContactEditPageIsDispalyed(getDriver()));
			
			
		}

}
