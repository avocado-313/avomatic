package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P24VoipAdminReport extends PageBase {
    public P24VoipAdminReport(WebDriver driver) {
        super(driver);
    }
    private final By AppsFromMenu = By.xpath("//a[@aria-label='Apps']//*[name()='svg']");
    private final By AppsPageTitle = By.xpath("//*[@data-testid=\"title\"]");

    private final By VoipAdminTitle = By.xpath("(//*[normalize-space()='VoIP Admin Reports'])[3]");
    private final By VoipAdminDesc = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-cc9b9l'])[17]");

    public void checkVoipAdmin() {
        clickOnElement(AppsFromMenu);
        waitForVisibilityOfElement(AppsPageTitle);
        scrollToElement(VoipAdminTitle);
        waitForVisibilityOfElement(VoipAdminTitle);
        Assert.assertTrue(driver.findElement(VoipAdminDesc).getText().contains("Provides insights and analytics on VoIP usage, call quality, and performance metrics."));

    }
}