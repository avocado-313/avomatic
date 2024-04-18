package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P04AvocadoContacts extends PageBase {
    public P04AvocadoContacts(WebDriver driver) {
        super(driver);
    }
    private final By create_contact_CTA = By.xpath("//button[normalize-space()='Create Contact']");
    private final By contact_icon_from_label = By.xpath("//a[@aria-label='Contacts']//*[name()='svg']");
    private final By contacts_title_from_contacts_screen = By.xpath("//h5[normalize-space()='Contacts']");
    private final By contacts_subTitle_from_contacts_screen = By .xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-1a4w3bo'])[1]");
    private final By bulk_action_CTA = By.xpath("//button[normalize-space()='Bulk Actions']");
    private final By create_new_contact_title = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-wtork8'])[1]");
    private final By x_close_create_contact = By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-o261au'])[1]");
    private final By contact_name_input = By.xpath("//*[@name='name']");
    private final By contact_phone_input = By.xpath("//*[@name='phoneNumber']");
    private final By contact_email_input = By.xpath("//*[@name='email']");
    private final By contact_whatsappChannel_input = By.xpath("//*[@name='channel']");
    private final By tags = By.xpath("//*[@aria-label='tags']");
    private final By save_CTA = By.xpath("//span[normalize-space()='Save']");
    private final By cancel_CTA = By.xpath("//button[normalize-space()='Cancel']");
    private final By upload_image_CTA = By.xpath("//button[normalize-space()='Upload image']");
    private final By image = By.xpath("//input[@name='image']");
    private final By edit_icon = By.xpath("(//*[@data-testid='EditIcon'])[1]");
    private final By phone_error_message = By.xpath("//*[@data-testid='phone-error']");
    private final By contact_error_message = By.xpath("//*[@ data-testid='phone-error']");
    private final By karim_salem_chat = By.xpath("(//tr[contains(., 'karim salem')]//*[@data-testid='archive-send-contacts-button'])[1]");

    String currentDir = System.getProperty("user.dir");
    String file_path = currentDir + "//images//avocad0.jpg";
    public void navigateAndValidateContactsScreen(){
        clickOnelement(contact_icon_from_label);
        waitForVisibilityOfElement(create_contact_CTA);
        Assert.assertTrue(driver.findElement(contacts_title_from_contacts_screen).getText().contains("Contacts"));
        Assert.assertTrue(driver.findElement(contacts_subTitle_from_contacts_screen).getText().contains("Manage your contacts"));
        Assert.assertTrue(assertElementDisplayed(bulk_action_CTA));
    }
    public void validateCreateContactCard(){
        clickOnelement(create_contact_CTA);
        waitForVisibilityOfElement(create_new_contact_title);
        ElementsValidator(x_close_create_contact,upload_image_CTA,contact_name_input,contact_phone_input,contact_email_input,contact_whatsappChannel_input,tags,cancel_CTA);
    }
    public void createNewContact(){
        validateErrorScreens(contact_phone_input,contact_email_input,phone_error_message);
        validateErrorScreens(contact_name_input,contact_email_input,contact_error_message);
        driver.findElement(image).sendKeys(file_path);
        sendTextToInputField("name" + generateRandomDigits(5),contact_name_input);
        sendTextToInputField("test.automation"+generateRandomDigits(5)+"@gmail.com",contact_email_input);
        sendTextToInputField(generateRandomNumber(),contact_phone_input);
        clickOnelement(save_CTA);
        waitForVisibilityOfElement(edit_icon);
        try {
            clickOnelement(edit_icon);
        }catch (Exception e){
            waitForTime(6000);
            clickOnelement(edit_icon);
        }
        clickOnelement(archive);

    }
    public void validateAndCreateNewContact(){
        navigateAndValidateContactsScreen();
        validateCreateContactCard();
        validateErrorScreens(contact_phone_input,contact_email_input,phone_error_message);
        validateErrorScreens(contact_name_input,contact_email_input,contact_error_message);
        driver.findElement(image).sendKeys(file_path);
        sendTextToInputField("name" + generateRandomDigits(5),contact_name_input);
        sendTextToInputField("test.automation"+generateRandomDigits(5)+"@gmail.com",contact_email_input);
        sendTextToInputField(generateRandomNumber(),contact_phone_input);
        clickOnelement(save_CTA);
        waitForVisibilityOfElement(edit_icon);
        try {
            clickOnelement(edit_icon);
        }catch (Exception e){
            waitForTime(6000);
            clickOnelement(edit_icon);
        }
        clickOnelement(archive);
    }
    private final By archive = By.xpath("//button[normalize-space()='Archive Contact']");
    public void validateEmptyFields(){
        navigateAndValidateContactsScreen();
        validateCreateContactCard();
        validateErrorScreens(contact_phone_input,contact_email_input,phone_error_message);
        validateErrorScreens(contact_name_input,contact_email_input,contact_error_message);
        clickOnelement(cancel_CTA);
    }
    private void validateErrorScreens(By by , By by1 ,By by2){
        clickOnelement(by);
        clickOnelement(by1);
        Assert.assertTrue(assertElementDisplayed(by2));
        Assert.assertTrue(driver.findElement(by2).getText().contains("This field can't be empty"));
    }
    public void validateChatScreen() {
        try {
            waitForVisibilityOfElement(karim_salem_chat);
            try {
                clickOnelement(karim_salem_chat);
            } catch (Exception e) {
                waitForTime(12000);
                clickOnelement(karim_salem_chat);
            }
            waitForVisibilityOfElement(By.xpath("//button[normalize-space()='+ New Chat']"));
            Assert.assertTrue(assertElementDisplayed(By.xpath("//button[normalize-space()='+ New Chat']")));
        }catch (Exception e){
            e.getStackTrace();
        }
    }

}
