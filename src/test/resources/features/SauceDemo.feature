Feature: Order Products on SauceDemo
  As a user, I want to buy something from Sauce Demo webpage

  Background:
    Given I am on login page

  Scenario: User places an order
    When I log in with credentials from database
    Then Product list page is opened
    When I make order
    Then I have successful order notification

  Scenario: Check total price of order is correct for user with id 2
    When  I log in as 2 user
    Then Product list page is opened
    When I proceed to checkout
    Then I have correct total price

  Scenario: Verify adding product to cart
    When I log in as 3 user
    Then Product list page is opened
    When I add product to cart
    Then I have a product in my cart

  Scenario: Verify sorting product in ascending order
    When I log in as 4 user
    Then Product list page is opened
    When I sort the products by price
    Then I verify product sorting correctly
