Feature: Add the product to filpkart cart
As a user I want to add the Bose Sport Earbuds into the cart and compare the details between cart checkout page and the product description page 

#  Background:
#  	Given I have installed an flipkart application on my device
#  	And I logged in as dummy user
#  	
#  Scenario: As user I want to add the Bose Sport Earbuds to cart, compare the details and uninstall the application
#    Given I have 42 cukes in my belly
##    When I wait 1 hour
##    Then my belly should growl

  Scenario: Login as valid user
    Given I go to the login page of flipkart app
    And I enter email and password from datafile
    When I search for the item from datafile
    And I look into the detail page of the item
    And I add the item to the cart
    Then I go to the cart and increase the quantity
    And I increase the quantity of the item from datafile
    And verify that only added item is available in the cart
    And I remove the item from the cart   
