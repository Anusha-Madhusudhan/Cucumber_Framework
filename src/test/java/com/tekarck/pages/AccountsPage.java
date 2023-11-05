/**
 * 
 */
package com.tekarck.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;

/**
 * 
 */
public class AccountsPage extends BasePage {
	
	public AccountsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#Account_Tab")
	private WebElement accountTab;
	
	@FindBy(xpath = "//div[@class='userBlock']//span")
	private WebElement userName;
	
	
	@FindBy(xpath = "//td[@class='pbButton']//input")
	private WebElement newBtn;
	
	
	@FindBy(css = "input#acc2")
	private WebElement accountName;
	
	
	@FindBy(css = "select#acc6")
	private WebElement type;
	
	
	@FindBy(xpath = "(//table[@class='detailList'])[3]//tbody//tr//td[2]//span//select[@id='00NHu00000PEMLd']")
	private WebElement customerPriority;
	
	
			
	@FindBy(xpath = "(//input[@value=' Save '])[2]")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//div[@class='bFilterView']//span[@class='fFooter']//a[2]")
	private WebElement creatNewView;
	
	@FindBy(css = "input#fname")
	private WebElement viewName;
	
	@FindBy(css = "input#devname")
	private WebElement viewUniqName;
	
	
    @FindBy(xpath = "//div[@class='controls']//select")
    private WebElement viewList;
    
    @FindBy(name = "fcf")
    WebElement viewDropDown;
    
    @FindBy(xpath = "//div[@class='filterLinks']//a[text()='Edit']")
    private WebElement editView;
    
    @FindBy(css = "#fcol1")
	private WebElement field;
    
    @FindBy(css = "#fop1")
	private WebElement operator;
    
    @FindBy(css = "#fval1")
	private WebElement value;
    
    @FindBy(css = "#colselector_select_0")
	private WebElement availableFields;
    
    @FindBy(css = "#colselector_select_1")
	private WebElement selectedFields;
    
    @FindBy(css = "#ext-gen20")
   	private WebElement selectDateField;
    
    @FindBy(xpath = "//div[@class='x-combo-list-inner']//div[text()='Created Date']")
    private WebElement createDate;
       
    @FindBy(xpath = "(//div[@class='zen-mbs text']//a)[1]")
    private WebElement addBtn;
    
    @FindBy(xpath = "//div[@class='x-grid3-header-offset']//table//thead//tr//td//div")
    private List<WebElement> viewColumnNames;
    
    @FindBy(xpath = "//table[@class='x-grid3-row-table']//tbody//tr//td[4]//div//a//span")
    private List<WebElement> accNameList;
    
    @FindBy(xpath = "//div[@class='lbBody']//ul//li//a[contains(text(),'activity')]")
    private WebElement lastActivity;
    
    @FindBy(xpath = "(//img[@class='x-form-trigger x-form-date-trigger'])[1]")
    private WebElement fromDateImg;
    
    @FindBy(xpath = "(//img[@class='x-form-trigger x-form-date-trigger'])[2]")
    private WebElement toDateImg;
    
    @FindBy(xpath = "(//div[@class='x-date-picker x-unselectable']//td//em//button[text()='Today'])[1]")
    private WebElement fromToday;
    
    @FindBy(xpath = "(//div[@class='x-date-picker x-unselectable']//td//em//button[text()='Today'])[2]")
    private WebElement toToday;
  
    @FindBy(xpath = "//div[text()='Loading...']")
    private WebElement loading;
    
    @FindBy(xpath = "//button[@id='ext-gen49']")
    private WebElement reportSaveBtn;
    
    @FindBy(xpath = "//input[@id='saveReportDlg_reportNameField']")
    private WebElement reportName;
    
    @FindBy(xpath = "//input[@id='saveReportDlg_DeveloperName']")
    private WebElement reportUniqueName;
    
    @FindBy(xpath = "//table[@id='dlgSaveAndRun']")
    private WebElement saveAndRunBtn;
    
    
    @FindBy(id = "ext-gen291")
    WebElement saveAndRunBtnDiv;
  
    
    @FindBy(xpath = "//div[@class='content']//h1")
    private WebElement reportNameOnReportPage;
    
