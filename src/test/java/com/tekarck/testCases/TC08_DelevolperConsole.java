/**
 * 
 */
package com.tekarck.testCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.tekarck.pages.UserMenuPage;

/**
 * 
 */
public class TC08_DelevolperConsole extends BaseTest {
	UserMenuPage hp;

//	@Test
	void userMenuItems() {
		loginToSalesForceApp();

		hp = new UserMenuPage(getDriver());

		List<String> actualMenuItems = hp.getUserMenuItemList();

		List<String> expectedMenuItems = new ArrayList<String>();

		expectedMenuItems.add("My Profile");
		expectedMenuItems.add("My Settings");
		expectedMenuItems.add("Developer Console");
		expectedMenuItems.add("Switch to Lightning Experience");
		expectedMenuItems.add("Logout");

		int i = 0;
		boolean flag = false;
		for (String str : actualMenuItems) {

			if (str.equals(expectedMenuItems.get(i))) {
				i++;
				flag = true;
			} else {
				flag = false;
				break;
			}

		}

		Assert.assertTrue(flag);

	}

	/*
	 * Click on Developer Console link from the drop down Click on close button the
	 * developer console browser
	 */
	/**
	 * @throws InterruptedException
	 * 
	 */
	@Test
	void verifyDelevolperConsole() throws InterruptedException {
		loginToSalesForceApp();
		hp = new UserMenuPage(getDriver());
		hp.clickUserMenu();
		hp.clickDeveloperCosole(getDriver());

		Assert.assertTrue(hp.verifyDeveloperWindowDisolayed(getDriver()));

	}

}
