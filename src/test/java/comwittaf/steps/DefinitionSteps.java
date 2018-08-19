package comwittaf.steps;

import comwittaf.model.cartview.CartItem;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import comwittaf.steps.serenity.EndUserSteps;

import java.util.List;

public class DefinitionSteps {

    @Steps
    EndUserSteps user;

    @Given("^the user is on the home page$")
    public void theUserIsOnTheHomePage() {
        user.is_on_the_home_page();
    }

    @When("^the user navigates to the shop page$")
    public void theUserNavigatesToTheShopPage() {
        user.navigates_to_the_shop_page();
    }

    @Then("^the user should see that cart is empty$")
    public void theUserShouldSeeThatCartIsEmpty() {
        user.should_have_empty_cart();
    }

    @Then("^the user should see that cart contains '(\\d+)' items?$")
    public void theUserShouldSeeThatCartIconContainsItems(Integer quantity) {
        user.should_see_that_cart_icon_contains_items(quantity);
    }

    @Then("^the page title should be '(.*)'")
    public void theShopPageTitleShouldBe(String title) {
        user.page_title_should_be(title);
    }

    @Given("^the user is on the shop page$")
    public void theUserIsOnTheShopPage() {
        user.is_on_the_shop_page();
    }

    @And("^the number of available products is '(\\d+)'$")
    public void theNumberOfAvailableProductsIs(int number) {
        user.should_see_number_of_products_on_the_page_is(number);
    }

    @When("^the user opens '(.*)' product page$")
    public void theUserOpensProductPageFor(String productName) {
        user.opens_product_page_for(productName);
    }

    @Then("^the product info is shown for '(.*)' product")
    public void theProductPageIsOpenedForProduct(String productName) {
        user.should_see_product_name_is(productName);
    }

    @Then("^the product price is '(.*)'")
    public void theProductPagePriceIs(String productPrice) {
        user.should_see_product_price_is(productPrice);
    }

    @Then("^the product sku is '(.*)'")
    public void theProductPageSkuIs(String productSku) {
        user.should_see_product_sku_is(productSku);
    }

    @When("^the user adds product to cart$")
    public void theUserAddsProductToCart() {
        user.adds_product_to_cart();
    }

    @Then("^cart is opened from the right of the screen$")
    public void cartIsOpenedFromTheRightOfTheScreen() {
        user.should_see_cart_popup_to_the_right();
    }

    @Then("^product '(.*)' is present in the cart$")
    public void productIsPresentInTheCart(String productName) {
        user.should_see_product_in_the_cart(productName);
    }

    @When("^the user removes '(.*)' from cart widget$")
    public void theUserRemovesFromCart(String productName) {
        user.removes_from_cart_widget(productName);
    }

    @When("^the user minimizes the cart$")
    public void theUserMinimizesTheCart() {
        user.minimizes_the_cart();
    }

    @And("^page content behind the cart popup is disabled$")
    public void pageIsDisabled() {
        user.should_see_page_is_disabled();
    }

    @Then("^cart popup is closed$")
    public void cartIsClosed() {
        user.should_see_cart_popup_is_closed();
    }

    @And("^the user navigates to the shop page with stores button$")
    public void theUserNavigatesToTheShopPageWithStoresButton() {
        user.navigates_to_the_shop_page_with_stores_button();
    }

    @When("^the user opens the cart$")
    public void theUserOpensCart() {
        user.opens_the_cart();
    }

    @When("^the user navigates to the cart view$")
    public void theUserNavigatesToTheCartView(){
        user.navigates_to_the_cart_view();
    }

    @Then("^the cart contains following items$")
    public void cartContainsAll(List<CartItem> cartItems) {
        user.cart_contains_all_items(cartItems);
    }

    @When("^the user removes '(.*)' from cart view$")
    public void theUserRemovesItemFromCartView(String productName) {
        user.removes_from_cart_view(productName);
    }

    @When("^the user changes quantity for '(.*)' product to '(\\d+)'$")
    public void theUserChangesQuantityForProduct(String productName, int qty) {
        user.changes_item_qty(productName, qty);
    }
}
