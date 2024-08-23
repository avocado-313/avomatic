package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P14ECommerce;
import avocado.P15ZidPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;
import static Base.ReadProperties.zidPassword;

public class M14ZidTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P14ECommerce commerce;
    P15ZidPage zid;


    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        commerce = new P14ECommerce(driver);
        zid = new P15ZidPage(driver);
    }
    @Test
    public void TC_01validateZidCard() {
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        zid.checkZidIntegrationCard();
        login.logout();
    }
    @Test
    public void TC_02validateZidInstall() {
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        zid.installZid(zidEmail,zidPassword);
        login.logout();
    }
}
