package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P17ShopifyPage extends PageBase {
    public P17ShopifyPage(WebDriver driver) {
        super(driver);
    }
    private final By shopifyIcon = By.xpath("//*[@alt='integration-shopify']");
    private final By shopifyTitle = By.xpath("(//*[normalize-space()='Shopify'])[2]");
    private final By installCTA = By.xpath("(//button[normalize-space()='Install'])[3]");
    private final By shopifyDescription = By.xpath("//*[normalize-space()='Enhance your store with automated" +
            " notifications, streamlined order management, abandoned cart recovery, and revenue-boosting marketing campaigns.']");
    private final By shopifyIntegrationTitle = By.xpath("(//*[normalize-space()='Shopify Integration'])[2]");
    private final By xCloseShopifyIntegrationCard = By.xpath("//*[@data-testid='CloseIcon']");
    private final By storeURLHeader = By.xpath("(//*[normalize-space()='Store URL'])[1]");
    private final By storeURLIntoBox = By.xpath("(//*[normalize-space()='Store URL'])[2]");
    private final By storeURLInputField = By.xpath("//input[@placeholder='https://my-store.com']");
    private final By youWillBeRedirectHeader = By.xpath("//*[normalize-space()='You will be redirected to Shopify Store for Installation']");
    private final By integrationCardDescriptionFirst = By.xpath("//*[normalize-space()='Log In:']");
    private final By integrationCardDescriptionSecond = By.xpath("//*[normalize-space()='Install the App:']");
    private final By integrationCardDescriptionThird = By.xpath("//*[normalize-space()='Return to Mottasl:']");
    private final By installShopifyCTA = By.xpath("//button[normalize-space()='Install Shopify']");


    public void checkShopifyCardIntoEcommerceScreen(){
        ElementsValidator(shopifyIcon,shopifyTitle,shopifyDescription,installCTA);
    }
    public void checkShopifyIntegrationCard(){
        clickOnElement(installCTA);
        ElementsValidator(shopifyIntegrationTitle,storeURLIntoBox,xCloseShopifyIntegrationCard,storeURLHeader,storeURLInputField
        ,youWillBeRedirectHeader,integrationCardDescriptionFirst,integrationCardDescriptionSecond,integrationCardDescriptionThird,installShopifyCTA);
        clickOnElement(xCloseShopifyIntegrationCard);
        waitForVisibilityOfElement(shopifyIcon);

    }
}
