
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
     Background: 
     Given I landed on LoginPage 

  @tag2
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    Then Checkout <productName> and submit the order
    

    Examples: 
      | name                     | password      |    productName   |
      | akshita.sharma@gmail.com | Tarun123@     |    ZARA COAT 3   |
      
