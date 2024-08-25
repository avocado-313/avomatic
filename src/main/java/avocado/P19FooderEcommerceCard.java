package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class P19FooderEcommerceCard extends PageBase {
    public P19FooderEcommerceCard(WebDriver driver) {
        super(driver);
    }
    private final By fooderIcon = By.xpath("//*[@alt='integration-fooder']");
    private final By fooderCardTitle = By.xpath("(//*[normalize-space()='Fooder'])[2]");
    private final By fooderCardDescription = By.xpath("(//*[contains(normalize-space(),'Receive orders via Fooder WhatsApp')])[13]");
    private final By installCTAFromCard = By.xpath("(//*[@type='button'])[16]");
    private final By xCloseIcon = By.xpath("//*[@data-testid='CloseIcon']");
    private final By fooderTitleFromModal = By.xpath("(//*[normalize-space()='Fooder Integration'])[2]");
    private final By fooderSubTitle = By.xpath("//*[normalize-space()='Please contact your account manager to install Fooder account']");
    private final By fooderDescription = By.xpath("//*[normalize-space()='Click the button below to be redirected to gofooder.com']");
    private final By installFooderCTAFromModal = By.xpath("//*[normalize-space()='Install Fooder']");
    public void checkFooderCardIntoECommerce(){
        ElementsValidator(fooderIcon,fooderCardTitle,fooderCardDescription);
    }
    public void checkFooderInstallCard(){
        Actions actions = new Actions(driver);
        waitForTime(5000);
        actions.moveToElement(driver.findElement(installCTAFromCard)).click().perform();
        waitForVisibilityOfElement(xCloseIcon);
        waitForTime(5000);
        ElementsValidator(fooderTitleFromModal,fooderSubTitle,fooderDescription,installFooderCTAFromModal);
        clickOnElement(xCloseIcon);
        waitForVisibilityOfElement(fooderIcon);
    }

}
