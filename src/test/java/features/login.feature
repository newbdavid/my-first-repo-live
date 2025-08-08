Feature: Login feature on Heroku App
  Scenario: Successful login
    Given I am on the login page
    When I type username "tomsmith" and password "SuperSecretPassword!"
    And I click on the login button
    Then I will see the heading "Secure Area"

  Scenario: Login with wrong credentials
    Given I am on the login page
    When I type username "David" and password "SuperSecretPassword!"
    And I click on the login button
    Then I should see an error message