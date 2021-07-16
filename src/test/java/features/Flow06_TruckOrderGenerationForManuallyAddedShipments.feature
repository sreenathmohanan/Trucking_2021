@Flow06
Feature: Flow06_Generation of Truck Order involving manually added shipments.

  Scenario: Generation of Truck Order involving manually added shipments.
    Given Login to Application and switch role for Flow06
    When Do Truck flight creation for Flow06
    And Do one till Booking and other till acceptance in LTE001 screen for Flow06
    And Do Build-up and Manifestation in OPR344 screen for Flow06
    Then List the flight in TRK001 Screen and manually add the shipment for Flow06
