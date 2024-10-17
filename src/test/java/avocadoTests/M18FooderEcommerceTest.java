package avocadoTests;

import Base.BaseTest;
import avocado.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;
import static Base.ReadProperties.Workspace;

public class M18FooderEcommerceTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P14ECommerce commerce;
    P19FooderEcommerceCard fooder;


    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        commerce = new P14ECommerce(driver);
        fooder = new P19FooderEcommerceCard(driver);
    }
    @Test
    public void TC_01validateFooderCommerceCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        fooder.checkFooderCardIntoECommerce();
        login.logout();
    }
    @Test
    public void TC_02validateFooderIntegrationModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        fooder.checkFooderCardIntoECommerce();
        fooder.checkFooderInstallCard();
        login.logout();
    }
}
