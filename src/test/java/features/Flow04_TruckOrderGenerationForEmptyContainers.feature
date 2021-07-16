@Flow04
Feature: Flow04_Generation of Truck Order with Empty Containers appended

  Scenario: Generation of Truck Order with Empty Containers appended.
    Given Login to Application and switch role for Flow04
    When Do Truck flight creation for Flow04
    And Do Booking in CAP018 screen for Flow04
    And Do Capture and Acceptance in LTE001 screen for Flow04
    And Do Build-up and Manifestation in OPR344 screen for Flow04
    Then Generate Truck Order with Empty Containers appended in TRK001 screen for Flow04
