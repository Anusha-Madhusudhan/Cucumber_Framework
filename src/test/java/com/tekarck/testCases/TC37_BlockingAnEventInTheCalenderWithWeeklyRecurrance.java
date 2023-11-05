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
import com.tekarch.utils.CommonUtils;
import com.tekarch.utils.FileUtils;
import com.tekarck.pages.HomePage;

/**
 * 
 */
public class TC37_BlockingAnEventInTheCalenderWithWeeklyRecurrance extends BaseTest {
	
	HomePage hp;
	
	@Test
	void verifyBlockingAnEventInTheCalenderWithWeeklyRecurrance() throws IOException {
		
		loginToSalesForceApp();
		hp=new HomePage(getDriver());
		
		hp.clickHomTab();
		
		
		// Thursday August 31, 2023
		String expecteddate=new SimpleDateFormat("EEEE MMMM dd, yyyy").format(new Date());
		
	    Assert.assertTrue(hp.vrifyCurrentDateDisplayed(expecteddate));
	    
	    hp.clickOnCurrentDateLink();
	    
	    String userName=FileUtils.readPropertiesFile(FileConstants.USER_MENU_TEST_DATA, "username2");
	    
	    Assert.assertTrue(hp.verifyCalenderPageDisplaedForFirstNameAndLastName(userName));
	    
	    hp.clickOn4PMLink();
	    
	    Assert.assertTrue(hp.verifyCandelNewEventPageIsDisplayed(getDriver()));
	    
	    hp.clickOnSubjectComboLinkAndSelectOtherFromComboBox(getDriver());
	    
	    hp.clickOnEndTime();
	    
//	    Assert.assertTrue(hp.verifyDropDownShouldBeDispalyedFrom5To1130PM());
	    
	    hp.select7PMFromTheDropDown();
	    
	    hp.checkRecurrence();
	    
	    Assert.assertTrue(hp.verifyOptionDisaplayed());
	    
	    hp.selectWeeklyRadioBtn();
	    
	    Assert.assertTrue(hp.verifyReccursEverySectionWith1EnteredInIt("1"));
	    
	    String currentDayOfTheWeek=new SimpleDateFormat("EEEE").format(new Date());
	    
	    Assert.assertTrue(hp.verifyCurrentDayOfTheWeekShouldBeSelected(currentDayOfTheWeek));
	    
	    hp.selectEndDate();
	    
       hp.clickSaveBtn();
	    
       Assert.assertTrue(hp.verifyCalenderPageDisplaedForFirstNameAndLastName(userName));
		
	    Assert.assertTrue(hp.verifyOtherEventDispalyedBetweenTimeSlot4PMTo7PM(getDriver()));
	    
		hp.clickOnMonthView(getDriver());
		
		if(CommonUtils.waitForTitleContais(getDriver(), "Month View")) {
		
		Assert.assertTrue(hp.verifyCalendarForFirstNameLastNameMonthViewDisplayed(userName,"Month View"));
		}
		
		/*
		 * POST Conditions Deleting the event created
		 * 
		 */
	    
		getDriver().navigate().back();
		
		Assert.assertTrue(hp.deleteEventFor4PM(getDriver()));
		System.out.println("Event got deleted");
		
		/*
		 * POST Conditions Deleting the event created
		 * 
		 */
		
	}

}
