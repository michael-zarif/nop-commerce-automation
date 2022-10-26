@smoke @currencies
  Feature: F03_Currencies | User change default currency

    Scenario: User could change currency to Euro on Home Page
      Given User go to home page
      When User selects "Euro" currency
      Then Price Labels currency is changed to "€"