Feature: Web Test

  Scenario: Google sum
    Given I go to google
    When I insert a number
    Then The answer should be

  Scenario: Amazon terms and conditions
    Given I go to amazon
    Then I click on todays deals
    Then I click on terms and conditions
    And I print all statements

  Scenario: Amazon shopping cart
    Given search for notepad
    Then click on the second item
    And add to basket
    Then go to the shopping cart
    And check the item is added

