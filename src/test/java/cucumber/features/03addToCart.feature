Feature: Add Product to Cart

  @TDD @AddToCart
  Scenario: User is able to add a product to cart
    Given User logged in and on Products page
    When User clicked Add to Cart for one of the product
    And User clicked Cart icon on the top right side
    Then User should see details of added product