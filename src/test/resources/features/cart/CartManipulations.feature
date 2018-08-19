Feature: Cart Manipulations
  In order to have a control over cart
  As a customer
  I want to have a possibility to add, update, remove items in the cart

  Scenario: Manipulating with cart
    Given the user is on the home page
    When the user navigates to the shop page
    Then the user should see that cart is empty
    And the page title should be 'ait-ht | STORES'
    And the number of available products is '12'

    When the user opens 'Premium Glasses' product page
    Then the user should see that cart is empty
    And the page title should be 'Premium Glasses | ait-ht'
    And the product info is shown for 'Premium Glasses' product
    And the product price is '$20.00'
    And the product sku is '364215375135191'

    When the user adds product to cart
    Then cart is opened from the right of the screen
    And product 'Premium Glasses' is present in the cart
    And the user should see that cart contains '1' item
    And page content behind the cart popup is disabled

    When the user removes 'Premium Glasses' from cart widget
    Then the user should see that cart is empty
    And cart is opened from the right of the screen
    And page content behind the cart popup is disabled

    When the user minimizes the cart
    Then cart popup is closed

    When the user adds product to cart
    Then cart is opened from the right of the screen
    And product 'Premium Glasses' is present in the cart
    And the user should see that cart contains '1' item
    And page content behind the cart popup is disabled

    When the user minimizes the cart
    Then cart popup is closed

    When the user navigates to the shop page with stores button
    Then the user should see that cart contains '1' item
    And the page title should be 'ait-ht | STORES'
    And the number of available products is '12'

    When the user opens the cart
    Then cart is opened from the right of the screen
    And product 'Premium Glasses' is present in the cart
    And the user should see that cart contains '1' item
    And page content behind the cart popup is disabled

    When the user minimizes the cart
    Then cart popup is closed

    When the user opens 'I'm a product' product page
    Then the user should see that cart contains '1' item
    And the page title should be 'I'm a product | ait-ht'
    And the product info is shown for 'I'm a product' product
    And the product price is '$40.00'
    And the product sku is '632835642834572'

    When the user adds product to cart
    Then cart is opened from the right of the screen
    And product 'I'm a product' is present in the cart
    And product 'Premium Glasses' is present in the cart
    And the user should see that cart contains '2' items
    And page content behind the cart popup is disabled

    When the user navigates to the cart view
    Then the cart contains following items
      | productName     | itemSku         | price  | quantity | total  |
      | Premium Glasses | 364215375135191 | $20.00 | 1        | $20.00 |
      | I'm a product   | 632835642834572 | $40.00 | 1        | $40.00 |

    When the user changes quantity for 'Premium Glasses' product to '3'
    Then the cart contains following items
      | productName     | itemSku         | price  | quantity | total  |
      | Premium Glasses | 364215375135191 | $20.00 | 3        | $60.00 |
      | I'm a product   | 632835642834572 | $40.00 | 1        | $40.00 |
    And the user should see that cart contains '4' items

    When the user removes 'I'm a product' from cart view
    Then the cart contains following items
      | productName     | itemSku         | price  | quantity | total  |
      | Premium Glasses | 364215375135191 | $20.00 | 3        | $60.00 |
    And the user should see that cart contains '3' item