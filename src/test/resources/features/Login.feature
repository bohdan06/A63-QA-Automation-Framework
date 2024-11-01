Feature:

  Scenario: Login Positive scenario
    Given I open Koel login page
    When I enter email "bohdan.ivasiv@testpro.io"
    And I enter password "TkSDMvReT57X$ym"
    And I submit
    Then I am logged in