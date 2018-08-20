package comwittaf.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ProductPage extends PageObject {

    private static final String IFRAME_NAME = "TPAMultiSection_jh9acbtn";

    @FindBy(xpath = "//*[@data-hook='product-title']")
    private WebElementFacade productName;

    @FindBy(xpath = "//*[@data-hook='product-page-sku']")
    private WebElementFacade productSku;

    @FindBy(xpath = "//*[@data-hook='product-price']")
    private WebElementFacade productPrice;

    @FindBy(xpath = "//*[@data-hook='add-to-cart']")
    private WebElementFacade addToCartButton;

    public String getProductName() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(IFRAME_NAME);
        String name = productName.getText();
        getDriver().switchTo().defaultContent();
        return name;
    }

    public String getProductSku() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(IFRAME_NAME);
        String sku = productSku.getText().replace("SKU: ", "");
        getDriver().switchTo().defaultContent();
        return sku;
    }

    public String getProductPrice() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(IFRAME_NAME);
        String price = productPrice.getText();
        getDriver().switchTo().defaultContent();
        return price;
    }

    public void addToCart() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(IFRAME_NAME);
        addToCartButton.click();
        getDriver().switchTo().defaultContent();
    }

}
