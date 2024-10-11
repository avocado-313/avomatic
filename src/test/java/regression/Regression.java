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
    P013CustomAttributes custom;
    P14ECommerce commerce;
    P15ZidPage zid;
    P16SallaPage salla;
    P17ShopifyPage shopify;
    P18WooCommercePage woo;
    P19FooderEcommerceCard fooder;
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
        custom = new P013CustomAttributes(driver);
        zid = new P15ZidPage(driver);
        salla = new P16SallaPage(driver);
        commerce = new P14ECommerce(driver);
        shopify = new P17ShopifyPage(driver);
        woo = new P18WooCommercePage(driver);
        fooder = new P19FooderEcommerceCard(driver);

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
//    @Test
//    public void TC_003ValidateWorkspace(){
//        login.loginToAvocado(username,password,Workspace);
//        home.checkHomeScreen();
//        workSpace.navigateToProfileWorkspace();
//        workSpace.validateWorkspaceElements();
//        workSpace.validateChangePassword();
//        workSpace.checkWorkSpaceProfile();
//        login.logout();
//    }
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
        login.logout();
    }
    @Test
    public void TC_011ValidateBroadcastScreen() {
        login.loginToAvocado(username2,password2,Workspace2);
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
//        login.loginToAvocado(username2, password2,Workspace2);
//        home.checkHomeScreen();
//        broadcast.validateBroadCastFromApps();
//        broadcast.navigateToBroadcastFromApps();
//        broadcast.checkBroadCastScreen();
//        broadcast.checkCreateBroadcastScreen();
//        try {
//            broadcast.selectTemplate();
//        }catch (Exception e){
//            e.getStackTrace();
//        }
////        broadcast.completeRecipientScreen(CONTACT);
//        login.logout();
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
        login.logout();
    }

    @Test
    public void TC_39validateNewRuleCreation(){
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        rule.navigateToRules();
        rule.checkCreateRulesScreen();
        rule.checkCreateRuleModalElements();
        rule.newRuleCreation("karim");
        login.logout();
    }
    @Test
    public void TC_40validateDeletionOfRule(){
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        rule.navigateToRules();
        rule.deleteRule();
        login.logout();
    }
    @Test
    public void TC_21validateCustomAttributesFromApp() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        custom.checkCustomAttributesFromApps();
    }
    @Test
    public void TC_22validateCustomAttributesScreenElements() {
        custom.navigateToCustomAttributes();
        custom.checkCustomAttributesScreen();
    }
    @Test
    public void TC_23validateCustomAttributesScreenTemplate() {
        custom.validateCreateCustomAttributeTemplate();
    }
    @Test
    public void TC_24validateCustomAttributesCreation() {
        custom.fillCreateCustomAttributesTemplate();
    }
    @Test
    public void TC_25validateDeleteCustomAttributes() {
        try {
            custom.deleteCustomAttributes();
        }catch (Exception e){
            e.getStackTrace();
        }
        login.logout();
    }
    @Test
    public void TC_26validateEcommerceScreen() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        login.logout();
    }
    @Test
    public void TC_27validateZidCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        zid.checkZidIntegrationCard();
        login.logout();
    }
    @Test
    public void TC_27validateSallaCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        salla.checkSallaCard();
        login.logout();
    }
    @Test
    public void TC_28validateSallaIntegrationModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        salla.checkSallaCard();
        salla.checkSallaModal();
        login.logout();
    }
    @Test
    public void TC_29validateShopifyCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        shopify.checkShopifyCardIntoEcommerceScreen();
        login.logout();
    }
    @Test
    public void TC_30validateShopifyIntegrationModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        shopify.checkShopifyCardIntoEcommerceScreen();
        shopify.checkShopifyIntegrationCard();
        login.logout();
    }
    @Test
    public void TC_31validateWooCommerceCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        woo.checkWooCommerceCardIntoECommerce();
        login.logout();
    }
    @Test
    public void TC_32validateWooCommerceIntegrationModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        woo.checkWooCommerceCardIntoECommerce();
        woo.checkWooCommerceIntegrationCard();
        login.logout();
    }
    @Test
    public void TC_33validateWooCommerceCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        fooder.checkFooderCardIntoECommerce();
        login.logout();
    }
    @Test
    public void TC_34validateWooCommerceIntegrationModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        fooder.checkFooderCardIntoECommerce();
        fooder.checkFooderInstallCard();
        login.logout();
    }
    @Test
    public void TC_35validateZidCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        zid.checkZidIntegrationCard();
        login.logout();
    }
    @Test
    public void TC_36validateZidInstallAndCancelProcess() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        zid.checkZidInstallationFunctionality(zidEmail,zidPassword,false);
        login.logout();
    }
    @Test
    public void TC_37validateZidInstallAndCompleteProcess() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        zid.checkZidInstallationFunctionality(zidEmail,zidPassword,true);
        login.logout();
    }
    @Test
    public void TC_38validateZidUnInstallation() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        zid.checkZidUnInstallation(zidEmail,zidPassword);
        login.logout();
    }

}
