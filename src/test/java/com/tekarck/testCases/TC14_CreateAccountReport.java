/**
 * 
 */
package com.tekarck.testCases;

import java.lang.reflect.Method;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarck.pages.AccountsPage;

/**
 * 
 */
public class TC14_CreateAccountReport extends BaseTest {
	AccountsPage ap;
	
	
	@Test
	void verifyCreateAccountReport(Method sMathodName)  {
		
		/*
		 * Preconditions for the test starts here
		 */
		loginToSalesForceApp();
		ap=new AccountsPage(getDriver());
		ap.clickAccountTab();
		Assert.assertTrue(ap.verifyAccountPageDisplayed(getDriver()));
		ap.clickNewBtn(getDriver());
		Assert.assertTrue(ap.verifyAccountEditPageDisplayed(getDriver()));
		String accountName=BaseTest.generateRandomString();
		ap.enterAccountName(accountName);
		ap.clickSaveBtn(getDriver());
		Assert.assertTrue(ap.verifyAccountIsCreatd(getDriver(),accountName));
		/*
		 * Preconditions for the test ends here
		 */
		
		
		ap.clickAccountTab();
		Assert.assertTrue(ap.verifyAccountPageDisplayed(getDriver()));
		
		ap.clickAccountsWithLastActivityGreaterThan30Days();
		
		 String expectedReportPageTitle=TitleConstants.CREATE_REPORT_PAGE_TITLE;
		   
		  boolean isReportTitlePagePresent=CommonUtils.waitForTitleOfThePage(getDriver(), expectedReportPageTitle);
		  
		  Assert.assertTrue(isReportTitlePagePresent);
		  
		  ap.clickDateField();
		  
		  ap.clickCreateDate();
		  
		  Assert.assertTrue(ap.WaitforLoadToDisappear(getDriver()));
		  ap.clickFromDateImg();
		  ap.clickFromTodayBtn();
		  Assert.assertTrue(ap.WaitforLoadToDisappear(getDriver()));
		  ap.clickToDateImg();
		  ap.clickToTodayBtn();
		  Assert.assertTrue(ap.WaitforLoadToDisappear(getDriver()));
		  ap.clickSaveReportBtn();
		  
		  String reportName=BaseTest.generateRandomString();
		  String reportUniquename=BaseTest.generateRandomString();
		  
		  ap.enterReportName(reportName);
		 
		  ap.enterReportUniqueName(reportUniquename);

		  ap.clickSaveAndRunBtn(getDriver());
		  
		  Assert.assertTrue(ap.verifyReportPageIsDispalyedWithReportName(getDriver(), reportName));
		  
		  
		  /*
		   * 
		   * Post conditions delete Report
		   */
		  
		  ap.deleteReport(getDriver());
	}

}
