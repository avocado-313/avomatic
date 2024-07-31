package regression;

import Base.BaseTest;
import avocado.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class Regression extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P03AvocadoWorkSpace workSpace;
    P04AvocadoContacts contacts;
    P05AvocadoApps apps;
    P06AvocadoSearch search ;
    P07AvocadoMedia media;
    P08AvocadoTags tags;
    P09BroadCast broadcast;
    P10Template template;
    P11QuickReplies reply;
    P12RulesPage rule;
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
        broadcast = new P09BroadCast(driver);
        template = new P10Template(driver);
        reply = new P11QuickReplies(driver);
        rule = new P12RulesPage(driver);
    }

    @Test
    public void TC_001ValidateLoginToAvocado(){
        login.validateLoginScreenLocators(username,password,Workspace);
        login.logout();
    }
    @Test
    public void TC_002ValidateIconsOfHomeScreen(){
        login.loginToAvocado(username,password,Workspace);
        home.checkHomeScreen();
        home.checkEachMenuIconNavigation();
        login.logout();
    }
    @Test
    public void TC_003ValidateWorkspace(){
        login.loginToAvocado(username,password,Workspace);
        home.checkHomeScreen();
        workSpace.navigateToProfileWorkspace();
        workSpace.validateWorkspaceElements();
        workSpace.validateChangePassword();
        workSpace.checkWorkSpaceProfile();
        login.logout();
    }
    @Test
    public void TC_004ValidateGreetingScreenFullScenario(){
        login.loginToAvocado(username,password,Workspace);
        home.checkHomeScreen();
        apps.navigateToGreetingScreen();
        apps.validateGreetingsScreen();
        apps.setWorkingHours("07","04");
        apps.validateGreetingMessageComponent();
        apps.sendGreetingMessage();
        login.logout();
    }
    @Test
    public void TC_005ValidateContacts() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        contacts.navigateAndValidateContactsScreen();
//        contacts.validateCreateContactCard();
    }
    @Test
    public void TC_006ValidateContactsCreation() {
//        contacts.createNewContact();
//        contacts.validateChatScreen();
    }
    @Test
    public void TC_007ValidateSearchScreen() {
        search.validateSearchScreen();
        search.validateSearchXClose();
        search.validateSearchScreen();
        search.validateContactsTab();
        search.validateMessageTab();
        search.validateLastActivity();
    }
    @Test
    public void TC_008ValidateMediaScreen() {
        media.validateUploadMediaFunctionality();
        media.validateMediaAcceptsLessThan10MbFiles();
        media.validateNavigateBackFromMediaToApps();
    }
    @Test
    public void TC_009ValidateTagsScreen() {
        tags.validateTagsScreen();
        tags.validateTagCreation();
        tags.validateDeleteTag();
    }
    @Test
    public void TC_010ValidateNavigateBackFromTags() {
        tags.checkNavigateBackFromTags();
    }
    @Test
    public void TC_011ValidateBroadcastScreen() {
        broadcast.validateBroadCastFromApps();
        broadcast.navigateToBroadcastFromApps();
        broadcast.checkBroadCastScreen();

    }
    @Test
    public void TC_012validateNavigateBAckFunctionalityIntoBroadcast(){
        broadcast.checkNavigateBackIntoBroadcastScreen();
        login.logout();
    }
    @Test
    public void TC_013validateCreateBroadCastScreen(){
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        broadcast.validateBroadCastFromApps();
        broadcast.navigateToBroadcastFromApps();
        broadcast.checkBroadCastScreen();
        broadcast.checkCreateBroadcastScreen();
        broadcast.selectTemplate();
        broadcast.completeRecipientScreen(CONTACT);
        login.logout();
    }
    @Test
    public void TC_014ValidateTemplateScreen() {
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();
        template.validateCreateTemplateScreen();
        login.logout();

    }
    @Test
    public void TC_15ValidateQuickRepliesScreen() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        reply.validateQuickRepliesFromApps();
        reply.validateQuickRepliesScreen();
        reply.validateCreateNewQuickReplyTemplate();
        login.logout();

    }
    @Test
    public void TC_16validateRulesFromApp() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        login.logout();

    }
    @Test
    public void TC_17validateNavigationTRules() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        rule.navigateToRules();
        login.logout();

    }
    @Test
    public void TC_18validateCreateRuleScreen() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        rule.navigateToRules();
        rule.checkCreateRulesScreen();
        login.logout();

    }

    @Test
    public void TC_19validateCreateRuleModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        rule.navigateToRules();
        rule.checkCreateRulesScreen();
        rule.checkCreateRuleModalElements();
        login.logout();

    }
    @Test
    public void TC_20validateNewRuleCreation() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        rule.navigateToRules();
        rule.checkCreateRulesScreen();
        rule.checkCreateRuleModalElements();
        rule.createNewRule();

    }

}
