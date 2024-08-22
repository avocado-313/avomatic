package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class P14ECommerce extends PageBase {
    public P14ECommerce(WebDriver driver) {
        super(driver);
    }
    private final By ECommerceIconFromSIdeMenu = By.xpath("//*[@data-testid='ShoppingCartIcon']");
    private final By ECommerceTitle = By.xpath("//*[@data-testid='title']");
    private final By EcommerceDescription = By.xpath("//*[@data-testid='description']");
    private final By manageYourStoreLabel = By.xpath("//*[normalize-space()='Manage your store']");
    private final By manageCTA = By.xpath("//button[normalize-space()='Manage']");
    private final By zidIcon = By.xpath("//*[@alt='integration-zid']");
    private final By showZidDescriptionIcon = By.xpath("(//*[@data-testid='CloseIcon'])[1]");
    private final By zidTitle = By.xpath("//*[normalize-space()='Zid']");
    private final By zidDescription = By.xpath("//*[normalize-space()='Elevate Your Store with Zid: " +
            "Automate alerts, manage orders effortlessly, reclaim abandoned carts, and boost revenue with targeted " +
            "campaigns. Transform your operations with Zid.']");
    private final By zidIntegrationTitle = By.xpath("//*[normalize-space()='Zid Integration']");
    private final By zidIntegrationSubTitle = By.xpath("//*[normalize-space()='You will be redirected to Zid Store for Installation']");
    private final By zidIntegrationDescriptionFirstLine = By.xpath("//*[normalize-space()='To Install the App, Follow These Simple Steps:']");
    private final By zidIntegrationDescriptionSecondLine = By.xpath("//*[normalize-space()=concat('Click on the ', \"'\", 'Install', \"'\", ' Button Below:')]");
    private final By zidIntegrationDescriptionThirdLine = By.xpath("//*[normalize-space()='Log In: Use your store login credentials to access your account.']");
    private final By zidIntegrationDescriptionForthLine = By.xpath("//*[normalize-space()='Install the App:']");
    private final By zidIntegrationDescriptionFifthLine = By.xpath("//*[normalize-space()='Return to Avocado:']");
    private final By installZidCTA = By.xpath("//button[normalize-space()='Install Zid']");
    private final By closeIntegrationIcon = By.xpath("(//*[@data-testid='CloseIcon'])[3]");


    public void checkECommerceScreen(){
        clickOnElement(ECommerceIconFromSIdeMenu);
        waitForVisibilityOfElement(ECommerceTitle);
        Assert.assertTrue(driver.findElement(ECommerceTitle).getText().contains("E-commerce Apps"));
        Assert.assertTrue(driver.findElement(EcommerceDescription).getText().contains("Integrate your business with leading e-commerce platforms to streamline your operations"));
        try {
            ElementsValidator(manageCTA, manageYourStoreLabel);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    private void checkZidCard(){
        ElementsValidator(zidIcon,zidDescription,zidTitle);
        if(!assertElementNotDisplayed(showZidDescriptionIcon)) waitForVisibilityOfWebElement(driver.findElement(zidTitle).findElement(By.xpath("..")).findElement(By.xpath("//*[normalize-space()='Installed']")));
    }
    public void checkZidIntegrationCard(){
        checkZidCard();
        try {
            clickOnElement(showZidDescriptionIcon);
        }catch (Exception e){
            driver.findElement(By.xpath("//*[normalize-space()='Install']")).click();
        }
        waitForVisibilityOfElement(zidIntegrationTitle);
        ElementsValidator(zidIntegrationTitle,zidIntegrationSubTitle,zidIntegrationDescriptionFirstLine,
                zidIntegrationDescriptionSecondLine,zidIntegrationDescriptionThirdLine,zidIntegrationDescriptionForthLine,
                zidIntegrationDescriptionFifthLine,installZidCTA);
        try {
            clickOnElement(closeIntegrationIcon);
        }catch (Exception e){
            driver.findElement(By.xpath("//*[@data-testid='CloseIcon']")).click();
        }
        waitForVisibilityOfElement(ECommerceTitle);
    }


}
