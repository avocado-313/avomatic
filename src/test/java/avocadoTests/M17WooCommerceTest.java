package avocadoTests;

import Base.BaseTest;
import avocado.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;
import static Base.ReadProperties.Workspace;

public class M17WooCommerceTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P14ECommerce commerce;
    P18WooCommercePage woo;


    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        commerce = new P14ECommerce(driver);
        woo = new P18WooCommercePage(driver);
    }
    @Test
    public void TC_01validateWooCommerceCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        woo.checkWooCommerceCardIntoECommerce();
        login.logout();
    }
    @Test
    public void TC_02validateWooCommerceIntegrationModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        woo.checkWooCommerceCardIntoECommerce();
        woo.checkWooCommerceIntegrationCard();
        login.logout();
    }
}
