/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.teckarck.constants.FileConstants;
import com.tekarch.utils.FileUtils;
import com.tekarck.pages.AccountsPage;

/**
 * 
 */
public class TC10_CreateAnAccount extends BaseTest {
	
	AccountsPage ap;
	String accountName;
	
	// (onlyForGroups = {"createNewaccount"})
	
	@BeforeMethod
	void preConditions() {
		loginToSalesForceApp();
		ap=new AccountsPage(getDriver());;
		
	}
	
	
	
	@Test(groups = {"createNewaccount"} )
	void createNewaccount() throws IOException {
		
//		loginToSalesForceApp();
//		ap=new AccountsPage(getDriver());
		ap.clickAccountTab();
		Assert.assertTrue(ap.verifyAccountPageDisplayed(getDriver()));
		ap.clickNewBtn(getDriver());
		Assert.assertTrue(ap.verifyAccountEditPageDisplayed(getDriver()));
		accountName=BaseTest.generateRandomString();
		ap.enterAccountName(accountName);
		ap.selectType(FileUtils.readPropertiesFile(FileConstants.ACCOUNTS_TEST_DATA_FILE_PATH, "type"));
		ap.selectCustomerPriority(FileUtils.readPropertiesFile(FileConstants.ACCOUNTS_TEST_DATA_FILE_PATH, "priority"));
		ap.clickSaveBtn(getDriver());
		Assert.assertTrue(ap.verifyAccountIsCreatd(getDriver(),accountName));
		
		/*
		 * POst conditions delete account
		 */
		
		
//		ap.slectAccountFromList(accountName);
//		Assert.assertTrue(ap.deleteAccount(accountName,getDriver()));
		
	}
	//(onlyForGroups = {"createNewaccount"})
	
	@AfterMethod
	void postConditios() {
		System.out.println("Inside the post conditions of create new account test");
		ap.slectAccountFromList(accountName);
		Assert.assertTrue(ap.deleteAccount(accountName,getDriver()));
		System.out.println("Account has been deleted :: "+accountName);
	}

}
