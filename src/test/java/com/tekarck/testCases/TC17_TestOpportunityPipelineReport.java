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
public class TC17_TestOpportunityPipelineReport extends BaseTest {

	
     OpportunitiesPage op;
	
	@Test
	void verifyOpportunityPipelineReporty() throws InterruptedException {
		
		loginToSalesForceApp();
		
		op=new OpportunitiesPage(getDriver());
		op.clickOnOppTab();
	    Assert.assertTrue(op.verifyOppPageIsDisplayed(getDriver()));	
	    
	    op.clickOnPipeline();
	    Assert.assertTrue(op.verifyPipelinePageDisplayed(getDriver()));
	    Assert.assertTrue(op.verifyPipelineReportStatusComplete(getDriver()));
	    
	    
	}
}
