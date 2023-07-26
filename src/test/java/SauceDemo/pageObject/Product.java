package SauceDemo.pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.ui.Select;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Product extends PageObject {

    @FindBy(xpath = "//span[@class='title' and text()='Products']")
    private WebElementFacade productTitle;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartContainer;
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElementFacade shopping_cart_badge;

    @FindBy(className = "product_sort_container")
    private WebElementFacade productSortDropdown;
    @FindBy(xpath = "//select[@class='product_sort_container']/option")
    private List<WebElementFacade> productSortOptions;

    @FindBy(id = "react-burger-menu-btn")
    private WebElementFacade menuButton;

    @FindBy(id = "about_sidebar_link")
    private WebElementFacade aboutLink;

    @FindBy(className = "btn_inventory")
    private List<WebElement> addToCartButtons;


    public boolean isProductTitleDisplayed() {
        return productTitle.isDisplayed();
    }
//    public void clickMenuButton() {
//        menuButton.click();
//    }

    public void selectAboutLink() {
        menuButton.click();
        aboutLink.click();
    }
    public void clickShoppingCartContainer() {
        shoppingCartContainer.click();
    }

    public void selectSortOption (String productSort) {
        productSortDropdown.click();
//        WebDriverWait wait = new WebDriverWait(
//        wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) productSortOptions));
        for (WebElementFacade option : productSortOptions) {
            if (option.getText().equals(productSort)) {
                option.click();
                break;
            }

        }


    }
    public void selectLastNProducts(int productQuantity){
        int totalProducts = addToCartButtons.size();
        int startIndex = totalProducts - productQuantity ;
        for (int i = startIndex; i < totalProducts; i++) {
            WebElement button = addToCartButtons.get(i);
            if (button.getText().equals("Add to cart")) {
                button.click();
            }
        }
    }
    public boolean verifyCartBadge(int expectedCount){
        int badge = Integer.parseInt(shopping_cart_badge.getText());
        if(expectedCount==badge) return true;
        else return false;
    }
    public boolean cartNotEmpty(){
        int badge = Integer.parseInt(shopping_cart_badge.getText());
        if(badge>0) return true;
        else return false;
    }



}
