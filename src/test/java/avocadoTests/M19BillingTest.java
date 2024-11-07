package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P20Billing;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;


public class M19BillingTest extends BaseTest {
    P01AvocadoLogin login;
    P02AvocadoHomeScreen home;
    P20Billing bill;

    @BeforeClass
    public void initObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        bill = new P20Billing(driver);
    }
    @Test
    public void TC_01ValidateBillingCreen(){
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        bill.navigateAndValidateBillingScreen();
        login.logout();
    }
}
