Feature: Sauce Demo testing
  As a user, I want to buy something from Sauce Demo webpage

  Scenario Outline: Checkout functionality
    Given I am on login page <userId>
    When I fill in my username and password as credentials
    And I add the products to the cart
    And I open cart page and click on checkout button
    And I fill in my first name last name and zipCode and click on continue button
    And I click on finish button
    Then A success message should be visible
    Examples:
      | userId |
      | 1  |
      | 2  |
