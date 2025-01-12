@PrestaShopPurchase
Feature: PrestaShop Purchase Test Cases

  @AddToCart @SkipLogin
  Scenario Outline: Add products to cart by categories, colors, sizes and quantities
    Given User configures item with "<Category>", "<Color>", "<Size>", and "<Quantity>"
    And User adds the item to the cart
    Then Verify the item is successfully added to the cart

    Examples:
      | Category      | Color    | Size    | Quantity |
      | CLOTHES       | Black    | M       | 2        |
      | CLOTHES       | White    | L       | 1        |
      | ACCESSORIES   | None     | None    | 3        |
      | ART           | None     | None    | 1        |