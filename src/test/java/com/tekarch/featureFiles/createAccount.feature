Feature: CreateAccount

Background:
Given  User should Launch and login to the application "https://login.salesforce.com/"
When User Clicks on Accounts link on the home page
Then Accounts page is displayed with correct UserName

@createNewaccount
Scenario: TC10 CreateAccount
When User Clicks on the New button to create new account
Then New Account edit page is displayed.
When User enters Account name  select type as Technology partner from drop down, set coustomer priority as high 
And User clicks on save button
Then New account page is displayed with account details.

@createnewview
Scenario: TC11 Createnewview
When User Clicks on create new view link on accounts page
And User provides View name, View unique name and click on save button 
Then Newely added View should be displayed in the account view list

@Editview
Scenario: TC12 Editview 
When User selects the view name from the view drop down list on the account page 
And User clicks on the Edit link the accounts page.
Then View name edit page Is displayed
When User Change the view name to new view name. 
And Select the filters field , operator , Value in Select fields to display, 
|filters field|operator|Value|
|Account Name|contains|a|
And User  Clicks on save button.
Then View page with New view name in the drop down is displayed.
And  View will have Last activity column added and the data of the list will have all account names which has a in the text.


@MergeAccounts
Scenario: TC13 MergeAccounts
When On the accounts page in Tools area, click on Merge Accounts link.
And User enters the Account name in the text box of merge accounts page and click Find accounts button.
And Entered Account name should result in atleast 2 or more account links. Select first two account links displayed in the list 
And click on Next button
Then Merge by Accounts step two page is displayed with the selected accounts details to merge
When Click on Merge button on Merge by accounts step two page. 
And Click on OK button on the pop up.
Then Once the accounts are merged, account page is displayed. In recently viewed view, new merged account is listed.

#Scenario: TC14 Create account report
#When User clicks on Accounts with last activity > 30 days link in reports area on accounts page. 
#Then Unsaved Repoet page is diaplayed
#When User Selects create date in the date field drop down, select todays date in From and To fileds on the unsaved report filed
#Then List of accounts qualified is displayed
#When User Clicks on the save button on unsaved report page.
#And  Provide report name, report unique name in the pop window and click on save and run report button.
#Then Report page with details and report name is displayed.
#










