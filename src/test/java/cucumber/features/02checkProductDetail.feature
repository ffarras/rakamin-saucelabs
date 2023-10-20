Feature: Check Product Detail

  @TDD @CheckProductDetail
  Scenario: User is able to check the detail of product
    Given User logged in and on Products page
    When User clicked one of the products
    Then User in Product Detail page