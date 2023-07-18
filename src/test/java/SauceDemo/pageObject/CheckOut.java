package SauceDemo.pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CheckOut extends PageObject {
    @FindBy(id = "first-name")
    private WebElementFacade firstNameInput;

    @FindBy(id = "last-name")
    private WebElementFacade lastNameInput;

    @FindBy(id = "postal-code")
    private WebElementFacade postalCodeInput;

    @FindBy(id = "cancel")
    private WebElementFacade cancelButton;

    @FindBy(id = "continue")
    private WebElementFacade continueButton;

    public void fillCheckoutForm(String FisrtName,String LastName, String PostalCode) {
        enterFirstName(FisrtName);
        enterLastName(LastName);
        enterPostalCode(PostalCode);
        clickContinueButton();
    }

    private void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    private void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    private void enterPostalCode(String postalCode) {
        postalCodeInput.sendKeys(postalCode);
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

}
