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
    P08AvocadoTags tags;
    P09BroadCast broadcast;
    P10Template template;
    P11QuickReplies reply;

    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        signup = new P31AvocadoSignUp(driver);
        home = new P02AvocadoHomeScreen(driver);
        workSpace = new P03AvocadoWorkSpace(driver);
        contacts = new P04AvocadoContacts(driver);
        tags = new P08AvocadoTags(driver);
        broadcast = new P09BroadCast(driver);
        template = new P10Template(driver);
        reply = new P11QuickReplies(driver);

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
    
    @Test
    public void TC_011ValidateBroadcastScreen()throws InterruptedException  {
        login.loginToAvocado(username2,password2,Workspace2);
        broadcast.validateBroadCastFromApps();
        broadcast.navigateToBroadcastFromApps();
        broadcast.checkBroadCastScreen();
        login.logout();

    }
    @Test
    public void TC_012validateNavigateBAckFunctionalityIntoBroadcast()throws InterruptedException {
        login.loginToAvocado(username2,password2,Workspace2);
        broadcast.validateBroadCastFromApps();
        broadcast.navigateToBroadcastFromApps();
        broadcast.checkNavigateBackIntoBroadcastScreen();
        login.logout();
    }
    @Test
    public void TC_013validateCreateBroadCastScreen()throws InterruptedException {
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
    public void TC_015ValidateQuickRepliesScreen()throws InterruptedException  {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        reply.validateQuickRepliesFromApps();
        reply.validateQuickRepliesScreen();
        reply.validateCreateNewQuickReplyTemplate();
        login.logout();

    }


}
