package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P03AvocadoWorkSpace;
import avocado.P05AvocadoApps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M04AppsTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P03AvocadoWorkSpace workspace;
    P05AvocadoApps apps;
    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        workspace = new P03AvocadoWorkSpace(driver);
        apps = new P05AvocadoApps(driver);
    }
    @Test
    public void TC_01ValidateGreetingScreen(){
        login.loginToAvocado(username,password,Workspace);
        home.checkHomeScreen();
        apps.navigateToGreetingScreen();
        apps.validateGreetingsScreen();
        apps.validateGreetingMessageComponent();
        apps.sendGreetingMessage();
    }
    @Test
    public void TC_02ValidateWorkingHoursComponent(){
        login.loginToAvocado(username,password,Workspace);
        home.checkHomeScreen();
        apps.navigateToGreetingScreen();
        apps.validateGreetingsScreen();
        apps.setWorkingHours("07","04");
    }
    @Test
    public void TC_03ValidateGreetingScreenFullScenario(){
        login.loginToAvocado(username,password,Workspace);
        home.checkHomeScreen();
        apps.navigateToGreetingScreen();
        apps.validateGreetingsScreen();
        apps.setWorkingHours("07","04");
        apps.validateGreetingMessageComponent();
        apps.sendGreetingMessage();
    }

}
