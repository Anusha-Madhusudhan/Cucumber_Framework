/**
 * 
 */
package com.teckarck.constants;

import com.tekarch.utils.CommonUtils;


/**
 * 
 */
public class FileConstants {
	
	public static  final String TEST_DATA_PROPERTIES_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\testData.properties";
	public static  final String LOGIN_TEST_DATA_PROPERTIES_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\LoginTestData.properties";
	public static  final String TEST_REPORT_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\"+ CommonUtils.getTimeStamp()+"TestReport.html";
	public static  final String SCREENSHOT_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\"+ CommonUtils.getTimeStamp()+"screenShot.png";
	public static  final String LOGIN_TEST_DATA_EXCEL_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\LoginTestData.xlsx";
	public static  final String USER_MENU_TEST_DATA=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\userMenuTestData.properties";
	public static  final String UPLOAD_PHOTO_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\SNice.png";
	public static  final String UPLOAD_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\testData.properties";
	public static  final String ACCOUNTS_TEST_DATA_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\AccountsTestData.properties";
	public static  final String LOGIN_TEST_DATA_JSON_FILE_PATH=System.getProperty("user.dir")+"/src/test/resources/testData/LoginTestData.json";
}
