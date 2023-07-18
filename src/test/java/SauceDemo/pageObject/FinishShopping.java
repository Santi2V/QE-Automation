package SauceDemo.pageObject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import  java.util.List;

public class FinishShopping extends PageObject {
    @FindBy(className = "item_pricebar")
    List<WebElementFacade> itemsPrice;

    @FindBy(xpath = "//div[@class='summary_info']/div[@class='summary_value_label'][1]")
    private WebElementFacade paymentInformation;

    @FindBy(xpath = "//div[@class='summary_info']/div[@class='summary_value_label'][2]")
    private WebElementFacade shippingInformation;

    @FindBy(xpath = "//div[@class='summary_info']/div[@class='summary_subtotal_label']")
    private WebElementFacade itemTotal;

    @FindBy(xpath = "//div[@class='summary_info']/div[@class='summary_tax_label']")
    private WebElementFacade tax;

    @FindBy(xpath = "//div[@class='summary_info']/div[@class='summary_info_label summary_total_label']")
    private WebElementFacade total;

    @FindBy(id = "cancel")
    private WebElementFacade cancelButton;

    @FindBy(id = "finish")
    private WebElementFacade finishButton;
    @FindBy (xpath="//h2[contains(text(),'Thank you for your order!')]")
    private WebElementFacade succesMessage;

    public void generateSummaryReport() {
        String paymentInfo = paymentInformation.getText();
        String shippingInfo = shippingInformation.getText();
        String itemTotalValue = itemTotal.getText();
        String taxValue = tax.getText();
        String totalValue = total.getText();
        String details="";
        details=details+"Payment Information: " + paymentInfo +"\n";
        details=details+"Shipping Information: " + shippingInfo+"\n";
        details=details+"Item Total: " + itemTotalValue+"\n";
        details=details+"Tax: " + taxValue+"\n";
        details=details+"Total: " + totalValue+"\n";
        Serenity.recordReportData().withTitle("Details of Shopping Cart Items").andContents(details);
    }
    public boolean verifyTotal() {
        double sum = 0;
        int totalProducts = itemsPrice.size();
        for (int i = 0; i < totalProducts; i++) {
            sum += Double.parseDouble(itemsPrice.get(i).getText().replace("$", ""));
        }
        double itemTotalValue = Double.parseDouble(itemTotal.getText().replace("$", "").replace("Item total: ", ""));
        return sum == itemTotalValue;
    }
    public void clickFinish(){
        finishButton.click();
    }
    public boolean finnishMessage(){
        return succesMessage.isDisplayed();
    }



}
