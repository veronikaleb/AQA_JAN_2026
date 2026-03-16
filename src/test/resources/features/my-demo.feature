Feature: my web feature

  Background: pre scenario
    Given Preconditions are "OK"

#  Scenario: my scenario
#    Given Set user password to "aaabcabcaaabcabc1"
#    Given There parameters are "param 1" and "param 2"
#    When I do something 5 times
#    Then Something happens with VALUE_4

  Scenario Outline: my scenario
    Given Set user password to "<password>"
    Given There parameters are "param 1" and "param 2"
    When I do something 5 times
    Then Something happens with VALUE_1
    Examples:
      | password          |
      | abcabc1           |
      | aaabcabc          |
      | aaabcabcaaabcabc1 |


#    password must be 8-16 symbols and 1 digit
  # NEgative: 7 symbols with digit
  # negative: 8 symbols without digit
  # negative: 17 symbols with digit