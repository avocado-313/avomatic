package avocadoTests;

import Base.BaseTest;
import avocado.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M10QuickRepliesTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P09BroadCast broadcast;
    P11QuickReplies reply;


    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        broadcast = new P09BroadCast(driver);
        reply = new P11QuickReplies(driver);
    }
    @Test
    public void TC_01ValidateQuickReplyScreen() {
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        reply.validateQuickRepliesFromApps();
        reply.validateQuickRepliesScreen();
        reply.validateCreateNewQuickReplyTemplate();

    }

}
