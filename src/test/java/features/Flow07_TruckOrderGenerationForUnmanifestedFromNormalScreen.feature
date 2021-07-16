@Flow07
Feature: Flow07_Truck order changes when unmanifested AWB is added to Import Manifest at Destination in full station

  Scenario: Truck order changes when unmanifested AWB is added to Import Manifest at Destination in full station
    Given Login to Application and switch role for Flow07
    When Do Truck flight creation for Flow07
    And Do Booking till acceptance in LTE001 screen for Flow07
    And Do Build-up and Manifestation in OPR344 screen for Flow07
    And Generate Truck Order in TRK001 screen for Flow07 after manifestation
    And manifestation is done, finalise the flight and mark the movement for Flow07
    Then do breakdown with pieces less than the manifested pieces and generate the Truck order for Flow07
