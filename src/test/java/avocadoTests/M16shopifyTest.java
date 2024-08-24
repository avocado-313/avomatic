package avocadoTests;

import Base.BaseTest;
import avocado.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;
import static Base.ReadProperties.Workspace;

public class M16shopifyTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P14ECommerce commerce;
    P17ShopifyPage shopify;


    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        commerce = new P14ECommerce(driver);
        shopify = new P17ShopifyPage(driver);
    }
    @Test
    public void TC_01validateShopifyCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        shopify.checkShopifyCardIntoEcommerceScreen();
        login.logout();
    }
    @Test
    public void TC_02validateShopifyIntegrationModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        shopify.checkShopifyCardIntoEcommerceScreen();
        shopify.checkShopifyIntegrationCard();
        login.logout();
    }
}
