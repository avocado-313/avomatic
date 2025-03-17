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
//    private final By MaintenancePopUp = By.xpath("//*[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeSmall css-l7mppb\"]");
    private final By Logo = By.xpath("//*[@src=\"https://assets.avocad0.dev/sdk/mottasl_orange.png\"]");
    private final By AgentDownloadReport = By.xpath("//*[@data-testid=\"AgentsTeamHeader-download-reports\"]");
    private final By TeamDownloadReport = By.xpath("//*[@data-testid=\"AgentsTeamHeader-download-reports\"]");
    private final By ConversationDownloadReport = By.xpath("//*[@data-testid=\"CONVERSATIONS.DOWNLOAD_REPORTS\"]");
    private final By AgentOverViewOutGoingMsg = By.xpath("(//*[@data-testid=\"ConversationCard-title\"])[2]");
    private final By AgentOverViewOutGoingGraph = By.xpath("//*[@class=\"recharts-surface\"]");
    private final By AgentOverViewIncomingMsg = By.xpath("(//*[@data-testid=\"ConversationCard-title\"])[3]");
    private final By AgentOverViewAverageResponseTime = By.xpath("(//*[@data-testid=\"ConversationCard-title\"])[4]");
    private final By AgentOverViewResolutionCount = By.xpath("(//*[@data-testid=\"ConversationCard-title\"])[5]");
    private final By AgentOverViewAverageResolutionTime = By.xpath("(//*[@data-testid=\"ConversationCard-title\"])[6]");
    private final By AgentOverViewAgentsDropDown = By.xpath("(//*[@data-testid=\"ArrowDropDownIcon\"])[1]");
    private final By AgentOverViewDurationDropDown = By.xpath("(//*[@data-testid=\"ArrowDropDownIcon\"])[2]");

    private final By TeamOverViewOutGoingMsg = By.xpath("(//*[@data-testid=\"ConversationCard-title\"])[2]");
    private final By TeamOverViewOutGoingGraph = By.xpath("//*[@class=\"recharts-surface\"]");
    private final By TeamOverViewIncomingMsg = By.xpath("(//*[@data-testid=\"ConversationCard-title\"])[3]");
    private final By TeamOverViewAverageResponseTime = By.xpath("(//*[@data-testid=\"ConversationCard-title\"])[4]");
    private final By TeamOverViewResolutionCount = By.xpath("(//*[@data-testid=\"ConversationCard-title\"])[5]");
    private final By TeamOverViewAverageResolutionTime = By.xpath("(//*[@data-testid=\"ConversationCard-title\"])[6]");

    private final By ConversationOutGoingMsg = By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1 css-1v3wi9g\"])[1]");
    private final By ConversationOutGoingGraph = By.xpath("//*[@class=\"recharts-surface\"]");
    private final By ConversationIncomingMsg = By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1 css-1v3wi9g\"])[2]");
    private final By ConversationAverageResponseTime = By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1 css-1v3wi9g\"])[3]");
    private final By ConversationTotalResolutionCount = By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1 css-1v3wi9g\"])[6]");
    private final By ConversationAverageResolutionTime = By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1 css-1v3wi9g\"])[5]");
    private final By ConversationAverageFirstResponseTime = By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1 css-1v3wi9g\"])[4]");



    public void checkAnalyticsPageTitle() {
//        clickOnElement(MaintenancePopUp);
        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        Assert.assertTrue(driver.findElement(AnalyticsPageTitle).getText().contains("Analytics"));
    }

    public void checkAnalyticsPageTitleDesc(){
//        clickOnElement(MaintenancePopUp);
        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitleDesc);
        Assert.assertTrue(driver.findElement(AnalyticsPageTitleDesc).getText().contains(("View your platform reports here")));
    }

    public void checkAnalyticsOverviewSection(){
//        clickOnElement(MaintenancePopUp);
        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsOverviewSectionAgent);
        waitForVisibilityOfElement(AnalyticsOverviewSectionTitle);
        Assert.assertTrue(driver.findElement(AnalyticsOverviewSectionTitle).getText().contains("Overview"));
    }

    public void checkAnalyticsAgentSection(){
//        clickOnElement(MaintenancePopUp);
//        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsAgentsSectionCta);
        waitForVisibilityOfElement(AnalyticsAgentsSectionTitle);
        Assert.assertTrue(driver.findElement(AnalyticsAgentsSectionTitle).getText().contains("Agents Overview"));
    }

    public void checkAnalyticsAgentDownloadReport(){
//        clickOnElement(MaintenancePopUp);
//        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsAgentsSectionCta);
        waitForVisibilityOfElement(AnalyticsAgentsSectionTitle);
        clickOnElement(AgentDownloadReport);
    }

    public void checkAnalyticsTeamsSection(){
//        clickOnElement(MaintenancePopUp);
//        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsTeamsSectionCta);
        waitForVisibilityOfElement(AnalyticsTeamsSectionTitle);
        Assert.assertTrue(driver.findElement(AnalyticsTeamsSectionTitle).getText().contains("Teams Overview"));
    }

    public void checkAnalyticsTeamDownloadReport(){
//        clickOnElement(MaintenancePopUp);
//        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsAgentsSectionCta);
        waitForVisibilityOfElement(AnalyticsTeamsSectionTitle);
        clickOnElement(TeamDownloadReport);
    }

    public void checkAnalyticsConversationSection(){
//        clickOnElement(MaintenancePopUp);
//        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsConversationCta);
        waitForVisibilityOfElement(AnalyticsConversationTitle);
        Assert.assertTrue(driver.findElement(AnalyticsConversationTitle).getText().contains("Conversations"));
    }

    public void checkAnalyticsConversationDownloadReport(){
//        clickOnElement(MaintenancePopUp);
//        waitForVisibilityOfElement(Logo);
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsConversationCta);
        waitForVisibilityOfElement(AnalyticsConversationTitle);
        clickOnElement(ConversationDownloadReport);
    }

    public void checkAnalyticsAllTabs(){
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsAgentsSectionCta);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(AgentOverViewDurationDropDown);
        waitForTime(1000);
        waitForVisibilityOfElement(AnalyticsAgentsSectionTitle);
        clickOnElement(AgentOverViewOutGoingMsg);
        waitForTime(1000);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(AgentOverViewDurationDropDown);
        waitForTime(1000);
        scrollToElement(AgentOverViewOutGoingGraph);
        clickOnElement(AgentOverViewIncomingMsg);
        waitForTime(1000);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(AgentOverViewDurationDropDown);
        waitForTime(1000);
        scrollToElement(AgentOverViewOutGoingGraph);
        clickOnElement(AgentOverViewAverageResponseTime);
        waitForTime(1000);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(AgentOverViewDurationDropDown);
        waitForTime(1000);
        scrollToElement(AgentOverViewOutGoingGraph);
        clickOnElement(AgentOverViewResolutionCount);
        waitForTime(1000);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(AgentOverViewDurationDropDown);
        waitForTime(1000);
        scrollToElement(AgentOverViewOutGoingGraph);
        clickOnElement(AgentOverViewAverageResolutionTime);
        waitForTime(1000);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(AgentOverViewDurationDropDown);
        waitForTime(1000);
    }

    public void checkAnalyticsTeamAllTabs(){
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsTeamsSectionCta);
        waitForVisibilityOfElement(AnalyticsTeamsSectionTitle);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(AgentOverViewDurationDropDown);
        waitForTime(1000);
        waitForVisibilityOfElement(AnalyticsTeamsSectionTitle);
        clickOnElement(TeamOverViewOutGoingMsg);
        waitForTime(1000);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(AgentOverViewDurationDropDown);
        waitForTime(1000);
        scrollToElement(TeamOverViewOutGoingGraph);
        clickOnElement(TeamOverViewIncomingMsg);
        waitForTime(1000);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(AgentOverViewDurationDropDown);
        waitForTime(1000);
        scrollToElement(TeamOverViewOutGoingGraph);
        clickOnElement(TeamOverViewAverageResponseTime);
        waitForTime(1000);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(AgentOverViewDurationDropDown);
        waitForTime(1000);
        scrollToElement(TeamOverViewOutGoingGraph);
        clickOnElement(TeamOverViewResolutionCount);
        waitForTime(1000);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(AgentOverViewDurationDropDown);
        waitForTime(1000);
        scrollToElement(TeamOverViewOutGoingGraph);
        clickOnElement(TeamOverViewAverageResolutionTime);
        waitForTime(1000);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(AgentOverViewDurationDropDown);
        waitForTime(1000);
    }

    public void checkAnalyticsConversationAllTabs(){
        clickOnElement(AnalyticsSideBarIcon);
        waitForVisibilityOfElement(AnalyticsPageTitle);
        clickOnElement(AnalyticsConversationCta);
        waitForVisibilityOfElement(AnalyticsConversationTitle);
        scrollToEndOfScreen();
        waitForTime(1000);
        scrollToElement(ConversationOutGoingGraph);
        waitForVisibilityOfElement(AnalyticsConversationTitle);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(ConversationOutGoingMsg);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(ConversationIncomingMsg);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(ConversationAverageResponseTime);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(ConversationAverageFirstResponseTime);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(ConversationAverageResolutionTime);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
        clickOnElement(AgentOverViewAgentsDropDown);
        clickOnElement(ConversationTotalResolutionCount);
        waitForTime(1000);
        clickOnElement(AgentOverViewAgentsDropDown);
        waitForTime(1000);
    }
}
