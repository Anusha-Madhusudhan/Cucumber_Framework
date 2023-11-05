package com.tekarck.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tekarch.utils.CommonUtils;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(how = How.ID,using = "username")
	private WebElement userName;
	
	
	@FindBy(id = "password")
	private WebElement password;
	
	
	@FindBy(id="Login")
	private WebElement loginBtn;
	
	
	@FindBy(xpath="//div[@id='userNav-menuItems']//a[@title='Logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//div[@id='userNav']")
	private WebElement userMenuBtn;
	
	
	@FindBy(xpath ="//div[substring-before(@class,'remember')]//child::input")
	private WebElement rememberMe;
	
	
	@FindBy(xpath="//div[@class='w0 links bt pt16 mb20']//a")
	private WebElement forgotPassword;
	
	
	@FindBy(xpath ="//div[@id='error']")
	private WebElement errorMsg;
	
	@FindBy(xpath ="//div[@class='verifyform']//input[2]")
	private WebElement continueBtn;
	
	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;
	
	
	@FindBy(id = "un")
	public WebElement forgotPwdUserName;
	
	
	
	

	
	public String getSavedUserName(WebDriver driver,String sExpectedText) {
		
		String savedUserName = null;
//		if(this.savedUsername.isDisplayed()) {
		if(CommonUtils.waitForElementToVisible(driver, savedUsername)) {
			if(CommonUtils.waitForText(driver, savedUsername, sExpectedText)) {
				savedUserName=this.savedUsername.getText();
			}
			
		}
		else {
			savedUserName=null;
		}
		return savedUserName;
	}
	

	public void setUserName(String userName,WebDriver driver) {
		if(CommonUtils.waitForElementToVisible(driver, this.userName)) {
			this.userName.clear();
		this.userName.sendKeys(userName);
		}
		else {
			System.out.println("User name is not diesplyed");
		}
	}

	
	public void setForgotPwdUserName(String userName) {
		if(this.forgotPwdUserName.isDisplayed()) {
			this.forgotPwdUserName.clear();
		this.forgotPwdUserName.sendKeys(userName);
		}
		else {
			System.out.println("User name is not diesplyed");
		}
	}

	

	public void setPassword(String password,WebDriver driver) {
		
		if(CommonUtils.waitForElementToVisible(driver, this.password)) {
			this.password.clear();
			this.password.sendKeys(password);
			}
			else {
				System.out.println("Password is not diesplyed");
			}
		
	}

	

	public void clickLoginBtn(WebDriver driver) {
		
		if(CommonUtils.waitForElementClickable(driver, this.loginBtn)) {
			this.loginBtn.click();
		}else {
			System.out.println("Login btn is not displayed");
		}
		
	}
	
	
     public void clickLogoutBtn() {
    	 
    	 clickUserMenuBtn();
		
		if(this.logoutBtn.isDisplayed()) {
			this.logoutBtn.click();
		}else {
			System.out.println("Logout btn is not displayed");
		}
		
	}
     
     
     public void clickUserMenuBtn() {
 		
 		if(this.userMenuBtn.isDisplayed()) {
 			this.userMenuBtn.click();
 		}else {
 			System.out.println("User Menu btn is not displayed");
 		}
 		
 	}

	

	public void clickRememberMe() {
		
		if(this.rememberMe.isSelected()) {
			System.out.println("Remember me check bo already selected");
		}
		else {
			this.rememberMe.click();
		}
		
	}

	

	public void clickForgotPassword() {
		
		if(this.forgotPassword.isDisplayed()) {
			this.forgotPassword.click();
		}else {
			System.out.println("forgot password is not displayed");
		}
		
		
		
	}

	public boolean isErrorMsgDisaplyed(WebDriver driver, String expectedErrorMsg) {
		
		boolean isErrorMessageMatched=false;
//		if(this.errorMsg.isDisplayed()) {
		if(CommonUtils.waitForElementToVisible(driver, errorMsg)) {
			if(CommonUtils.waitForText(driver, errorMsg, expectedErrorMsg)) {
				isErrorMessageMatched=true;
			}
			else {
				isErrorMessageMatched=false;
			}

		}
		else {
			System.out.println("Error message not displayed");
		}
		
		return isErrorMessageMatched;
	}

	

	

	public void clickContinueBtn() {
		

		if(this.continueBtn.isDisplayed()) {
			this.continueBtn.click();
		}else {
			System.out.println("continue btn is not displayed");
		}
		
	}


	public String getErrorMsg(WebDriver driver) {
		String errorMessage;
//		if(errorMsg.isDisplayed()) {
		if(CommonUtils.waitForElementToVisible(driver, errorMsg)) {
			errorMessage=errorMsg.getText();
			
		}
		else {
			errorMessage=null;
			System.out.println("Error message not displayed");
		}
		return errorMessage;
	}
	
	
	
	
	

}
