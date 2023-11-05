/**
 * 
 */
package com.tekarck.pages;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;

/**
 * 
 */
public class HomePage extends BasePage {
	
	

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Home")
	WebElement homeTab;
	
	@FindBy(xpath = "//h1[@class='currentStatusUserName']//a")
	WebElement userNameOnHomePage;
	
	@FindBy(id = "tailBreadcrumbNode")
	WebElement userNameOnMyProfilePage;
	
	@FindBy(id = "AllTab_Tab")
	WebElement plusSignBtn;
	
	@FindBy(xpath = "//input[@value='Customize My Tabs']")
	WebElement customizeTab;
	
	@FindBy(id = "duel_select_1")
	WebElement selectedTabs;
	
	@FindBy(id = "duel_select_0_left")
	WebElement removeBtn;

	@FindBy(id = "duel_select_0")
	WebElement availableTabs;
	
	@FindBy(xpath = "//input[@value=' Save ']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//ul[@id='tabBar']//li//a")
	List<WebElement> tabBar;
	
	@FindBy(id = "duel_select_0_right")
	WebElement addBtn;
	
	@FindBy(xpath = "//span[@class='pageDescription']//a")
	WebElement dateLink;
	
	@FindBy(css = ".pageType")
	WebElement currentStatusUserName;
	
	@FindBy(partialLinkText = "4:00 PM")
	WebElement _4PM;
	
	
	@FindBy(partialLinkText = "8:00 PM")
	WebElement _8PM;
	
	@FindBy(xpath ="//a[@title='Combo (New Window)']")
	WebElement subjectCombo;
	
	@FindBy(linkText = "Other")
	WebElement other;
	
	@FindBy(id = "EndDateTime_time")
	WebElement endTime;
	
	@FindBy(id = "timePickerItem_38")
	WebElement _7PM;
	
	@FindBy(id = "timePickerItem_42")
	WebElement _9PM;
	
	
	@FindBy(id = "IsRecurrence")
	WebElement recurrenceCheckBox;
	
	@FindBy(xpath = "//div[@id='recpat']//table//tbody//tr/td/label")
	List<WebElement> recurrence;
	
	@FindBy(id = "rectypeftw")
	WebElement weeklyRadioBtn;
	
	@FindBy(xpath = "//div[@id='w']//div")
	WebElement recurseEvery;
	
	@FindBy(id = "wi")
	WebElement numberOfWeeksInputText;
	
	
	
	@FindBy(xpath = "//div[@class='periodElementGroup']//input[@type='checkbox']")
	List<WebElement> daysOfTheWeekCheckBox;
	
	@FindBy(xpath = "//div[@class='periodElementGroup']//input[@type='checkbox']//following-sibling::label")
	List<WebElement> daysOfTheWeek;
	
	@FindBy(id = "RecurrenceStartDateTime")
	WebElement reccurenceStartDate;
	
	
	@FindBy(id = "RecurrenceEndDateOnly")
	WebElement reccurenceEndDate;
	
	@FindBy(xpath = "//table[@class='detailList']//tbody//tr[2]//td[2]")
	WebElement eventDetailsSubject;
	
	@FindBy(xpath = "//table[@class='detailList']//tbody//tr[5]//td[2]")
	WebElement eventDetailsStart;
	
	@FindBy(xpath = "//table[@class='detailList']//tbody//tr[6]//td[2]")
	WebElement eventDetailsEnd;
	
	@FindBy(id = "p:f:j_id25:j_id69:28:j_id71:0:j_id72:calendarEvent:j_id84")
	WebElement eventDetails;
	
	@FindBy(xpath = "//a[@title='Month View']")
	WebElement monthView;
	
	@FindBy(xpath = "//div[@id='p:f:j_id25:j_id69:20:hh']//a[@title='Busy - Other']")
	WebElement eventOtherFor4PM;
	
	
	@FindBy(xpath = "//div[@id='p:f:j_id25:j_id69:28:hh']//a[@title='Busy - Other']")
	WebElement eventOtherFor8PM;
	
	
	
	@FindBy(xpath = "//input[@value='Delete']")
	WebElement deleteEvent;
	
	
	
	public void clickHomTab() {
		
		if(homeTab.isDisplayed()) {
			homeTab.click();
		}else{
			System.out.println("Home Page is not displayed");
		}
		
	}

	public String getUserNameOnHomePage() {
		String userName = null;
		if(userNameOnHomePage.isDisplayed()) {
			userName=userNameOnHomePage.getText();
		}else{
			System.out.println("User Name is not displayed");
		}
		
		
		return userName;
	}

	public void clickOnUserName() {
		if(userNameOnHomePage.isDisplayed()) {
			userNameOnHomePage.click();
		}else{
			System.out.println("User Name is not displayed");
		}
		
		
	}

