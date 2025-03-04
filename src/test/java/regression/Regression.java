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
    P20Billing bill;
    P30WhatsappWidget whatsapp;
    P21Analytics analytics;
    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        signup = new P31AvocadoSignUp(driver);
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
        bill = new P20Billing(driver);
        whatsapp = new P30WhatsappWidget(driver);
        analytics = new P21Analytics(driver);

    }

    @Test
    public void TC_001ValidateLoginToAvocado(){
        login.validateLoginScreenLocators(username,password,Workspace);
        login.logout();
    }

    @Test
    public void TC_0001ValidateRegisterSetup()  {
        signup.validateRegisterScreen();
        signup.registerAccount("tech@123", "8874023329");
        login.logout();
    }
//    @Test
//    public void TC_002ValidateIconsOfHomeScreen(){
//        login.loginToAvocado(username,password,Workspace);
//        home.checkHomeScreen();
//        home.checkEachMenuIconNavigation();
//        login.logout();
//    }
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
        apps.validateAwayMessageComponent();
        apps.sendAwayMessage();
        login.logout();
    }
    @Test
    public void TC_005ValidateContacts() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        contacts.navigateAndValidateContactsScreen();
        login.logout();

    }
    @Test
    public void TC_006ValidateContactsCreation() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        contacts.createNewContact();
        contacts.validateChatScreen();
        login.logout();
    }
    @Test
    public void TC_007ValidateSearchScreen() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        search.validateSearchScreen();
        search.validateSearchXClose();
        search.validateSearchScreen();
        search.validateContactsTab();
        search.validateMessageTab();
        search.validateLastActivity();
        login.logout();
    }
