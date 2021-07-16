@Flow05
Feature: Flow05_Generation of Truck Order after breakdown with pieces less than manifested pieces

  Scenario: Generation of Truck Order after breakdown with pieces less than manifested pieces
    Given Login to Application and switch role for Flow05
    When Do Truck flight creation for Flow05
    And Do Booking till acceptance in LTE001 screen for Flow05
    And Do Build-up and Manifestation in OPR344 screen for Flow05
    And Generate Truck Order in TRK001 screen for Flow05 after manifestation
    And manifestation is done, finalise the flight and mark the movement for Flow05
    Then do breakdown with pieces less than the manifested pieces and generate the Truck order for Flow05
