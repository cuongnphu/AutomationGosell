Feature: Verify GoSELL Product page

  Scenario Outline: Verify GoSELL Product page
    Given Open GoSELL website
    And Login GoSELL with username as "<username>" and password as "<password>"
    When Go to Product page
    Then Verify Product page
    Examples:
      | username  | password |
      | cuongstg@yopmail.com | 123456@X |