Feature: Final Bill Calculation

  @ScenarioOutlineExample
  Scenario Outline: Customer Bill Amount Calculation
    Given I have a Customer
    And user enters initial bill amount as <InitialBillAmount>
    And Sales Tax Rate is <TaxRate> Percent
    Then Final bill amount calculate is <CalculateBillAmount>
    Examples:
      | InitialBillAmount | TaxRate | CalculateBillAmount |
      | 100               | 10      | 110                 |
      | 200               | 8       | 2161                |
      | 100               | 1.55    | 101.55              |