///**
// * 
// */
//package com.tekarch.stepDefinitions;
//
//import java.io.IOException;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//import com.teckarck.constants.FileConstants;
//import com.teckarck.constants.TitleConstants;
//import com.tekarch.utils.CommonUtils;
//import com.tekarck.pages.LoginPage;
//import com.tekarck.pages.MyProfilePage;
//import com.tekarck.pages.MySettingPage;
//import com.tekarck.pages.UserMenuPage;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import io.cucumber.java.en.*;
//
///**
// * 
// */
//public class UserMenuStepDefinitions extends BaseStepDefinsClass {
//	
//	
//	
//	
//	
//	
//	@Given("User should Launch and login to the application {string}")
//	public void user_should_launch_and_login_to_the_application(String url) {
////		driver=new ChromeDriver();
//		
//		hp=new UserMenuPage(driver);
//		myProfilePage=new MyProfilePage(driver);
//		
//		
//		driver.get(url);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		loginToSalesForceApp(driver);
//		
//	}
//	@When("User clicks on the User Menu drop down on the home page")
//	public void user_clicks_on_the_user_menu_drop_down_on_the_home_page() {
//		hp.clickUserMenu();
//	}
//	@Then("User should be able to see the drop down options")
//	public void user_should_be_able_to_see_the_drop_down_options(DataTable dataTable) {
//		
//		List<String> actualMenuItems=hp.getUserMenuItems();
//		
//	    // Write code here that turns the phrase above into concrete actions
//	    // For automatic transformation, change DataTable to one of
//	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
//	    //
//	    // For other transformations you can register a DataTableType.
//		
//		
////		System.err.println(dataTable.asLists());
////		
////		List<List<String>> expectedMenuItems=dataTable.asLists();
////		System.out.println("Expected menu items from data table");
////		 int i = 0;
////			boolean flag = false;
////			for (String str : actualMenuItems) {
////				
////				System.out.println(expectedMenuItems.get(0).get(i));
////				System.out.println(str);
////				if (str.equals(expectedMenuItems.get(0).get(i))) {
////					
////					i++;
////					flag = true;
////				} else {
////					flag = false;
////					break;
////				}
////
////			}
//		
//		System.err.println(dataTable.asMaps());
//		
//		List<Map<String, String>> expectedMenuItems=dataTable.asMaps();
//		
//		
//		System.out.println("Expected menu items from data table");
//		 int i = 0;
//			boolean flag = false;
//			for (String str : actualMenuItems) {
//				
//				System.out.println(expectedMenuItems.get(i).get("UserMenuItems"));
//				System.out.println(str);
//				if (str.equals(expectedMenuItems.get(i).get("UserMenuItems"))) {
//					
//					i++;
//					flag = true;
//				} else {
//					flag = false;
//					break;
//				}
//
//			}
//		
//		   Assert.assertTrue(flag);
//	    
//	}
//	
//	
//	@When("User clicks on the  {string} option from user menu drop down")
//	public void user_clicks_on_the_option_from_user_menu_drop_down(String sOption) {
//		hp.clickUserMenu();
//		hp.clickMyProfile();
//		
//	}
//
//	@Then("User Sould see the User profile page")
//	public void user_sould_see_the_user_profile_page() {
//        CommonUtils.waitForElementClickable(driver, myProfilePage.getProfilePage());
//		
//		Assert.assertTrue(myProfilePage.isMyProfilePageIsVisible());
//		
//		
//	}
//
//	@When("User Clicks on edit profile button to edit contact information")
//	public void user_clicks_on_edit_profile_button_to_edit_contact_information() {
//		Assert.assertTrue(myProfilePage.clickEditMyProfile(driver));
//		
//	}
//
//	@Then("Edit profile pop up window is displayed with contact and About tabs to edit.")
//	public void edit_profile_pop_up_window_is_displayed_with_contact_and_about_tabs_to_edit() {
//		
//		myProfilePage.switchFrame(driver);
//	}
//
//	@When("User Clicks on About tab and enter {string}")
//	public void user_clicks_on_about_tab_and_enter(String sLastName) {
//		
//		myProfilePage.clickAboutTab();
//		myProfilePage.setLastName(sLastName);
//	}
//
//	@When("User clicks on save all button")
//	public void user_clicks_on_save_all_button() {
//		myProfilePage.clickSaveAll(driver);
//	}
//
//	@Then("UserProfilePage with changed {string} is displayed")
//	public void user_profile_page_with_changed_is_displayed(String sLastName) {
//		Assert.assertTrue(myProfilePage.verifyEditedLastName(sLastName));
//	}
//
//	@When("User Clicks on Post link,")
//	public void user_clicks_on_post_link() {
//		myProfilePage.clickPost(driver);
//	}
//
//	@When("User enters the {string} to post in the post text area and click on share button")
//	public void user_enters_the_to_post_in_the_post_text_area_and_click_on_share_button(String sText) {
//		myProfilePage.switchToPostFrame(driver);
//		myProfilePage.setpostText(driver,sText);
//        driver.switchTo().defaultContent();
//		
//		myProfilePage.clickShare();
//	}
//
//	@Then("{string} entered should be displayed on the page")
//	public void entered_should_be_displayed_on_the_page(String sText) {
//		Assert.assertTrue(myProfilePage.verifyPostText(driver,sText));
//	}
//
//	@When("User clicks on the  file link and click on upload a file from computer button.")
//	public void user_clicks_on_the_file_link_and_click_on_upload_a_file_from_computer_button() {
//		Assert.assertTrue(myProfilePage.isMyProfilePageIsVisible());
//		myProfilePage.clickFile(driver);
//		myProfilePage.clickUpLoadFile(driver);
//	}
//
//	@When("User Clicks on choose file button and select a file to be uploaded and click open button.")
//	public void user_clicks_on_choose_file_button_and_select_a_file_to_be_uploaded_and_click_open_button() {
//		String filePath=FileConstants.UPLOAD_FILE_PATH;
//		myProfilePage.sendFile(filePath);
//		myProfilePage.clickShare();
//	}
//
//	@Then("Selected file should be posted")
//	public void selected_file_should_be_posted() {
//		Assert.assertTrue(myProfilePage.verifyUploadedFileName(driver,"testData"));
//	}
//
//	@When("User Hover the mouse on myprofilephoto image and Add photo link appears.")
//	public void user_hover_the_mouse_on_myprofilephoto_image_and_add_photo_link_appears() {
//		Assert.assertTrue(myProfilePage.isMyProfilePageIsVisible());
//	}
//
//	@When("User Clicks on the link to upload a photo.")
//	public void user_clicks_on_the_link_to_upload_a_photo() {
//		myProfilePage.clickUploadPhoto(driver);
//	}
//
//	@When("User Clicks on Choose file button and select the image to upload.")
//	public void user_clicks_on_choose_file_button_and_select_the_image_to_upload() {
//		myProfilePage.switchtoUploadPhotoIFrameID(driver);
//		myProfilePage.sendphoto(FileConstants.UPLOAD_PHOTO_PATH);
//		
//		myProfilePage.clickSaveBtn();
//		
//		myProfilePage.waitForSpinnerDisapear(driver);
//		
//		myProfilePage.clickCropSaveBtn(driver);
//		
//		driver.switchTo().defaultContent();
//	}
//
//	@Then("Uploaded photo should appear on the image.")
//	public void uploaded_photo_should_appear_on_the_image() {
//		
//	}
//	
//	
//	@When("User Click My Settings option from user menu")
//	public void user_click_my_settings_option_from_user_menu() {
//		hp.clickUserMenu();
//		hp.clickMySettings();
//	}
//
//	@Then("My Settings page is displayed")
//	public void my_settings_page_is_displayed() throws IOException {
//		mySettingPage=new MySettingPage(driver);
//		String expectedText="My Settings";
//		Assert.assertTrue(mySettingPage.verifyMySettingPageDisplayed(expectedText,driver));
//	}
//
//	@When("User Clicks on personal link and select Login History link.")
//	public void user_clicks_on_personal_link_and_select_login_history_link() {
//		mySettingPage.clickPersonalLink();
//		mySettingPage.clickLoginHistory();
//	}
//
//	@When("Click on Download login  history link.")
//	public void click_on_download_login_history_link() {
//		Assert.assertTrue(mySettingPage.clickDownloadLogin(driver));
//	}
//
//	@Then("Login history is displayed and the data is downloaded in .csv format.")
//	public void login_history_is_displayed_and_the_data_is_downloaded_in_csv_format() throws IOException {
//      driver.navigate().back();
//		
//		Assert.assertTrue(mySettingPage.verifyMySettingPageDisplayed("My Settings",driver));
//		
//		Assert.assertTrue(mySettingPage.verifyFileDownloaded());
//
//	}
//
//	@When("User Clicks on Display & Layout link and select Customize My Tabs link.")
//	public void user_clicks_on_display_layout_link_and_select_customize_my_tabs_link() {
//		mySettingPage.clickDispalyAndLayoutLink();
//		mySettingPage.clickCustomizeTabs();
//	}
//
//	@When("User Selects Salesforce Chatter option from custom App: drop down.")
//	public void user_selects_salesforce_chatter_option_from_custom_app_drop_down() {
//		mySettingPage.selectSalesForceChatter("Salesforce Chatter");
//	}
//
//	@When("User Selects Reports tab from Available Tabs list.")
//	public void user_selects_reports_tab_from_available_tabs_list() {
//		if (!mySettingPage.selectReportTab("Reports")) {
//
//			mySettingPage.clickAddBtn();
//		}
//	}
//
//	@When("Click on >\\(Add) button.")
//	public void click_on_add_button() {
//		mySettingPage.clickSaveBtn();
//	}
//
//	@Then("Reports field is added to Selected Tabs list and also added in the links available in top of salesforce page and sales force chatter page and sales and marketing pages.")
//	public void reports_field_is_added_to_selected_tabs_list_and_also_added_in_the_links_available_in_top_of_salesforce_page_and_sales_force_chatter_page_and_sales_and_marketing_pages() {
//
//	}
//
//	@When("User Clicks on Email link and click on my email settings link under that")
//	public void user_clicks_on_email_link_and_click_on_my_email_settings_link_under_that() {
//		mySettingPage.clickEmail();
//		mySettingPage.clickEmailSettings();
//	}
//
//	@When("User Provides {string} in Email Name field, {string} in Email Address field,")
//	public void user_provides_in_email_name_field_in_email_address_field(String emailName, String emailAddress) {
//		mySettingPage.setEmailName(emailName);
//		mySettingPage.setEmailAddress(emailAddress);
//	}
//
//	@When("Select automatic BCC radio button")
//	public void select_automatic_bcc_radio_button() {
//		mySettingPage.selectAutomaticBCC();
//	}
//
//	@When("click on save button")
//	public void click_on_save_button() {
//		mySettingPage.clickSaveBtn();
//	}
//
//	@Then("provided details are saved as default mail options and My settings page is displayed.")
//	public void provided_details_are_saved_as_default_mail_options_and_my_settings_page_is_displayed() {
//		Assert.assertTrue(mySettingPage.verifyEmailUpdation(driver));
//
//		String expectedTitle = TitleConstants.MY_EMAIL_SETTINGS_TITLE;
//
//		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(driver, expectedTitle));
//	}
//
//	@When("User Clicks on Calendar & Remainders")
//	public void user_clicks_on_calendar_remainders() {
//		mySettingPage.clickCalenderAndRamainder();
//	}
//
//	@When("User clicks on Activity Remainders link.")
//	public void user_clicks_on_activity_remainders_link() {
//		mySettingPage.clickActivityRemainder();
//	}
//
//	@When("On Remainders page click on Open a test Remainder button.")
//	public void on_remainders_page_click_on_open_a_test_remainder_button() {
//		mySettingPage.clickOpenTestRemainder(driver);
//	}
//
//	@Then("Sample event pop window is dispayed.")
//	public void sample_event_pop_window_is_dispayed() {
//		Assert.assertTrue(mySettingPage.verifyThePopUpWindow(driver));
//	}
//	
//	
//	@When("User Clicks on Developer Console link from the User Menu drop down")
//	public void user_clicks_on_developer_console_link_from_the_user_menu_drop_down() {
//		hp.clickUserMenu();
//		hp.clickDeveloperCosole(driver);
//	}
//	@Then("Force.com Developer Console window is displayed")
//	public void force_com_developer_console_window_is_displayed() {
//		boolean isDeveloperWindowDisplayed=false;
//		Set<String> windowHabdles=driver.getWindowHandles();
//		List<String> windowHandleList=new ArrayList<String>(windowHabdles);
//		
//		if(CommonUtils.waitForNumOfWindowsToBe(driver, 2)){
//			driver.switchTo().window(windowHandleList.get(1));
//			Assert.assertTrue(CommonUtils.waitForTitleOfThePage(driver, "Developer Console"));
//			
//			isDeveloperWindowDisplayed=true;
//			
//		}
//		Assert.assertTrue(isDeveloperWindowDisplayed);
//		
//	}
//	@When("User Clicks on close button the developer console browser")
//	public void user_clicks_on_close_button_the_developer_console_browser() {
//		driver.close();
//		
//	}
//	@Then("Force.com Developer Console window is closed")
//	public void force_com_developer_console_window_is_closed() {
//		Set<String> windowHabdles=driver.getWindowHandles();
//		List<String> windowHandleList=new ArrayList<String>(windowHabdles);
//		driver.switchTo().window(windowHandleList.get(0));
//		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(driver, "Home Page ~ Salesforce - Developer Edition"));
//	}
//	
//	@When("User Clicks on Logout option from the User Menu drop down")
//	public void user_clicks_on_logout_option_from_the_user_menu_drop_down() {
//		hp.clickUserMenu();
//		hp.clickLogOut();
//	}
//	@Then("Logout  of current sales force application  and Login page is displayed.")
//	public void logout_of_current_sales_force_application_and_login_page_is_displayed() {
//		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.LOGIN_PAGE_TITLE));
//	}
//	
//	@After
//	public void tearDown(Scenario scenario) {
//		System.out.println("Executing after the scenario :: "+scenario.getName());
//		driver.quit();
//	}
//
//}
