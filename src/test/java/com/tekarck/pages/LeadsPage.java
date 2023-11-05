/**
 * 
 */
package com.tekarck.pages;

import java.util.ArrayList;
import java.util.List;

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
public class LeadsPage extends BasePage {
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@id='Lead_Tab']//a")
	private WebElement leadsTab;
	
	
	@FindBy(id = "fcf")
	private WebElement leadsList;
	
	@FindBy(xpath = "//input[@value=' Go! ']")
	private WebElement goBtn;
	
	@FindBy(xpath = "//select[@class='title']")
	private WebElement leadsDropDown;
	
	@FindBy(xpath = "//input[@value=' New ']")
	private WebElement newBtn;
	
	@FindBy(id = "name_lastlea2")
	private WebElement lastName;
	
	@FindBy(id = "lea3")
	private WebElement compnyName;
	
	
	@FindBy(xpath = "//input[@value=' Save ']")
	private WebElement saveBtn;

	@FindBy(xpath = "//div[@class='textBlock']//h2")
	private WebElement lastNameText;
	
	
	public void clickLeadsTab() {
		if(leadsTab.isDisplayed()) {
			leadsTab.click();
		
		}else {
			System.out.println("Leads Tab is not displayed");
		}
		
	}

	public boolean verifyLeadsPageDisplayed(WebDriver driver) {
		boolean isLeadsPageDisplayed=false;
		if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.LEADS_PAGE_TITLE)) {
			isLeadsPageDisplayed=true;
		}
		return isLeadsPageDisplayed;
	}

	public boolean verifyLeadsDropDownList(WebDriver driver) {
		boolean isLeadDropDownListPresent=false;
		 List<String> expectedList=new ArrayList<String>();
	    expectedList.add("All Open Leads");
	    expectedList.add("My Unread Leads");
	    expectedList.add("Recently Viewed Leads");
	    expectedList.add("Today's Leads");
	    expectedList.add("View - Custom 1");
	    expectedList.add("View - Custom 2");
	    
	    if(leadsList.isDisplayed()) {
	    	Select s=new Select(leadsList);
	    	List<WebElement> optionsList=s.getOptions();
	    	 
	 	    int i=0;
	 	    
	 	    for(WebElement ele:optionsList) {
	 	    	if(ele.getText().equals(expectedList.get(i))) {
	 	    	i++;
	 	    	isLeadDropDownListPresent=true;
	 	    	continue;
	 	    	}
	 	    	else {
	 	    		isLeadDropDownListPresent=false;
	 				break;
	 			}
	 	    }
	    	
	    }
	    else {
	    	System.out.println("List drop down is not present");
	    }
		return isLeadDropDownListPresent;
	}

	public void selectMyUnreadLeads(String sOption) {
		
		 if(leadsList.isDisplayed()) {
		    	Select s=new Select(leadsList);
		    	s.selectByVisibleText(sOption);
		    	
		 }else {
		    	System.out.println("List drop down is not present");
		    }
		
	}

	public boolean verifyLoginPageDisplayed(WebDriver driver) {
		boolean isLoginPageDisplayed=false;
		
		if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.LOGIN_PAGE_TITLE)) {
			isLoginPageDisplayed=true;
		}
		return isLoginPageDisplayed;
	}

	public boolean verifyDropDownListForDefoultSelectedOption(String sOption) {
		boolean isDropDownListForDefoultSelectedOptionDisplayed=false;
		if(leadsList.isDisplayed()) {
	    	Select s=new Select(leadsList);
	    	if(s.getFirstSelectedOption().getText().equals(sOption)) {
	    		isDropDownListForDefoultSelectedOptionDisplayed=true;
	    	}
	    	
	 }else {
	    	System.out.println("List drop down is not present");
	    }
		
		return isDropDownListForDefoultSelectedOptionDisplayed;
	}

	public void selectTodaysLeads(String sOption) {
		 if(leadsList.isDisplayed()) {
		    	Select s=new Select(leadsList);
		    	if(!s.getFirstSelectedOption().getText().equals(sOption)) {
		    	s.selectByVisibleText(sOption);
		    	}
		 }else {
		    	System.out.println("List drop down is not present");
		    }
		
	}

	public void clickGoBtn() {
		if(goBtn.isDisplayed()) {
			goBtn.click();
		}else {
	    	System.out.println("Go Btn is not Displayed");
	    }
	}

	public boolean verifyTodaysLeadsPageDisplayed(WebDriver driver, String sOption) {
		boolean isTodaysLeadsPageDisplayed=false;
		if(leadsDropDown.isDisplayed()) {
	    	Select s=new Select(leadsDropDown);
	    	
	    	if(s.getFirstSelectedOption().getText().equals(sOption)) {
	    		isTodaysLeadsPageDisplayed=true;
	    	}
	    	
	 }else {
	    	System.out.println("List drop down is not present");
	    }
		return isTodaysLeadsPageDisplayed;
		
		
	}

	public void clickNewBtn() {
		
		if(newBtn.isDisplayed()) {
			newBtn.click();
		}else {
	    	System.out.println("New Btn is not Dispalyed");
	    }
	}

	public boolean verifyLeadsEditPageIsDisplayed(WebDriver driver) {
		boolean isLeadsEditPageIsDisplayed=false;
		
		if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.LEADS_EDIT_PAGE_TITLE)) {
			isLeadsEditPageIsDisplayed=true;
		}
		return isLeadsEditPageIsDisplayed;
	}

	public void enterLastName(String sLastName) {
		if(lastName.isDisplayed()) {
			lastName.clear();
			lastName.sendKeys(sLastName);
		}else {
	    	System.out.println("Last name text is not Dispalyed");
	    }
	}

	public void enterCompanyName(String companyName) {
		if(compnyName.isDisplayed()) {
			compnyName.clear();
			compnyName.sendKeys(companyName);
		}else {
	    	System.out.println("Company name text is not Dispalyed");
	    }
	}

	public void clickSaveBtn() {
		if(saveBtn.isDisplayed()) {
			saveBtn.click();
		}else {
	    	System.out.println("saveBtn is not Dispalyed");
	    }
	}

	public boolean verifyNewlyCreatedLeadViewPageDisplayed(WebDriver driver, String sLastName) {
		
		boolean isNewlyCreatedLeadViewPageDisplayed=false;
		
		if(lastNameText.isDisplayed()) {
			if(CommonUtils.waitForText(driver, lastNameText, sLastName)&& CommonUtils.waitForTitleContais(driver, sLastName)) {
				isNewlyCreatedLeadViewPageDisplayed=true;
			}
		}
		return isNewlyCreatedLeadViewPageDisplayed;
	}
	
	
	

}