    @FindBy(xpath = "//table[@class='list']//tbody//tr//th[@class=' dataCell  ']//a")
    private List<WebElement> accountNameList;
    
    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteBtn;
    
    
    @FindBy(xpath = "//div[@class='filterLinks']//a[2]")
    private WebElement deleteView;
    
    @FindBy(xpath = "//div[@class='toolsContentRight']//ul//li//a[text()='Merge Accounts']")
    private WebElement mergeLink;
    
    @FindBy(xpath = "//input[@value='Save & New']")
    private WebElement saveAndNewBtn;
    
    @FindBy(id = "srch")
    private WebElement textToMergeAcc;
    
    @FindBy(name = "srchbutton")
    private WebElement findAccountsBtn;
    

    
    @FindBy(xpath = "//table[@class='list']//th[@class=' dataCell  booleanColumn']//input")
    private List<WebElement> accountsNameRadioBtnListToMerge;
    
    
 
    
    @FindBy(xpath = " //table[@class='list']//td[1]")
    private List<WebElement> accountsNameListToMerge;
    
    @FindBy(xpath = "//input[@value=' Next ']")
    private WebElement nextBtn;
    
    @FindBy(xpath = "//h1[@class='noSecondHeader pageType']")
    private WebElement mergeAccountHeaderText;
    
    @FindBy(tagName = "label")
    private List<WebElement> mergeAccountNamesOnMergeMyAccPage;
    
    @FindBy(xpath = "//input[@value=' Merge ']")
    private WebElement mergeBtn;
    
    @FindBy(xpath = "//input[@value=' Go! ']")
    private WebElement goBtn;
    
    
  //span[@class='fFooter']//a
  
    
    @FindBy(xpath = "//label//preceding-sibling::input")
    private List<WebElement> mergeAccountRadioBtnsOnMergeMyAccPage;
    
    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteAccReport;
    
    @FindBy(xpath = "//table//descendant::td[@id='bodyCell']")
    private WebElement mergedAcctPage;

	public void clickAccountTab() {
		if(accountTab.isDisplayed()) {
			accountTab.click();
		}else {
			System.out.println("Account Tab is not displayed");
		}
	}

	public boolean verifyAccountPageDisplayed(WebDriver driver) {
		boolean isaccountPageIsDisplayed=false;
		
		String expAccPageTitle=TitleConstants.ACCOUNTS_PAGE_TITLE;
		
		if(CommonUtils.waitForTitleOfThePage(driver, expAccPageTitle)) {
			isaccountPageIsDisplayed=true;
		}
			
		
		return isaccountPageIsDisplayed;
		
		
	}

	public void clickNewBtn(WebDriver driver) {
		
		if(newBtn.isDisplayed()) {
			if(CommonUtils.waitForElementClickable(driver, newBtn)) {
				newBtn.click();
			}
		}else {
			System.out.println("New btn is not dispalyed");
		}
		
	}

	public void enterAccountName(String sAccountName) {
		
		if(accountName.isDisplayed()) {
			accountName.clear();
			accountName.sendKeys(sAccountName);
		}
		else {
			System.out.println("Account Name is not dispalyed");
		}
	}

	public void selectType(String sType) {
		if(type.isDisplayed()) {
			Select s=new Select(type);
			s.selectByValue(sType);
		}else {
			System.out.println("Type is not dispalyed");
		}
	}

	public void selectCustomerPriority(String sCustomerPriority) {
		
		if(customerPriority.isDisplayed()) {
			Select s=new Select(customerPriority);
			s.selectByValue(sCustomerPriority);
		}else {
			System.out.println("Customer Priority is not dispalyed");
		}
	}

	public void clickSaveBtn(WebDriver driver) {
		
		if(saveBtn.isDisplayed()) {
			if(CommonUtils.waitForElementClickable(driver, saveBtn)) {
				saveBtn.click();
			}
		}else {
			System.out.println("save button is not dispalyed");
		}
	}

	
		public boolean verifyAccountEditPageDisplayed(WebDriver driver) {
			boolean isAccountEditPageIsDisplayed=false;
			
			String expAccEditPageTitle=TitleConstants.CREATE_NEW_ACCOUNT_PAGE_TITLE;
			
			if(CommonUtils.waitForTitleOfThePage(driver, expAccEditPageTitle)) {
				isAccountEditPageIsDisplayed=true;
			}
		return isAccountEditPageIsDisplayed;
	}

