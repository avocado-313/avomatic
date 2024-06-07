package avocadoTests;

import Base.BaseTest;
import avocado.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M08BroadcastTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P09BroadCast broadcast;


    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        broadcast = new P09BroadCast(driver);
    }
    @Test
    public void TC_01ValidateBroadcastScreen() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        broadcast.validateBroadCastFromApps();
        broadcast.navigateToBroadcastFromApps();
        broadcast.checkBroadCastScreen();
    }
    @Test
    public void TC_02validateCreateBroadCastScreen(){
        broadcast.checkCreateBroadcastScreen();
    }
    @Test
    public void TC_03validateNavigateBAckFunctionalityIntoBroadcast(){
        broadcast.checkNavigateBackIntoBroadcastScreen();
    }
}
