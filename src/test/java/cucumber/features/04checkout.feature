Feature: Checkout Product

  @TDD @Checkout @CheckoutValid
  Scenario: User Checkout Product with Valid Detail Shipping
    Given User logged in and on Products page
    When User clicked Add to Cart for one of the product
    And User clicked Cart icon on the top right side
    And User clicked Checkout button
    And User input first name
    And User input last name
    And User input zip code
    And User clicked Continue button
    And User checked the product in checkout
    And User clicked Finish button
    Then User should see checkout complete confirmation

  @TDD @Checkout @CheckoutInvalid
  Scenario Outline: User Checkout Product with Invalid Detail Shipping
    Given User logged in and on Products page
    When User clicked Add to Cart for one of the product
    And User clicked Cart icon on the top right side
    And User clicked Checkout button
    And User input <firstName> as first name
    And User input <lastName> as last name
    And User input <zipCode> as zip code
    And User clicked Continue button
    Then User should see alert <alertMessage> must be filled

    Examples:
      | firstName | lastName | zipCode | alertMessage |
      |           |        |      | Error: First Name is required      |
      | Andi      |        |      | Error: Last Name is required       |
      | Andi      | Mallarangeng |      | Error: Postal Code is required       |
      | Andi      | Mallarangeng | NotPostCode     | Error: Postal Code format is not number       |