		public boolean verifyAccountIsCreatd(WebDriver driver,String sAccountName) {
			
			boolean isAccountCreated=false;
			
			if(CommonUtils.waitForTitleContais(driver, sAccountName)) {
				isAccountCreated=true;
			}
			return isAccountCreated;
		}

		public void clickCreateNewView(WebDriver driver) {
			
			if(creatNewView.isDisplayed()) {
				if(CommonUtils.waitForElementClickable(driver, creatNewView)) {
					
					creatNewView.click();
				}
			}else {
				System.out.println("Create New View is not displayed");
			}
			
		}

		public boolean verifyCreateNewViewPageisDaisplayed(WebDriver driver) {
			boolean isTitlePresent=false;
			
			String expectedCreateNewViewPageTitle=TitleConstants.CREATE_NEW_VIEW_PAGE_TITLE;
			
			if(CommonUtils.waitForTitleOfThePage(driver, expectedCreateNewViewPageTitle)) {
				isTitlePresent=true;
			}
			
			return isTitlePresent;
		}

		public void enterViewName(String sViewName) {
			
			if(viewName.isDisplayed()) {
				viewName.clear();
				viewName.sendKeys(sViewName);
			}
			else {
				System.out.println("View Name is not displayed");
			}
		}

		public void enterViewUniqueName(String sViewUniqueName) {
			if(viewUniqName.isDisplayed()) {
				viewUniqName.clear();
				viewUniqName.sendKeys(sViewUniqueName);
			}
			else {
				System.out.println("View Unique Name is not displayed");
			}
		}

		public boolean verifyNewViewCreatedAndDisplyed(String sViewName) {
			boolean isNewViewCreated=false;
			
			if(viewList.isDisplayed()) {
				Select s=new Select(viewList);
				
				if(s.getFirstSelectedOption().getText().equals(sViewName)) {
					isNewViewCreated=true;
				}
				
//				List<WebElement> selectedOps=s.getAllSelectedOptions();
//				
//				if(selectedOps.get(0).getText().equals(sViewName)) {
//					isNewViewCreated=true;
//				}
			}
			
			return isNewViewCreated;
		}

		public void selectViewNameToEdit(String sViewName) {
			
			if(viewDropDown.isDisplayed()){
				Select s=new Select(viewDropDown);
				s.selectByVisibleText(sViewName);
			}else {
				System.out.println("View drop down is not displayed");
			}
			
		}
		
		
         public List<WebElement> getAllOptionsToEdit() {
        	 List<WebElement> options = new ArrayList<WebElement>();
			if(viewDropDown.isDisplayed()){
				Select s=new Select(viewDropDown);
				 options= s.getOptions();
			}else {
				System.out.println("View drop down is not displayed");
			}
			return options;
		}

		public void clickEdit(WebDriver driver) {
			
			if(CommonUtils.waitForElementToVisible(driver, editView)) {
				
				editView.click();
				
			}else {
				System.out.println("Edit Btn is not displayed");
			}
			
		}

		public boolean verifyViewNameToBeEditedOnEditPage(WebDriver driver, String sViewName) {
			boolean isViewNameDisplayed=false;
			
			if(viewName.isDisplayed()) {
				if(viewName.getAttribute("value").equals(sViewName)) {
					isViewNameDisplayed=true;
				}
				
			}else {
				System.out.println("View List is not displayed");
			}
			
			return isViewNameDisplayed;
		}

		public void enterNewVieName(String sNewViewName) {
			if(viewName.isDisplayed()) {
				viewName.clear();
				viewName.sendKeys(sNewViewName);
			}else {
				System.out.println("View name is not displayed");
			}
			
		}

		public void selectField(String sField) {
			if(field.isDisplayed()){
				Select s=new Select(field);
				s.selectByVisibleText(sField);
			}else {
				System.out.println("field is not displayed");
			}
			
		}

		public void selectOperator(String sOperator) {
			if(operator.isDisplayed()){
				Select s=new Select(operator);
				s.selectByVisibleText(sOperator);
			}else {
				System.out.println("operator is not displayed");
			}
		}

		public void enterValue(String sValue) {
			if(value.isDisplayed()) {
				value.clear();
				value.sendKeys(sValue);
			}else {
				System.out.println("Value text is not displayed");
			}
		}

