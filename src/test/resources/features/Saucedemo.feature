Feature: Sauce Demo Shopping

    Scenario: Login and Product Interaction
      Given User starts on the Sauce Demo login page
      When  User logs in with a standard user
      Then  User should be on the Products page

    Scenario: About Tab Navigation
      Given  User navigates to the About tab
      Then User should be on the About page
      And User goes back to Product page

    Scenario Outline: Product Sorting and Cart Verification
      Given User sort the products by <productSort>
      Then User add <productQuantity> to the cart which are the firsts showed
      And the cart count should be <productQuantity> in the top-right corner

      Examples:
      |productSort|productQuantity|
      |Price (high to low)|     4        |
#      |Price (low to high) |   3         |
#      |Name (A to Z) |         1         |
#      |Name (Z to A) |         2         |

    Scenario: Cart Details and Checkout
      When  User navigate to the cart
      Then  All the product information its saved
  #    And the saved product information should be displayed in the Serenity report
      And User proceed to checkout

    Scenario: Personal Information and Total Price Verification
      Given User on the Checkout: User Information page
      When User enter personal information and continue
      Then the total price is verified

    Scenario: Payment Information and Confirmation
      When  User check the payment, shipping, and price details
  #    Then the payment, shipping, and price information should be displayed in the Serenity report
      Then User complete the purchase
      And A success message should be displayed
