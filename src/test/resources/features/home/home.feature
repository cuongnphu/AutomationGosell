Feature: Verify GoSELL Home page

  Scenario Outline: Verify GoSELL Home page
    Given Open GoSELL website
    When Login GoSELL with username as "<username>" and password as "<password>"
    Then Verify Home page
    Examples:
      | username  | password |
      | cuongstg@yopmail.com | 123456@X |