		public boolean selectAvailabeFields(String sAvailableFieldOption) {
			
			boolean isOptionSelected=false;
			if(availableFields.isDisplayed()){
				Select s=new Select(availableFields);
				try {
				s.selectByVisibleText(sAvailableFieldOption);
				isOptionSelected=true;
				}catch(Exception e){
					
					System.out.println("Element to be selected is not in the availableFields");
					
					if(selectedFields.isDisplayed()){
					
						Select s2=new Select(selectedFields);
						s2.selectByVisibleText(sAvailableFieldOption);
						isOptionSelected=true;
				}
			}
			}else {
				System.out.println("AvailableFieldOption is not displayed");
			}
			
			return isOptionSelected;
		}

		
		
		public void clickAddBtn() {
			
			if(addBtn.isDisplayed()) {
				addBtn.click();
			}else {
				System.out.println("add button is not displayed");
			}
			
		}

		public boolean verifyTheEditedNewViewNameDisplayed(String sEditedNewViewName) {
			boolean isTheEditedNewViewNameDisplayed=false;
			
			if(viewList.isDisplayed()) {
				Select s=new Select(viewList);
				if(s.getFirstSelectedOption().getText().equals(sEditedNewViewName)) {
					isTheEditedNewViewNameDisplayed=true;
				}
			}
			
			return isTheEditedNewViewNameDisplayed;
		}

		public boolean verifyTheColumnAddedToViewTable(String sLastColoumnName) {
			boolean isTheColumnAddedToViewTable=false;
			
			for(WebElement ele:viewColumnNames) {
				if(ele.getText().equals(sLastColoumnName)) {
					isTheColumnAddedToViewTable=true;
					break;
				}
			}
			
			return isTheColumnAddedToViewTable;
		}

		public boolean verifyAccountNameContainsLetterADispalyed(String letterShouldBeInTheAccountName) {
			
			boolean isAccountNameContainsLetterADispalyed=false;
			
			for(WebElement ele:accNameList) {
				System.out.println(ele.getText());
		if(ele.getText().contains(letterShouldBeInTheAccountName)||ele.getText().contains(letterShouldBeInTheAccountName.toUpperCase())){
			
			
			
				
				isAccountNameContainsLetterADispalyed=true;
					continue;
				}
			else {
				isAccountNameContainsLetterADispalyed=false;
				break;
			}
				
			}
			
			return isAccountNameContainsLetterADispalyed;
		}

		public void clickAccountsWithLastActivityGreaterThan30Days() {
			
			if(lastActivity.isDisplayed()) {
				lastActivity.click();
			}else {
				System.out.println("Last activity is not Displayed");
			}
		}

		public void clickDateField() {
			
			if(selectDateField.isDisplayed()) {
				
				selectDateField.click();
			}else {
				System.out.println("Date Field is not Displayed");
			}
			
		}

		public void clickCreateDate() {

			if(createDate.isDisplayed()) {
				
				createDate.click();
			}else {
				System.out.println("CreateDate is not Displayed");
			}
			
		}

		public boolean WaitforLoadToDisappear(WebDriver driver) {
			
			boolean isLoadingDisapear=false;
			if(CommonUtils.waitForElementToDisapear(driver, loading)) {
				isLoadingDisapear=true;
			}
			else {
				isLoadingDisapear=false;
			}
			return isLoadingDisapear;
		}

		public void clickFromDateImg() {
			
			if(fromDateImg.isDisplayed()) {
				fromDateImg.click();
			}else {
				System.out.println("From date img is not displayed");
			}
			
		}

		public void clickFromTodayBtn() {
			if(fromToday.isDisplayed()) {
				fromToday.click();
			}else {
				System.out.println("fromToday Btn is not displayed");
			}
			
		}

		public void clickToDateImg() {
			if(toDateImg.isDisplayed()) {
				toDateImg.click();
			}else {
				System.out.println("toDateImg img is not displayed");
			}
			
		}

		public void clickToTodayBtn() {
			if(toToday.isDisplayed()) {
				toToday.click();
			}else {
				System.out.println("toToday Btn is not displayed");
			}
			
		}

		public void clickSaveReportBtn() {
			
			if(reportSaveBtn.isDisplayed()) {
				reportSaveBtn.click();
			}else {
				System.out.println("Report Save btn is not displayed");
			}
			
		}

