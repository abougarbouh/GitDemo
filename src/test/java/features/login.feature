Feature: login into Application

  Scenario Outline: positive test validating login
    Given Initialize the browser with chrome
    And Navigate to "http://www.qaclickacademy.com/" Site
    And Click on Login link in home page to land on secure sign in Page
    When User enters <username> and <password> and logs in
    Then Verify that user is successfully logged in
    And close browser

    Examples:
      | username | password |
      | ahmed    | 2243     |
      | sami     | 4445     |
