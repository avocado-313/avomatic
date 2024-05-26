package regression;

import Base.BaseTest;
import avocado.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.password;
import static Base.ReadProperties.username;

public class Regression extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P03AvocadoWorkSpace workSpace;
    P04AvocadoContacts contacts;
    P05AvocadoApps apps;
    P06AvocadoSearch search ;
    P07AvocadoMedia media;
    P08AvocadoTags tags;
    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        workSpace = new P03AvocadoWorkSpace(driver);
        contacts = new P04AvocadoContacts(driver);
        apps = new P05AvocadoApps(driver);
        search = new P06AvocadoSearch(driver);
        media = new P07AvocadoMedia(driver);
        tags = new P08AvocadoTags(driver);
    }

    @Test
    public void TC_01ValidateLoginToAvocado(){
        login.validateLoginScreenLocators(username,password);
        login.logout();
    }
    @Test
    public void TC_02ValidateIconsOfHomeScreen(){
        login.loginToAvocado(username,password);
        home.checkHomeScreen();
        home.checkEachMenuIconNavigation();
        login.logout();
    }
    @Test
    public void TC_03ValidateWorkspace(){
        login.loginToAvocado(username,password);
        home.checkHomeScreen();
        workSpace.navigateToProfileWorkspace();
        workSpace.validateWorkspaceElements();
        workSpace.validateChangePassword();
        workSpace.checkWorkSpaceProfile();
        login.logout();
    }
    @Test
    public void TC_04ValidateGreetingScreenFullScenario(){
        login.loginToAvocado(username,password);
        home.checkHomeScreen();
        apps.navigateToGreetingScreen();
        apps.validateGreetingsScreen();
        apps.setWorkingHours("07","04");
        apps.validateGreetingMessageComponent();
        apps.sendGreetingMessage();
        login.logout();
    }
    @Test
    public void TC_05ValidateContacts() {
        login.loginToAvocado(username, password);
        home.checkHomeScreen();
        contacts.navigateAndValidateContactsScreen();
//        contacts.validateCreateContactCard();
    }
    @Test
    public void TC_06ValidateContactsCreation() {
//        contacts.createNewContact();
//        contacts.validateChatScreen();
    }
    @Test
    public void TC_07ValidateSearchScreen() {
        search.validateSearchScreen();
        search.validateSearchXClose();
        search.validateSearchScreen();
        search.validateContactsTab();
        search.validateMessageTab();
        search.validateLastActivity();
    }
    @Test
    public void TC_08ValidateMediaScreen() {
        media.validateUploadMediaFunctionality();
        media.validateMediaAcceptsLessThan10MbFiles();
        media.validateNavigateBackFromMediaToApps();
    }
    @Test
    public void TC_09ValidateTagsScreen() {
        tags.validateTagsScreen();
        tags.validateTagCreation();
        tags.validateDeleteTag();
    }
}
