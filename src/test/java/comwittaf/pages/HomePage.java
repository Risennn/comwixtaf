package comwittaf.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://georgel8.wixsite.com/ait-ht")
public class HomePage extends PageObject {

    @FindBy(xpath = "//span[text()='SHOP']")
    private WebElementFacade shopButton;

    @FindBy(xpath = "//p[text()='STORES']")
    private WebElementFacade storesButton;

    @FindBy(xpath = "//p[text()='HOME']")
    private WebElementFacade homeButton;

    public void navigateToShopWithShopButton() {
        shopButton.click();
    }

    public void navigateToHome() {
        homeButton.click();
    }

    public void navigateToShopWithStoresButton() {
        storesButton.click();
    }

}
