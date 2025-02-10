package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P21Analytics;
import avocado.P30WhatsappWidget;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M21Analytics extends BaseTest {
    P01AvocadoLogin login;
    P02AvocadoHomeScreen home;
    P21Analytics analytics;


    @BeforeClass
    public void initObject(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        analytics = new P21Analytics(driver);
    }
    @Test
    public void TC_01validateAnalyticsPageTitle() {
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsPageTitle();
        login.logout();
    }

    @Test
    public void TC_02validateAnalyticsPageTitleDesc(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsPageTitleDesc();
        login.logout();
    }

    @Test
    public void TC_03validateAnalyticsOverviewSection(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsOverviewSection();
        login.logout();
    }

    @Test
    public void TC_04validateAnalyticsAgentsSection(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsAgentSection();
        login.logout();
    }

    @Test
    public void TC_05validateAnalyticsAgentsDownloadReport(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsAgentDownloadReport();
        login.logout();
    }


    @Test
    public void TC_06validateAnalyticsTeamsSection(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsTeamsSection();
        login.logout();
    }

    @Test
    public void TC_07validateAnalyticsTeamsDownloadReport(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsTeamDownloadReport();
        login.logout();
    }


    @Test
    public void TC_08validateAnalyticsConversationSection(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsConversationSection();
        login.logout();
    }

    @Test
    public void TC_09validateAnalyticsConversationDownloadReport(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsConversationDownloadReport();
        login.logout();
    }


}
