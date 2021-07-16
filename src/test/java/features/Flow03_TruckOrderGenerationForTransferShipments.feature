@Flow03
Feature: Flow03_Generation of Truck order for transfer shipments ,Truck Cost estimation and Validate the versions of truck order after every transaction

  Scenario: Generation of Truck order for transfer shipments ,Truck Cost estimation and Validate the versions of truck order after every transaction
    Given Login to Application and switch role for Flow03
    #When Do Truck flight creation for Flow03
    And Do Booking in CAP018 screen for Flow03
    And Do Capture and Acceptance in LTE001 screen for Flow03
    And Do Build-up and Manifestation in OPR344 screen for Flow03
    And Do CTM Outbound in OPR002 for Flow03
    Then Generate Truck Order with transfer shipments ,Truck Cost estimation and Validate the versions of truck order in TRK001 screen for Flow03
