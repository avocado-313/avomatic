package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

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
    private final By zidIntegrationDescriptionFifthLine = By.xpath("//*[normalize-space()='Return to Mottasl:']");
    private final By installZidCTA = By.xpath("//button[normalize-space()='Install Zid']");
    private final By closeIntegrationIcon = By.xpath("(//*[@data-testid='CloseIcon'])[3]");
    private final By acceptCookiesCTA = By.xpath("//*[@id='hs-eu-confirmation-button']");
    private final By zidEmailInput = By.xpath("//input[@name='email']");
    private final By nextCTA = By.xpath("(//*[normalize-space()='التالي'])[2]");
    private final By loginUsingPassword = By.xpath("//*[@data-identifier='zid-login-form-login-with-password']");
    private final By passwordInput = By.xpath("//input[@name='password']");
    private final By loginCTA = By.xpath("(//*[@class='zid-button__content' and contains(normalize-space(),'تسجيل الدخول')])[1]");
    private final By storeLogo = By.xpath("//*[@alt='شعار المتجر']");
    private final By activateZidCTA = By.xpath("(//*[normalize-space()='فعل التطبيق'])[3]");
    private final By avocadoHub = By.xpath("//*[normalize-space() ='أفوكادو هاب']");
    private final By closeZidUpdates = By.xpath("//div[@class='beamerAnnouncementBarClose']//*[name()='svg']");
    private final By confirmAppActivation = By.xpath("(//*[@type='button'])[13]");
    private final By avocadoLogo = By.xpath("//*[@alt='Avocado Hub']");
    private final By installApp = By.xpath("(//*[normalize-space()='تثبيت التطبيق'])[3]");
    private final By cancelProcess = By.xpath("(//button[@type='submit'])[1]");


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
    public void checkZidInstallationFunctionality(String zidMail, String zidPassword , boolean isInstall){
        try {
            navigateToInstallAVC(zidMail, zidPassword);
            completeToInstallationScreen();
        }catch (Exception e){
            e.getStackTrace();
        }
        if(!isInstall) {
            try {
                clickOnElement(cancelProcess);
                waitForTime(10000);
                waitForVisibilityOfElement(avocadoHub, 200);
                closeSecondAndBackToFirst(installZidCTA);
                clickOnElement(By.xpath("//*[@data-testid='CloseIcon']"));
            }catch (Exception e){
                e.getStackTrace();
            }
        }else {
            try {
                clickOnElement(installApp);
                System.out.println("installed...");
                waitForTime(10000);
                closeSecondAndBackToFirst(installZidCTA);
                clickOnElement(By.xpath("//*[@data-testid='CloseIcon']"));
            }catch (Exception e){
                e.getStackTrace();
            }
        }

    }
    public void checkZidUnInstallation(String zidMail, String zidPassword){
        try {
            navigateToInstallAVC(zidMail, zidPassword);
            uninstallAVCFromZid();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    private void completeToInstallationScreen(){
        try {
            ElementsValidator(avocadoHub, activateZidCTA);
            clickOnElement(activateZidCTA);
            waitForVisibilityOfElement(confirmAppActivation);
            clickOnElement(confirmAppActivation);
            closeSecondAndGoToThird(avocadoLogo);
            waitForTime(5000);
            System.out.println("****** " + driver.getCurrentUrl());
            waitForVisibilityOfElement(avocadoLogo);
        }catch (Exception e){
            e.getStackTrace();
        }
        scrollToElement(cancelProcess);
        Assert.assertTrue(assertElementDisplayed(cancelProcess));
    }
    private void navigateToInstallAVC(String zidMail, String zidPassword){
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
        clickOnElement(installZidCTA);
        switchToWindowByIndex(2);
        try {
            waitForVisibilityOfElement(avocadoHub);
            waitForTime(10000);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    public void uninstallAVCFromZid(){
        clickOnElement(uninstallCTA);
        clickOnElement(uninstallCTAFromPopup);
        clickOnElement(selectOthers);
        sendTextToInputField("text",uniStallReasonInput);
        scrollToElement(confirmUnInstall);
        clickOnElement(confirmUnInstall);

    }
    private final By uninstallCTA = By.xpath("(//*[normalize-space()='الغاء التفعيل'])[3]");
    private final By uninstallCTAFromPopup = By.xpath("(//*[normalize-space()='الغاء التفعيل'])[4]");
    private final By selectOthers = By.xpath("(//*[@class='zid-checkbox__checkmark'])[8]");
    private final By uniStallReasonInput = By.xpath("(//*[@id='reason-message'])[2]");
    private final By confirmUnInstall = By.xpath("(//*[normalize-space()='الغاء التفعيل'])[4]");
    private void loginToZid(String zidMail,String zidPassword){
        waitForTime(2000);
        try {
            clickOnElement(acceptCookiesCTA);
        }catch (Exception e){
            e.getStackTrace();
        }
        waitForVisibilityOfElement(zidEmailInput,90);
        driver.findElement(zidEmailInput).sendKeys(zidMail);
        waitForTime(10000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(nextCTA)).click().perform();
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
