Feature: certificate Check
  As a user,
  I want to enter invalid certificate number and to see "Сертификат не найден"

  Scenario Outline:  Verify "Сертификат не найден" message appears when invalid value inputted
    Given I am on Certificate page
    Then I can see Certificate input field
    When I fill out the following parameters:
      | id   | number   |
      | <id> | <number> |
    Then Certificate not found

    Examples:
      | id | number                         |
      | 0  | W99SCoGHfvbChBy                |
      | 1  | dKfH2                          |
      | 2  | 3ARfeJ6Vxj                     |
      | 3  | hyF8XUrEbe0nbR5IOHtk4VVEbGMVSO |