package avocadoTests;

import Base.BaseTest;
import avocado.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M15SallaTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P14ECommerce commerce;
    P16SallaPage salla;


    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        commerce = new P14ECommerce(driver);
        salla = new P16SallaPage(driver);
    }
    @Test
    public void TC_01validateSallaCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        salla.checkSallaCard();
        login.logout();
    }
    @Test
    public void TC_02validateSallaIntegrationModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        salla.checkSallaCard();
        salla.checkSallaModal();
        login.logout();
    }
}
