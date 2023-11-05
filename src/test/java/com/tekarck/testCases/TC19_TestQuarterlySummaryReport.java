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
public class TC19_TestQuarterlySummaryReport extends BaseTest {
	
 OpportunitiesPage op;
	
	@Test
	void verifyStucOpportunitiesReport() throws InterruptedException {
		
		loginToSalesForceApp();
		
		op=new OpportunitiesPage(getDriver());
		op.clickOnOppTab();
	    Assert.assertTrue(op.verifyOppPageIsDisplayed(getDriver()));	
	    
	    op.selectInterval(getDriver());
	    op.selectInclude(getDriver());
	    
	    op.clickRunReport();
	    
	    Assert.assertTrue(op.verifyOpptyReportPageTitle(getDriver()));
	    
	    Assert.assertTrue(op.verifyReportPageWithSearchCriteria(getDriver()));
	    
	}

}
