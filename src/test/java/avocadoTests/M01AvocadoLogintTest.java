package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M01AvocadoLogintTest extends BaseTest {
    P01AvocadoLogin login ;
    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
    }
    @Test
    public void TC_01ValidateLoginToAvocado(){
       login.validateLoginScreenLocators(username,password,Workspace);
       login.logout();
    }
}
