Feature: Login data driven test from json file

  @dataDriven
  Scenario Outline: Login with multiple creds
    Given Launch App "https://login.salesforce.com/"
    When User enters User Name and password <count>
    And User clicks on the Login button
    Then User should be navigated to Home page
    #And Close the browser

    Examples: 
      | count |
      |     0 |
      |     1 |
      |     2 |
      |     3 |
