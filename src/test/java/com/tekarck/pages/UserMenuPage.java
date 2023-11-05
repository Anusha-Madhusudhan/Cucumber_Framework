/**
 * 
 */
package com.tekarck.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tekarch.utils.CommonUtils;

/**
 * 
 */
public class UserMenuPage extends BasePage {
	
	public UserMenuPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="userNavButton")
	WebElement userMenu;
	
	@FindBy(id="userNav-menuItems")
	WebElement userMenuItems;
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']//a")
	List<WebElement> userMenuItemList;
	
	@FindBy(id="userNavLabel")
	WebElement userNameInUserMenuBtn;
	
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']//a[1]")
	WebElement myProfile;
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']//a[2]")
	WebElement mySettings;
	
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']//a[3]")
	WebElement developerCosole;
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']//a[4]")
	WebElement switchTolightningExp;
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']//a[5]")
	WebElement logOut;
	
	@FindBys(@FindBy(xpath = "//div[@id='userNav-menuItems']//a"))
	WebElement menuItems;
	
	public void clickUserMenu() {
		
		if(this.userMenu.isDisplayed()) {
			this.userMenu.click();
		}
		else {
			
		}
	}

	public void clickUserMenuItems() {
		if(this.userMenuItems.isDisplayed()) {
			this.userMenuItems.click();
		}
		else {
			
		}
	}

	public void clickMyProfile() {
		if(this.myProfile.isDisplayed()) {
			this.myProfile.click();
		}
		else {
			
		}
	}

	public void clickMySettings() {
		if(this.mySettings.isDisplayed()) {
			this.mySettings.click();
		}
		else {
			
		}
	}

	public void clickDeveloperCosole(WebDriver driver) {
		if(developerCosole.isDisplayed()) {
			if(CommonUtils.waitForElementClickable(driver, developerCosole)) {
				developerCosole.click();
			}
		}
		else {
			
		}
	}

	public void clickSwitchTolightningExp() {
		if(this.switchTolightningExp.isDisplayed()) {
			this.switchTolightningExp.click();
		}
		else {
			
		}
	}

	public void clickLogOut() {
		
		
		if(this.logOut.isDisplayed()) {
			this.logOut.click();
		}
		else {
			
		}
	}

	public List<String> getUserMenuItems() {
		
		List<String> userMenuItems=new ArrayList<String>();
		userMenuItems.add(this.myProfile.getText());
		userMenuItems.add(this.mySettings.getText());
		userMenuItems.add(this.developerCosole.getText());
		userMenuItems.add(this.switchTolightningExp.getText());
		userMenuItems.add(this.logOut.getText());
		
		return userMenuItems;
		
	}
	
      public List<String> getUserMenuItemList() {
		
		List<String> userMenuItems=new ArrayList<String>();
		
		if(this.userMenu.isDisplayed()) {
			this.userMenu.click();
			
		for(WebElement userMenuItem:userMenuItemList) {
			
			userMenuItems.add(userMenuItem.getText());
			System.out.println(userMenuItem.getText());
			
		}
		}
		return userMenuItems;
		
	}

	public boolean verifyDeveloperWindowDisolayed(WebDriver driver) {
		
		boolean isDeveloperWindowDisplayed=false;
		
		
		Set<String> windowHabdles=driver.getWindowHandles();
		List<String> windowHandleList=new ArrayList<String>(windowHabdles);
		
		if(CommonUtils.waitForNumOfWindowsToBe(driver, 2)){
			driver.switchTo().window(windowHandleList.get(1));
			Assert.assertTrue(CommonUtils.waitForTitleOfThePage(driver, "Developer Console"));
			driver.close();
			driver.switchTo().window(windowHandleList.get(0));
			Assert.assertTrue(CommonUtils.waitForTitleOfThePage(driver, "Home Page ~ Salesforce - Developer Edition"));
			isDeveloperWindowDisplayed=true;
			
		}
		
		return isDeveloperWindowDisplayed;
		
		
		
		
		
	}

	public boolean verifyUserNameOnUserMenuBtn(String lastName) {
		
		boolean isUserNameOnUserMenuBtnUpdated=false;
		
		if(userNameInUserMenuBtn.isDisplayed()) {
			if(userNameInUserMenuBtn.getText().contains(lastName)) {
				isUserNameOnUserMenuBtnUpdated=true;
			}
		}
		return isUserNameOnUserMenuBtnUpdated;
	}

}
