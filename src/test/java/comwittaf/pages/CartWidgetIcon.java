package comwittaf.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CartWidgetIcon extends PageObject {

    @FindBy(xpath = "//*[local-name()='svg']/*[local-name()='text']")
    private WebElementFacade cartIcon;

    public int getCartWidgetIconItemsNumber() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame("comp-jh9acbuw");
        String itemsCount = cartIcon.getText();
        getDriver().switchTo().defaultContent();
        return Integer.valueOf(itemsCount);
    }

    public void openTheCart() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame("comp-jh9acbuw");
        cartIcon.click();
        getDriver().switchTo().defaultContent();
    }

    public WebElementFacade getCartIcon() {
        return cartIcon;
    }

}
