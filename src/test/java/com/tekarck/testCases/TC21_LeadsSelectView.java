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
public class TC21_LeadsSelectView extends BaseTest {
	
	LeadsPage lp;

	@Test
	void verifyLeadsSelectView() {
		
		loginToSalesForceApp();
		lp=new LeadsPage(getDriver());
		lp.clickLeadsTab();
	    Assert.assertTrue(lp.verifyLeadsPageDisplayed(getDriver()));
	    
	    lp.verifyLeadsDropDownList(getDriver());
		
	}

}
