package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P20Billing extends PageBase {
    public P20Billing(WebDriver driver) {
        super(driver);
    }
    private final By BillingIconFromSideMenu = By.xpath("//button[@value='Billing']//*[name()='svg']");
    private final By BillingTitle = By.xpath("//*[@data-testid='title']");
    private final By BillingDescription = By.xpath("//*[@data-testid='description']");
    private final By BillingDashboardCTA = By.xpath("//button[normalize-space() = 'Billing Dashboard']");
    private final By DashboardLabel = By.xpath("//*[normalize-space() = 'Subscription Details']");

    public void navigateAndValidateBillingScreen(){
        clickOnElement(BillingIconFromSideMenu);
        waitForVisibilityOfElement(BillingTitle);
        Assert.assertTrue(driver.findElement(BillingTitle).getText().contains("Subscription Management"));
        Assert.assertTrue(driver.findElement(BillingDescription).getText().contains("Manage and review your subscription and billing details."));
        try {
            ElementsValidator(BillingDashboardCTA, DashboardLabel);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
