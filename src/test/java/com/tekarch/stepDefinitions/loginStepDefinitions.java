///**
// * 
// */
//package com.tekarch.stepDefinitions;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.Duration;
//
//import org.junit.Assert;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.teckarck.constants.TitleConstants;
//import com.tekarch.utils.CommonUtils;
//import com.tekarch.utils.DataProviderClass;
//import com.tekarck.pages.LoginPage;
//
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
///**
// * 
// */
//public class loginStepDefinitions extends BaseStepDefinsClass{
//	
//	String sUserName;
////	String sUserName;
//	String sPassword;
//	String[][] userCreds;
//	
//	
//	
//	
//	@AfterStep
//	public void addScreenshot(Scenario scenario){
//		
////		TakesScreenshot ts=(TakesScreenshot) driver;
////		File src=ts.getScreenshotAs(OutputType.FILE);
//		//validate if scenario has failed
//				if(scenario.isFailed()) {
//					final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//					scenario.attach(screenshot, "image/png", "image"); 
//				}
//		
//	}
//	
//	@Given("Launch App {string}")
//	public void launch_app(String url) {
////		driver=new ChromeDriver();
//		lp=new LoginPage(driver);
//		driver.get(url);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	   
//	}
//	@When("User enters User Name {string}")
//	public void user_enters_user_name(String uName) {
//		sUserName=uName;
//		lp.setUserName(uName, driver);
//		
//		
//	}
//	@When("User clears the Password field")
//	public void user_clears_the_password_field() {
//		lp.setPassword("", driver);
//	}
//	@When("User clicks on the Login button")
//	public void user_clicks_on_the_login_button() {
//		lp.clickLoginBtn(driver);
//	}
//	
//	@When("User enters Password {string}")
//	public void user_enters_password(String password) {
//	    lp.setPassword(password, driver);
//	}
//	
//	@Then("User should be navigated to Home page")
//	public void user_should_be_navigated_to_home_page() {
//		String expectedPagetitle = TitleConstants.HOME_PAGE_TITLE;
//		boolean flag = CommonUtils.waitForTitleOfThePage(driver, expectedPagetitle);
//		Assert.assertTrue(flag);
//	}
//	
//	@Then("User should see the error message {string} should be displayed")
//	public void user_should_see_the_error_message_should_be_displayed(String errorMsg) {
//		boolean isErrorMsgPresent=lp.isErrorMsgDisaplyed(driver,errorMsg);
//		Assert.assertTrue(isErrorMsgPresent);
//	}
//	
//	@When("User slects Remember me check box")
//	public void user_slects_remember_me_check_box() {
//		lp.clickRememberMe();
//	}
//	@When("User clicks on  User Menu button and clicks Log Out button")
//	public void user_clicks_on_user_menu_button_and_clicks_log_out_button() {
//		lp.clickLogoutBtn();
//	}
//	@Then("User Should be navigated to Login Page")
//	public void user_should_be_navigated_to_login_page() {
//		String expectedPagetitle = TitleConstants.LOGIN_PAGE_TITLE;
//		boolean flag = CommonUtils.waitForTitleOfThePage(driver, expectedPagetitle);
//		Assert.assertTrue(flag);
//	}
//	@Then("User Name should be displayed on User name field.")
//	public void user_name_should_be_displayed_on_user_name_field() {
//		 String expecteSavedUserName=sUserName;
//	       String actualSavedUserName=lp.getSavedUserName(driver,expecteSavedUserName);
//			
//			Assert.assertEquals(actualSavedUserName,expecteSavedUserName);
//	}
//
//	
//	@When("User clicks on forgot Password link")
//	public void user_clicks_on_forgot_password_link() {
//		lp.clickForgotPassword();
//	}
//	@Then("User Should be navigated to sales force forgot password page")
//	public void user_should_be_navigated_to_sales_force_forgot_password_page() {
//      String expectedTitle=TitleConstants.FORGOT_PASSWORD_PAGE_TITLE;
//		
//		boolean flag=CommonUtils.waitForTitleOfThePage(driver, expectedTitle);
//		Assert.assertTrue(flag);
//	}
//	@When("User provides user name {string} in the user name field")
//	public void user_provides_user_name_in_the_user_name_field(String sUserName) {
//		lp.setForgotPwdUserName(sUserName);
//	}
//	@When("User clicks on continue button")
//	public void user_clicks_on_continue_button() {
//		lp.clickContinueBtn();
//	}
//	@Then("Passwprd reset message page should be displayed.")
//	public void passwprd_reset_message_page_should_be_displayed() {
//		 String expectedTitle=TitleConstants.CHECK_YOUR_PAGE_TITLE;
//			
//			boolean flag=CommonUtils.waitForTitleOfThePage(driver, expectedTitle);
//			Assert.assertTrue(flag);
//	}
//	@Then("User should get the email to reset the password")
//	public void user_should_get_the_email_to_reset_the_password() {
//		// Email validation code goes here
//		Assert.assertTrue(true);
//	}
//	
//	@When("User enters wrong Password {string}")
//	public void user_enters_wrong_password(String pwd) {
//		lp.setPassword(pwd, driver);
//	}
//	@Then("User should get Error message")
//	public void user_should_get_error_message() {
//     String expectedErr="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
//		
//		boolean isExpectedErrorMsgPresent=lp.isErrorMsgDisaplyed(driver,expectedErr);
//		
//		
//		Assert.assertTrue(isExpectedErrorMsgPresent);
//	}
//	
//	
//	
//
//	@Before("@dataDriven")
//	public void getUserCredsFromJsonFile() throws IOException {
//		
//		userCreds=DataProviderClass.getDataFromJsonFile();
//		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//		System.out.println(userCreds);
//	}
//	
//	
//	@When("User enters User Name and password {int}")
//	public void user_enters_user_name_and_password(Integer rowCount)  {
//		
//		
//		sUserName=userCreds[rowCount][0];
//		sPassword=userCreds[rowCount][1];
//		
//		lp.setUserName(sUserName, driver);
//		lp.setPassword(sPassword, driver);
//	}
//	
//	
//	@After
//	@Then("Close the browser")
//	public void close_the_browser() {
//		driver.quit();
//	}
//	
//	
//
//
//
//
//}
