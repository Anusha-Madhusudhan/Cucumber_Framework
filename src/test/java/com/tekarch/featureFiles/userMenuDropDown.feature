Feature: User menu drop down

  @regression
  Scenario: Select user menu drop down
    Given User should Launch and login to the application "https://login.salesforce.com/"
    When User clicks on the User Menu drop down on the home page
    Then User should be able to see the drop down options
      #List<Map<String, String>>
      | UserMenuItems                  |
      | My Profile                     |
      | My Settings                    |
      | Developer Console              |
      | Switch to Lightning Experience |
      | Logout                         |
     #List<List<String>>:
      #| My Profile | My Settings | Developer Console | Switch to Lightning Experience | Logout |

   @regression   
   Scenario Outline: Select My Profile option from user menu  drop down
   Given User should Launch and login to the application "https://login.salesforce.com/"
    When User clicks on the  "My profile" option from user menu drop down
    Then User Sould see the User profile page 
    When User Clicks on edit profile button to edit contact information
    Then Edit profile pop up window is displayed with contact and About tabs to edit. 
    When User Clicks on About tab and enter <Last name>
    And User clicks on save all button
    Then UserProfilePage with changed <Last name> is displayed
    When User Clicks on Post link, 
    And User enters the <text> to post in the post text area and click on share button
    Then <text> entered should be displayed on the page
    When User clicks on the  file link and click on upload a file from computer button.
    And User Clicks on choose file button and select a file to be uploaded and click open button.
    Then Selected file should be posted
    When User Hover the mouse on myprofilephoto image and Add photo link appears. 
    And User Clicks on the link to upload a photo. 
    And User Clicks on Choose file button and select the image to upload. 
    Then Uploaded photo should appear on the image.
    
   Examples:
|Last name|text| 
|"Sumedh"|"ABCDEFGH"|

@regression
Scenario Outline: Select My settings option from user menu  drop down
 Given User should Launch and login to the application "https://login.salesforce.com/"
 When  User Click My Settings option from user menu
 Then My Settings page is displayed
 When User Clicks on personal link and select Login History link.
 And  Click on Download login  history link.
 Then Login history is displayed and the data is downloaded in .csv format.
 When User Clicks on Display & Layout link and select Customize My Tabs link. 
 And User Selects Salesforce Chatter option from custom App: drop down. 
 And User Selects Reports tab from Available Tabs list.
 And  Click on >(Add) button. 
 Then Reports field is added to Selected Tabs list and also added in the links available in top of salesforce page and sales force chatter page and sales and marketing pages.
 When User Clicks on Email link and click on my email settings link under that
 And User Provides <EmailName> in Email Name field, <EmailAddress> in Email Address field, 
 And Select automatic BCC radio button 
 And click on save button
 Then provided details are saved as default mail options and My settings page is displayed.
 When User Clicks on Calendar & Remainders
 And User clicks on Activity Remainders link.
 And  On Remainders page click on Open a test Remainder button.
 Then Sample event pop window is dispayed.

Examples:
|EmailName|EmailAddress| 
|"Anusha"|"anusha.basavaraj28@gmail.com"|

Scenario: Select Developers Console option from user menu  drop down
Given User should Launch and login to the application "https://login.salesforce.com/"
When User Clicks on Developer Console link from the User Menu drop down
Then Force.com Developer Console window is displayed
When User Clicks on close button the developer console browser
Then Force.com Developer Console window is closed


Scenario: Select Logout option from user menu  drop down
Given User should Launch and login to the application "https://login.salesforce.com/"
When User Clicks on Logout option from the User Menu drop down
Then Logout  of current sales force application  and Login page is displayed.






    