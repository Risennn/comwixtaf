package comwittaf.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CartWidgetPopup extends PageObject {

    private static final int CART_WIDGET_POPUP_WIDTH = 383;
    private static final String DATA_HOOK_CART_WIDGET_DROPDOWN = "//*[@data-hook='cart-widget-dropdown']";
    private static final String BUTTON_DATA_HOOK_CART_WIDGET_REMOVE_ITEM = "//../../button[@data-hook='cart-widget-remove-item']";
    private static final String DATA_HOOK_CART_WIDGET_QTY = "/..//*[@data-hook='cart-widget-qty']";

    @FindBy(xpath = "//button[@id='cart-widget-close']")
    private WebElementFacade closeCartWidget;

    @FindBy(xpath = "//div[@class='siteAspectsContainer']//iframe[contains(@src, 'cartwidgetPopup')]")
    private WebElementFacade iframeContainer;

    @FindBy(xpath = "//footer/a[@data-hook='widget-view-cart-button']")
    private WebElementFacade viewCartButton;

    @FindBys({@FindBy(xpath = "//*[@data-hook='cart-widget-item']")})
    private List<WebElementFacade> cartWidgetItems;

    public void closeCartWidget() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(iframeContainer);
        closeCartWidget.click();
        getDriver().switchTo().defaultContent();
    }

    public Integer getProductQuantity(final String productName) {
        return Integer.valueOf(
                getProductInTheCart(productName).find(By.xpath(DATA_HOOK_CART_WIDGET_QTY)).getText());
    }

    public Boolean isProductPresentInTheCart(final String productName) {
        return getProductInTheCart(productName).isDisplayed();
    }

    public void removeProductFromTheCart(final String productName) {
        getProductInTheCart(productName).find(By.xpath(BUTTON_DATA_HOOK_CART_WIDGET_REMOVE_ITEM)).click();
    }

    public Boolean isCartOpenedFromTheRightSideOfThePage() {
        getDriver().switchTo().defaultContent();
        try {
            getDriver().switchTo().frame(iframeContainer);
            int x = find(By.xpath(DATA_HOOK_CART_WIDGET_DROPDOWN)).getLocation().getX();
            int windowWidth = getDriver().manage().window().getSize().getWidth();
            getDriver().switchTo().defaultContent();
            return (windowWidth - x) == CART_WIDGET_POPUP_WIDTH;
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }

    private WebElementFacade getProductInTheCart(final String productName) {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(iframeContainer);
        return find(By.xpath("//*[@data-hook='cart-widget-name' and text()=\"" + productName + "\"]"));
    }

    public void navigateToCartView() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(iframeContainer);
        viewCartButton.click();
        getDriver().switchTo().defaultContent();
    }

}
