/**
 * 
 */
package com.tekarck.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;

/**
 * 
 */
public class ContactsPage extends BasePage {
	
	public ContactsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Contact_Tab")
	private WebElement contacts;
	
	@FindBy(xpath = "//input[@value=' New ']")
	private WebElement newBtn;
	
	@FindBy(id = "name_lastcon2")
	private WebElement lastName;
	
	@FindBy(id = "con4_lkwgt")
	private WebElement accountName;
	
	@FindBy(id = "lksrch")
	private WebElement inputText;
	
	private String iFrameSearch="searchFrame";
	
	private String iFrameResult="resultsFrame";
	
	@FindBy(xpath = "//input[@value=' Go! ']")
	private WebElement goBtn;
	
	@FindBy(xpath = "//table//tbody//tr//th//a")
	private List<WebElement> accountList;
	
	
	@FindBy(xpath = "//input[@value=' Save ']")
	private WebElement saveBtn;
	
	
	@FindBy(xpath = "//div[@class='textBlock']//h2")
	private WebElement lastNameText;
	
	@FindBy(linkText = "Create New View")
	private WebElement newViewBtn;
	
	@FindBy(id = "fname")
	private WebElement viewName;

	@FindBy(id = "devname")
	private WebElement viewUniqueName;
	
	@FindBy(xpath = "//select[@class='title']")
	private WebElement view;
	
	@FindBy(id = "hotlist_mode")
	private WebElement recentCont;
	
	@FindBy(xpath = "//table[@class='list']//tbody//tr[contains(@class,'dataRow')]//th")
	private List<WebElement> contactList;
	
	@FindBy(id = "fcf")
	private WebElement viewSelect;
	
	@FindBy(xpath ="//table//thead//tr")
	private WebElement myContactstableHeaderRow;
	
	@FindBy(xpath = "//table//thead//tr//td")
	private List<WebElement> myContactstableHeaderColoumns;
	
	
	@FindBy(xpath ="//table[@class='x-grid3-row-table']//tbody//tr")
	private List<WebElement> myContactstableBodyRow;
	
	@FindBy(xpath = "//table[@class='x-grid3-row-table']//tbody//tr//td")
	private List<WebElement> myContactstableBodyColoumns;
	
	
	@FindBy(xpath ="//table[@class='list']//tbody//tr[contains(@class,'dataRow')]//th//a")
	List<WebElement> contactsList;
	
	
	@FindBy(xpath ="(//table[@class='list']//tbody//tr[contains(@class,'dataRow')]//th//a)[1]")
	private WebElement myContact;
	
	@FindBy(xpath ="//input[@value='Cancel']")
	private WebElement cancelBtn;
	
	
	String expectedErrorMsg=" You must enter a value";
	
	@FindBy(xpath ="//input[@value='Save & New']")
	private WebElement saveAndNewBtn;
	
	
	
	@FindBy(xpath ="//input[@value='Delete']")
	private WebElement deleteContactBtn;
	
	
	@FindBy(xpath = "//input[@id='con4']")
	private WebElement accountNameValue;
	

	public WebElement getAccountNameValue() {
		return accountNameValue;
	}


	public void clickOnContactsTab() {
		
		if(contacts.isDisplayed()) {
			contacts.click();
		}else {
			System.out.println("Contacts tab is not Dispalyed");
		}
		
	}


	public void clickNewBtn() {

		if(newBtn.isDisplayed()) {
			newBtn.click();
		}else {
			System.out.println("newBtn  is not Dispalyed");
		}
	}


