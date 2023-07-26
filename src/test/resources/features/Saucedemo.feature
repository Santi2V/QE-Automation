Feature: Sauce Demo Shopping

  Scenario: Login and Product Interaction
    Given User starts on the Sauce Demo login page
    When User logs in with a standard user
    Then User should be on the Products page

  Scenario: About Tab Navigation
    Given User is on the Products page
    When User navigates to the About tab
    Then User should be on the About page
    And User goes back to the Product page

  Scenario Outline: Product Sorting and Cart Verification
    Given User is on the Products page
    When User sorts the products by <productSort>
    Then User adds <productQuantity> products to the cart which are the last shown
    And the cart count should be <expectedCartCount> in the top-right corner

    Examples:
      | productSort        | productQuantity | expectedCartCount |
      | Price (low to high) | 4               | 4                |
#      | Price (high to low) | 3               | 3                |
#      | Name (A to Z)       | 1               | 1                |
#      | Name (Z to A)       | 2               | 2                |

  Scenario: Cart Details and Checkout
    Given User has added products to the cart
    When User navigates to the cart
    Then All the product information is saved
    And User proceeds to checkout

  Scenario: Personal Information and Total Price Verification
    Given User is on the Checkout: User Information page
    When User enters personal information and continues
    Then the total price is verified

  Scenario: Payment Information and Confirmation
    Given User has verified the total price
    When User checks the payment, shipping, and price details
    Then User completes the purchase
    And A success message should be displayed

