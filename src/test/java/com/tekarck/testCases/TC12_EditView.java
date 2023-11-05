/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.teckarck.constants.FileConstants;
import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarch.utils.FileUtils;
import com.tekarck.pages.AccountsPage;

/**
 * 
 */
public class TC12_EditView extends BaseTest {

	AccountsPage ap;
	String viewNameToBeEdited;
	String newViewName;

	@Test()
	void editView() throws IOException {

		loginToSalesForceApp();
		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(getDriver(), TitleConstants.HOME_PAGE_TITLE));
		ap = new AccountsPage(getDriver());
		ap.clickAccountTab();
		Assert.assertTrue(ap.verifyAccountPageDisplayed(getDriver()));

		/*
		 * 
		 * PreConditions For the test case Edit View Start here.
		 * 
		 * Create a view before editing it.
		 * 
		 * 
		 */

//		try {
//			List<WebElement> options = ap.getAllOptionsToEdit();
//
//			viewNameToBeEdited = options.get(1).getText();
//		} catch (Exception e) {
//			System.out.println("No view created to edit");

			ap.clickCreateNewView(getDriver());
			
			Assert.assertTrue(ap.verifyCreateNewViewPageisDaisplayed(getDriver()));
			String viewName = BaseTest.generateRandomString();
			String viewUniqueName = BaseTest.generateRandomString();
			ap.enterViewName(viewName);
			ap.enterViewUniqueName(viewUniqueName);
			ap.clickSaveBtn(getDriver());
			Assert.assertTrue(ap.verifyNewViewCreatedAndDisplyed(viewName));
			
			viewNameToBeEdited=viewName;
			
//		}

		newViewName = BaseTest.generateRandomString();
		/*
		 * 
		 * PreConditions For the test case Edit View Ends here
		 * 
		 */
		ap.selectViewNameToEdit(viewNameToBeEdited);// Need to change the view name before running the test.
		ap.clickGoBtn(getDriver());
		ap.clickEdit(getDriver());
		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(getDriver(), TitleConstants.EDIT_VIEW_PAGE_TITLE));

		Assert.assertTrue(ap.verifyViewNameToBeEditedOnEditPage(getDriver(), viewNameToBeEdited));

		ap.enterNewVieName(newViewName);
		ap.selectField(FileUtils.readPropertiesFile(FileConstants.ACCOUNTS_TEST_DATA_FILE_PATH, "field"));
		ap.selectOperator(FileUtils.readPropertiesFile(FileConstants.ACCOUNTS_TEST_DATA_FILE_PATH, "operator"));
		ap.enterValue(FileUtils.readPropertiesFile(FileConstants.ACCOUNTS_TEST_DATA_FILE_PATH, "value"));

		Assert.assertTrue(ap.selectAvailabeFields(
				FileUtils.readPropertiesFile(FileConstants.ACCOUNTS_TEST_DATA_FILE_PATH, "fieldToDispaly")));
		ap.clickAddBtn();
		ap.clickSaveBtn(getDriver());
		Assert.assertTrue(ap.verifyTheEditedNewViewNameDisplayed(newViewName));
		Assert.assertTrue(ap.verifyTheColumnAddedToViewTable(FileUtils.readPropertiesFile(FileConstants.ACCOUNTS_TEST_DATA_FILE_PATH, "fieldToDispaly")));
		Assert.assertTrue(ap.verifyAccountNameContainsLetterADispalyed("a"));

		/*
		 * Post conditions Delete view
		 */

		
		 Assert.assertTrue(ap.verifyDeleteViewCreated(newViewName,getDriver()));
	}

}