	public boolean verifyContactEditPageIsDispalyed(WebDriver driver) {
		boolean isContactEditPageIsDispalyed=false;
		if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.CONTACTS_EDIT_PAGE_TITLE)) {
			isContactEditPageIsDispalyed=true;
		}
		return isContactEditPageIsDispalyed;
	}


	public void enterLastName(String sLastName) {
		
		if(lastName.isDisplayed()) {
			lastName.clear();
			lastName.sendKeys(sLastName);
			
		}else {
			System.out.println("Last Name is not Dispalyed");
		}
	}


	public String clickAccountSearchImg(WebDriver driver) {
		String value=null;
		if(accountName.isDisplayed()) {
			accountName.click();
			
			Set<String> windowHandles=driver.getWindowHandles();
			 
			 List<String> list=new ArrayList<String>(windowHandles);
			 
			 String parentWindowHandle=list.get(0);
			 
			 String childWindowHandle=list.get(1);
			 
			 driver.switchTo().window(childWindowHandle);
			
			
			driver.switchTo().frame(iFrameSearch);
			
			if(inputText.isDisplayed()) {
				
				inputText.sendKeys("*a");
			}
			else {
				System.out.println("inputText is not displayed");
			}
			if(goBtn.isDisplayed()) {
				goBtn.click();
			}else {
				System.out.println("Go btn is not displayed");
			}
			
			driver.switchTo().defaultContent();
			
			driver.switchTo().frame(iFrameResult);
			
			 value=accountList.get(0).getText();
			 
			 
			
			accountList.get(0).click();
			 
			 
			
			driver.switchTo().window(parentWindowHandle);
			
			
			
//			accountNameValue.sendKeys(Keys.TAB);   // this is for firefox
			
			System.out.println("Returning account name   "+value);
			
			
		}else {
			System.out.println("AccountSearchImg is not Dispalyed");
		}
		return value;
	}


	public void clickSaveBtn(WebDriver driver) {
		
		if(CommonUtils.waitForNumOfWindowsToBe(driver, 1)) {
		if(CommonUtils.waitForElementToVisible(driver, saveBtn)) {
			saveBtn.click();
			System.out.println("Save btn clicked");
		}else {
			System.out.println("saveBtn  is not Dispalyed");
		}
		}
	}


	public boolean verifyNewCantactCreated(WebDriver driver, String sLastName) {
		boolean isNewCantactCreated=false;
		if(CommonUtils.waitForElementToVisible(driver, lastNameText)) {
			if(CommonUtils.waitForText(driver, lastNameText, sLastName)) {
				isNewCantactCreated=true;
			}
		}
		return isNewCantactCreated;
	}


	public void clickCreateNewView() {
		
		if(newViewBtn.isDisplayed()) {
			newViewBtn.click();
		}else {
			System.out.println("New view btn is not displayed");
		}
		
	}


	public boolean verifyCreateNewViewPageDispaled(WebDriver driver) {
		boolean isCreateNewViewPageDispaled=false;
		
		if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.CONTACTS_CREATE_NEW_VIEW_PAGE_TITLE)) {
			isCreateNewViewPageDispaled=true;
		}
		return isCreateNewViewPageDispaled;
	}


	public void enterViewName(String sViewName) {
		if(viewName.isDisplayed()) {
			viewName.clear();
			viewName.sendKeys(sViewName);
		}else {
			System.out.println("New view text is not displayed");
		}
	}


	public void enterViewUniqueName(String sViewUniqueName) {
		if(viewUniqueName.isDisplayed()) {
			viewUniqueName.clear();
			viewUniqueName.sendKeys(sViewUniqueName);
		}else {
			System.out.println("viewUniqueName text is not displayed");
		}
	}


	public boolean verifyCreatedNewViewNameDisplayedOnCantactsPage(String sViewName) {
		boolean isCreatedNewViewNameDisplayedOnCantactsPage=false;
		if(view.isDisplayed()) {
			Select s=new Select(view);
			if(s.getFirstSelectedOption().getText().equals(sViewName)) {
				isCreatedNewViewNameDisplayedOnCantactsPage=true;
			}
		}
		return isCreatedNewViewNameDisplayedOnCantactsPage;
	}


	public void selectRecentlyCreatedContacts(String sOption) {
		
		if(recentCont.isDisplayed()) {
			Select s=new Select(recentCont);
			s.selectByVisibleText(sOption);
		}else {
			System.out.println("Recently created option is not displayed");
		}
		
	}


	public boolean verifyRecenlyCeatedContactsAreDisplayed() {
		
		boolean isRecenlyCeatedContactsAreDisplayed=false;
		
		for(WebElement ele:contactList) {
			isRecenlyCeatedContactsAreDisplayed=true;
			System.out.println(ele.getText());
		}
		return isRecenlyCeatedContactsAreDisplayed;
	}


	public void selectMyContacts(String sOption) {
		if(viewSelect.isDisplayed()) {
			
			Select s=new Select(viewSelect);
			if(!s.getFirstSelectedOption().getText().equals(sOption)) {
			s.selectByVisibleText(sOption);
			}
		}else {
			System.out.println("View drop down is not displayed");
		}
		
	}


	public void clickGoBtn() {
		if(goBtn.isDisplayed()) {
			goBtn.click();
		}else {
			System.out.println("Go btn is not displayed");
		}
	}


	public boolean verifyAllContactsDispalyed() {
		
		boolean allContactsDisplyed=false;
		
		for(WebElement ele:myContactstableHeaderColoumns) {
			
			System.out.print(ele.getText()+"   ");
		}
		System.out.println();
		
		int length=myContactstableHeaderColoumns.size();
		

		
		int i=0;
		
		for(WebElement colm:myContactstableBodyColoumns) {
				
			
		if(i<length) {
			System.out.print(colm.getText()+"   ");
			allContactsDisplyed=true;
			i++;
		}
		else if(i>=length){
			i=0;
			System.out.println();
		}
		}
		
		
		return allContactsDisplyed;
	}
	
	
	public List<WebElement> getcontactList() {
        return contactList;
    }


	public String selectContact(WebDriver driver) throws InterruptedException {
		
		
		
		
		String contactName=myContact.getText();
//		
		if(CommonUtils.waitForElementClickable(driver, myContact)) {
//			
//			
			myContact.click();
		}
		
		
		
		
//		  WebElement contact=getcontactList().get(0);
//		  String contactName=contact.getText(); 
//		  for(WebElement ele:contactList) 
//		  { 
//		  System.out.println(ele.getText());
//		  } 
//		  
////		  driver.findElement(By.linkText(contactName)).click(); 
//		  
//		  if(CommonUtils.waitForElementClickable(driver, contact)) { 
//			  contact.click(); 
//			  }
		 
		return contactName;
		
	}


	public boolean verifySelectedCotactPageDisplayed(WebDriver driver, String contactName) {
		
		
		boolean isSelectedCotactPageDisplayed=false;
		
		if(CommonUtils.waitForTitleContais(driver, contactName)) {
			
			isSelectedCotactPageDisplayed=true;
			
			
		}
		return isSelectedCotactPageDisplayed;
	}


	public boolean verifyErrorMsgDisplayed(WebDriver driver) {
		boolean isErrorMsgDisplayed=false;
		
		if(driver.getPageSource().contains(expectedErrorMsg)) {
			isErrorMsgDisplayed=true;
		}
		
		return isErrorMsgDisplayed;
	}


	public void clickCancelBtn() {
		
		if(cancelBtn.isDisplayed()) {
			cancelBtn.click();
		}else {
			System.out.println("Cancel Btn is not Dispalyed");
		}
		
	}


	public boolean verifyNewViewNotCreated(String sViewName) {
		  boolean isNewViewNotCreated=true;
		
		
		if(viewSelect.isDisplayed()) {
			Select s=new Select(viewSelect);
			 List<WebElement> options=s.getOptions();
			    for(WebElement ele:options) {
			    	
			    	if(ele.getText().equals(sViewName)) {
			    		isNewViewNotCreated=false;
			    		break;
			    	}
			    }
		}
		return isNewViewNotCreated;
	}


	public boolean verifyContactsHomePageIsDispalyed(WebDriver driver) {
		
		boolean isContactsHomePageIsDispalyed=false;
		
		if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.CONTACTS_PAGE_TITLE)) {
			isContactsHomePageIsDispalyed=true;
		}
		
		return isContactsHomePageIsDispalyed;
	}


	public void clickSaveAndNewBtn() {

		if(saveAndNewBtn.isDisplayed()) {
			saveAndNewBtn.click();
		}else {
			System.out.println("saveAndNewBtn is not displayed");
		}
	}


	public boolean deleteContact(WebDriver driver) {
		boolean isContactDeleted=false;
		
		if(deleteContactBtn.isDisplayed()) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", deleteContactBtn);
			deleteContactBtn.click();
			try {
				Alert alert=CommonUtils.waitForAlert(driver);
				alert.accept();
				isContactDeleted=true;
			}catch(NoAlertPresentException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("Delete contact btn is not displayed");
		}
		
		return isContactDeleted;
	}
	
	
}
