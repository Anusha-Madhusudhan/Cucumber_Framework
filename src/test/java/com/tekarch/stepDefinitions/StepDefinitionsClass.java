/**
 * 
 */
package com.tekarch.stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import com.teckarck.constants.FileConstants;
import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarch.utils.DataProviderClass;
import com.tekarch.utils.FileUtils;
import com.tekarck.pages.AccountsPage;
import com.tekarck.pages.LoginPage;
import com.tekarck.pages.MyProfilePage;
import com.tekarck.pages.MySettingPage;
import com.tekarck.pages.UserMenuPage;
import com.tekarck.testCases.BaseTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 */
public class StepDefinitionsClass extends BaseStepDefinsClass {
	
	String sUserName;
	String sPassword;
	String[][] userCreds;
	String accountName;
	String viewName;
	String viewNameToBeEdited;
	String newViewName;
	String mergedAccountName;
	
	@Before(order=0)
	public void setUp(Scenario scenario) {
		System.out.println("****************Before Scenario method**************");
		System.out.println("Executing Before the scenario :: "+scenario.getName());
		driver=new ChromeDriver();
		logger=LogManager.getLogger(this.getClass().getName());
		
	}
	
	
	@After(order=0)
	public void tearDown(Scenario scenario) {
		System.out.println("****************After Scenario method**************");
		System.out.println("Executing after the scenario :: "+scenario.getName());
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario){
		
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		File src=ts.getScreenshotAs(OutputType.FILE);
		//validate if scenario has failed
				if(scenario.isFailed()) {
					final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
					scenario.attach(screenshot, "image/png", "image"); 
				}
	}
	
	
	@After("@createNewaccount")
	public void aPostConditiosCreateNewaccount(Scenario scenario) {
		System.out.println("****************After Scenario @createNewaccount method**************");
		System.out.println("Executing after the scenario :: "+scenario.getName());
		System.out.println("Inside the post conditions of create new account test");
		ap.slectAccountFromList(accountName);
		Assert.assertTrue(ap.deleteAccount(accountName,driver));
		System.out.println("Account has been deleted :: "+accountName);
	}
	
	
	@After("@createnewview")
	public void aPostConditiosCreateNewView(Scenario scenario) {
		System.out.println("****************After Scenario @createnewview method**************");
		System.out.println("Executing after the scenario :: "+scenario.getName());
		System.out.println("Inside the post conditions of create new view test");
		 Assert.assertTrue(ap.verifyDeleteViewCreated(viewName,driver));
	}
	
	@Before("@Editview")
	public void preConditionsForEditview(Scenario scenario) {
		System.out.println("****************Before Scenario Editview pre condition method method**************");
		System.out.println("Executing Before the scenario :: "+scenario.getName());
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		loginToSalesForceApp(driver);
		ap=new AccountsPage(driver);
		ap.clickAccountTab();
		ap.clickCreateNewView(driver);
		
		Assert.assertTrue(ap.verifyCreateNewViewPageisDaisplayed(driver));
		String viewName = BaseTest.generateRandomString();
		String viewUniqueName = BaseTest.generateRandomString();
		ap.enterViewName(viewName);
		ap.enterViewUniqueName(viewUniqueName);
		ap.clickSaveBtn(driver);
		Assert.assertTrue(ap.verifyNewViewCreatedAndDisplyed(viewName));
		
		viewNameToBeEdited=viewName;
	}
	
	
	@After("@Editview")
	public void aPostConditiosEditview(Scenario scenario) {
		System.out.println("****************After Scenario @Editview method**************");
		System.out.println("Executing after the scenario :: "+scenario.getName());
		System.out.println("Inside the post conditions of Editview test");
		 Assert.assertTrue(ap.verifyDeleteViewCreated(newViewName,driver));
	}
	
	
	@Before("@MergeAccounts")
	public void preConditionsForMergeAccounts(Scenario scenario) {
		System.out.println("****************Before Scenario Merge accounts pre condition method method**************");
		System.out.println("Executing Before the scenario :: "+scenario.getName());
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		loginToSalesForceApp(driver);
		ap=new AccountsPage(driver);
		ap.clickAccountTab();
		
		List<String> accounts=new ArrayList<String>();
	    accounts.add("abc");
	    accounts.add("abcde");
	    accounts.add("abcdefg");
	    
	    ap.clickNewBtn(driver);
	    
	    for(String s:accounts) {
		Assert.assertTrue(ap.verifyAccountEditPageDisplayed(driver));
		ap.enterAccountName(s);
		ap.clickSaveAndNewBtn(driver);
	    }    
	    
	    ap.clickAccountTab();
	    Assert.assertTrue(ap.verifyAccountPageDisplayed(driver));
	    
	    Assert.assertTrue(ap.verifyAccountsAreCreatd(driver,accounts));
	}
	
