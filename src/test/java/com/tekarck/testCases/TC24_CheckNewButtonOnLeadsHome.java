/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarck.pages.LeadsPage;

/**
 * 
 */
public class TC24_CheckNewButtonOnLeadsHome extends BaseTest {

	LeadsPage lp;

	@Test
	void verifyLeadsTab() {
		
		loginToSalesForceApp();
		lp=new LeadsPage(getDriver());
		lp.clickLeadsTab();
	    Assert.assertTrue(lp.verifyLeadsPageDisplayed(getDriver()));
	    
	    lp.clickNewBtn();
	    Assert.assertTrue(lp.verifyLeadsEditPageIsDisplayed(getDriver()));
	    
	    String lastName=BaseTest.generateRandomString();
	    String companyName=BaseTest.generateRandomString();
	    
	    
	    lp.enterLastName(lastName);
	    
	    lp.enterCompanyName(companyName);
	    
	    lp.clickSaveBtn();
	    
	    Assert.assertTrue(lp.verifyNewlyCreatedLeadViewPageDisplayed(getDriver(),lastName));
		
	}
}
