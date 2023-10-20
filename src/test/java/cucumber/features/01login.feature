Feature: Login Page SwagLabs

  @TDD @Login
  Scenario Outline: User login Swaglabs site, status <status>
    Given Login page SwagLabs
    When User input <username> as username
    And User input <password> as password
    And Click login button
    Then I Verify <status> login result

    Examples:
      | username       | password | status  |
      | standard_user  | secret_sauce | success |
      | user_salah     | usersalah    | failed  |