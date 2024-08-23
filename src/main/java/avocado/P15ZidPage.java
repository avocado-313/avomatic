package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P15ZidPage extends PageBase {
    public P15ZidPage(WebDriver driver) {
        super(driver);
    }
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
    private final By acceptCookiesCTA = By.xpath("//*[@id='hs-eu-confirmation-button']");
    private final By zidEmailInput = By.xpath("//input[@name='email']");
    private final By nextCTA = By.xpath("(//*[normalize-space()='التالي'])[2]");
    private final By loginUsingPassword = By.xpath("//*[@data-identifier='zid-login-form-login-with-password']");
    private final By passwordInput = By.xpath("//input[@name='password']");
    private final By loginCTA = By.xpath("(//*[@class='zid-button__content' and contains(normalize-space(),'تسجيل الدخول')])[1]");
    private final By storeLogo = By.xpath("//*[@alt='شعار المتجر']");
    private final By closeZidUpdates = By.xpath("//div[@class='beamerAnnouncementBarClose']//*[name()='svg']");


    private void checkZidCard(){
        ElementsValidator(zidIcon,zidDescription,zidTitle);
        if(!assertElementNotDisplayed(showZidDescriptionIcon)) waitForVisibilityOfWebElement(driver.findElement(zidTitle).findElement(By.xpath("..")).findElement(By.xpath("//*[normalize-space()='Installed']")));
    }
    public void checkZidIntegrationCard(){
        checkZidCard();
        clickToInstall();
        waitForVisibilityOfElement(zidIntegrationTitle);
        ElementsValidator(zidIntegrationTitle,zidIntegrationSubTitle,zidIntegrationDescriptionFirstLine,
                zidIntegrationDescriptionSecondLine,zidIntegrationDescriptionThirdLine,zidIntegrationDescriptionForthLine,
                zidIntegrationDescriptionFifthLine,installZidCTA);
        closeModal();
        waitForVisibilityOfElement(ECommerceTitle);
    }
    private void closeModal(){
        try {
            clickOnElement(closeIntegrationIcon);
        }catch (Exception e){
            driver.findElement(By.xpath("//*[@data-testid='CloseIcon']")).click();
        }
    }
    public void installZid(String zidMail,String zidPassword){
        checkZidCard();
        clickToInstall();
        waitForVisibilityOfElement(zidIntegrationTitle);
        ElementsValidator(zidIntegrationTitle,zidIntegrationSubTitle,zidIntegrationDescriptionFirstLine,
                zidIntegrationDescriptionSecondLine,zidIntegrationDescriptionThirdLine,zidIntegrationDescriptionForthLine,
                zidIntegrationDescriptionFifthLine,installZidCTA);
        clickOnElement(installZidCTA);
        switchToWindowByIndex(2);
        loginToZid(zidMail,zidPassword);
        closeSecondAndBackToFirst(installZidCTA);
        closeModal();

    }
    private void loginToZid(String zidMail,String zidPassword){
        clickOnElement(acceptCookiesCTA);
        waitForVisibilityOfElement(zidEmailInput,90);
        driver.findElement(zidEmailInput).sendKeys(zidMail);
        clickOnElement(nextCTA);
        waitForVisibilityOfElement(loginUsingPassword,90);
        clickOnElement(loginUsingPassword);
        waitForVisibilityOfElement(passwordInput,90);
        sendTextToInputField(zidPassword,passwordInput);
        clickOnElement(loginCTA);
        waitForVisibilityOfElement(storeLogo);
    }
    private void clickToInstall(){
        try {
            clickOnElement(showZidDescriptionIcon);
        }catch (Exception e){
            driver.findElement(By.xpath("//*[normalize-space()='Install']")).click();
        }
    }
}
