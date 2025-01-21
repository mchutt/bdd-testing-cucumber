Feature: Sauce Demo testing
  As a user, I want to buy something from Sauce Demo webpage

  Background:
    Given I am on login page

  Scenario: User places an order
    When I log in with credentials from database
    Then Product list page is opened
    When I make order and proceed to checkout
    Then I have successful order notification

  Scenario Outline: User adds products to cart and verify their presence
    When I log in as <userId> user
    Then Product list page is opened
    When I add several products to cart
    Then I have products in my cart in my cart
    Examples:
      | userId |
      | 2      |
      | 1      |
