package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P23AppsRoboCalling;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M23RoboCallingAppTest extends BaseTest {

    P01AvocadoLogin login;
    P02AvocadoHomeScreen home;
    P23AppsRoboCalling appsRoboCalling;

    @BeforeClass
    public void initObject(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        appsRoboCalling = new P23AppsRoboCalling(driver);
    }

    @Test
    public void TC_01validateRoboCallingAppText() {
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        appsRoboCalling.checkRoboCallingAppText();
        login.logout();
    }
}
