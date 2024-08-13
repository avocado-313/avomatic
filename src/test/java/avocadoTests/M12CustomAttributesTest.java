package avocadoTests;

import Base.BaseTest;
import avocado.P013CustomAttributes;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P12RulesPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M12CustomAttributesTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P013CustomAttributes custom;


    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        custom = new P013CustomAttributes(driver);
    }
    @Test
    public void TC_01validateCustomAttributesFromApp() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        custom.checkCustomAttributesFromApps();
    }
    @Test
    public void TC_02validateCustomAttributesScreenElements() {
        custom.navigateToCustomAttributes();
        custom.checkCustomAttributesScreen();
    }
    @Test
    public void TC_03validateCustomAttributesScreenTemplate() {
        custom.validateCreateCustomAttributeTemplate();
    }
    @Test
    public void TC_04validateCustomAttributesCreation() {
        custom.fillCreateCustomAttributesTemplate();
    }
    @Test
    public void TC_05validateDeleteCustomAttributes() {
        custom.deleteCustomAttributes();
    }
}
