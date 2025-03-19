package avocadoTests;

import Base.BaseTest;
import avocado.P01AvocadoLogin;
import avocado.P02AvocadoHomeScreen;
import avocado.P20Billing;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static Base.ReadProperties.*;


public class M19BillingTest extends BaseTest {
    P01AvocadoLogin login;
    P02AvocadoHomeScreen home;
    P20Billing bill;

    @BeforeClass
    public void initObjects() {
        login = new P01AvocadoLogin(driver);
        home = new P02AvocadoHomeScreen(driver);
        bill = new P20Billing(driver);
    }
    @Test(priority = 1)
    public void TC_01ValidateBillingCreen(){
        login.loginToAvocado(username, password, Workspace);
        home.checkHomeScreen();
        bill.navigateAndValidateBillingScreen();
        login.logout();
    }

    @Test(priority = 2)
    public void TC_02ValidateBillingDashboard() {
        login.loginToAvocado(username3, password3, Workspace3);
        home.checkHomeScreen();
        bill.navigateAndValidateBillingScreen();
        bill.testBillingDashboardVisibleAndClickable();
        login.logout();

    }

    @Test(priority = 3)
    public void TC_03ValidateInvoiceSearch() {
        login.loginToAvocado(username3, password3, Workspace3);
        home.checkHomeScreen();
        bill.navigateAndValidateBillingScreen();
        bill.validateInvoiceSearch();
        bill.validateInvoiceSort();
        login.logout();
    }


    @Test(priority = 4)
    public void TC_04ValidateInvoiceStatus() {
        login.loginToAvocado(username3, password3, Workspace3);
        home.checkHomeScreen();
        bill.navigateAndValidateBillingScreen();
        bill.validateInvoiceStatus();
        login.logout();

    }

    @Test(priority = 5)
    public void TC_05ValidateOnlinePayemnt() {
        login.loginToAvocado(username3, password3, Workspace3);
        home.checkHomeScreen();
        bill.navigateAndValidateBillingScreen();
        bill.checkdeleteicon();
        bill.onlinePaymentFlow();
        login.logout();

    }

    @Test(priority = 6)
    public void TC_06ValidateOnlinePayNow() {
        login.loginToAvocado(username3, password3, Workspace3);
        home.checkHomeScreen();
        bill.navigateAndValidateBillingScreen();
        bill.checkdeleteicon();
        bill.onlinePaymentPayNowflow();
        login.logout();
    }

    @Test(priority = 7)
    public void TC_07ValidatePayLater() {
        login.loginToAvocado(username3, password3, Workspace3);
        home.checkHomeScreen();
        bill.navigateAndValidateBillingScreen();
        bill.checkdeleteicon();
        bill.onlinePaymentPayLaterFlow();
        login.logout();
    }

    @Test(priority = 8,dependsOnMethods = "TC_07ValidatePayLater")
    public void TC_08ValidateDeletePayment() {
        login.loginToAvocado(username3, password3, Workspace3);
        home.checkHomeScreen();
        bill.navigateAndValidateBillingScreen();
        bill.deletePaymenticon();
        login.logout();

    }

    @Test(priority = 9)
    public void TC_09ValidateUsageReport() {
        login.loginToAvocado(username3, password3, Workspace3);
        home.checkHomeScreen();
        bill.navigateAndValidateBillingScreen();
        bill.checkUsageReport();
        bill.checkTopUPCard();
        bill.checkUsageCreditCard();
        login.logout();
    }

    @Test(priority = 10)
    public void TC_10ValidateNotificationSetting() {
        login.loginToAvocado(username3, password3, Workspace3);
        home.checkHomeScreen();
        bill.navigateAndValidateBillingScreen();
        bill.checkNotification("jogeswar.mahanta@twerlo.com");
        login.logout();
    }

    @Test(priority = 11)
    public void TC_11ValidateNotificationSettingEmpty() {
        login.loginToAvocado(username3, password3, Workspace3);
        home.checkHomeScreen();
        bill.navigateAndValidateBillingScreen();
        bill.checkNotificationEmpty();
        login.logout();
    }
}

