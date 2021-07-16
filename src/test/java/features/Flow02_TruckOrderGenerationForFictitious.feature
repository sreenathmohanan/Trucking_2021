@Flow02
Feature: Flow02_Creation of Adhoc Truck for New Lane through GSA and Generation of Truck order for Fictitious Truck Flight

  Scenario: Creation of Adhoc Truck for New Lane through GSA and Generation of Truck order for Fictitious Truck Flight
    Given Login to Application and switch role for Flow02
    When Create an Ad-Hoc Truck in FLT003 screen for Flow02
    Then Generation of Truck Order for the Fictious truck for Flow02
