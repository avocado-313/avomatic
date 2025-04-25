package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P22AppsCallReport extends PageBase {
    public P22AppsCallReport(WebDriver driver) {super(driver);}

    private final By CallsReportText = By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1 css-q2b610\"])[14]");
    private final By AppsFromMenu = By.xpath("//a[@aria-label='Apps']//*[name()='svg']");
    private final By AppsPageTitle = By.xpath("//*[@data-testid=\"title\"]");


    public void checkCallsReportText(){
        clickOnElement(AppsFromMenu);
        waitForVisibilityOfElement(AppsPageTitle);
        clickOnElement(CallsReportText);
    }
}
