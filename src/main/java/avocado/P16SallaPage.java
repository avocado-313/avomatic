package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P16SallaPage extends PageBase {
    public P16SallaPage(WebDriver driver) {
        super(driver);
    }
    private final By sallaIcon = By.xpath("//*[@alt='integration-salla']");
    private final By sallaTitle = By.xpath("(//*[normalize-space()='Salla'])[2]");
    private final By sallaDescription = By.xpath("//*[normalize-space()='Automate communication," +
            " oversee orders with precision, recover lost sales, and drive revenue growth through strategic marketing." +
            " Elevate your store with Salla.']");
    private final By xCloseSallaModal = By.xpath("//*[@data-testid='CloseIcon']");
    private final By sallaIntegrationLabel =By.xpath("(//*[normalize-space()='Salla Integration'])[2]");
    private final By sallaIntegrationSubTitle = By.xpath("//*[normalize-space()='You will be redirected to Salla Store for Installation']");
    private final By integrationSallaSecond = By.xpath("//*[normalize-space()='Install Salla:']");
    private final By integrationSallaThird = By.xpath("//*[normalize-space()='Accept Authorization:']");
    private final By integrationSallaForth = By.xpath("//*[normalize-space()='Access App Settings:']");
    private final By integrationSallaFifth = By.xpath("//*[normalize-space()='Add Business ID:']");
    private final By integrationSallaLatest = By.xpath("//*[normalize-space()='Confirm Business ID:']");
    private final By installSallaCTA = By.xpath("//button[normalize-space()='Install Salla']");
    private final By copyBusinessCTA = By.xpath("//button[@aria-label='Copied']");





    public void checkSallaCard(){
        ElementsValidator(sallaIcon,sallaTitle,sallaDescription);
    }
    public void checkSallaModal(){
        clickOnElement(By.xpath("(//*[normalize-space()='Install'])[4]"));
        waitForVisibilityOfElement(xCloseSallaModal);
        waitForTime(5000);
        ElementsValidator(sallaIntegrationLabel,sallaIntegrationSubTitle,integrationSallaSecond,integrationSallaThird
        ,integrationSallaForth,integrationSallaFifth,integrationSallaLatest,installSallaCTA,copyBusinessCTA);
        clickOnElement(xCloseSallaModal);
        waitForVisibilityOfElement(sallaTitle);
    }

}
