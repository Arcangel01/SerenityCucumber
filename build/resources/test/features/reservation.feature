Feature: Check available flights
  As a user I want to check a flight with the lowest price

  Scenario: Check cheap flights
    Given Arcangel wants to select the cheapest flight
    When Arcangel wants to compare the initial value with the final value
    Then Arcangel makes the reservation