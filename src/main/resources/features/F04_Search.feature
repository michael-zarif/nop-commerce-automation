@smoke @search
  Feature: F04_Search | User search for different products

    Scenario Outline: User could search for an product using product name
      Given User go to home page
      When User searches for "<product>"
      Then User is navigated to "<product>" search results page
      Examples:
        | product |
        | book    |
        | laptop  |
        | nike    |

    Scenario Outline: User could search for an product using product sku
      Given User go to home page
      When User searches for "<product>"
      When User opens product page
      Then User finds the "<product>" keyword in the product page
      Examples:
        | product |
        | SCI_FAITH    |
        | APPLE_CAM  |
        | SF_PRO_11    |