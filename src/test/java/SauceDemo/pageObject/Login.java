package SauceDemo.pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class Login extends PageObject {
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElementFacade usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElementFacade passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElementFacade loginButton;

    @FindBy(xpath = "//div[@class='error-message-container']")
    private WebElementFacade errorDisplay;

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
    public boolean isErrorDisplayed() {
        return errorDisplay.isDisplayed();
    }
    public String getErrorMessage() {
        return errorDisplay.getText();
    }

}
