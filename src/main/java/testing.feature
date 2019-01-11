Feature: Testing
  I want to use this template for my feature file

  @tag1
  Scenario: Testing Add Customer Functionality
    Given User is in telecom page
    And The user navigates to add customer page
    When The user fill in the details
    |BGCHECK|Done|
    |FNAME|ABC|
    |LNAME|XYZ|
    |EMAIL|abcxyz@gmail.com|
    |ADDRESS|testing|
    |PHONE|1234567890|
    And The user clicks submit button  
    Then User should see the generated customer id

  