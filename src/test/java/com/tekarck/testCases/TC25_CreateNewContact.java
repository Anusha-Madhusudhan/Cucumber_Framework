/**
 * 
 */
package com.tekarck.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarch.utils.CommonUtils;
import com.tekarck.pages.ContactsPage;

/**
 * 
 */
public class TC25_CreateNewContact extends BaseTest {
	
	ContactsPage cp;
	
	@Test
	void verifyCreateNewContact() throws InterruptedException{
		
		loginToSalesForceApp();
		
		cp=new ContactsPage(getDriver());
		cp.clickOnContactsTab();
		cp.clickNewBtn();
	    Assert.assertTrue(cp.verifyContactEditPageIsDispalyed(getDriver()));
	    String lastName=BaseTest.generateRandomString();
	    cp.enterLastName(lastName);
		String accountName=cp.clickAccountSearchImg(getDriver());
		
		
		
//		CommonUtils.waitForAttributeValue(getDriver(),cp.getAccountNameValue(), "value",accountName);
//		Assert.assertTrue(cp.verifyContactEditPageIsDispalyed(getDriver()));
		Thread.sleep(3000);
		
		cp.clickSaveBtn(getDriver());
		Assert.assertTrue(cp.verifyNewCantactCreated(getDriver(),lastName));
		
		Assert.assertTrue(cp.deleteContact(getDriver()));
		
	}
	

}
