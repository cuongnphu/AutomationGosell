Feature: Login GoSELL

  Scenario Outline: Test positive TCs login
    Given Open GoSELL website
    When Login GoSELL with username as "<username>" and password as "<password>"
    Then Verify login GoSELL
    And Logout GoSELL
    Examples:
      | username  | password |
      | cuongstg@yopmail.com | 123456@X |
      | baotran123@yopmail.com | 123456x@X |

  