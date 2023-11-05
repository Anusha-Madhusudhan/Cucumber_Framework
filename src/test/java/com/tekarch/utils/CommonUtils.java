/**
 * 
 */
package com.tekarch.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.teckarck.constants.WaitCostants;
import com.tekarck.testCases.BaseTest;

/**
 * 
 */
public class CommonUtils {
	
	
	public static String getScreenShot(String sTestName) throws IOException {
		  
//		  String screenShotPath=FileConstants.SCREENSHOT_FILE_PATH;
		  
		   String screenShotPath=System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\"+getTimeStamp()+sTestName+"ScreenShot.png";
		  
		  TakesScreenshot ts=(TakesScreenshot) BaseTest.getDriver();
		  File src= ts.getScreenshotAs(OutputType.FILE);
		 
		  File destn=new File(screenShotPath);
		  
		  org.apache.commons.io.FileUtils.copyFile(src, destn);
		 
		  return screenShotPath;
	  }
	
	
  public static String getTimeStamp() {
		
		String timeStamp=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		return timeStamp;
	}
	
	public static boolean waitForElementClickable(WebDriver driver, WebElement element) {
		boolean isElementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementClickable = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isElementClickable;
	}
	
	
	public static boolean waitForNumOfWindowsToBe(WebDriver driver, int iNumberOfWindows) {
		boolean isAllWindowsOpened = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
		try {
			isAllWindowsOpened =wait.until(ExpectedConditions.numberOfWindowsToBe(iNumberOfWindows));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isAllWindowsOpened;
	}
	
	
	
	public static boolean waitForText(WebDriver driver, WebElement element,String text) {
		boolean isTextPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(element,text));
			isTextPresent = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isTextPresent;
	}
	
	
	public static boolean waitForTitleOfThePage(WebDriver driver,String title) {
		boolean isTitlePresent = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_TITLE_OF_THE_PAGE);
		try {
			isTitlePresent =wait.until(ExpectedConditions.titleIs(title));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isTitlePresent;
	}
	
	public static boolean waitForElementToVisible(WebDriver driver, WebElement element) {
		boolean isElementVisible = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			isElementVisible = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isElementVisible;
	}
	
	
	
	
	public static WebDriver waitForFrameToBeAvailableToSwitch(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
		try {
			driver=wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	
	
	public static boolean waitForElementToDisapear(WebDriver driver, WebElement element) {
		boolean isElementDisapear = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT_TO_DISAPEAR);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			isElementDisapear = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementDisapear;
	}

	public static boolean waitForTitleContais(WebDriver driver, String sText) {
		boolean isTitleContainsText = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
		try {
			isTitleContainsText =wait.until(ExpectedConditions.titleContains(sText));
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isTitleContainsText;
	}


	public static Alert waitForAlert(WebDriver driver) {
		Alert isAlertPresent = null;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
		try {
			isAlertPresent =wait.until(ExpectedConditions.alertIsPresent());
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAlertPresent;
	}


	public static void waitForAttributeValue(WebDriver driver, WebElement accountNameValue, String attribute ,String value) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
		try {
			wait.until(ExpectedConditions.attributeContains(accountNameValue, attribute, value));
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	
	
//	public static boolean waitForSelectedOption(WebDriver driver, String sText) {
//		boolean isSelctedOptionPresent = false;
//		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
//		try {
//			isSelctedOptionPresent =wait.until(ExpectedConditions.(sText));
//			 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return isSelctedOptionPresent;
//	}
}

