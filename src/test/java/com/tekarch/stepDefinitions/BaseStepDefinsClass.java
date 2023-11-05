/**
 * 
 */
package com.tekarch.stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.teckarck.constants.FileConstants;
import com.tekarch.utils.FileUtils;
import com.tekarck.pages.AccountsPage;
import com.tekarck.pages.LoginPage;
import com.tekarck.pages.MyProfilePage;
import com.tekarck.pages.MySettingPage;
import com.tekarck.pages.UserMenuPage;


/**
 * 
 */
public class BaseStepDefinsClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public UserMenuPage hp;
	public MyProfilePage myProfilePage;
	public MySettingPage mySettingPage;
	public Logger logger;
	public AccountsPage ap;
	
	
	
	public  void loginToSalesForceApp(WebDriver driver) {
		lp=new LoginPage(driver);
		try {
		lp.setUserName(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PROPERTIES_FILE_PATH, "userName"),driver);
		lp.setPassword(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PROPERTIES_FILE_PATH, "password"),driver);
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		lp.clickLoginBtn(driver);
	}
	
	
	

}
