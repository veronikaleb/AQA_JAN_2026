Feature: Test with API + DB + Selenium

  Scenario: Retrieve, store and google random people
    #API
    Given I request 3 random people from service
    #DB
    Given I store these people in DB
    When I pick 1 random person from DB
    #WEB
    When I open google main page
    When I accept cookies if present
    Then I set search field to that person's first and last name