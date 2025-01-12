@PrestaShopLogin
Feature: PrestaShop Login Check Test Cases

  Background:
    Given User click sign in button on homepage
  @AllEmpty
  Scenario Outline: Check  "<username>" username "<password>" password for login
    And write "<username>" for username field
    And write "<password>" for password field
    And Click sign in button
    Then Check unsuccessful login
    Examples:
      |username       |password   |
      |empty          |empty      |
      |abcdefg        |empty      |
      |empty          |123456     |

  @UnsuccessfulLogin
  Scenario Outline: Check Correct "<username>" username & False "<password>" Password for login
    And write "<username>" for username field
    And write "<password>" for password field
    And Click sign in button
    Then Check the "<error>" message that authentication was not successful
    Examples:
      | username     | error                  | password |
      | correctEmail | Authentication failed. | abc1234  |


  @SuccessfulLogin
  Scenario Outline: Correct "<username>" Username &  Correct "<password>" Password for login
    And write "<username>" for username field
    And write "<password>" for password field
    And Click sign in button
    Then Check Successful login
    Examples:
      | username     | password        |
      | correctEmail | correctPassword |





