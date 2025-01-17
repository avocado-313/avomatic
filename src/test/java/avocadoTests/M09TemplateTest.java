package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P09BroadCast;
import avocado.P10Template;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M09TemplateTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P09BroadCast broadcast;
    P10Template template;


    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        broadcast = new P09BroadCast(driver);
        template = new P10Template(driver);
    }
    @Test
    public void TC_01ValidateTemplateScreen() throws InterruptedException {
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();
        template.validateCreateTemplateScreen();
        template.validateCreateNewTemplate();
        login.logout();
    }
    @Test
    public void TC_02ValidateMediaandVariableTemplateCreation() throws InterruptedException {
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();
        template.validateCreateTemplateScreen();
        template.validateMediaAndVariableTemplate();
        login.logout();

    }
    @Test
    public void TC_03ValidateQuickReplyTemplateCreation() throws InterruptedException {
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();
        template.validateCreateTemplateScreen();
        template.validateQuickReplyButtonTemplate();
        login.logout();


    }
    @Test
    public void TC_04ValidateCTATemplateCreation() throws InterruptedException {
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();
        template.validateCreateTemplateScreen();
        template.validateCTATemplate();
        login.logout();


    }
    @Test
    public void TC_05ValidateAddLangCreation() throws InterruptedException {
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();

        template.validateAddLangTemplate();
        login.logout();


    }
    @Test
    public void TC_06ValidateDuplicateTemplateCreation() throws InterruptedException {
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();
        template.duplicateTemplateCreation();
        login.logout();
    }

    @Test
    public void TC_07ValidateTemplateDeletion() throws InterruptedException {
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        template.validateTemplateScreen();
        template.validateDeleteTemplate();
        login.logout();
    }


}
