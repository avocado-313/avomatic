package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P03AvocadoWorkSpace;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M02WorkspceTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P03AvocadoWorkSpace workspace;
    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        workspace = new P03AvocadoWorkSpace(driver);
    }
    @Test
    public void TC_01ValidateWorkspace(){
        login.loginToAvocado(username,password,Workspace);
        home.checkHomeScreen();
        workspace.navigateToProfileWorkspace();
        workspace.validateWorkspaceElements();
        workspace.validateChangePassword();
        workspace.checkWorkSpaceProfile();
    }
}