	@After("@MergeAccounts")
	public void postConditionsForMergeAccounts(Scenario scenario){
		System.out.println("****************After Scenario @MergeAccounts method**************");
		System.out.println("Executing after the scenario :: "+scenario.getName());
		System.out.println("Inside the post conditions of @MergeAccounts test");
		System.out.println(mergedAccountName);
		ap.slectAccountFromList(mergedAccountName);
		   
		Assert.assertTrue(ap.deleteAccount(mergedAccountName,driver));
	}
	
	@Given("Launch App {string}")
	public void launch_app(String url) {
//		driver=new ChromeDriver();
		lp=new LoginPage(driver);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   
	}
	@When("User enters User Name {string}")
	public void user_enters_user_name(String uName) {
		sUserName=uName;
		lp.setUserName(uName, driver);
		
		
	}
	@When("User clears the Password field")
	public void user_clears_the_password_field() {
		lp.setPassword("", driver);
	}
	@When("User clicks on the Login button")
	public void user_clicks_on_the_login_button() {
		lp.clickLoginBtn(driver);
	}
	
	@When("User enters Password {string}")
	public void user_enters_password(String password) {
	    lp.setPassword(password, driver);
	}
	
	@Then("User should be navigated to Home page")
	public void user_should_be_navigated_to_home_page() {
		String expectedPagetitle = TitleConstants.HOME_PAGE_TITLE;
		boolean flag = CommonUtils.waitForTitleOfThePage(driver, expectedPagetitle);
		Assert.assertTrue(flag);
	}
	
	@Then("User should see the error message {string} should be displayed")
	public void user_should_see_the_error_message_should_be_displayed(String errorMsg) {
		boolean isErrorMsgPresent=lp.isErrorMsgDisaplyed(driver,errorMsg);
		Assert.assertTrue(isErrorMsgPresent);
	}
	
	@When("User slects Remember me check box")
	public void user_slects_remember_me_check_box() {
		lp.clickRememberMe();
	}
	@When("User clicks on  User Menu button and clicks Log Out button")
	public void user_clicks_on_user_menu_button_and_clicks_log_out_button() {
		lp.clickLogoutBtn();
	}
	@Then("User Should be navigated to Login Page")
	public void user_should_be_navigated_to_login_page() {
		String expectedPagetitle = TitleConstants.LOGIN_PAGE_TITLE;
		boolean flag = CommonUtils.waitForTitleOfThePage(driver, expectedPagetitle);
		Assert.assertTrue(flag);
	}
	@Then("User Name should be displayed on User name field.")
	public void user_name_should_be_displayed_on_user_name_field() {
		 String expecteSavedUserName=sUserName;
	       String actualSavedUserName=lp.getSavedUserName(driver,expecteSavedUserName);
			
			Assert.assertEquals(actualSavedUserName,expecteSavedUserName);
	}

	
	@When("User clicks on forgot Password link")
	public void user_clicks_on_forgot_password_link() {
		lp.clickForgotPassword();
	}
	@Then("User Should be navigated to sales force forgot password page")
	public void user_should_be_navigated_to_sales_force_forgot_password_page() {
      String expectedTitle=TitleConstants.FORGOT_PASSWORD_PAGE_TITLE;
		
		boolean flag=CommonUtils.waitForTitleOfThePage(driver, expectedTitle);
		Assert.assertTrue(flag);
	}
	@When("User provides user name {string} in the user name field")
	public void user_provides_user_name_in_the_user_name_field(String sUserName) {
		lp.setForgotPwdUserName(sUserName);
	}
	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		lp.clickContinueBtn();
	}
	@Then("Passwprd reset message page should be displayed.")
	public void passwprd_reset_message_page_should_be_displayed() {
		 String expectedTitle=TitleConstants.CHECK_YOUR_PAGE_TITLE;
			
			boolean flag=CommonUtils.waitForTitleOfThePage(driver, expectedTitle);
			Assert.assertTrue(flag);
	}
	@Then("User should get the email to reset the password")
	public void user_should_get_the_email_to_reset_the_password() {
		// Email validation code goes here
		Assert.assertTrue(true);
	}
	
	@When("User enters wrong Password {string}")
	public void user_enters_wrong_password(String pwd) {
		lp.setPassword(pwd, driver);
	}
	@Then("User should get Error message")
	public void user_should_get_error_message() {
     String expectedErr="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		boolean isExpectedErrorMsgPresent=lp.isErrorMsgDisaplyed(driver,expectedErr);
		
		
		Assert.assertTrue(isExpectedErrorMsgPresent);
	}
	
	
	

	@Before("@dataDriven")
	public void getUserCredsFromJsonFile() throws IOException {
		
		userCreds=DataProviderClass.getDataFromJsonFile();
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println(userCreds);
	}
	
	
	@When("User enters User Name and password {int}")
	public void user_enters_user_name_and_password(Integer rowCount)  {
		
		
		sUserName=userCreds[rowCount][0];
		sPassword=userCreds[rowCount][1];
		
		lp.setUserName(sUserName, driver);
		lp.setPassword(sPassword, driver);
	}
	
	
