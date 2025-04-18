package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P31AvocadoSignUp;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class M33AvocadoSignupTest extends BaseTest {
    P01AvocadoLogin login;
    P31AvocadoSignUp signUp;
    P02AvocadoHomeScreen home;

    @BeforeClass
    public void initObjects(){
        login = new P01AvocadoLogin(driver);
        signUp = new P31AvocadoSignUp(driver);
    }
    @Test
    public void TC_001ValidateRegisterScreenElements() throws InterruptedException {
        signUp.validateRegisterScreen();
    }

    @Test
    public void TC_002ValidateRegisterNewAccount() throws InterruptedException {
        signUp.registerAccount_withoutVerification("tech@123", "8874023329");
        login.logout();
    }

    @Test
    public void TC_003ValidateRegisterVerificationMail(){
        signUp.registerAccount_withVerifyNow("12345678", "8874023329");
    }

}
