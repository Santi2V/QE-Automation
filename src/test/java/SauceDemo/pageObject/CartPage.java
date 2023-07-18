package SauceDemo.pageObject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CartPage extends PageObject {
    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    private WebElementFacade cartTitle;
    @FindBy(className = "cart_quantity")
    private List<WebElementFacade> item;

    @FindBy(className = "cart_quantity")
    private List<WebElementFacade> item_quantity;

    @FindBy(className = "inventory_item_name")
    private List<WebElementFacade> item_name;

    @FindBy(className = "inventory_item_desc")
    private List<WebElementFacade> item_desc;

    @FindBy(className = "inventory_item_price")
    private List<WebElementFacade> item_price;

    @FindBy(className = "checkout_button")
    private WebElementFacade checkout;

    public void saveDetails(){
        String details="";
        int totalProducts = item.size();
        for (int i = 0; i < totalProducts; i++) {
            details =details+"\n"+"\n"+item_name.get(i).getText()+ "\n Description: " +item_desc.get(i).getText()+"\n Price:" +item_price.get(i).getText()+"\n Quantity: "+item_quantity.get(i).getText()+"\n";
        }
        Serenity.recordReportData().withTitle("Details of Shopping Cart Items").andContents(details);
    }
    public void clickCheckout(){
        checkout.click();
    }

}
