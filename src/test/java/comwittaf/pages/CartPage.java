package comwittaf.pages;

import comwittaf.model.cartview.CartItem;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://georgel8.wixsite.com/ait-ht/cart-page")
public class CartPage extends PageObject {

    private static final String DATA_HOOK_ITEM = "//*[@data-hook='item']";
    private static final String DATA_HOOK_ITEM_SKU = "[data-hook=item-sku]";
    private static final String DATA_HOOK_PRODUCT_PRICE = "[data-hook=product-price]";
    private static final String DATA_HOOK_PRODUCT_NAME = "[data-hook=product-name]";
    private static final String DATA_HOOK_PRODUCT_QUANTITY_INPUT = "[data-hook=product-quantity] input";
    private static final String DATA_HOOK_PRODUCT_TOTAL_PRICE = "[data-hook=product-total-price]";
    private static final String ANCESTOR_SECTION_DATA_HOOK_PRODUCT_QUANTITY_INPUT = "//ancestor::section//*[@data-hook='product-quantity']//input";

    @FindBy(xpath = "//div[@class='p1inlineContent']//iframe[contains(@src, 'cart?')]")
    private WebElementFacade iframeContainer;

    public boolean containsCartItem(final CartItem cartItem) {
        boolean result;
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(iframeContainer);
        result = getCartItems().stream().anyMatch(item -> item.equals(cartItem));
        getDriver().switchTo().defaultContent();
        return result;
    }

    public void removeProductFromTheCart(String productName) {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(iframeContainer);
        find(By.xpath("//*[@aria-label=\"remove " + productName + " from the cart\"]")).click();
        getDriver().switchTo().defaultContent();
    }

    public List<CartItem> getCartItems() {
        List<CartItem> cartItems = new ArrayList<>();
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(iframeContainer);
        findAll(By.xpath(DATA_HOOK_ITEM)).forEach(item -> {
            CartItem existingCartItem = new CartItem();
            existingCartItem.setItemSku(item.then(DATA_HOOK_ITEM_SKU).getText());
            existingCartItem.setPrice(item.then(DATA_HOOK_PRODUCT_PRICE).getText());
            existingCartItem.setProductName(item.then(DATA_HOOK_PRODUCT_NAME).getText());
            existingCartItem.setQuantity(Integer.valueOf(item.then(DATA_HOOK_PRODUCT_QUANTITY_INPUT).getAttribute("value")));
            existingCartItem.setTotal(item.then(DATA_HOOK_PRODUCT_TOTAL_PRICE).getText());
            cartItems.add(existingCartItem);
        });
        getDriver().switchTo().defaultContent();
        return cartItems;
    }

    private WebElementFacade getProductInTheCart(final String productName) {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(iframeContainer);
        return find(By.xpath("//*[@data-hook='product-name' and text()=\"" + productName + "\"]"));
    }

    public void changeItemQuantity(String productName, int qty) {
        WebElementFacade qtyInput = getProductInTheCart(productName).findBy(By.xpath(ANCESTOR_SECTION_DATA_HOOK_PRODUCT_QUANTITY_INPUT));
        qtyInput.typeAndTab(String.valueOf(qty));
    }
}
