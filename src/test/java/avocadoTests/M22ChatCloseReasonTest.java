package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P26ChatClosing;
import avocado.P26ChatClosing;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M22ChatCloseReasonTest extends BaseTest {
    P01AvocadoLogin login;
    P02AvocadoHomeScreen home;
    P26ChatClosing close;

    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        close = new P26ChatClosing(driver);
    }

    @Test
    public void TC_01validateClosChatReasonFromApps(){
        login.loginToAvocado(username3, password3, Workspace3);
        home.checkHomeScreen();
        close.validateChatCloseReasonFromApps();
        login.logout();
    }

    @Test
    public void TC_02validateCreateReason(){
        login.loginToAvocado(username3, password3, Workspace3);
        home.checkHomeScreen();
        close.validateChatCloseReasonFromApps();
        close.validateCreateCloseReason();
        close.validateEditCloseReason();

    }
}
