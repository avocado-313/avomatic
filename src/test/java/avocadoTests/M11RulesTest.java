package avocadoTests;

import Base.BaseTest;
import avocado.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M11RulesTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P12RulesPage rule;


    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        rule = new P12RulesPage(driver);

    }
    @Test
    public void TC_01validateRulesFromApp() {
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        login.logout();

    }
    @Test
    public void TC_02validateNavigationTRules() {
        login.loginToAvocado(username2, password2,Workspace2);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        rule.navigateToRules();
        login.logout();

    }
    @Test
    public void TC_03validateCreateRuleScreen() {
        login.loginToAvocado(username, password,Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        rule.navigateToRules();
        rule.checkCreateRulesScreen();
        login.logout();

    }
    @Test
    public void TC_04validateCreateRuleModal() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        rule.navigateToRules();
        rule.checkCreateRulesScreen();
        rule.checkCreateRuleModalElements();
        login.logout();

    }
    @Test
    public void TC_05validateNewRuleCreation() {
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        rule.checkRulesFromApp();
        rule.navigateToRules();
        rule.checkCreateRulesScreen();
        rule.checkCreateRuleModalElements();
        rule.createNewRule();
        rule.newRuleCreation("view5");
        rule.deleteRule();

    }
}