//    @Test
//    public void TC_008ValidateMediaScreen() {
//        login.loginToAvocado(username, password,Workspace);
//        home.checkHomeScreen();
//        media.validateUploadMediaFunctionality();
//        media.validateMediaAcceptsLessThan10MbFiles();
//        media.validateNavigateBackFromMediaToApps();
//        login.logout();
//    }
    @Test
    public void TC_009ValidateTagsScreen() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        tags.validateTagsScreen();
        tags.validateTagCreation();
        tags.validateDeleteTag();
        login.logout();
    }
    @Test
    public void TC_010ValidateNavigateBackFromTags() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        tags.validateTagsFromApps();
        tags.checkNavigateBackFromTags();
        login.logout();
    }
    @Test
    public void TC_011ValidateBroadcastScreen() {
        login.loginToAvocado(username2,password2,Workspace2);
        broadcast.validateBroadCastFromApps();
        broadcast.navigateToBroadcastFromApps();
        broadcast.checkBroadCastScreen();
        login.logout();

    }
    @Test
    public void TC_012validateNavigateBAckFunctionalityIntoBroadcast(){
        login.loginToAvocado(username2,password2,Workspace2);
        broadcast.validateBroadCastFromApps();
        broadcast.navigateToBroadcastFromApps();
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
//        try {
//            broadcast.selectTemplate();
//        }catch (Exception e){
//            e.getStackTrace();
//        }
        broadcast.completeRecipientScreen(CONTACT);
        login.logout();
    }
    @Test
    public void TC_014ValidateTemplateScreen() throws InterruptedException {
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();
        template.validateCreateTemplateScreen();
        template.validateCreateNewTemplate();
        login.logout();

    }
    @Test
    public void TC_015ValidateQuickRepliesScreen() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        reply.validateQuickRepliesFromApps();
        reply.validateQuickRepliesScreen();
        reply.validateCreateNewQuickReplyTemplate();
        login.logout();

    }
    @Test
    public void TC_016validateRulesFromApp() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        login.logout();

    }
    @Test
    public void TC_017validateNavigationTRules() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        rule.navigateToRules();
        login.logout();

    }
    @Test
    public void TC_018validateCreateRuleScreen() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        rule.navigateToRules();
        rule.checkCreateRulesScreen();
        login.logout();

    }

    @Test
    public void TC_019validateCreateRuleModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        rule.navigateToRules();
        rule.checkCreateRulesScreen();
        rule.checkCreateRuleModalElements();
        login.logout();

    }
    @Test
    public void TC_020validateNewRuleCreation() {
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
    public void TC_021validateNewRuleCreation(){
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
    public void TC_022validateDeletionOfRule(){
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        rule.navigateToRules();
        rule.deleteRule();
        login.logout();
    }
    @Test
    public void TC_023validateCustomAttributesFromApp() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        custom.checkCustomAttributesFromApps();
    }
    @Test
    public void TC_024validateCustomAttributesScreenElements() {
        custom.navigateToCustomAttributes();
        custom.checkCustomAttributesScreen();
    }
    @Test
    public void TC_025validateCustomAttributesScreenTemplate() {
        custom.validateCreateCustomAttributeTemplate();
    }
    @Test
    public void TC_026validateCustomAttributesCreation() throws InterruptedException {
        custom.fillCreateCustomAttributesTemplate();
    }
    @Test
    public void TC_027validateDeleteCustomAttributes() {
        try {
            custom.deleteCustomAttributes();
        }catch (Exception e){
            e.getStackTrace();
        }

    }
    @Test
    public void TC_028validateEditAttributes() throws InterruptedException {
        custom.editAttribute();
    }
    @Test
    public void TC_029validateSearchAttribute() throws InterruptedException {
        custom.searchAttribute();
        login.logout();
    }
    @Test
    public void TC_28validateEcommerceScreen() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        login.logout();
    }
    @Test
    public void TC_29validateZidCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        zid.checkZidIntegrationCard();
        login.logout();
    }
    @Test
    public void TC_30validateSallaCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        salla.checkSallaCard();
        login.logout();
    }
    @Test
    public void TC_31validateSallaIntegrationModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        salla.checkSallaCard();
        salla.checkSallaModal();
        login.logout();
    }
    @Test
    public void TC_32validateShopifyCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        shopify.checkShopifyCardIntoEcommerceScreen();
        login.logout();
    }
    @Test
    public void TC_33validateShopifyIntegrationModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        shopify.checkShopifyCardIntoEcommerceScreen();
        shopify.checkShopifyIntegrationCard();
        login.logout();
    }
    @Test
    public void TC_34validateWooCommerceCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        woo.checkWooCommerceCardIntoECommerce();
        login.logout();
    }
    @Test
    public void TC_35validateWooCommerceIntegrationModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        woo.checkWooCommerceCardIntoECommerce();
        woo.checkWooCommerceIntegrationCard();
        login.logout();
    }
    @Test
    public void TC_36validateFooderCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        fooder.checkFooderCardIntoECommerce();
        login.logout();
    }
    @Test
    public void TC_37validateFooderIntegrationModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        fooder.checkFooderCardIntoECommerce();
        fooder.checkFooderInstallCard();
        login.logout();
    }
    @Test
    public void TC_38validateZidCard() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        zid.checkZidIntegrationCard();
        login.logout();
    }
    @Test
    public void TC_39validateZidInstallAndCancelProcess() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        zid.checkZidInstallationFunctionality(zidEmail,zidPassword,false);
        login.logout();
    }
    @Test
    public void TC_40validateZidInstallAndCompleteProcess() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        zid.checkZidInstallationFunctionality(zidEmail,zidPassword,true);
        login.logout();
    }
    @Test
    public void TC_41validateZidUnInstallation() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        commerce.checkECommerceScreen();
        zid.checkZidUnInstallation(zidEmail,zidPassword);
        login.logout();
    }
    @Test
    public void TC_01ValidateBillingScreen(){
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        bill.navigateAndValidateBillingScreen();
        login.logout();
    }
    @Test
    public void TC_02validateWhatsappWidgetScreenElements() throws InterruptedException {
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        whatsapp.navigateToWhatsAppWidget();
        whatsapp.checkWhatsAppWidgetScreen();
        login.logout();
    }
    @Test
    public void TC_42ValidateMediaandVariableTemplateCreation() throws InterruptedException {
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();
        template.validateCreateTemplateScreen();
        template.validateMediaAndVariableTemplate();
        login.logout();

    }
    @Test
    public void TC_43ValidateQuickReplyTemplateCreation() throws InterruptedException {
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();
        template.validateCreateTemplateScreen();
        template.validateQuickReplyButtonTemplate();
        login.logout();


    }
    @Test
    public void TC_44ValidateCTATemplateCreation() throws InterruptedException {
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();
        template.validateCreateTemplateScreen();
        template.validateCTATemplate();
        login.logout();


    }
    @Test
    public void TC_45ValidateAddLangCreation() throws InterruptedException {
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();

        template.validateAddLangTemplate();
        login.logout();


    }
    @Test
    public void TC_46ValidateDuplicateTemplateCreation() throws InterruptedException {
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();
        template.duplicateTemplateCreation();
        login.logout();
    }

    @Test
    public void TC_47ValidateTemplateDeletion() throws InterruptedException {
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();
        template.validateDeleteTemplate();
        login.logout();
    }

    @Test
    public void TC_48validateAnalyticsPageTitle() {
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsPageTitle();
        login.logout();
    }

    @Test
    public void TC_49validateAnalyticsPageTitleDesc(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsPageTitleDesc();
        login.logout();
    }

    @Test
    public void TC_50validateAnalyticsOverviewSection(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsOverviewSection();
        login.logout();
    }

    @Test
    public void TC_51validateAnalyticsAgentsSection(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsAgentSection();
        login.logout();
    }

    @Test
    public void TC_52validateAnalyticsAgentsDownloadReport(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsAgentDownloadReport();
        login.logout();
    }


    @Test
    public void TC_53validateAnalyticsTeamsSection(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsTeamsSection();
        login.logout();
    }

    @Test
    public void TC_54validateAnalyticsTeamsDownloadReport(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsTeamDownloadReport();
        login.logout();
    }


    @Test
    public void TC_55validateAnalyticsConversationSection(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsConversationSection();
        login.logout();
    }

    @Test
    public void TC_56validateAnalyticsConversationDownloadReport(){
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        analytics.checkAnalyticsConversationDownloadReport();
        login.logout();
    }

}
