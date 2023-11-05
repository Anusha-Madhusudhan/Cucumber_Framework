/**
 * 
 */
package com.tekarck.pages;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;

/**
 * 
 */
public class OpportunitiesPage extends BasePage {
	
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@id='Opportunity_Tab']//a")
	WebElement opportunitiesTab;
	
	@FindBy(id = "fcf")
	WebElement selectOppDropDown;
	
	@FindBy(xpath = "//input[@value=' New ']")
	WebElement newBtn;
	
	@FindBy(id = "opp3")
	WebElement oppName;
	
	@FindBy(id = "opp4_lkwgt")
	WebElement searchForAccName;
	
	String iFrameIDForAccName="searchFrame";
	
	String iFrameIDForReult="resultsFrame";
	
	@FindBy(id = "opp9")
	WebElement closedate;
	
	@FindBy(id = "opp11")
	WebElement stage;
	
	@FindBy(xpath = "//input[@value=' Save ']")
	WebElement saveBtn;
	
    @FindBy(xpath = "//div[@class='pBody']//input[@id='lksrch']")
	WebElement inputText;
    
    @FindBy(className = "pageDescription")
	WebElement actualOppName;
    
    @FindBy(xpath = "//table//tbody//tr//th//a")
	List<WebElement> acctNameList;
    
   
    @FindBy(id = "opp12")
	WebElement probability;
    
    @FindBy(id = "opp6")
	WebElement leadSrc;
    
    @FindBy(xpath = "//input[@id='opp17']//following-sibling::a")
	WebElement primaryCampaignSource;
    
  
    
    @FindBy(xpath = "//h2[@class='pageDescription']")
	WebElement oppNameOnOppPage;
    
     
    @FindBy(xpath = "//input[@value=' Go! ']")
   	WebElement goBtn;
    

    @FindBy(xpath = "//div[@class='lbBody']//ul//li//a[contains(text(),'Pipeline')]")
    WebElement pipeline;
    
    @FindBy(xpath = "//table[@class='reportTable tabularReportTable']//tbody//tr//th")
    List<WebElement> tableHeaders;
 
    
    @FindBy(xpath = "//table//tr[contains(@class,'dataRow')]")
   	List<WebElement> primaryCampaignSourceData ;
    
    @FindBy(xpath = "//table[@class='reportTable tabularReportTable']//tbody//tr[@class='even']")
    List<WebElement> rows;
    
    @FindBy(id = "status")
	WebElement pipelineReportStatus;
    
    @FindBy(linkText = "Stuck Opportunities")
    WebElement stuckOpportunities;
    
    @FindBy(css = ".noSecondHeader.pageType")
    WebElement stuckOpportunitiesText;
    
    @FindBy(id = "quarter_q")
	WebElement interval;
    
    @FindBy(id = "open")
    WebElement include;
    
    @FindBy(xpath = "//input[@value='Run Report']")
    WebElement runReport;
    
    @FindBy(id = "quarter_q")
    WebElement range;
    
    @FindBy(id = "scope")
    WebElement show;
    
    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteOppty;
    
	public void clickOnOppTab() {
		
		if(opportunitiesTab.isDisplayed()) {
			opportunitiesTab.click();
		}
		else {
			System.out.println("Opp Tab is not displayed");
		}
	}

	public boolean verifyOppDropDownList() {
		
		List<String> expectedOptions = new ArrayList<String>();
		expectedOptions.add("All Opportunities");
		expectedOptions.add("Closing Next Month");
		expectedOptions.add("Closing This Month");
		
		expectedOptions.add("My Opportunities");
		expectedOptions.add("New Last Week");
		expectedOptions.add("New This Week");
		expectedOptions.add("Opportunity Pipeline");
		expectedOptions.add("Private");
		expectedOptions.add("Recently Viewed Opportunities");
		expectedOptions.add("Won");
		
		Select s = new Select(selectOppDropDown);
		
		boolean isDropDownListPresent=false;
		
		List<WebElement> actualOptions = s.getOptions();
		
		int i = 0;

		for (WebElement ele : actualOptions) {
			
			System.out.println(ele.getText());
			

			if (expectedOptions.get(i).equals(ele.getText())) {

				isDropDownListPresent = true;
				i++;
				continue;
			} else {
				isDropDownListPresent = false;
				break;
			}

		}
		
		return isDropDownListPresent;
	}

	public boolean verifyOppPageIsDisplayed(WebDriver driver) {
		
		boolean isOppPageDisplayed=false;
		String expectedTitle = TitleConstants.OPPORTUNITIES_PAGE_TITLE;
		if(CommonUtils.waitForTitleOfThePage(driver, expectedTitle)) {
			isOppPageDisplayed=true;
		}
		else {
			System.out.println("Opportunities page is not disaplyed");
			isOppPageDisplayed=false;
		}
		return isOppPageDisplayed;
		
		
	}

	public void clickNewBtn() {
		
		if(newBtn.isDisplayed()) {
			
			newBtn.click();
		}
		else {
			System.out.println("New Btn is not displayed");
		}
	}

	public void enterOppName(String sOppName) {
		
		if(oppName.isDisplayed()) {
			oppName.clear();
			oppName.sendKeys(sOppName);
		}else {
			System.out.println("Opp name text box is not displayed");
		}
		
		
	}

	public void clickOnToFindAccName(WebDriver driver) {
		
		if(searchForAccName.isDisplayed()) {
			searchForAccName.click();
			
			Set<String> windowHandles=driver.getWindowHandles();
			 
			 List<String> list=new ArrayList<String>(windowHandles);
			 
			 String parentWindowHandle=list.get(0);
			 
			 String childWindowHandle=list.get(1);
			 
			 driver.switchTo().window(childWindowHandle);
			 
			 driver.switchTo().frame(iFrameIDForReult);
			 
			 acctNameList.get(0).click();
			 
			 driver.switchTo().window(parentWindowHandle);
			 
		}
		
		
	}

	public void enterCloseDate(String date) {
		
		if(closedate.isDisplayed()) {
			closedate.sendKeys(date);
		}
		else {
			System.out.println("Close Date is not displayed");
		}
	}

	public void selectStage() {
		
		if(stage.isDisplayed()) {
			Select s=new Select(stage);
			s.selectByIndex(2);
		}
		else {
			System.out.println("Stage is not displayed");
		}
	}

	public void enterProbability(String sProbability) {
		if(probability.isDisplayed()) {
			probability.clear();
			probability.sendKeys(sProbability);
		}
		else {
			System.out.println("probability is not displayed");
		}
	}

	public void selectLeadSource() {
		
		if(leadSrc.isDisplayed()) {
			Select s=new Select(leadSrc);
			s.selectByIndex(1);
			
		}else {
			System.out.println("Lead src is not displayed");
		}
		
	}

	public void enterPrimaryCampaignSource(WebDriver driver) {
		if(primaryCampaignSource.isDisplayed()) {
			
			primaryCampaignSource.click();
			
			Set<String> windowHandles=driver.getWindowHandles();
			 
			 List<String> list=new ArrayList<String>(windowHandles);
			 
			 String parentWindowHandle=list.get(0);
			 
			 String childWindowHandle=list.get(1);
			 
			 driver.switchTo().window(childWindowHandle);
			 
			 driver.switchTo().frame(iFrameIDForAccName);
			 
			 if(inputText.isDisplayed()) {
				 inputText.clear();
				 inputText.sendKeys("*a");
				 
				 goBtn.click();
			 }else {
				 System.out.println("Input text not present");
			 }
			 
			 driver.switchTo().defaultContent();
			 driver.switchTo().frame(iFrameIDForReult);
			 primaryCampaignSourceData.get(0).click();
			 driver.switchTo().window(parentWindowHandle);
			 
		}
	}

	public void clickSaveBtn() {
		
		if(saveBtn.isDisplayed()) {
			saveBtn.click();
		}else {
			 System.out.println("Save btn is not present");
		 }
		
	}

	public boolean verifyOppCreated(WebDriver driver,String sOppName) {
		
		boolean isOppCreated=false;
		
		if(CommonUtils.waitForTitleContais(driver, sOppName)) {
			
			if(CommonUtils.waitForText(driver, oppNameOnOppPage, sOppName)) {
				isOppCreated=true;
			}
			
		}
		return isOppCreated;
		
	}

	public void clickOnPipeline() {

		if(pipeline.isDisplayed()) {
			pipeline.click();
		}else {
			System.out.println("Oppty Pipeline is not displayed");
		}
	}

	public boolean verifyPipelinePageDisplayed(WebDriver driver) {
		boolean isPipelinePageDisplayed=false;
		
		if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.OPPORTUNITIES_PIPELINE_PAGE_TITLE)) {
			isPipelinePageDisplayed=true;
		}
		
		return isPipelinePageDisplayed;
	}

	public boolean verifyPipelineReportStatusComplete(WebDriver driver) {
		boolean isPipelineReportStatusComplete=false;
		if(pipelineReportStatus.isDisplayed()) {
			if(CommonUtils.waitForText(driver, pipelineReportStatus, "Complete")) {
				isPipelineReportStatusComplete=true;
			}
		}
		return isPipelineReportStatusComplete;
	}

	public void clickOnStuckOppty() {
		
		if(stuckOpportunities.isDisplayed()) {
			stuckOpportunities.click();
		}else {
			System.out.println("Stuck Opportunities is not displayed");
		}
	}

	public boolean verifyStuckOpptyPageDisplayed(WebDriver driver) {
		boolean isStuckOpptyPageDisplayed=false;
		
		if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.STUCK_OPPORTUNITIES_PAGE_TITLE)) {
			if(CommonUtils.waitForText(driver, stuckOpportunitiesText, "Stuck Opportunities")) {
				isStuckOpptyPageDisplayed=true;
			}
		}
		return isStuckOpptyPageDisplayed;
	}

	public void selectInterval(WebDriver driver) {
		
		if(interval.isDisplayed()) {
			Select s=new Select(interval);
			s.selectByVisibleText("Current FQ");
			
		}else {
			System.out.println("Interval is not displayed");
		}
		
	}

	public void selectInclude(WebDriver driver) {
		if(include.isDisplayed()) {
			Select s=new Select(include);
			s.selectByVisibleText("All Opportunities");
			
		}else {
			System.out.println("Include is not displayed");
		}
	}

	public void clickRunReport() {
		
		if(runReport.isDisplayed()) {
			runReport.click();
		}else {
			System.out.println("Run Report is not displayed");
		}
		
	}

	public boolean verifyReportPageWithSearchCriteria(WebDriver driver) {
		boolean isReportPageWithSearchCriteriaDisplayed=false;
		Select s1=new Select(range);
		
		
		if(s1.getFirstSelectedOption().getText().equals("Current FQ")) {
			System.out.println(s1.getFirstSelectedOption().getText());
			Select s2=new Select(show);
			System.out.println(s2.getFirstSelectedOption().getText());
			if(s2.getFirstSelectedOption().getText().equalsIgnoreCase("All Opportunities")) {
				isReportPageWithSearchCriteriaDisplayed=true;
			}
		}
		return isReportPageWithSearchCriteriaDisplayed;
	}

	public boolean verifyOpptyReportPageTitle(WebDriver driver) {
		boolean isOpptyReportPageTitleDisplayed=false;
		
		if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.OPPORTUNITIES_REPORT_PAGE_TITLE)) {
			isOpptyReportPageTitleDisplayed=true;
		}
		return isOpptyReportPageTitleDisplayed;
	}

	public void deleteOpp(WebDriver driver) {
		
		if(CommonUtils.waitForElementClickable(driver, deleteOppty)) {
			deleteOppty.click();
			try {
			Alert alert=CommonUtils.waitForAlert(driver);
			alert.accept();
			}catch(NoAlertPresentException e) {
				System.out.println("Alert not present");
			}
		}
		else {
			System.out.println("deleteOppty btn is not displayed");
		}
		
	}
	

}
