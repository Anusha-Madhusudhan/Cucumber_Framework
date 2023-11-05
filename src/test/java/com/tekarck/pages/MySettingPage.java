/**
 * 
 */
package com.tekarck.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.teckarck.constants.FileConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarch.utils.FileUtils;

/**
 * 
 */
public class MySettingPage extends BasePage {
	
	
	public MySettingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "PersonalInfo_font")
	private WebElement personalLink;

	@FindBy(id = "LoginHistory_font")
	private WebElement loginHistory;

	@FindBy(xpath = "//a[contains(text(),'Download login')]")
	private WebElement downloadLoginHistory;

	@FindBy(id = "DisplayAndLayout_font")
	private WebElement dispalyAndLayout;

	@FindBy(id = "CustomizeTabs_font")
	private WebElement customizeTab;

	@FindBy(id = "p4")
	private WebElement customApp;

	@FindBy(id = "duel_select_0")
	private WebElement availableTabs;

	@FindBy(id = "duel_select_0_right")
	private WebElement addBtn;

	@FindBy(id = "duel_select_1")
	private WebElement selectedTabs;

	@FindBy(xpath = "//ul[@id='tabBar']//li//a")
	private List<WebElement> tabBar;

	@FindBy(id = "EmailSetup_font")
	private WebElement emailSetup;

	@FindBy(id = "EmailSettings_font")
	private WebElement emailSettings;

	@FindBy(id = "sender_name")
	private WebElement emailName;

	@FindBy(id = "sender_email")
	private WebElement emailAddress;

	@FindBy(id = "auto_bcc1")
	private WebElement autoBCC;

	@FindBy(xpath = "//input[@value=' Save ']")
	private WebElement saveBtn;

	@FindBy(xpath = "//div[@class='messageText']")
	private WebElement textMsg;

	@FindBy(id = "CalendarAndReminders_font")
	private WebElement calenderAndReminders;

	@FindBy(id = "Reminders_font")
	private WebElement activityReminders;

	@FindBy(css = "#testbtn")
	private WebElement tsetReminderBtn;

	@FindBy(xpath = "(//div[@class='subject'])[1]")
	private WebElement sampleEvent;
	
	@FindBy(xpath = "//span[@class='folderText']")
	private WebElement mySettingText;
	
	
	
	public void clickPersonalLink() {
		if(personalLink.isDisplayed()) {
			
			personalLink.click();
		}
		else {
			System.out.println("Personal link is not displayed");
		}
	}
	
	public void clickLoginHistory() {
		if(loginHistory.isDisplayed()) {
			
			loginHistory.click();
		}
		else {
			System.out.println("loginHistory link is not displayed");
		}
	}
	
	public boolean clickDownloadLogin(WebDriver driver) {
		
		boolean isDownloadLinkPresent=false;
		if(CommonUtils.waitForElementClickable(driver, downloadLoginHistory)) {
			
			downloadLoginHistory.click();
			
			
			
			isDownloadLinkPresent=true;
		}
		else {
			System.out.println("downloadLoginHistory link is not displayed");
		}
		return isDownloadLinkPresent;
	}

	public void clickDispalyAndLayoutLink() {
		if(dispalyAndLayout.isDisplayed()) {
			dispalyAndLayout.click();
		}else {
			System.out.println("Display and layout  link is not displayed");
		}
		
	}

	public void clickCustomizeTabs() {
		if(customizeTab.isDisplayed()) {
			customizeTab.click();
		}else {
			System.out.println("Customize Tab  link is not displayed");
		}
		
	}

	public void selectSalesForceChatter(String sOption) {
		if(customApp.isDisplayed()) {
			
			Select s=new Select(customApp);
			s.selectByVisibleText(sOption);
			
		}else {
			System.out.println("Custom App   is not displayed");
		}
		
	}

	public boolean selectReportTab(String sOption) {
		
		boolean isOptionPresentInSelectedTab=false;
		Select s;
		
		
		
		if(selectedTabs.isDisplayed()) {
			
			 s=new Select(selectedTabs);
			 
			List<WebElement> selectedTabOptions= s.getOptions();
			
			for(WebElement ele:selectedTabOptions) {
				
				if(ele.getText().equals(sOption)) {
					isOptionPresentInSelectedTab=true;
					break;
				}
				
			}
			
			
		}
		
		if(isOptionPresentInSelectedTab==false) {
			if(availableTabs.isDisplayed()) {
				
				 s=new Select(availableTabs);
				s.selectByVisibleText(sOption);
				
			}else {
				System.out.println("Available App   is not displayed");
			}
			
		}else {
			System.out.println(sOption+"  is alredy present in the selected option");
		}
		
       return isOptionPresentInSelectedTab;
		
	}

	public void clickAddBtn() {
		if(addBtn.isDisplayed()) {
			addBtn.click();
		}else {
			System.out.println("Add button  is not displayed");
		}
		
	}

	public boolean verifyReportsAddedToTabMenu(String addedtTab) {
		boolean isTabAdded=false;
		
		for(WebElement ele:tabBar) {
			
			System.out.println(ele.getText());
			
			if(ele.getText().equals(addedtTab)){
				
				isTabAdded=true;
			}
			
		}
		return isTabAdded;
	}

	public void clickSaveBtn() {
		if(saveBtn.isDisplayed()) {
			saveBtn.click();
		}
		else {
			System.out.println("Save Btn is not displayed");
		}
	}

	public void clickEmail() {
		if(emailSetup.isDisplayed()) {
			emailSetup.click();
		}else {
			System.out.println("Email is not displayed");
		}
		
	}

	public void clickEmailSettings() {
		if(emailSettings.isDisplayed()) {
			emailSettings.click();
		}else {
			System.out.println("emailSettings is not displayed");
		}
		
	}

	public void setEmailName(String sEmailName) {
		if(emailName.isDisplayed()) {
			emailName.clear();
			emailName.sendKeys(sEmailName);
			
		}else {
			System.out.println("email name is not displayed");
		}
		
	}

	public void setEmailAddress(String sEmailAddress) {
		if(emailAddress.isDisplayed()) {
			emailAddress.clear();
			emailAddress.sendKeys(sEmailAddress);
			
		}else {
			System.out.println("email address is not displayed");
		}
		
	}

	public void selectAutomaticBCC() {
		if(autoBCC.isSelected()) {
			
		}else {
			autoBCC.click();
		}
		
	}

	public boolean verifyEmailUpdation(WebDriver driver) {
		
		boolean isEmailUpdated=false;
		String expectedText="Your settings have been successfully saved.";
		
		if(textMsg.isDisplayed()) {
			
			if(CommonUtils.waitForText(driver, textMsg, expectedText)) {
				isEmailUpdated=true;
			}
			
		}else {
			System.out.println("Text msg is not displayed");
		}
		return isEmailUpdated;
	}

	public void clickCalenderAndRamainder() {
		
		if(calenderAndReminders.isDisplayed()) {
			calenderAndReminders.click();
		}else {
			System.out.println("calenderAndReminders is not displayed");
		}
		
		
	}

	public void clickActivityRemainder() {
		if(activityReminders.isDisplayed()) {
			activityReminders.click();
		}else {
			System.out.println("activityReminders is not displayed");
		}
		
	}

	public void clickOpenTestRemainder(WebDriver driver) {
		if(tsetReminderBtn.isDisplayed()) {
			
			if(CommonUtils.waitForElementClickable(driver, tsetReminderBtn)) {
//				JavascriptExecutor js=(JavascriptExecutor) driver;
//				js.executeScript("arguments[0].click();", tsetReminderBtn);
//				tsetReminderBtn.sendKeys(Keys.ENTER);
				
				tsetReminderBtn.click();
				
				
			}
			else {
				System.out.println("tsetReminderBtn is not clickable");
			}
		}else {
			System.out.println("tsetReminderBtn is not displayed");
		}
		
	}

	public boolean verifyThePopUpWindow(WebDriver driver) {
		boolean isSampleEventPopUpOpened=false;
		
		if(CommonUtils.waitForNumOfWindowsToBe(driver, 2)) {
			Set<String> windowHandles=driver. getWindowHandles();
			List<String> windowHandlesList=new ArrayList<String>(windowHandles);
			
			System.out.println(windowHandles.size());
			
			driver.switchTo().window(windowHandlesList.get(1));
			
			if(sampleEvent.isDisplayed()) {
				
				if(sampleEvent.getText().equals("  Sample Event.")) {
					isSampleEventPopUpOpened=true;
					
					driver.close();
				}
				
			}else {
				System.out.println("sampleEvent is not displayed");
			}
			
			driver.switchTo().window(windowHandlesList.get(0));
		}
		
		
		
		return isSampleEventPopUpOpened;
	}

	public boolean verifyMySettingPageDisplayed(String expectedText, WebDriver driver) throws IOException {
		boolean isMySettingPageDisplayed=false;
		
		
		
		CommonUtils.waitForTitleContais(driver, FileUtils.readPropertiesFile(FileConstants.USER_MENU_TEST_DATA, "updatedUserName"));
		
		if(mySettingText.isDisplayed()) {
			if(mySettingText.getText().equals(expectedText)) {
				isMySettingPageDisplayed=true;
			}
		}
		return isMySettingPageDisplayed;
	}

	public boolean verifyFileDownloaded() {
		
		System.out.println("verifyFileDownloaded");
		boolean isFileDownloaded=false;
		
		File dir = new File("C:\\Users\\anush\\Downloads");
		  File[] dirContents = dir.listFiles();
		  
		  System.err.println("Size of the dir "+dirContents.length);

		  for (int i = 0; i < dirContents.length; i++) {
//			 if(dirContents[i].exists()){
		      if (dirContents[i].getName().contains("LoginHistory")) {
		    	  
		    	  System.out.println("File downloaded with name "+dirContents[i].getName());
		          // File has been found, it can now be deleted:
		          dirContents[i].delete();
		          isFileDownloaded=true;
		      }
//			 }
		          }
		      return isFileDownloaded;
		
	}
	
	

	
	
	
}
