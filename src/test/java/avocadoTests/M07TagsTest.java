package avocadoTests;

import Base.BaseTest;
import avocado.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.password;
import static Base.ReadProperties.username;

public class M07TagsTest extends BaseTest {
    P01AvocadoLogin login ;
    P02AvocadoHomeScreen home;
    P06AvocadoSearch search;
    P07AvocadoMedia media;
    P08AvocadoTags tags;

    @BeforeClass
    public void initiateObjects(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        search = new P06AvocadoSearch(driver);
        media = new P07AvocadoMedia(driver);
        tags = new P08AvocadoTags(driver);
    }
    @Test
    public void TC_01ValidateTagsScreen() {
        login.loginToAvocado(username, password);
        home.checkHomeScreen();
        tags.validateTagsScreen();
        tags.validateTagCreation();
        tags.validateDeleteTag();
    }

}
