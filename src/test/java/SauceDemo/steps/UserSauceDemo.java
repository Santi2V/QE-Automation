package SauceDemo.steps;

import SauceDemo.pageObject.*;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Steps;


public class UserSauceDemo extends ScenarioActor {
    String actor;

    @Steps(shared=true)
    Login Login;

    About About;
    Product Product;
    CartPage cartPage;
    CheckOut checkOut;

    FinishShopping finishShopping;
    public void navigateTo(){
        Login.setDefaultBaseUrl("https://www.saucedemo.com/");
        Login.open();
    }
     public void Login(String user,String pass){
        Login.login(user,pass);
     }

     public boolean onProductPage(){
       return Product.isProductTitleDisplayed();
     }
     public void About(){
        Product.selectAboutLink();
     }
     public void backOnProductPage(){
         Product.openAt("https://www.saucedemo.com/inventory.html");
     }
     public void verifyAbout(){
    About.onAbout();
     }
     public void FilterProduct(String productSort){
        Product.selectSortOption(productSort);
     }
     public  void addToCart(int productQuantity){
         Product.selectLastNProducts(productQuantity);

     }
     public void checkCart(){
        Product.cartNotEmpty();
     }
     public boolean verifyBadgeCart(int expectedCount){
        return Product.verifyCartBadge(expectedCount);
     }
     public void goToCart()
     {
         Product.clickShoppingCartContainer();
     }

     public void saveItemDetails(){
        cartPage.saveDetails();
     }
    public void goFromCartToCheckout(){
        cartPage.clickCheckout();
    }

    public void onCheckout(){
        checkOut.onCheckout();
    }
    public void fillInfoCheckout(String FisrtName,String LastName, String PostalCode){
        checkOut.fillCheckoutForm(FisrtName,LastName,PostalCode);
    }

    public void verifyTotalPrice(){
        finishShopping.verifyTotal();
    }
    public void generateReport(){
        finishShopping.generateSummaryReport();
    }
    public void finish(){
        finishShopping.clickFinish();
    }
    public boolean verifySuccess(){
       return finishShopping.finnishMessage();
    }
}
