Feature: Sauce demo testing
  In order to use Cucumber in my project, I want to check how to test Sauce demo

  Scenario Outline: Checkout functionality
    Given I am on login page
    When I login with '<username>' and 'secret_sauce' credentials
    Then page 'ProductList' should be open
    Examples:
      | username      |
      | standard_user |
      | visual_user   |
