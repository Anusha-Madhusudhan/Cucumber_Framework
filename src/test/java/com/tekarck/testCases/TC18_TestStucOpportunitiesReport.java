/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarck.pages.OpportunitiesPage;

/**
 * 
 */
public class TC18_TestStucOpportunitiesReport extends BaseTest {

  OpportunitiesPage op;
	
	@Test
	void verifyStucOpportunitiesReport() throws InterruptedException {
		
		loginToSalesForceApp();
		
		op=new OpportunitiesPage(getDriver());
		op.clickOnOppTab();
	    Assert.assertTrue(op.verifyOppPageIsDisplayed(getDriver()));	
	    
	    op.clickOnStuckOppty();
	    Assert.assertTrue(op.verifyStuckOpptyPageDisplayed(getDriver()));
	    
	}
}
