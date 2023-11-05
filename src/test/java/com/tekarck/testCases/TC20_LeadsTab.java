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
public class TC20_LeadsTab extends BaseTest{
	LeadsPage lp;

	@Test
	void verifyLeadsTab() {
		
		loginToSalesForceApp();
		lp=new LeadsPage(getDriver());
		lp.clickLeadsTab();
	    Assert.assertTrue(lp.verifyLeadsPageDisplayed(getDriver()));
		
	}
	
}
