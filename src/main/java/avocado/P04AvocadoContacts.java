package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P04AvocadoContacts extends PageBase {
    public P04AvocadoContacts(WebDriver driver) {
        super(driver);
    }
    private final By create_contact_CTA = By.xpath("//button[normalize-space()='Create Contact']");
    private final By contact_icon_from_label = By.xpath("//a[@aria-label='Contacts']//*[name()='svg']");
    private final By contacts_title_from_contacts_screen = By.xpath("//h5[normalize-space()='Contacts']");
    private final By contacts_subTitle_from_contacts_screen = By .xpath("//p[normalize-space()='Create and Manage your contacts']");
    private final By bulk_action_CTA = By.xpath("//button[normalize-space()='Bulk Actions']");
    private final By create_new_contact_title = By.xpath("//p[normalize-space()='Create new contact']");
    private final By x_close_create_contact = By.xpath("//*[@data-testid='CloseIcon']");
    private final By contact_name_input = By.xpath("//*[@name='name']");
    private final By contact_phone_input = By.xpath("//*[@name='phoneNumber']");
    private final By contact_email_input = By.xpath("//*[@name='email']");
    private final By contact_whatsappChannel_input = By.xpath("//*[@name='channel']");
    private final By tags = By.xpath("//*[@aria-label='tags']");
    private final By save_CTA = By.xpath("//span[normalize-space()='Save']");
    private final By cancel_CTA = By.xpath("//button[normalize-space()='Cancel']");
    private final By upload_image_CTA = By.xpath("//button[normalize-space()='Upload image']");
    private final By image = By.xpath("//input[@name='image']");
    private final By edit_icon = By.xpath("(//button[@data-testid='edit-contacts-button'])[1]");
    private final By phone_error_message = By.xpath("//*[@data-testid='phone-error']");
    private final By contact_error_message = By.xpath("//*[@ data-testid='phone-error']");
    private final By karim_salem_chat = By.xpath("(//*[@data-testid='archive-send-contacts-button'])[1]");

    String currentDir = System.getProperty("user.dir");
    String file_path = currentDir + "//images//avocad0.jpg";
    public void navigateAndValidateContactsScreen(){
        clickOnElement(contact_icon_from_label);
        waitForVisibilityOfElement(create_contact_CTA);
        Assert.assertTrue(driver.findElement(contacts_title_from_contacts_screen).getText().contains("Contacts"));
        Assert.assertTrue(driver.findElement(contacts_subTitle_from_contacts_screen).getText().contains("Manage your contacts"));
        Assert.assertTrue(assertElementDisplayed(bulk_action_CTA));
    }
    public void validateCreateContactCard() throws InterruptedException {
        Thread.sleep(5000);
        clickOnElement(create_contact_CTA);
        waitForVisibilityOfElement(create_new_contact_title);
        ElementsValidator(x_close_create_contact,upload_image_CTA,contact_name_input,contact_phone_input,contact_email_input,contact_whatsappChannel_input,cancel_CTA);
    }
    public void createNewContact(){
        validateErrorScreens(contact_phone_input,contact_email_input,phone_error_message);
        validateErrorScreens(contact_name_input,contact_email_input,contact_error_message);
        driver.findElement(image).sendKeys(file_path);
        sendTextToInputField("name" + generateRandomDigits(5),contact_name_input);
        sendTextToInputField("test.automation"+generateRandomDigits(5)+"@gmail.com",contact_email_input);
        sendTextToInputField(generateRandomNumber(),contact_phone_input);
        clickOnElement(save_CTA);
        waitForVisibilityOfElement(edit_icon);
        try {
            clickOnElement(edit_icon);
        }catch (Exception e){
            waitForTime(10000);
            clickOnElement(edit_icon);
        }
        clickOnElement(archive);

    }
    public void validateAndCreateNewContact() throws InterruptedException {
        navigateAndValidateContactsScreen();
        validateCreateContactCard();
        validateErrorScreens(contact_phone_input,contact_email_input,phone_error_message);
        validateErrorScreens(contact_name_input,contact_email_input,contact_error_message);
        driver.findElement(image).sendKeys(file_path);
        sendTextToInputField("name" + generateRandomDigits(5),contact_name_input);
        sendTextToInputField("test.automation"+generateRandomDigits(5)+"@gmail.com",contact_email_input);
        sendTextToInputField(generateRandomNumber(),contact_phone_input);
        clickOnElement(save_CTA);
        // Edit test case will add later as a new because new changes appear in FE
//        waitForTime(5000);
//        waitForVisibilityOfElement(edit_icon);
//       Thread.sleep(10000);
//       clickOnElement(edit_icon);
//        clickOnElement(archive);
    }
    private final By archive = By.xpath("//button[normalize-space()='Archive Contact']");
    public void validateEmptyFields() throws InterruptedException {
        navigateAndValidateContactsScreen();
        validateCreateContactCard();
        validateErrorScreens(contact_phone_input,contact_email_input,phone_error_message);
        validateErrorScreens(contact_name_input,contact_email_input,contact_error_message);
        clickOnElement(cancel_CTA);
    }
    private void validateErrorScreens(By by , By by1 ,By by2){
        clickOnElement(by);
        clickOnElement(by1);
        Assert.assertTrue(assertElementDisplayed(by2));
        Assert.assertTrue(driver.findElement(by2).getText().contains("This field can't be empty"));
    }
    public void validateChatScreen() {
        try {
            waitForVisibilityOfElement(karim_salem_chat);
            try {
                clickOnElement(karim_salem_chat);
            } catch (Exception e) {
                waitForTime(12000);
                clickOnElement(karim_salem_chat);
            }
            waitForVisibilityOfElement(By.xpath("//button[normalize-space()='+ New Chat']"));
            Assert.assertTrue(assertElementDisplayed(By.xpath("//button[normalize-space()='+ New Chat']")));
        }catch (Exception e){
            e.getStackTrace();
        }
    }


    // Filters for Contact section

    private final By contacts_date_filter = By.xpath("(//*[@placeholder='Date Added'])[1]");
    private final By filter_search = By.xpath("(//button[normalize-space() = 'Search'])[1]");
    private final By filter_screen_validation = By.xpath("//div[@aria-hidden='false']//th[@class='MuiTableCell-root MuiTableCell-head MuiTableCell-alignLeft MuiTableCell-sizeMedium css-1mq4yx4'][normalize-space()='Users']");
    private final By contacts_tags_filter = By.xpath("//div[@aria-hidden='false']//button[@id='search-dropdown-button']");
    private final By contacts_tags_search = By.xpath("//input[@placeholder='Search Tags']");
    private final By tags_checkbox = By.xpath(" (//ul[@data-testid='all-tags-list']//span)[1]");
    private final By contact_channel_filter = By.xpath("(//input[@placeholder= 'Channel'])[1]");
    private final By contact_clear_filter_btn = By.xpath("(//button[normalize-space()='Clear Filter'])[1]");


    public void checkDateAddedFilter(){
        waitForVisibilityOfElement(contacts_date_filter);
        clickOnElement(contacts_date_filter);
        waitForTime(1000);
        driver.findElement(contacts_date_filter).sendKeys(Keys.ARROW_DOWN);
        waitForTime(1000);
        System.out.println("Down clicked");
        waitForVisibilityOfElement(filter_search);
        clickOnElement(filter_search);
        waitForVisibilityOfElement(filter_screen_validation);
        assertElementDisplayed(filter_screen_validation);
        Assert.assertTrue(driver.findElement(filter_screen_validation).getText().contains("Users"));
    }



    public void checkTagsFilter(){
        clickOnElement(contacts_tags_filter);
        waitForTime(1000);
        clickOnElement(contacts_tags_search);
        sendTextToInputField("Peace",contacts_tags_search);
        clickOnElement(tags_checkbox);
        clickOnElement(filter_search);
        assertElementDisplayed(filter_screen_validation);
        Assert.assertTrue(driver.findElement(filter_screen_validation).getText().contains("Users"));
    }

    public void checkChannelFilter(){
        clickOnElement(contact_channel_filter);
        waitForTime(1000);
        driver.findElement(contact_channel_filter).sendKeys(Keys.ARROW_DOWN);
        System.out.println("Down clicked");
        waitForVisibilityOfElement(filter_search);
        clickOnElement(filter_search);
        assertElementDisplayed(filter_screen_validation);
        Assert.assertTrue(driver.findElement(filter_screen_validation).getText().contains("Users"));
        clickOnElement(contact_clear_filter_btn);
    }



}
