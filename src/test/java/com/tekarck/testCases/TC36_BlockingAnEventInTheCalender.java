/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.teckarck.constants.FileConstants;
import com.tekarch.utils.FileUtils;
import com.tekarck.pages.HomePage;

/**
 * 
 */
public class TC36_BlockingAnEventInTheCalender extends BaseTest {
	HomePage hp;
	@Test
	void verifyBlockingAnEventInTheCalender() throws IOException {
		
		loginToSalesForceApp();
		hp=new HomePage(getDriver());
		
		hp.clickHomTab();
		
        String expecteddate=new SimpleDateFormat("EEEE MMMM dd, yyyy").format(new Date());
		
	    Assert.assertTrue(hp.vrifyCurrentDateDisplayed(expecteddate));
	    
	    hp.clickOnCurrentDateLink();
	    
	    String userName=FileUtils.readPropertiesFile(FileConstants.USER_MENU_TEST_DATA, "username2");
	    
	    Assert.assertTrue(hp.verifyCalenderPageDisplaedForFirstNameAndLastName(userName));
	    
	    hp.clickOn8PMLink();
	    
	    Assert.assertTrue(hp.verifyCandelNewEventPageIsDisplayed(getDriver()));
	    hp.clickOnSubjectComboLinkAndSelectOtherFromComboBox(getDriver());
	    hp.clickOnEndTime();
	    hp.select9PMFromTheDropDown();
	    
	    hp.clickSaveBtn();
	    
	    Assert.assertTrue(hp.verifyCalenderPageDisplaedForFirstNameAndLastName(userName));
	    
	    Assert.assertTrue(hp.verifyOtherEventDispalyedBetweenTimeSlot8PMTo9PM(getDriver()));
	    
	    /*
		 * POST Conditions Deleting the event created
		 * 
		 */
	    
		
		
		Assert.assertTrue(hp.deleteEventFor8PM(getDriver()));
		System.out.println("Event got deleted");
		
		/*
		 * POST Conditions Deleting the event created
		 * 
		 */
		
	    
	}

}
