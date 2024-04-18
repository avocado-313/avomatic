package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P03AvocadoWorkSpace;
import avocado.P04AvocadoContacts;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.password;
import static Base.ReadProperties.username;

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
    public void TC_01ValidateContacts() {
        login.loginToAvocado(username, password);
        home.checkHomeScreen();
        contacts.navigateAndValidateContactsScreen();
        contacts.validateCreateContactCard();
    }
    @Test
    public void TC_02ValidateContactsCreation() {
        login.loginToAvocado(username, password);
        home.checkHomeScreen();
        contacts.validateAndCreateNewContact();
    }

    @Test
    public void TC_03ValidateEmptyFields() {
        login.loginToAvocado(username, password);
        home.checkHomeScreen();
        contacts.validateEmptyFields();
    }
    @Test
    public void TC_04ValidateChatScreen() {
        login.loginToAvocado(username, password);
        home.checkHomeScreen();
        contacts.validateAndCreateNewContact();
        contacts.validateChatScreen();
    }

}
