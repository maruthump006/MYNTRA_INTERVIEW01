Feature: Myntra Web Application Automation

  Scenario: Add T-Shirt to Bag
    Given I open the Myntra web application
    And I type and search for the "T-Shirt" product
    And I select the first product
    And I select the "M" size
    And I click the "Add To Bag" button
    Then I close the current tab
    And I click the bag icon
    And I take a screenshot of the selected bag
