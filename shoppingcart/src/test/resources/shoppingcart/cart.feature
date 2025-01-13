Feature: Shopping Cart Management
  As a customer
  I want to manage my shopping cart
  So that I can prepare my order

  Scenario Outline: Adding products to cart without discount
    Given an empty shopping cart
    When I add <quantity> "<product>" with unit price of <price> dollars
    Then the cart should contain <quantity> items
    And the total amount should be <total> dollars

    Examples:
      | product           | quantity | price  | total |
      | Python Book      | 2        | 24.99  | 49.98 |
      | USB Webcam       | 1        | 59.99  | 59.99 |
      | Wireless Charger | 3        | 15.99  | 47.97 |

  Scenario Outline: Adding products to cart with discount
    Given an empty shopping cart
    When I add <quantity> "<product>" with unit price of <price> dollars and <discount> percent discount
    Then the cart should contain <quantity> items
    And the total amount should be <total> dollars

    Examples:
      | product           | quantity | price  | discount | total  |
      | Gaming Monitor   | 1        | 299.99 | 20      | 239.99 |
      | Mechanical Mouse | 2        | 49.99  | 15      | 84.98  |
      | Gaming Headset   | 1        | 129.99 | 30      | 90.99  | 