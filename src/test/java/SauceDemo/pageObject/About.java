package SauceDemo.pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;

public class About extends PageObject {
    public void onAbout(){
        String currentUrl = getDriver().getCurrentUrl();
        String expectedUrl = "https://saucelabs.com/";
        Assert.assertEquals(expectedUrl,currentUrl);
    }

}
