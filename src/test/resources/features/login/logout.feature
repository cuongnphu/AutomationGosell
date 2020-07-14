Feature: Logout GoSELL

  Scenario Outline: Test positive TC logout
    Given Open GoSELL website
    When Login GoSELL with username as "<username>" and password as "<password>"
    And Logout GoSELL
    Then Verify login GoSELL page
    Examples:
      | username | password |
      | cuongstg@yopmail.com | 123456@X |