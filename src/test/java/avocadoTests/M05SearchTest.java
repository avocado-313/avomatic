package avocadoTests;

import Base.BaseTest;
import avocado.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M05SearchTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P06AvocadoSearch search;

    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        search = new P06AvocadoSearch(driver);
    }
    @Test
    public void TC_01ValidateSearchScreen() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        search.validateSearchScreen();
//        search.validateSearchXClose();
//        search.validateSearchClosedOnceClickingOutsideSearchContainer();
        search.validateContactsTab();
        search.validateMessageTab();
        search.validateLastActivity();

        login.logout();
    }


}
