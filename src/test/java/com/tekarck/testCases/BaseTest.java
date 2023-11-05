/**
 * 
 */
package com.tekarck.testCases;


import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.teckarck.constants.FileConstants;
import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarch.utils.FileUtils;
import com.tekarck.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;


/**
 * 
 */
public class BaseTest {
	
    Logger logger;
	
	private static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<WebDriver>();
	
	
	@Parameters({"browser","URL","isHeadless"})
	@BeforeClass
	void setUp(@Optional("chrome")String br,@Optional("https://login.salesforce.com/")String appln,@Optional("false")boolean isHeadless) throws IOException {
		logger=LogManager.getLogger(this.getClass().getName());
		logger.info("Set driver : "+br);

		
		/*
		 * PARAMETERIZATION from testNG.xml file
		 */
	   WebDriver driver=getBrowserType(br,isHeadless);
	   threadLocal.set(driver);
		driver.get(appln);
		logger.info("Launching the application : "+appln);
		
		/*
		 * Parameter from properties file
		
		driver=BaseTest.getBrowserType(FileUtils.readPropertiesFile(FileConstants.TEST_DATA_PROPERTIES_FILE_PATH,"browser"));
		driver.get(FileUtils.readPropertiesFile(FileConstants.TEST_DATA_PROPERTIES_FILE_PATH,"URL"));
		*/
		
		
		String expectedPagetitle = TitleConstants.LOGIN_PAGE_TITLE;
		boolean flag = CommonUtils.waitForTitleOfThePage(getDriver(), expectedPagetitle);
		Assert.assertTrue(flag);
		
		logger.info("Login Page title :"+expectedPagetitle);
		
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
	}

	@AfterClass
	void tearDown() {
		
		getDriver().quit();
		logger.info("Closing the browser :");
     	threadLocal.remove();
	}

	private  WebDriver getBrowserType(String browser,boolean isHeadless) {
		
		String brName=browser.toLowerCase();
		WebDriver driver;
		
		switch (brName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions chOptions=new ChromeOptions();
			if(isHeadless) {
				
				chOptions.addArguments("--headless");
			}
			
		   driver=new ChromeDriver(chOptions);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foxOptions=new FirefoxOptions();
			if(isHeadless) {
				foxOptions.addArguments("-headless");
			}
			
			   driver=new FirefoxDriver(foxOptions);
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver=  new SafariDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions=new EdgeOptions();
			if(isHeadless) {
				edgeOptions.addArguments("headless");
			}
			   driver=new EdgeDriver(edgeOptions);
			break;

		default:
			System.out.println("Provide valid browser name");
			driver=  null;
		}
		
		return driver;
		
	}
	
	
	
	    public static WebDriver getDriver() {
	    	
		return threadLocal.get();

	}






	public static void loginToSalesForceApp() {
		LoginPage lp=new LoginPage(getDriver());
		try {
		lp.setUserName(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PROPERTIES_FILE_PATH, "userName"),getDriver());
		lp.setPassword(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PROPERTIES_FILE_PATH, "password"),getDriver());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		lp.clickLoginBtn(getDriver());
	}
	
	
	
	
	
  
  
	public static String generateRandomString(){
		
		
		
		return RandomString.make(5);
		
	}
  




	

}
