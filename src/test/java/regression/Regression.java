package regression;

import Base.BaseTest;
import avocado.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class Regression extends BaseTest {
    P01AvocadoLogin login ;
    P31AvocadoSignUp signup;
    P02AvocadoHomeScreen home;
    P03AvocadoWorkSpace workSpace;
    P04AvocadoContacts contacts;


    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        signup = new P31AvocadoSignUp(driver);
        home = new P02AvocadoHomeScreen(driver);
        workSpace = new P03AvocadoWorkSpace(driver);
        contacts = new P04AvocadoContacts(driver);
       


    }

 
    @Test
    public void TC_005ValidateContacts() throws InterruptedException {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        contacts.navigateAndValidateContactsScreen();
        contacts.validateCreateContactCard();
        login.logout();
    }
        @Test
    public void TC_009ValidateTagsScreen() throws InterruptedException  {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        tags.validateTagsScreen();
        tags.validateTagCreation();
        tags.validateDeleteTag();
        login.logout();
    }
    @Test
    public void TC_010ValidateNavigateBackFromTags() throws InterruptedException  {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        tags.validateTagsFromApps();
        tags.checkNavigateBackFromTags();
        login.logout();
    }


}
