@Flow09
Feature: Flow09_Generation of Truck Order after breakdown with pieces less than manifested pieces

  Scenario: Generation of Truck Order after breakdown with pieces less than manifested pieces
    Given Login to Application and switch role for Flow09
    When Do Truck flight creation for Flow09
    And Do Booking till acceptance in LTE001 screen for Flow09
    And Do Build-up and Manifestation in OPR344 screen for Flow09
    Then in TRK001 screen, verify ATD error and add charge head for Flow09 after manifestation
