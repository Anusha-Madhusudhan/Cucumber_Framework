/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarck.pages.BasePage;
import com.tekarck.pages.HomePage;

/**
 * 
 */
public class TC33_VerifyFirstNameAndLastNameOnHomePage extends BaseTest {
	
	HomePage hp;
	
	
	@Test
	void VerifyFirstNameAndLastNameOnHomePage() {
		
		loginToSalesForceApp();
		hp=new HomePage(getDriver());
		
		hp.clickHomTab();
		
		String userNameOnHomePage=hp.getUserNameOnHomePage();
		
		hp.clickOnUserName();
		
	    Assert.assertTrue(hp.verifyUserNameOnHomePageSameAsOnMyProfilePage(userNameOnHomePage));
		
		
	}

}
