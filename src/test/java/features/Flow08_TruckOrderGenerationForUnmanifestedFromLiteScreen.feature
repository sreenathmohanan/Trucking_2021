@Flow08
Feature: Flow08_Truck order changes when unmanifested AWB is added to LTE003 at Destination in Lite station

  Scenario: Truck order changes when unmanifested AWB is added to LTE003 at Destination in Lite station
    Given Login to Application and switch role for Flow08
    When Do Truck flight creation for Flow08
    And Do Booking till acceptance in LTE001 screen for Flow08
    And Do Build-up and Manifestation in OPR344 screen for Flow08
    And Generate Truck Order in TRK001 screen for Flow08 after manifestation
    And manifestation is done, finalise the flight and mark the movement for Flow08
    Then In LTE003 screen add the unmanifested AWB for Flow08 and generate the truck order
