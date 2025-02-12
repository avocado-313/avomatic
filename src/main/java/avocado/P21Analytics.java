package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P21Analytics extends PageBase {
    public P21Analytics(WebDriver driver) {super(driver);}

    private final By AnalyticsPageTitle = By.xpath("//*[normalize-space()='Analytics']");
    private final By AnalyticsSideBarIcon = By.xpath("(//*[@xmlns=\"http://www.w3.org/2000/svg\"])[1]");
    private final By AnalyticsPageTitleDesc = By.xpath("//*[normalize-space()='View your platform reports here']");
    private final By AnalyticsOverviewSectionAgent = By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-h6 css-2xgtc5\"])[4]");
    private final By AnalyticsOverviewSectionTitle = By.xpath("//*[@class=\"MuiTypography-root MuiTypography-h5 css-72ogzh\"]");
    private final By AnalyticsAgentsSectionCta = By.xpath("(//*[@data-testid=\"setting-button\"])[2]");
    private final By AnalyticsAgentsSectionTitle = By.xpath("//*[@data-testid=\"AgentsTeamHeader\"]");
    private final By AnalyticsTeamsSectionCta = By.xpath("(//*[@data-testid=\"setting-button\"])[3]");
    private final By AnalyticsTeamsSectionTitle = By.xpath("//*[@data-testid=\"AgentsTeamHeader\"]");
    private final By AnalyticsConversationCta = By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1 css-1eucit8\"])[4]");
    private final By AnalyticsConversationTitle = By.xpath("//*[@class=\"MuiTypography-root MuiTypography-h5 css-72ogzh\"]");
    private final By MaintenancePopUp = By.xpath("//*[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeSmall css-l7mppb\"]");
    private final By Logo = By.xpath("//*[@src=\"https://assets.avocad0.dev/sdk/mottasl_orange.png\"]");
    private final By AgentDownloadReport = By.xpath("//*[@data-testid=\"AgentsTeamHeader-download-reports\"]");
    private final By TeamDownloadReport = By.xpath("//*[@data-testid=\"AgentsTeamHeader-download-reports\"]");
    private final By ConversationDownloadReport = By.xpath("//*[@data-testid=\"CONVERSATIONS.DOWNLOAD_REPORTS\"]");



    public void checkAnalyticsPageTitle() {
        clickOnElement(MaintenancePopUp);
        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        Assert.assertTrue(driver.findElement(AnalyticsPageTitle).getText().contains("Analytics"));
    }

    public void checkAnalyticsPageTitleDesc(){
        clickOnElement(MaintenancePopUp);
        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitleDesc);
        Assert.assertTrue(driver.findElement(AnalyticsPageTitleDesc).getText().contains(("View your platform reports here")));
    }

    public void checkAnalyticsOverviewSection(){
        clickOnElement(MaintenancePopUp);
        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsOverviewSectionAgent);
        waitForVisibilityOfElement(AnalyticsOverviewSectionTitle);
        Assert.assertTrue(driver.findElement(AnalyticsOverviewSectionTitle).getText().contains("Overview"));
    }

    public void checkAnalyticsAgentSection(){
        clickOnElement(MaintenancePopUp);
        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsAgentsSectionCta);
        waitForVisibilityOfElement(AnalyticsAgentsSectionTitle);
        Assert.assertTrue(driver.findElement(AnalyticsAgentsSectionTitle).getText().contains("Agents Overview"));
    }

    public void checkAnalyticsAgentDownloadReport(){
        clickOnElement(MaintenancePopUp);
        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsAgentsSectionCta);
        waitForVisibilityOfElement(AnalyticsAgentsSectionTitle);
        clickOnElement(AgentDownloadReport);
    }

    public void checkAnalyticsTeamsSection(){
        clickOnElement(MaintenancePopUp);
        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsTeamsSectionCta);
        waitForVisibilityOfElement(AnalyticsTeamsSectionTitle);
        Assert.assertTrue(driver.findElement(AnalyticsTeamsSectionTitle).getText().contains("Teams Overview"));
    }

    public void checkAnalyticsTeamDownloadReport(){
        clickOnElement(MaintenancePopUp);
        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsAgentsSectionCta);
        waitForVisibilityOfElement(AnalyticsTeamsSectionTitle);
        clickOnElement(TeamDownloadReport);
    }

    public void checkAnalyticsConversationSection(){
        clickOnElement(MaintenancePopUp);
        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsConversationCta);
        waitForVisibilityOfElement(AnalyticsConversationTitle);
        Assert.assertTrue(driver.findElement(AnalyticsConversationTitle).getText().contains("Conversations"));
    }

    public void checkAnalyticsConversationDownloadReport(){
        clickOnElement(MaintenancePopUp);
        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsConversationCta);
        waitForVisibilityOfElement(AnalyticsConversationTitle);
        clickOnElement(ConversationDownloadReport);
    }



}