	public boolean verifyUserNameOnHomePageSameAsOnMyProfilePage(String sUserNameOnHomePage) {
		boolean isUserNameOnHomePageSameAsOnMyProfilePage=false;
		
		if(userNameOnMyProfilePage.isDisplayed()) {
			
			if(userNameOnMyProfilePage.getText().contains(sUserNameOnHomePage)) {
				isUserNameOnHomePageSameAsOnMyProfilePage=true;
			}
		}
		
		
		return isUserNameOnHomePageSameAsOnMyProfilePage;
	}

	public void clickOnPlusSign(WebDriver driver) {
		
		if(CommonUtils.waitForElementToVisible(driver, plusSignBtn)) {
			plusSignBtn.click();
		}else {
			System.out.println("Plus sign btn not displayed");
		}
		
	}

	public boolean verifyAllTabPageDisplayed(WebDriver driver) {
		boolean isAllTabPageDisplayed=false;
		
		if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.ALL_TABS_PAGE_TITLE)|| driver.getPageSource().contains("All Tabs")) {
			isAllTabPageDisplayed=true;
		}
		
		return isAllTabPageDisplayed;
		
	}

	public void clickCustomizeTabBtn() {
		
		if(customizeTab.isDisplayed()) {
			customizeTab.click();
		}else {
			System.out.println("customizeTab not displayed");
		}
	}

	

	public boolean verifyCustomizeTabPageDisplayed(WebDriver driver) {
        boolean isCustomizeTabPageDisplayed=false;
		
		if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.CUSTOMIZE_MYTAB_PAGE_TITLE)) {
			isCustomizeTabPageDisplayed=true;
		}
		
		return isCustomizeTabPageDisplayed;
	}

	public void selectTabFromSelectedTabList(String tabToBeRemoved) {
		
		if(selectedTabs.isDisplayed()) {
			Select s=new Select(selectedTabs);
			s.selectByVisibleText(tabToBeRemoved);
		}else {
			System.out.println("selectedTabs not displayed");
		}
		
	}

	public void clickOnRemoveBtn() {
		
		if(removeBtn.isDisplayed()) {
			removeBtn.click();
		}else {
			System.out.println("removeBtn not displayed");
		}
		
	}

	public boolean verifyRemovedTabAvailableInAvailableTab(String tabToBeRemoved) {
		boolean isRemovedTabAvailableInAvailableTab=false;
		if(availableTabs.isDisplayed()) {
			Select s=new Select(availableTabs);
			List<WebElement> availableOps=s.getOptions();
			for(WebElement op:availableOps) {
				if(op.getText().equals(tabToBeRemoved)) {
					isRemovedTabAvailableInAvailableTab=true;
					break;
				}
			}
		}else {
			System.out.println("selectedTabs not displayed");
		}
		return isRemovedTabAvailableInAvailableTab;
	}

	public void clickSaveBtn() {
		if(saveBtn.isDisplayed()) {
			saveBtn.click();
		}else {
			System.out.println("save btn not displayed");
		}
	}

	public boolean vrifyRemovedTabPresentOnTheTabBar(String tabToBeRemoved) {
		boolean isTabAvailableInTabBar=true;
		
		for(WebElement op:tabBar) {
			
			if(op.getText().equals(tabToBeRemoved)) {
				isTabAvailableInTabBar=false;
				break;
			}
			
		}
		return isTabAvailableInTabBar;
	}

	public void selectTabFromAvailableTabList(String tabToBeRemoved) {

		if(availableTabs.isDisplayed()) {
			Select s=new Select(availableTabs);
			s.selectByVisibleText(tabToBeRemoved);
		}else {
			System.out.println("selectedTabs not displayed");
		}
	}

	public void clickAddBtn() {
		if(addBtn.isDisplayed()) {
			addBtn.click();
		}else {
			System.out.println("add Btn not displayed");
		}
		
	}

	public boolean vrifyCurrentDateDisplayed(String expecteddate) {
		boolean isCurrentDateDisplayed=false;
		
		if(dateLink.isDisplayed()) {
			if(dateLink.getText().equals(expecteddate)) {
				isCurrentDateDisplayed=true;
			}
		}else {
			System.out.println("Date link is not present");
		}
		
		return isCurrentDateDisplayed;
	}

	public void clickOnCurrentDateLink() {
		if(dateLink.isDisplayed()) {
			dateLink.click();
		}else {
			System.out.println("Date link is not present");
		}
	}

	public boolean verifyCalenderPageDisplaedForFirstNameAndLastName(String sUserName) {
		boolean isCalenderPageDisplaedForFirstNameAndLastName=false;
		if(currentStatusUserName.isDisplayed()) {
			if(currentStatusUserName.getText().contains(sUserName)) {
				isCalenderPageDisplaedForFirstNameAndLastName=true;
			}
		}else {
			System.out.println("User Name is not present");
		}
		
		return isCalenderPageDisplaedForFirstNameAndLastName;
	}

	public void clickOn4PMLink() {
		
		if(_4PM.isDisplayed()) {
			_4PM.click();
		}else {
			System.out.println("_4PM  link is not present");
		}
		
	}

	public boolean verifyCandelNewEventPageIsDisplayed(WebDriver driver) {
		boolean isCandelNewEventPageIsDisplayed=false;
		
		if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.CALENDER_NEW_EVENT_PAGE_TITLE)) {
			isCandelNewEventPageIsDisplayed=true;
		}
		
		return isCandelNewEventPageIsDisplayed;
	}

	public void clickOnSubjectComboLinkAndSelectOtherFromComboBox(WebDriver driver) {
		
		if(subjectCombo.isDisplayed()) {
			subjectCombo.click();
			
			Assert.assertTrue(CommonUtils.waitForNumOfWindowsToBe(driver, 2));
			
			Set<String> windowHandles=driver.getWindowHandles();
			List<String> windowHandlesList=new ArrayList<>(windowHandles);
			
			driver.switchTo().window(windowHandlesList.get(1));
			
			if(other.isDisplayed()) {
				other.click();
			}else {
				System.out.println("Other  link is not present");
			}
			
			Assert.assertTrue(CommonUtils.waitForNumOfWindowsToBe(driver, 1));
			
			driver.switchTo().window(windowHandlesList.get(0));
			
			
		}else {
			System.out.println("subjectCombo  link is not present");
		}
		
	}

	public void clickOnEndTime() {
		
		if(endTime.isDisplayed()) {
			endTime.click();
		}else {
			System.out.println("endTime   is not present");
		}
		
	}
	
	
    public void select7PMFromTheDropDown() {
		
    	if(_7PM.isDisplayed()) {
    		_7PM.click();
    	}
    	else {
			System.out.println("_7PM   is not present");
		}
	}

