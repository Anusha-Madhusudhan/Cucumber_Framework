/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.teckarck.constants.FileConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarch.utils.FileUtils;
import com.tekarck.pages.MyProfilePage;
import com.tekarck.pages.UserMenuPage;

/**
 * 
 */
/**
 * 
 */
public class TC06_MyProfile extends BaseTest {
	
	
	UserMenuPage hp;
	MyProfilePage myProfilePage;
	
	
	/*Select user menu for <username> drop down[TC01]
	 * 
	 * Click "My profile" option from user menu
	 * 
	 * Click on edit profile button to edit contact information
	 * 
	 * Click on About tab and enter <Lastname> and click on save all button
	 */
	@Test
	void verifyEditMyProfile() throws InterruptedException, IOException {
		
		hp=new UserMenuPage(getDriver());
		
		
		loginToSalesForceApp();
		
		hp.clickUserMenu();
		
		hp.clickMyProfile();
		

		
		myProfilePage=new MyProfilePage(getDriver());
		
		CommonUtils.waitForElementClickable(getDriver(), myProfilePage.getProfilePage());
		
		Assert.assertTrue(myProfilePage.isMyProfilePageIsVisible());
		
		Assert.assertTrue(myProfilePage.clickEditMyProfile(getDriver()));
		
		myProfilePage.switchFrame(getDriver());
		
		myProfilePage.clickAboutTab();
		
//		myProfilePage.setLastName("XXXX");
		String lastName=FileUtils.readPropertiesFile(FileConstants.USER_MENU_TEST_DATA, "lastName");
		
		myProfilePage.setLastName(lastName);
		
		myProfilePage.clickSaveAll(getDriver());
		
		Assert.assertTrue(myProfilePage.verifyEditedLastName(lastName));
		
		
//		hp.clickUserMenu();
//		
//		hp.clickLogOut();
		
		
		
	}
	
	/*
	 * Click on Post link, Enter the <text> to post in the post text area and click on share button
	 */
	@Test(dependsOnMethods = "verifyEditMyProfile")
	void postText() throws IOException, InterruptedException{
		CommonUtils.waitForTitleContais(getDriver(), FileUtils.readPropertiesFile(FileConstants.USER_MENU_TEST_DATA, "updatedUserName"));

		
		myProfilePage.clickPost(getDriver());
		
		myProfilePage.switchToPostFrame(getDriver());
		
		String postText=FileUtils.readPropertiesFile(FileConstants.USER_MENU_TEST_DATA, "postText");
		
		myProfilePage.setpostText(getDriver(),postText);
		
		getDriver().switchTo().defaultContent();
		
		myProfilePage.clickShare();
		
		
		Assert.assertTrue(myProfilePage.verifyPostText(getDriver(),postText));
		
		/*
		 * Post Conditions Delete file after uploading
		 */


		Assert.assertTrue(myProfilePage.deleteFileUploaded(getDriver()));

	}
	

	/*
	 * Click on the  file link and click on "upload a file from computer" button. 
	 * Click on choose file button and select a file to be uploaded and click open button.
	 * (dependsOnMethods = "postText")
	 */
	@Test(dependsOnMethods = "postText")
	void uploadFile() throws InterruptedException{
		Assert.assertTrue(myProfilePage.isMyProfilePageIsVisible());
		myProfilePage.clickFile(getDriver());
		myProfilePage.clickUpLoadFile(getDriver());
		String filePath=FileConstants.UPLOAD_FILE_PATH;
		myProfilePage.sendFile(filePath);
		myProfilePage.clickShare();
		Assert.assertTrue(myProfilePage.verifyUploadedFileName(getDriver(),"testData"));
		
		/*
		 * Post Conditions Delete file after uploading
		 */
		
		
//		Assert.assertTrue(myProfilePage.deleteFileUploaded(getDriver()));
		
	}
	
	/*
	 * Hover the mouse on myprofilephoto image and Add photo link appears. Click on the link to upload a photo. 
	 * Click on Choose file button and select the image to upload. Crop the photo to fit the image.
	 */
	@Test(dependsOnMethods = "uploadFile")
	void addPhoto(){
		Assert.assertTrue(myProfilePage.isMyProfilePageIsVisible());
		myProfilePage.clickUploadPhoto(getDriver());
		myProfilePage.switchtoUploadPhotoIFrameID(getDriver());
		myProfilePage.sendphoto(FileConstants.UPLOAD_PHOTO_PATH);
		
		myProfilePage.clickSaveBtn();
		
		myProfilePage.waitForSpinnerDisapear(getDriver());
		
		myProfilePage.clickCropSaveBtn(getDriver());
		
		getDriver().switchTo().defaultContent();
		
		
	}

}
