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
    P22AppsCallReport appsCallReport;
    P23AppsRoboCalling appsRoboCalling;
    P24WebPhone webPhone;

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
        appsCallReport = new P22AppsCallReport(driver);
        appsRoboCalling = new P23AppsRoboCalling(driver);
        webPhone = new P24WebPhone(driver);


    }

    @Test
    public void TC_001ValidateLoginToAvocado(){
        login.validateLoginScreenLocators(username,password,Workspace);
        login.logout();
    }

    @Test
    public void TC_0001ValidateRegisterSetup() throws InterruptedException {
        signup.validateRegisterScreen();
    }

    @Test
    public void TC_0002ValidateRegisterWithoutVerify() throws InterruptedException {
        signup.registerAccount_withoutVerification("tech@123", "8874023329");
        login.logout();

    }

    @Test
    public void TC_0003ValidateRegisterWithVerification(){
        signup.registerAccount_withVerifyNow("12345678", "8874023329");
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
    public void TC_005ValidateContacts() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        contacts.navigateAndValidateContactsScreen();
        contacts.validateCreateContactCard();
        login.logout();
    }
    @Test
    public void TC_006ValidateContactsCreation() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        contacts.validateAndCreateNewContact();
        login.logout();
    }



}
