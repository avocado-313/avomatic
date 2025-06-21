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


}
