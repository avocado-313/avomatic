package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P21Analytics;
import avocado.P22AppsCallReport;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M22AppsCallReportTest extends BaseTest {
    P01AvocadoLogin login;
    P02AvocadoHomeScreen home;
    P22AppsCallReport appsCallReport;

    @BeforeClass
    public void initObject(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        appsCallReport = new P22AppsCallReport(driver);
    }

    @Test
    public void TC_01validateCallsReportText() {
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        appsCallReport.checkCallsReportText();
        login.logout();
    }

}
