package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P18WooCommercePage extends PageBase {
    public P18WooCommercePage(WebDriver driver) {
        super(driver);
    }
    private final By wooCommerceIcon = By.xpath("//*[@alt='integration-woocommerce']");
    private final By wooCommerceCardTitle = By.xpath("(//*[normalize-space()='Woocommerce'])[2]");
    private final By wooCommerceCardDescription = By.xpath("(//*[normalize-space()='Enhance your store with automated" +
            " notifications, streamlined order management, abandoned cart recovery, and revenue-boosting marketing campaigns.'])[2]");
    private final By installCTA = By.xpath("(//button[normalize-space()='Install'])[4]");
    private final By xCloseWooIntegrationCard = By.xpath("//*[@data-testid='CloseIcon']");
    private final By storeURLHeader = By.xpath("(//*[normalize-space()='Store URL'])[1]");
    private final By storeURLIntoBox = By.xpath("(//*[normalize-space()='Store URL'])[2]");
    private final By storeURLInputField = By.xpath("//input[@placeholder='https://my-store.com']");
    private final By consumerKeyHeader = By.xpath("(//*[normalize-space()='Consumer Key'])[1]");
    private final By consumerKeyIntoBox = By.xpath("(//*[normalize-space()='Consumer Key'])[2]");
    private final By consumerKeyInputField = By.xpath("//input[@placeholder='xx-xx-xx-xx-xx-xx-xx']");
    private final By consumerSecretHeader = By.xpath("(//*[normalize-space()='Consumer Secret'])[1]");
    private final By consumerSecretIntoBox = By.xpath("(//*[normalize-space()='Consumer Secret'])[2]");
    private final By consumerSecretInputField = By.xpath("//input[@placeholder='xx-xx-xx-xx-xx-xx-xx']");
    private final By confirmMotaselLabel = By.xpath("(//*[normalize-space()='Confirm that mottasl extention must be installed in your store'])[2]");
    private final By checkBox = By.xpath("//*[@data-testid='CheckBoxOutlineBlankIcon']");
    private final By installWooCommerceCTA = By.xpath("//button[normalize-space()='Install Woocommerce']");

    public void checkWooCommerceCardIntoECommerce(){
        ElementsValidator(wooCommerceIcon,wooCommerceCardTitle,wooCommerceCardDescription,installCTA);
    }
    public void checkWooCommerceIntegrationCard(){
        clickOnElement(installCTA);
        waitForVisibilityOfElement(xCloseWooIntegrationCard);
        ElementsValidator(storeURLHeader,storeURLInputField,storeURLIntoBox,consumerKeyHeader,consumerKeyInputField,consumerKeyIntoBox
        ,consumerSecretHeader,consumerSecretInputField,consumerSecretIntoBox,confirmMotaselLabel,checkBox,installWooCommerceCTA);
    }
}
