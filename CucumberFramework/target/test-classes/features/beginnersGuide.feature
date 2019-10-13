Feature:  Beginners Guide page

  @beginnersGuide
  Scenario Outline: Verification of fields in Beginners Guide page
    Given I navigate to <pageName> page
    #And I verify that page contains text "Selenium: Beginners Guide"
    #And I verify that page contains text "Below is a list of links to the examples needed in the chapters. Click on the links below and follow the steps in the book."
    And I verify that chapter1 link exists
    And I verify that chapter2 link exists
    And I verify that chapter3 link exists
    And I verify that chapter4 link exists
    And I verify that chapter8 link exists
    And I add 3 adults
    And I verify that country dropdown has options
    |INDIA|
    |JAPAN|
    |USA  |
    |SRILANKA|
    |PAKISTAN|
    And I have 3 adults
    |Adult1|Adult2|Adult3|
    |A     |B     |C     |
    |29    |31    |32    |
    #And I enter text "abcd" in q text field
  Examples:
    |pageName|
    |Beginners Guide|
    |About us       |
    |Careers       |
    |Dashboard     |


