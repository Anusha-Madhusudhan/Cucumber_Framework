Feature: Login feature to SFDC application

  @regression
  Scenario: Login Error Message
    Given Launch App "https://login.salesforce.com/"
    When User enters User Name "anusha@tek.com"
    And User clears the Password field
    And User clicks on the Login button
    Then User should see the error message "Please enter your password." should be displayed
    #And Close the browser

  #@regression @smoke
  #Scenario Outline: Login with multiple creds
    #Given Launch App "https://login.salesforce.com/"
    #When User enters User Name <username>
    #And User enters Password <password>
    #And User clicks on the Login button
    #Then User should be navigated to Home page
    #And Close the browser
#
    #Examples: 
      #| username         | password    |
      #| "anusha@tek.com" | "Sumedh@03" |
      #| "anu@tek.com"    | "Sumedh@03" |
      #| "anusha@tek.com" | "Sumedh"    |
      #| "anu@tek.com"    | "Sume"      |

  @regression
  Scenario: Check RemeberMe
    Given Launch App "https://login.salesforce.com/"
    When User enters User Name "anusha@tek.com"
    And User enters Password "Sumedh@03"
    And User slects Remember me check box
    And User clicks on the Login button
    Then User should be navigated to Home page
    When User clicks on  User Menu button and clicks Log Out button
    Then User Should be navigated to Login Page
    And User Name should be displayed on User name field.

  @regression
  Scenario: Forgot Password-A
    Given Launch App "https://login.salesforce.com/"
    When User clicks on forgot Password link
    Then User Should be navigated to sales force forgot password page
    When User provides user name "anusha@tek.com" in the user name field
    And User clicks on continue button
    Then Passwprd reset message page should be displayed.
    And User should get the email to reset the password

  @regression
  Scenario: Forgot Password-B
    Given Launch App "https://login.salesforce.com/"
    When User enters User Name "anusha@tek.com"
    And User enters wrong Password "12345"
    And User clicks on the Login button
    Then User should get Error message
    #And Close the browser
