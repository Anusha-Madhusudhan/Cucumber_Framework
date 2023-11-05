/**
 * 
 */
package com.tekarck.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarck.pages.OpportunitiesPage;

/**
 * 
 */
public class TC15_opportunitiesDropDown extends BaseTest {
	
	OpportunitiesPage op;
	
	@Test
	void verifyopportunitiesDropDown() {
		
		loginToSalesForceApp();
		op=new OpportunitiesPage(getDriver());
		
		op.clickOnOppTab();
		
	    Assert.assertTrue(op.verifyOppPageIsDisplayed(getDriver()));

		
	    Assert.assertTrue(op.verifyOppDropDownList());	
		
	}
	
	

}
