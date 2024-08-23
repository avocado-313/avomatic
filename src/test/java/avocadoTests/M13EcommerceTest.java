package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P14ECommerce;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M13EcommerceTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P14ECommerce commerce;


    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        commerce = new P14ECommerce(driver);
    }
    @Test
    public void TC_01validateEcommerceScreen() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        login.logout();
    }

}
