package comwittaf.steps.serenity;

import comwittaf.model.cartview.CartItem;
import comwittaf.pages.*;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriverException;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EndUserSteps {

    private HomePage homePage;
    private ShopPage shopPage;
    private CartWidgetIcon cartWidgetIcon;
    private CartWidgetPopup cartWidgetPopup;
    private ProductPage productPage;
    private CartPage cartPage;

    @Step
    public void is_on_the_home_page() {
        homePage.open();
    }

    @Step
    public void navigates_to_the_shop_page() {
        homePage.navigateToShopWithShopButton();
    }

    @Step
    public void should_have_empty_cart() {
        assertThat(cartWidgetIcon.getCartWidgetIconItemsNumber(), equalTo(0));
    }

    @Step
    public void page_title_should_be(String title) {
        assertThat(homePage.getTitle(), equalTo(title));
    }

    @Step
    public void is_on_the_shop_page() {
        shopPage.open();
    }

    @Step
    public void should_see_number_of_products_on_the_page_is(Integer number) {
        assertThat(number, equalTo(shopPage.getAvailableProductsQuantity()));
    }

    @Step
    public void opens_product_page_for(String productName) {
        shopPage.goToProductPage(productName);
    }

    @Step
    public void should_see_product_price_is(String price) {
        assertThat(price, equalTo(productPage.getProductPrice()));
    }

    @Step
    public void should_see_product_name_is(String price) {
        assertThat(price, equalTo(productPage.getProductName()));
    }

    @Step
    public void should_see_product_sku_is(String price) {
        assertThat(price, equalTo(productPage.getProductSku()));
    }

    @Step
    public void adds_product_to_cart() {
        productPage.addToCart();
    }

    @Step
    public void should_see_cart_popup_to_the_right() {
        assertThat("Cart opened not to the right on the page.", cartWidgetPopup.isCartOpenedFromTheRightSideOfThePage());
    }

    @Step
    public void should_see_product_in_the_cart(String productName) {
        assertThat("Product " + productName + " is not present in the cart", cartWidgetPopup.isProductPresentInTheCart(productName));
    }

    @Step
    public void should_see_that_cart_icon_contains_items(Integer quantity) {
        assertThat(quantity, equalTo(cartWidgetIcon.getCartWidgetIconItemsNumber()));
    }

    @Step
    public void removes_from_cart_widget(String productName) {
        cartWidgetPopup.removeProductFromTheCart(productName);
    }

    @Step
    public void minimizes_the_cart() {
        cartWidgetPopup.closeCartWidget();
    }

    @Step
    public void should_see_page_is_disabled() {
        boolean result = false;
        try {
            cartWidgetIcon.openTheCart();
        } catch (WebDriverException e) {
            result = true;
        }
        assertThat("Page content behind Cart Popup should be not clickable.", result);
    }

    @Step
    public void should_see_cart_popup_is_closed() {
        assertThat("Cart Popup should be closed", !cartWidgetPopup.isCartOpenedFromTheRightSideOfThePage());
    }

    @Step
    public void navigates_to_the_shop_page_with_stores_button() {
        homePage.navigateToShopWithStoresButton();
    }

    @Step
    public void opens_the_cart() {
        cartWidgetIcon.openTheCart();
    }

    @Step
    public void navigates_to_the_cart_view() {
        cartWidgetPopup.navigateToCartView();
    }

    @Step
    public void cart_contains_all_items(List<CartItem> cartItems) {
        assertThat(cartItems, containsInAnyOrder(cartPage.getCartItems().toArray()));
    }

    @Step
    public void removes_from_cart_view(String productName) {
        cartPage.removeProductFromTheCart(productName);
    }

    @Step
    public void changes_item_qty(String productName, int qty) {
        cartPage.changeItemQuantity(productName, qty);
    }
}