//	@After
//	@Then("Close the browser")
//	public void close_the_browser() {
//		driver.quit();
//	}
	
	

	@Given("User should Launch and login to the application {string}")
	public void user_should_launch_and_login_to_the_application(String url) {
//		driver=new ChromeDriver();
		
		hp=new UserMenuPage(driver);
		myProfilePage=new MyProfilePage(driver);
		
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		loginToSalesForceApp(driver);
		
	}
	@When("User clicks on the User Menu drop down on the home page")
	public void user_clicks_on_the_user_menu_drop_down_on_the_home_page() {
		hp.clickUserMenu();
	}
	@Then("User should be able to see the drop down options")
	public void user_should_be_able_to_see_the_drop_down_options(DataTable dataTable) {
		
		List<String> actualMenuItems=hp.getUserMenuItems();
		
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		
//		System.err.println(dataTable.asLists());
//		
//		List<List<String>> expectedMenuItems=dataTable.asLists();
//		System.out.println("Expected menu items from data table");
//		 int i = 0;
//			boolean flag = false;
//			for (String str : actualMenuItems) {
//				
//				System.out.println(expectedMenuItems.get(0).get(i));
//				System.out.println(str);
//				if (str.equals(expectedMenuItems.get(0).get(i))) {
//					
//					i++;
//					flag = true;
//				} else {
//					flag = false;
//					break;
//				}
//
//			}
		
		System.err.println(dataTable.asMaps());
		
		List<Map<String, String>> expectedMenuItems=dataTable.asMaps();
		
		
		System.out.println("Expected menu items from data table");
		 int i = 0;
			boolean flag = false;
			for (String str : actualMenuItems) {
				
				System.out.println(expectedMenuItems.get(i).get("UserMenuItems"));
				System.out.println(str);
				if (str.equals(expectedMenuItems.get(i).get("UserMenuItems"))) {
					
					i++;
					flag = true;
				} else {
					flag = false;
					break;
				}

			}
		
		   Assert.assertTrue(flag);
	    
	}
	
	
	@When("User clicks on the  {string} option from user menu drop down")
	public void user_clicks_on_the_option_from_user_menu_drop_down(String sOption) {
		hp.clickUserMenu();
		hp.clickMyProfile();
		
	}

	@Then("User Sould see the User profile page")
	public void user_sould_see_the_user_profile_page() {
        CommonUtils.waitForElementClickable(driver, myProfilePage.getProfilePage());
		
		Assert.assertTrue(myProfilePage.isMyProfilePageIsVisible());
		
		
	}

	@When("User Clicks on edit profile button to edit contact information")
	public void user_clicks_on_edit_profile_button_to_edit_contact_information() {
		Assert.assertTrue(myProfilePage.clickEditMyProfile(driver));
		
	}

	@Then("Edit profile pop up window is displayed with contact and About tabs to edit.")
	public void edit_profile_pop_up_window_is_displayed_with_contact_and_about_tabs_to_edit() {
		
		myProfilePage.switchFrame(driver);
	}

	@When("User Clicks on About tab and enter {string}")
	public void user_clicks_on_about_tab_and_enter(String sLastName) {
		
		myProfilePage.clickAboutTab();
		myProfilePage.setLastName(sLastName);
	}

	@When("User clicks on save all button")
	public void user_clicks_on_save_all_button() {
		myProfilePage.clickSaveAll(driver);
	}

	@Then("UserProfilePage with changed {string} is displayed")
	public void user_profile_page_with_changed_is_displayed(String sLastName) {
		Assert.assertTrue(myProfilePage.verifyEditedLastName(sLastName));
	}

	@When("User Clicks on Post link,")
	public void user_clicks_on_post_link() {
		myProfilePage.clickPost(driver);
	}

	@When("User enters the {string} to post in the post text area and click on share button")
	public void user_enters_the_to_post_in_the_post_text_area_and_click_on_share_button(String sText) {
		myProfilePage.switchToPostFrame(driver);
		myProfilePage.setpostText(driver,sText);
        driver.switchTo().defaultContent();
		
		myProfilePage.clickShare();
	}

	@Then("{string} entered should be displayed on the page")
	public void entered_should_be_displayed_on_the_page(String sText) {
		Assert.assertTrue(myProfilePage.verifyPostText(driver,sText));
	}

	@When("User clicks on the  file link and click on upload a file from computer button.")
	public void user_clicks_on_the_file_link_and_click_on_upload_a_file_from_computer_button() {
		Assert.assertTrue(myProfilePage.isMyProfilePageIsVisible());
		myProfilePage.clickFile(driver);
		myProfilePage.clickUpLoadFile(driver);
	}

	@When("User Clicks on choose file button and select a file to be uploaded and click open button.")
	public void user_clicks_on_choose_file_button_and_select_a_file_to_be_uploaded_and_click_open_button() {
		String filePath=FileConstants.UPLOAD_FILE_PATH;
		myProfilePage.sendFile(filePath);
		myProfilePage.clickShare();
	}

	@Then("Selected file should be posted")
	public void selected_file_should_be_posted() {
		Assert.assertTrue(myProfilePage.verifyUploadedFileName(driver,"testData"));
	}

	@When("User Hover the mouse on myprofilephoto image and Add photo link appears.")
	public void user_hover_the_mouse_on_myprofilephoto_image_and_add_photo_link_appears() {
		Assert.assertTrue(myProfilePage.isMyProfilePageIsVisible());
	}

	@When("User Clicks on the link to upload a photo.")
	public void user_clicks_on_the_link_to_upload_a_photo() {
		myProfilePage.clickUploadPhoto(driver);
	}

	@When("User Clicks on Choose file button and select the image to upload.")
	public void user_clicks_on_choose_file_button_and_select_the_image_to_upload() {
		myProfilePage.switchtoUploadPhotoIFrameID(driver);
		myProfilePage.sendphoto(FileConstants.UPLOAD_PHOTO_PATH);
		
		myProfilePage.clickSaveBtn();
		
		myProfilePage.waitForSpinnerDisapear(driver);
		
		myProfilePage.clickCropSaveBtn(driver);
		
		driver.switchTo().defaultContent();
	}

	@Then("Uploaded photo should appear on the image.")
	public void uploaded_photo_should_appear_on_the_image() {
		
	}
	
	
	@When("User Click My Settings option from user menu")
	public void user_click_my_settings_option_from_user_menu() {
		hp.clickUserMenu();
		hp.clickMySettings();
	}

	@Then("My Settings page is displayed")
	public void my_settings_page_is_displayed() throws IOException {
		mySettingPage=new MySettingPage(driver);
		String expectedText="My Settings";
		Assert.assertTrue(mySettingPage.verifyMySettingPageDisplayed(expectedText,driver));
	}

	@When("User Clicks on personal link and select Login History link.")
	public void user_clicks_on_personal_link_and_select_login_history_link() {
		mySettingPage.clickPersonalLink();
		mySettingPage.clickLoginHistory();
	}

	@When("Click on Download login  history link.")
	public void click_on_download_login_history_link() {
		Assert.assertTrue(mySettingPage.clickDownloadLogin(driver));
	}

	@Then("Login history is displayed and the data is downloaded in .csv format.")
	public void login_history_is_displayed_and_the_data_is_downloaded_in_csv_format() throws IOException {
      driver.navigate().back();
		
		Assert.assertTrue(mySettingPage.verifyMySettingPageDisplayed("My Settings",driver));
		
		Assert.assertTrue(mySettingPage.verifyFileDownloaded());

	}

	@When("User Clicks on Display & Layout link and select Customize My Tabs link.")
	public void user_clicks_on_display_layout_link_and_select_customize_my_tabs_link() {
		mySettingPage.clickDispalyAndLayoutLink();
		mySettingPage.clickCustomizeTabs();
	}

	@When("User Selects Salesforce Chatter option from custom App: drop down.")
	public void user_selects_salesforce_chatter_option_from_custom_app_drop_down() {
		mySettingPage.selectSalesForceChatter("Salesforce Chatter");
	}

	@When("User Selects Reports tab from Available Tabs list.")
	public void user_selects_reports_tab_from_available_tabs_list() {
		if (!mySettingPage.selectReportTab("Reports")) {

			mySettingPage.clickAddBtn();
		}
	}

	@When("Click on >\\(Add) button.")
	public void click_on_add_button() {
		mySettingPage.clickSaveBtn();
	}

	@Then("Reports field is added to Selected Tabs list and also added in the links available in top of salesforce page and sales force chatter page and sales and marketing pages.")
	public void reports_field_is_added_to_selected_tabs_list_and_also_added_in_the_links_available_in_top_of_salesforce_page_and_sales_force_chatter_page_and_sales_and_marketing_pages() {

	}

	@When("User Clicks on Email link and click on my email settings link under that")
	public void user_clicks_on_email_link_and_click_on_my_email_settings_link_under_that() {
		mySettingPage.clickEmail();
		mySettingPage.clickEmailSettings();
	}

	@When("User Provides {string} in Email Name field, {string} in Email Address field,")
	public void user_provides_in_email_name_field_in_email_address_field(String emailName, String emailAddress) {
		mySettingPage.setEmailName(emailName);
		mySettingPage.setEmailAddress(emailAddress);
	}

	@When("Select automatic BCC radio button")
	public void select_automatic_bcc_radio_button() {
		mySettingPage.selectAutomaticBCC();
	}

	@When("click on save button")
	public void click_on_save_button() {
		mySettingPage.clickSaveBtn();
	}

	@Then("provided details are saved as default mail options and My settings page is displayed.")
	public void provided_details_are_saved_as_default_mail_options_and_my_settings_page_is_displayed() {
		Assert.assertTrue(mySettingPage.verifyEmailUpdation(driver));

		String expectedTitle = TitleConstants.MY_EMAIL_SETTINGS_TITLE;

		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(driver, expectedTitle));
	}

	@When("User Clicks on Calendar & Remainders")
	public void user_clicks_on_calendar_remainders() {
		mySettingPage.clickCalenderAndRamainder();
	}

	@When("User clicks on Activity Remainders link.")
	public void user_clicks_on_activity_remainders_link() {
		mySettingPage.clickActivityRemainder();
	}

	@When("On Remainders page click on Open a test Remainder button.")
	public void on_remainders_page_click_on_open_a_test_remainder_button() {
		mySettingPage.clickOpenTestRemainder(driver);
	}

	@Then("Sample event pop window is dispayed.")
	public void sample_event_pop_window_is_dispayed() {
		Assert.assertTrue(mySettingPage.verifyThePopUpWindow(driver));
	}
	
	
	@When("User Clicks on Developer Console link from the User Menu drop down")
	public void user_clicks_on_developer_console_link_from_the_user_menu_drop_down() {
		hp.clickUserMenu();
		hp.clickDeveloperCosole(driver);
	}
	@Then("Force.com Developer Console window is displayed")
	public void force_com_developer_console_window_is_displayed() {
		boolean isDeveloperWindowDisplayed=false;
		Set<String> windowHabdles=driver.getWindowHandles();
		List<String> windowHandleList=new ArrayList<String>(windowHabdles);
		
		if(CommonUtils.waitForNumOfWindowsToBe(driver, 2)){
			driver.switchTo().window(windowHandleList.get(1));
			Assert.assertTrue(CommonUtils.waitForTitleOfThePage(driver, "Developer Console"));
			
			isDeveloperWindowDisplayed=true;
			
		}
		Assert.assertTrue(isDeveloperWindowDisplayed);
		
	}
	@When("User Clicks on close button the developer console browser")
	public void user_clicks_on_close_button_the_developer_console_browser() {
		driver.close();
		
	}
	@Then("Force.com Developer Console window is closed")
	public void force_com_developer_console_window_is_closed() {
		Set<String> windowHabdles=driver.getWindowHandles();
		List<String> windowHandleList=new ArrayList<String>(windowHabdles);
		driver.switchTo().window(windowHandleList.get(0));
		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(driver, "Home Page ~ Salesforce - Developer Edition"));
	}
	
	@When("User Clicks on Logout option from the User Menu drop down")
	public void user_clicks_on_logout_option_from_the_user_menu_drop_down() {
		hp.clickUserMenu();
		hp.clickLogOut();
	}
	@Then("Logout  of current sales force application  and Login page is displayed.")
	public void logout_of_current_sales_force_application_and_login_page_is_displayed() {
		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.LOGIN_PAGE_TITLE));
	}
	
	

	@When("User Clicks on Accounts link on the home page")
	public void user_clicks_on_accounts_link_on_the_home_page() {
		ap=new AccountsPage(driver);
		ap.clickAccountTab();
	}

	@Then("Accounts page is displayed with correct UserName")
	public void accounts_page_is_displayed_with_correct_user_name() {
		Assert.assertTrue(ap.verifyAccountPageDisplayed(driver));
	}

	@When("User Clicks on the New button to create new account")
	public void user_clicks_on_the_new_button_to_create_new_account() {
		ap.clickNewBtn(driver);
	}

	@Then("New Account edit page is displayed.")
	public void new_account_edit_page_is_displayed() {
		Assert.assertTrue(ap.verifyAccountEditPageDisplayed(driver));
	}

	@When("User enters Account name  select type as Technology partner from drop down, set coustomer priority as high")
	public void user_enters_account_name_select_type_as_technology_partner_from_drop_down_set_coustomer_priority_as_high() throws IOException {
		accountName=BaseTest.generateRandomString();
		ap.enterAccountName(accountName);
		ap.selectType(FileUtils.readPropertiesFile(FileConstants.ACCOUNTS_TEST_DATA_FILE_PATH, "type"));
		ap.selectCustomerPriority(FileUtils.readPropertiesFile(FileConstants.ACCOUNTS_TEST_DATA_FILE_PATH, "priority"));
	}

	@When("User clicks on save button")
	public void user_clicks_on_save_button1() {
		ap.clickSaveBtn(driver);
	}
	@Then("New account page is displayed with account details.")
	public void new_account_page_is_displayed_with_account_details() {
		Assert.assertTrue(ap.verifyAccountIsCreatd(driver,accountName));
	}

	@When("User Clicks on create new view link on accounts page")
	public void user_clicks_on_create_new_view_link_on_accounts_page() {
		ap.clickCreateNewView(driver);
		 Assert.assertTrue(ap.verifyCreateNewViewPageisDaisplayed(driver));
	}

	@When("User provides View name, View unique name and click on save button")
	public void user_provides_view_name_view_unique_name_and_click_on_save_button() {
		    viewName=BaseTest.generateRandomString();
		    String viewUniqueName=BaseTest.generateRandomString();
		    ap.enterViewName(viewName);
		    ap.enterViewUniqueName(viewUniqueName);
		    ap.clickSaveBtn(driver);
	}

	@Then("Newely added View should be displayed in the account view list")
	public void newely_added_view_should_be_displayed_in_the_account_view_list() {
		Assert.assertTrue(ap.verifyNewViewCreatedAndDisplyed(viewName));
	}

	@When("User selects the view name from the view drop down list on the account page")
	public void user_selects_the_view_name_from_the_view_drop_down_list_on_the_account_page() {
		newViewName = BaseTest.generateRandomString();
		ap.selectViewNameToEdit(viewNameToBeEdited);
	}

	@When("User clicks on the Edit link the accounts page.")
	public void user_clicks_on_the_edit_link_the_accounts_page() {
		ap.clickGoBtn(driver);
		ap.clickEdit(driver);
	}

	@Then("View name edit page Is displayed")
	public void view_name_edit_page_is_displayed() {
		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.EDIT_VIEW_PAGE_TITLE));
		Assert.assertTrue(ap.verifyViewNameToBeEditedOnEditPage(driver, viewNameToBeEdited));
	}

	@When("User Change the view name to new view name.")
	public void user_change_the_view_name_to_new_view_name() {
		ap.enterNewVieName(newViewName);
	}

	@When("Select the filters field , operator , Value in Select fields to display,")
	public void select_the_filters_field_operator_value_in_select_fields_to_display(io.cucumber.datatable.DataTable dataTable) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    List<Map<String,String>> list=dataTable.asMaps();
	    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	    System.out.println(list);
	    
	    ap.selectField(list.get(0).get("filters field"));
		ap.selectOperator(list.get(0).get("operator"));
		ap.enterValue(list.get(0).get("Value"));
		Assert.assertTrue(ap.selectAvailabeFields(
				FileUtils.readPropertiesFile(FileConstants.ACCOUNTS_TEST_DATA_FILE_PATH, "fieldToDispaly")));
		ap.clickAddBtn();
	}

	@When("User  Clicks on save button.")
	public void user_clicks_on_save_button() {
		ap.clickSaveBtn(driver);
	}

	@Then("View page with New view name in the drop down is displayed.")
	public void view_page_with_new_view_name_in_the_drop_down_is_displayed() {
		Assert.assertTrue(ap.verifyTheEditedNewViewNameDisplayed(newViewName));
	}

	@Then("View will have Last activity column added and the data of the list will have all account names which has a in the text.")
	public void view_will_have_last_activity_column_added_and_the_data_of_the_list_will_have_all_account_names_which_has_a_in_the_text() throws IOException {
		Assert.assertTrue(ap.verifyTheColumnAddedToViewTable(FileUtils.readPropertiesFile(FileConstants.ACCOUNTS_TEST_DATA_FILE_PATH, "fieldToDispaly")));
		Assert.assertTrue(ap.verifyAccountNameContainsLetterADispalyed("a"));
	}

	@When("On the accounts page in Tools area, click on Merge Accounts link.")
	public void on_the_accounts_page_in_tools_area_click_on_merge_accounts_link() {
		ap.clickMergeAccountsLink();
		Assert.assertTrue(ap.verifyMergeAccountPageDisplayed(driver));
	}

	@When("User enters the Account name in the text box of merge accounts page and click Find accounts button.")
	public void user_enters_the_account_name_in_the_text_box_of_merge_accounts_page_and_click_find_accounts_button() {
		ap.enterTextToFindAccountToMerge("abc");
		ap.clickFindAccountBtn();
	}

	@When("Entered Account name should result in atleast {int} or more account links. Select first two account links displayed in the list")
	public void entered_account_name_should_result_in_atleast_or_more_account_links_select_first_two_account_links_displayed_in_the_list(Integer int1) {
		List<String> accountsToBeMerged=ap.mergeAccounts();
		Assert.assertTrue(ap.verifyMergeMyAccountsDisplayed(driver,accountsToBeMerged));
	}

	@When("click on Next button")
	public void click_on_next_button() {
	}

	@Then("Merge by Accounts step two page is displayed with the selected accounts details to merge")
	public void merge_by_accounts_step_two_page_is_displayed_with_the_selected_accounts_details_to_merge() {
		mergedAccountName=ap.getMergedAccountName();
	}

	@When("Click on Merge button on Merge by accounts step two page.")
	public void click_on_merge_button_on_merge_by_accounts_step_two_page() {
		ap.clickMergeBtn(driver);
	}

	@When("Click on OK button on the pop up.")
	public void click_on_ok_button_on_the_pop_up() {
	}

	@Then("Once the accounts are merged, account page is displayed. In recently viewed view, new merged account is listed.")
	public void once_the_accounts_are_merged_account_page_is_displayed_in_recently_viewed_view_new_merged_account_is_listed() {
		Assert.assertTrue(ap.verifyAccountPageDisplayed(driver));
	}

	@When("User clicks on Accounts with last activity > {int} days link in reports area on accounts page.")
	public void user_clicks_on_accounts_with_last_activity_days_link_in_reports_area_on_accounts_page(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Unsaved Repoet page is diaplayed")
	public void unsaved_repoet_page_is_diaplayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User Selects create date in the date field drop down, select todays date in From and To fileds on the unsaved report filed")
	public void user_selects_create_date_in_the_date_field_drop_down_select_todays_date_in_from_and_to_fileds_on_the_unsaved_report_filed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("List of accounts qualified is displayed")
	public void list_of_accounts_qualified_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User Clicks on the save button on unsaved report page.")
	public void user_clicks_on_the_save_button_on_unsaved_report_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Provide report name, report unique name in the pop window and click on save and run report button.")
	public void provide_report_name_report_unique_name_in_the_pop_window_and_click_on_save_and_run_report_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Report page with details and report name is displayed.")
	public void report_page_with_details_and_report_name_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	

}
