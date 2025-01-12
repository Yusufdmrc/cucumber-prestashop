@PrestaShopRegister
Feature: PrestaShop Register Test Cases

  Scenario: User registers with random data
    Given User navigates to the registration page
    When User fills the registration form with random data
    And User submits the registration form
    Then Verify the account is successfully created
