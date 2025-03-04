package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P30WhatsappWidget;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Base.ReadProperties.*;

public class M30WhatsappWidgetTest extends BaseTest {
    P01AvocadoLogin login;
    P02AvocadoHomeScreen home;
    P30WhatsappWidget whatsapp;

    @BeforeClass
    public void initObject(){
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        whatsapp = new P30WhatsappWidget(driver);
    }

    @Test
    public void TC_01validateWhatsappWidgetFromApp() {
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        whatsapp.checkWhatsAppWidgetFromApps();
        login.logout();
    }
    @Test
    public void TC_02validateWhatsappWidgetScreenElements() throws InterruptedException {
        login.loginToAvocado(username2, password2, Workspace2);
        home.checkHomeScreen();
        whatsapp.navigateToWhatsAppWidget();
        whatsapp.checkWhatsAppWidgetScreen();
    }

}
