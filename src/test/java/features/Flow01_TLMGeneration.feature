@Flow01
Feature: Flow01_Generation of Truck load manifest

  Scenario: Generation of Truck load manifest
    Given Login to Application and switch role for Flow01
    When Do Truck flight creation for Flow01
    And Do Booking in CAP018 screen for Flow01
    And Do Capture and Acceptance in LTE001 screen for Flow01
    And Do Build-up and Manifestation in OPR344 screen for Flow01
    Then Generate Truck Order in TRK001 screen for Flow01
