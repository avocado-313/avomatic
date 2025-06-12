package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P04AvocadoContacts;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M03ContactsTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P04AvocadoContacts contacts;
    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        contacts = new P04AvocadoContacts(driver);
    }
    @Test
    public void TC_01ValidateContacts() throws InterruptedException {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        contacts.navigateAndValidateContactsScreen();
        contacts.validateCreateContactCard();
        login.logout();
    }
    @Test
    public void TC_02ValidateContactsCreation() throws InterruptedException {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        contacts.validateAndCreateNewContact();
        login.logout();
    }

    @Test
    public void TC_03ValidateEmptyFields() throws InterruptedException {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        contacts.validateEmptyFields();
        login.logout();
    }
    @Test
    public void TC_04ValidateChatScreen() throws InterruptedException {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        contacts.validateAndCreateNewContact();
        contacts.validateChatScreen();
        login.logout();
    }


    @Test
    public void TC_05ValidateFilters(){
        login.loginToAvocado(username,password,Workspace);
        home.checkHomeScreen();
        contacts.navigateAndValidateContactsScreen();
        contacts.checkDateAddedFilter();
        contacts.checkTagsFilter();
        contacts.checkChannelFilter();
        login.logout();
    }


}
