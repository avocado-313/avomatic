package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P06AvocadoSearch;
import avocado.P07AvocadoMedia;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.password;
import static Base.ReadProperties.username;

public class M06MediaTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P06AvocadoSearch search;
    P07AvocadoMedia media;

    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        search = new P06AvocadoSearch(driver);
        media = new P07AvocadoMedia(driver);
    }
    @Test
    public void TC_01ValidateMediaScreen() {
        login.loginToAvocado(username, password);
        home.checkHomeScreen();
        media.validateUploadMediaFunctionality();
        media.validateMediaAcceptsLessThan10MbFiles();
        media.validateNavigateBackFromMediaToApps();
    }
}
