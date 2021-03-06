package comwittaf.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

@DefaultUrl("https://georgel8.wixsite.com/ait-ht/shop")
public class ShopPage extends PageObject {

    private static final String IFRAME_NAME = "TPASection_jh9acbfx";

    @FindBys({@FindBy(xpath = "//section[@aria-label='Product Gallery']//li")})
    private List<WebElementFacade> products;

    public void goToProductPage(String productName) {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(IFRAME_NAME);
        find(By.xpath("//*[local-name() = 'product-image']/img[@alt=\"" + productName + "\"]/../../..")).click();
        getDriver().switchTo().defaultContent();
    }

    public Integer getAvailableProductsQuantity() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(IFRAME_NAME);
        int size = products.size();
        getDriver().switchTo().defaultContent();
        return size;
    }

}