//	public boolean verifyDropDownShouldBeDispalyedFrom5To1130PM() {
//		
//		
//		return false;
//	}

	public void checkRecurrence() {
		
		if(recurrenceCheckBox.isDisplayed()) {
			if(!recurrenceCheckBox.isSelected()) {
				recurrenceCheckBox.click();
			}
		}
		else {
			System.out.println("recurrenceCheckBox   is not present");
		}
	}

	public boolean verifyOptionDisaplayed() {
		boolean recurrenceFalg=false;
		
		List<String> expectedRecurrence=new ArrayList<String>();
		expectedRecurrence.add("Frequency");
		expectedRecurrence.add("Recurrence Start");
		expectedRecurrence.add("Recurrence End");
		int i=0;
		
		for(WebElement rec:recurrence) {
			
			if(rec.getText().equals(expectedRecurrence.get(i))){
				recurrenceFalg=true;
				i++;
			}else {
				recurrenceFalg=false;
			}
			
		}
		return recurrenceFalg;
	}

	public void selectWeeklyRadioBtn() {
		
		if(weeklyRadioBtn.isDisplayed()) {
			if(!weeklyRadioBtn.isSelected()) {
				weeklyRadioBtn.click();
			}
		}else {
			System.out.println("weeklyRadioBtn is not displyed");
		}
		
	}

	public boolean verifyReccursEverySectionWith1EnteredInIt(String string) {
		boolean isReccursEverySectionWith1EnteredInIt=false;
		if(numberOfWeeksInputText.isDisplayed()) {
			if(numberOfWeeksInputText.getAttribute("value").equals(string)) {
				isReccursEverySectionWith1EnteredInIt=true;
			}
		}
		
		return isReccursEverySectionWith1EnteredInIt;
	}

	public boolean verifyCurrentDayOfTheWeekShouldBeSelected(String currentDayOfTheWeek) {
		boolean isCurrentDayOfTheWeekShouldBeSelected=false;
		int i=0;
		for(WebElement ele:daysOfTheWeekCheckBox) {
			if(ele.isSelected()) {
				if(daysOfTheWeek.get(i).getText().equals(currentDayOfTheWeek)){
				
					isCurrentDayOfTheWeekShouldBeSelected=true;
				break;
			}
		}
			
				i++;
			
		
	}

		return isCurrentDayOfTheWeekShouldBeSelected;
	
	
	}

	public void selectEndDate() {
		
		String currentDate=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		
		System.out.println(currentDate);
		
		String endDateL=LocalDate.now().plusWeeks(2).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		
//		String endDateL=LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		System.out.println(endDateL);
		
		if(reccurenceEndDate.isDisplayed()) {
			reccurenceEndDate.clear();
			reccurenceEndDate.sendKeys(endDateL);
		}else {
			
			System.out.println("reccurenceEndDate is not displayed");
		}
		
		
	}

	

	public boolean verifyOtherEventDispalyedBetweenTimeSlot4PMTo7PM(WebDriver driver) {
		boolean isOtherEventDispalyedBetweenTimeSlot4PMTo7PM=false;
			
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", _4PM); 

		Actions act=new Actions(driver);
		act.moveToElement(eventOtherFor4PM).build().perform();
			
				if(eventDetailsSubject.getText().equals("Other")) {
					if(eventDetailsStart.getText().contains("4:00 PM")) {
						if(eventDetailsEnd.getText().contains("7:00 PM")) {
							isOtherEventDispalyedBetweenTimeSlot4PMTo7PM=true;
						}
					}

		}
		
		return isOtherEventDispalyedBetweenTimeSlot4PMTo7PM;
	}

	public void clickOnMonthView(WebDriver driver) {
		if(monthView.isDisplayed()) {
			if(CommonUtils.waitForElementClickable(driver, monthView)) {
				
				JavascriptExecutor jse2 = (JavascriptExecutor)driver;
				jse2.executeScript("arguments[0].scrollIntoView();", monthView); 
				
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click();", monthView); 
				
				
//				Actions act=new Actions(driver);
//				act.moveToElement(monthView).build().perform();
//				monthView.click();
			}
			
		}else {
			System.out.println("Month view is not displayed");
		}
	}

	public boolean verifyCalendarForFirstNameLastNameMonthViewDisplayed(String userName, String string) {
		boolean isCalendarForFirstNameLastNameMonthViewDisplayed=false;
		
		if(currentStatusUserName.isDisplayed()) {
			if(currentStatusUserName.getText().contains(userName)){
				if(currentStatusUserName.getText().contains(string)) {
					isCalendarForFirstNameLastNameMonthViewDisplayed=true;
				}
			}
		}
		return isCalendarForFirstNameLastNameMonthViewDisplayed;
	}

	public boolean deleteEventFor4PM(WebDriver driver) {
		
		boolean isOtherEventDeleted=false;
		
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", _4PM); 

		Actions act=new Actions(driver);
		act.moveToElement(eventOtherFor4PM).build().perform();
			
		
			deleteEvent.click();
			try {
			driver.switchTo().alert().accept();
			isOtherEventDeleted=true;
			}catch (NoAlertPresentException e) {
				System.out.println(e.getMessage());
			}
		
		
		return isOtherEventDeleted;
		
	}
	
     public boolean deleteEventFor8PM(WebDriver driver) {
		
		boolean isOtherEventDeleted=false;
		
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", _4PM); 

		Actions act=new Actions(driver);
		act.moveToElement(eventOtherFor8PM).build().perform();
			
		
			deleteEvent.click();
			try {
			driver.switchTo().alert().accept();
			isOtherEventDeleted=true;
			}catch (NoAlertPresentException e) {
				System.out.println(e.getMessage());
			}
		
		
		return isOtherEventDeleted;
		
	}

	public void clickOn8PMLink() {
		
		if(_8PM.isDisplayed()) {
			_8PM.click();
		}
		else {
			System.out.println("8 PM is not displayed");
		}
		
	}

	public void select9PMFromTheDropDown() {

    	if(_9PM.isDisplayed()) {
    		_9PM.click();
    	}
    	else {
			System.out.println("_9PM   is not present");
		}
		
	}

	public boolean verifyOtherEventDispalyedBetweenTimeSlot8PMTo9PM(WebDriver driver) {
		
		boolean isOtherEventDispalyedBetweenTimeSlot8PMTo9PM=false;
		
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", _8PM); 

		Actions act=new Actions(driver);
		act.moveToElement(eventOtherFor8PM).build().perform();
			
				if(eventDetailsSubject.getText().equals("Other")) {
					if(eventDetailsStart.getText().contains("8:00 PM")) {
						if(eventDetailsEnd.getText().contains("9:00 PM")) {
							isOtherEventDispalyedBetweenTimeSlot8PMTo9PM=true;
						}else {
							System.out.println(eventDetailsEnd.getText());
						}
					}

		}
		
		return isOtherEventDispalyedBetweenTimeSlot8PMTo9PM;
	}

	public boolean verifyTabToBeRemovedPresentInSelectedList(String tabToBeRemoved) {
		boolean isTabToBeRemovedPresentInSelectedList=false;
		
		if(selectedTabs.isDisplayed()) {
			Select s=new Select(selectedTabs);
			List<WebElement> allOptions=s.getOptions();
			for(WebElement ele:allOptions) {
				if(ele.getText().equals(tabToBeRemoved)) {
					isTabToBeRemovedPresentInSelectedList=true;
					break;
				}
			}
		}else {
			System.out.println("selectedTabs not displayed");
		}
		
		return isTabToBeRemovedPresentInSelectedList;
	}
	
}












