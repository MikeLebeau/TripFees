Feature: as a travel agency, I want to calculate travel fees depending on the departure and destination trip
  The travel price is computed using the travel fees and the agency fees added together.

  Scenario: Determine the fees for a supported destination
    Given the customer want to travel to "Paris"
    And the travel fees are 800€
    And the agency fees are 50€
    When the system calculate the travel fees
    Then the travel price is 850€