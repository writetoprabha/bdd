Feature: Login to rediff.com

  @Login
  Scenario: Login to rediiff.com using user id and password
    Given I open firefox
    And I navigate to rediffHomePage
    And I click on login
    And I wait for 3000 milliseconds
    And I enter writetoprabha in userId text field
    And I enter password1 in password text field
    And I click on go
    And I verify that page contains text
    |Temporary error occured[#5001], please try again.|


  @Login
  Scenario: Login to rediiff.com using user id and password
    Given I open firefox
    And I navigate to rediffHomePage
    And I click on login
    And I wait for 3000 milliseconds
    And I enter writetoprabha in userId text field
    And I enter password1 in password text field
    And I click on go
    And I verify that page contains text
      |Temporary error ocured[#5001], please try again.|