		public void enterReportName(String sReportName) {
			
			if(reportName.isDisplayed()) {
				reportName.clear();
				reportName.sendKeys(sReportName);
			}else {
				System.out.println("Report NAme is not displayed");
			}
			
		}

		public void enterReportUniqueName(String sReportUniquename)  {
			if(reportUniqueName.isEnabled()&& reportUniqueName.isDisplayed()) {
				
				
				reportUniqueName.sendKeys(sReportUniquename);
				
				
				
			}else {
				System.out.println("Report Unique NAme is not displayed");
			}
		}

		public void clickSaveAndRunBtn(WebDriver driver) {
		CommonUtils.waitForElementToVisible(driver, saveAndRunBtnDiv);
			
			if(saveAndRunBtn.isDisplayed()) {
				if(CommonUtils.waitForElementToVisible(driver, saveAndRunBtn)) {
					
					saveAndRunBtn.click();
					
				}
			}else {
				System.out.println("saveAndRunBtn is not displayed");
			}
			
		}

		public boolean verifyReportPageIsDispalyedWithReportName(WebDriver driver, String sReportName) {
			
			boolean isReportNamePresentOnTheReportPage=false;
			
			if(CommonUtils.waitForTitleContais(driver, sReportName)) {
				
				if(CommonUtils.waitForText(driver, reportNameOnReportPage, sReportName)) {
					isReportNamePresentOnTheReportPage=true;
					
				}
				
			}else {
				System.out.println("Report page does not contains Report name");
			}
			return isReportNamePresentOnTheReportPage;
		}

		public void slectAccountFromList(String accountName2) {
			
			for(WebElement ele:accountNameList) {
				if(ele.getText().equals(accountName2)) {
					if(ele.isDisplayed()) {
						ele.click();
						break;
					}
					
				}
				
			}
			
		}

		public boolean deleteAccount(String accountName2,WebDriver driver) {
			boolean isAccountDeleted=false;
			
			
			
			if(CommonUtils.waitForTitleContais(driver, accountName2)&&(CommonUtils.waitForElementToVisible(driver, mergedAcctPage))) {
				
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
				
				if(CommonUtils.waitForElementToVisible(driver, deleteBtn)) {
					deleteBtn.click();
					try {
						
					Alert alert=CommonUtils.waitForAlert(driver);
					alert.accept();
					isAccountDeleted=true;
					System.out.println("Account deleted  "+accountName2);
					}catch(NoAlertPresentException e) {
						System.out.println(e.getMessage());
					}
				}
			}
			return isAccountDeleted;
			
		}

		public boolean verifyDeleteViewCreated(String sViewName,WebDriver driver) {
			
            boolean isNewViewDeleted=false;
			
			if(viewList.isDisplayed()) {
				Select s=new Select(viewList);
				
				
				
				List<WebElement> selectedOps=s.getAllSelectedOptions();
				
				for(WebElement ele:selectedOps) {
					if(ele.getText().equals(sViewName)) {
						
						s.selectByVisibleText(sViewName);
						if(deleteView.isDisplayed()) {
							deleteView.click();
							driver.switchTo().alert().accept();
							isNewViewDeleted=true;
							
							System.out.println("View created by test case has been deleted :: "+sViewName);
						}
						
					}
				}
			}
			
			return isNewViewDeleted;
			
			
			
		}

		public void clickSaveAndNewBtn(WebDriver driver) {

			if(saveAndNewBtn.isDisplayed()) {
				saveAndNewBtn.click();
			}else {
				System.out.println("Save and new btn is not displayed");
			}
		}

		public boolean verifyAccountsAreCreatd(WebDriver driver, List<String> accounts) {
			
			boolean accountsAreCreated=true;
			
			
			for(int i=0;i<accounts.size();i++) {
			for(WebElement ele:accountNameList) {
				

				if(ele.getText().equals(accounts.get(i))){
					
					accountsAreCreated=true;
					break;
				}
				
			
			}
			
			if(accountsAreCreated==false) {
				break;
			}
			
			}	
			
			
			return accountsAreCreated;
		}

		public void clickMergeAccountsLink() {

			if(mergeLink.isDisplayed()) {
				mergeLink.click();
			}else {
				System.out.println("Merge account not displayed");
			}
		}

