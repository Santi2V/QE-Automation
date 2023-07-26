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
    public void afterloginProductsPage()
    {
        user.onProductPage();
    }
    @Given ("^User is on the Products page$")
    public void startsOnProductsPage()
    {
        user.onProductPage();
    }
    @When("^User navigates to the About tab$")
    public void userNavigatesToAboutTab() {
         user.About();
    }

    @Then("^User should be on the About page$")
    public void userOnAboutPage() {

        user.verifyAbout();
    }

    @And("^User goes back to the Product page$")
    public void userGoesBackToProductPage() {
        user.backOnProductPage();
    }


    @When("^User sorts the products by (.*)$")
    public void userSortsProducts(String productSort) {
        user.FilterProduct(productSort);
    }

    @Then("^User adds (.*) products to the cart which are the last shown$")
    public void userAddsProductsToCart(int productQuantity) {
        user.addToCart(productQuantity);
    }

    @Then("^the cart count should be (.*) in the top-right corner$")
    public void cartCountShouldBe(int expectedCount) {
        user.verifyBadgeCart(expectedCount);
    }

    @Given("^User has added products to the cart$")
    public void cartNotEmpty(){
     user.checkCart();
    }

    @When("^User navigates to the cart")
    public void userNavigatesToCart() {
        user.goToCart();
    }

    @Then("^All the product information is saved$")
    public void allProductInformationSaved() {
        user.saveItemDetails();
    }
    @And("User proceeds to checkout")
    public void userToCheckout() {
        user.goFromCartToCheckout();
    }


    @Given("^User is on the Checkout: User Information page$")
    public void userOnUserInformationPage() {
        user.onCheckout();
    }

    @When("^User enters personal information and continues$")
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

    @Given("^User has verified the total price$")
    public void verifyTotalPrice(){ user.verifyTotalPrice();}


    @When("^User checks the payment, shipping, and price details$")
    public void userChecksDetails() {
        user.generateReport();
    }

    @Then("^User completes the purchase$")
    public void completePurchase() {
        user.finish();
    }

    @And("A success message should be displayed")
    public void successMessageDisplayed() {
        user.verifySuccess();
    }

}


