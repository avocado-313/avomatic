package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P02AvocadoHomeScreen extends PageBase {
    public P02AvocadoHomeScreen(WebDriver driver) {
        super(driver);
    }
    private final By analytics_icon_from_menu = By.xpath("//a[@aria-label='Analytics']");
    private final By search_icon_from_menu = By.xpath("//button[@aria-label='Search']");
    private final By chat_icon_from_menu = By.xpath("//a[@aria-label='Chat']");
    private final By media_icon_from_label = By.xpath("//a[@aria-label='Media Library']");
    private final By contact_icon_from_label = By.xpath("//a[@aria-label='Contacts']");
    private final By contains_icon_from_label = By.xpath("//*[@aria-label='E-commerce Apps']");
    private final By broadcast_icon_from_menu = By.xpath("//a[@aria-label='Broadcast']");
    private final By settings_icon_from_menu = By.xpath("//a[@aria-label='Settings']");
    private final By subscription_billing_icon_from_menu = By.xpath("//button[@value='Billing']//*[name()='svg']");
    private final By language_icon_from_menu = By.xpath("//*[@aria-label='English Language']");
//    private final By notification_icon_from_menu = By.xpath("//a[@aria-label='Notifications']//*[name()='svg']");
    private final By account_icon_from_menu = By.xpath("//button[@aria-label='Profile']");
    private final By apps_from_menu = By.xpath("//a[@aria-label='Apps']");
    private final By new_chat = By.xpath("//button[normalize-space()='+ New Chat']");
    private final By search_title = By.xpath("(//h5[normalize-space()='Search'])[1]");
    private final By media_library_title = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-1hxh1sq'])[1]");
    private final By create_contact_CTA = By.xpath("//button[normalize-space()='Create Contact']");
    private final By apps_title = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-1hxh1sq'])[1]");

    public void checkHomeScreen(){
        ElementsValidator(analytics_icon_from_menu,search_icon_from_menu,chat_icon_from_menu,media_icon_from_label,contact_icon_from_label,broadcast_icon_from_menu
        ,contains_icon_from_label,settings_icon_from_menu,subscription_billing_icon_from_menu,language_icon_from_menu,account_icon_from_menu);
    }
    private void clickAndValidate(By by1, By by2){
        clickOnElement(by1);
        waitForVisibilityOfElement(by2);
        Assert.assertTrue(assertElementDisplayed(by2));
    }
    public void checkEachMenuIconNavigation(){
        clickAndValidate(chat_icon_from_menu,new_chat);
        clickAndValidate(search_icon_from_menu,search_title);
        clickAndValidate(media_icon_from_label,media_library_title);
        clickAndValidate(contact_icon_from_label,create_contact_CTA);
        clickAndValidate(apps_from_menu,apps_title);
    }
}
