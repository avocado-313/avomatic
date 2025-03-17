package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P24WebPhone;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M24WebCallingTest extends BaseTest {
    P01AvocadoLogin login;
    P02AvocadoHomeScreen home;
    P24WebPhone webPhone;

    @BeforeClass
    public void initObject(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        webPhone = new P24WebPhone(driver);
    }

    @Test
    public void TC_01validateWebPhoneIcon() {
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        webPhone.checkWebPhoneIcon();
        login.logout();
    }

}
