package SauceDemo.stepsDefinitions;

import SauceDemo.steps.UserSauceDemo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class UserDefinitionSteps {

    @Steps(shared = true)
    UserSauceDemo user;

    @Given("^User starts on the Sauce Demo login page$")
    public void userNavigatesLogin() {
        user.navigateTo();
    }

    @When("^User logs in with a standard user$")

    public void userLogsIn() {
        user.Login("standard_user","secret_sauce");
    }
    @Then("^User should be on the Products page$")
    public void onProductsPage()
    {

    }

//    @Then("^User should be logged in successfully$")
//    public void userLoggedInSuccessfully() {
//        user.verifyLoginSuccess();
//    }

//    @Then("^User should be on the Products page$")
//    public void userOnProductsPage() {
//        user.verifyOnProductsPage();
//    }

    @When("^User navigates to the About tab$")
    public void userNavigatesToAboutTab() {
//        user.navigateToAboutPage();
    }

    @Then("^User should be on the About page$")
    public void userOnAboutPage() {
//        user.verifyOnAboutPage();
        user.About();
    }

    @Then("^User goes back to Product page$")
    public void userGoesBackToProductPage() {
//        user.goBackToProductPage();
    }

//    @Given("^User on the Products page$")
//    public void userOnProductsPage() {
//        user.verifyOnProductsPage();
//    }

    @When("^User sort the products by (.*)$")
    public void userSortsProducts(String productSort) {
        user.FilterProduct(productSort);
    }

    @Then("^User add (.*) to the cart which are the firsts showed$")
    public void userAddsProductsToCart(int productQuantity) {
        user.addToCart(productQuantity);
    }

    @Then("^the cart count should be (.*) in the top-right corner$")
    public void cartCountShouldBe(int expectedCount) {
        user.verifyBadgeCart(expectedCount);
    }

    @When("^User navigate to the cart$")
    public void userNavigatesToCart() {
        user.goToCart();
    }

    @Then("^All the product information its saved$")
    public void allProductInformationSaved() {
        user.saveItemDetails();
    }
    @And("User proceed to checkout")
    public void userToCheckout() {
        user.goFromCartToCheckout();
    }


    @Given("^User on the Checkout: User Information page$")
    public void userOnUserInformationPage() {

    }

    @When("^User enter personal information and continue$")
    public void userEnterPersonalInformation() {
        String name="x";
        String lastname="x";
        String postalcode="x";
        user.fillInfoCheckout(name,lastname,postalcode);
    }

    @Then("^the total price is verified$")
    public void totalPriceVerified() {
        user.verifyTotalPrice();
    }

//    @Given("^User on the Checkout: Overview page$")
//    public void userOnOverviewPage() {
//        user.();
//    }

    @When("^User check the payment, shipping, and price details$")
    public void userChecksDetails() {
        user.generateReport();
    }

    @Then("^User complete the purchase$")
    public void completePurchase() {
        user.finish();
    }

    @And("A success message should be displayed")
    public void successMessageDisplayed() {
        user.verifySuccess();
    }
}