		public boolean verifyMergeAccountPageDisplayed(WebDriver driver) {
			
			boolean isMergeAccountPageDisplayed=false;
			
			if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.MERGE_ACCOUNT_PAGE_TITLE)) {
				isMergeAccountPageDisplayed=true;
			}
			return isMergeAccountPageDisplayed;
		}

		public void enterTextToFindAccountToMerge(String accountName) {
			
			if(textToMergeAcc.isDisplayed()) {
				textToMergeAcc.clear();
				textToMergeAcc.sendKeys(accountName);
			}else {
				System.out.println("Text is not present not displayed");
			}
		}

		public void clickFindAccountBtn() {

			if(findAccountsBtn.isDisplayed()) {
				findAccountsBtn.click();
			}else {
				System.out.println("findAccountsBtn is not present not displayed");
			}
		}

		
		public List<String> mergeAccounts() {
			
			List<String> mergingAccounts=new ArrayList<String>();
		
			try {
			int i=0;
			int x=0;
			for(WebElement ele:accountsNameRadioBtnListToMerge) {
				mergingAccounts.add(accountsNameListToMerge.get(x).getText());
				if(!ele.isSelected()) {
					ele.click();
				}
				else {
					System.out.println("Account name "+ele.getText()+" already selected");
				}
				
				i++;
				x++;
				if(i==3) {
					break;
				}
			}
			
			if(nextBtn.isDisplayed()) {
				nextBtn.click();
			}else {
				System.err.println("Next btn is not displayed");
			}
			
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			System.out.println("Accounts are not displayed to select");
		}
			return mergingAccounts;
	
	
	
		}

		public boolean verifyMergeMyAccountsDisplayed(WebDriver driver, List<String> accountsToBeMerged) {
			String expectedText="Merge My Accounts";
		
			boolean isMergeMyAccountsDisplayed=false;
			
			if(mergeAccountHeaderText.isDisplayed()) {
				if(mergeAccountHeaderText.getText().equals(expectedText)) {
					System.out.println("***************");
			for(int i=0;i<accountsToBeMerged.size();i++) {
				List<WebElement> accuntsList=driver.findElements(By.xpath("//table[@class='mergeEntity']//tbody//tr[4]//td"));
				for(WebElement ele:accuntsList) {
					System.out.println("***************&&&&&&&&&&&&");
					System.out.println(ele.getText());
					System.out.println(accountsToBeMerged.get(i));

					if(ele.getText().equals(accountsToBeMerged.get(i))){
						
						isMergeMyAccountsDisplayed=true;
						break;
					}
					
				
				}
				
				if(isMergeMyAccountsDisplayed==false) {
					break;
				}
				
				}	
				}
			}
			

			return isMergeMyAccountsDisplayed;
		}

		public void clickMergeBtn(WebDriver driver) {

			if(mergeBtn.isDisplayed()) {
				mergeBtn.click();
				try {
					Alert alert=CommonUtils.waitForAlert(driver);
					alert.accept();
					
				}catch(NoAlertPresentException e) {
					System.out.println(e.getMessage());
				}
			}else {
				System.out.println("Merge Btn is not displyaed");
			}
		}

		public String getMergedAccountName() {
			String accountName = null;
			
			
			int i=0;
			for(WebElement ele:mergeAccountRadioBtnsOnMergeMyAccPage) {
			String name=mergeAccountNamesOnMergeMyAccPage.get(i).getText();
				if(ele.isSelected()) {
					accountName=name;
					break;
				}
				i++;
			}
			
		
			return accountName;
		}

		public void clickGoBtn(WebDriver driver) {
			
			
			
			if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.ACCOUNTS_PAGE_TITLE)){
				if(goBtn.isDisplayed()) {
					goBtn.click();
				}else {
					System.out.println("Go btn is not displayed");
				}
			}else {
				System.out.println("Page is not on Accounts home page");
			}
			
			
		}

		public void deleteReport(WebDriver driver) {
			if(CommonUtils.waitForElementClickable(driver, deleteAccReport)) {
				deleteAccReport.click();
				try {
				Alert alert=CommonUtils.waitForAlert(driver);
				alert.accept();
				}catch(NoAlertPresentException e) {
					System.out.println("Alert not present");
				}
			}
			else {
				System.out.println("delete report btn is not displayed");
			}
		}
}
