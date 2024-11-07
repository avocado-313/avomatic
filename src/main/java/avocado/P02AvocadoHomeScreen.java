package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.testng.Assert;


public class P02AvocadoHomeScreen extends PageBase {
    public P02AvocadoHomeScreen(WebDriver driver) {
        super(driver);
    }

    private final By home_analytics_icon = By.xpath("//a[@aria-label='Analytics']");
    private final By home_search_icon =  By.xpath("//div[@aria-label='Search']");
    private final By home_chat_icon = By.xpath("//a[@aria-label='Chat']");
    private final By home_conatct_icon = By.xpath("//a[@aria-label='Contacts']");
    private final By home_media_library_icon = By.xpath("//a[@aria-label='Media Library']");
    private final By home_broadcast_icon = By.xpath("//a[@aria-label='Broadcast']");
    private final By home_ecommerce_icon = By.xpath("//a[@aria-label='E-commerce Apps']");
    private final By home_apps_icon = By.xpath("//a[@aria-label='Apps']//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]");
    private final By home_settings_icon = By.xpath("//a[@aria-label='Settings']");
    private final By home_help_icon = By.xpath("//button[@aria-label='Help Center']");
    private final By home_billing_icon = By.xpath("//a[@aria-label='Billing']");
    private final By home_lang_icon = By.xpath("//button[@aria-label='English Language']");
    private final By home_profile_icon = By.xpath("//button[@aria-label='Profile']");
    private final By new_chat = By.xpath("//button[normalize-space() ='+ New Chat']");
    private final By search_title = By.xpath("(//h5[normalize-space()='Search'])[1]");
    private final By media_library_title = By.xpath("//p[@class ='MuiTypography-root MuiTypography-body1 css-1hxh1sq']");
    private final By create_contact_CTA = By.xpath("//button[normalize-space()='Create Contact']");
    private final By apps_title = By.xpath("//p[normalize-space() = 'Apps']");






    public void checkHomeScreen(){
        ElementsValidator(home_analytics_icon,home_search_icon,home_chat_icon,home_conatct_icon,home_media_library_icon,home_broadcast_icon,home_ecommerce_icon,
                home_apps_icon,home_settings_icon,home_help_icon,home_billing_icon,home_lang_icon,home_profile_icon);
    }



    private void clickAndValidate(By by1, By by2){
        clickOnElement(by1);
        waitForVisibilityOfElement(by2);
        Assert.assertTrue(assertElementDisplayed(by2));
    }



    public void checkEachMenuIconNavigation(){
        clickAndValidate(home_chat_icon,new_chat);
        clickAndValidate(home_search_icon,search_title);
        clickAndValidate(home_media_library_icon,media_library_title);
        clickAndValidate(home_conatct_icon,create_contact_CTA);
        clickAndValidate(home_apps_icon, apps_title);
    }





}
