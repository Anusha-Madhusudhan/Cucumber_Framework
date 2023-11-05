/**
 * 
 */
package com.tekarck.testCases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarck.pages.OpportunitiesPage;

import freemarker.template.SimpleDate;

/**
 * 
 */
public class TC16_CreateANewOpty extends BaseTest {
	
	OpportunitiesPage op;
	
	@Test
	void verifyCrearingNewOpportunity() throws InterruptedException {
		
		loginToSalesForceApp();
		
		op=new OpportunitiesPage(getDriver());
		op.clickOnOppTab();
	    Assert.assertTrue(op.verifyOppPageIsDisplayed(getDriver()));	
		op.clickNewBtn();
		String oppName=BaseTest.generateRandomString();
		op.enterOppName(oppName);
		op.clickOnToFindAccName(getDriver());
		String closeDate=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		op.enterCloseDate(closeDate);
		op.selectStage();
		op.enterProbability("3");
		op.selectLeadSource();
		op.enterPrimaryCampaignSource(getDriver());
		op.clickSaveBtn();
		Assert.assertTrue(op.verifyOppCreated(getDriver(), oppName));
		
		
		
		/*
		 * Post conditions to delete oppty
		 */
		
		
		op.deleteOpp(getDriver());
		 Assert.assertTrue(op.verifyOppPageIsDisplayed(getDriver()));
	}

}
