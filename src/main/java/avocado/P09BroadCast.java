package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class P09BroadCast extends PageBase {
    public P09BroadCast(WebDriver driver) {
        super(driver);
    }
    private final By broad_Cast_title = By.xpath("//*[@data-testid='title']");
    private final By broad_cast_title_description = By.xpath("//*[@data-testid='description']");
    private final By new_broadcast_CTA = By.xpath("//button[normalize-space()='New Broadcast']");
    private final By broadcast_from_apps = By.xpath("//*[normalize-space()='Broadcast']");
    private final By back_arrow_into_broadcast = By.xpath("//*[@data-testid='ArrowBackIosNewRoundedIcon']");
    private final By select_a_status = By.xpath("//*[@placeholder='Select a Status']");
    private final By select_by_date = By.xpath("//*[@data-testid='date-range-last-activity']");
    private final By search_input_field = By.xpath("//input[@placeholder='Search']");
    private final By searchByTemplate_input_field = By.xpath("//input[@placeholder='Search by template id']");
    private final By grid_view = By.xpath("//*[@data-testid='GridViewOutlinedIcon']");
    private final By list_view = By.xpath("//*[@data-testid='FormatListBulletedRoundedIcon']");
    private final By apps_from_menu = By.xpath("//a[@aria-label='Apps']//*[name()='svg']");
    private final By greeting_and_away = By.xpath("//p[normalize-space()='Greetings & Away']");
    private final By broadcast_icon = By.xpath("//*[@data-testid='PodcastsIcon']");
    private final By broadCast_description_from_apps = By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-1ezpj7n'])[1]");
    private final By create_broadcast_title = By.xpath("//*[@data-testid='title']");
    private final By create_broadcast_description = By.xpath("//*[@data-testid='description']");
    private final By create_broadcast_broadcast_details= By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-4788qd'])[1]");
    private final By create_broadcast_broadcast_details_description = By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-1e17j98'])[1]");
    private final By create_broadcast_recipient_selection = By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-4788qd'])[2]");
    private final By create_broadcast_recipient_selection_description = By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-1e17j98'])[2]");
    private final By create_broadcast_schedule_or_send_broadcast = By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-4788qd'])[3]");
    private final By create_broadcast_schedule_or_send_broadcast_description = By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-1e17j98'])[3]");
    private final By broadcast_name_input = By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq']");
    private final By select_language_input = By.xpath("//input[@value='English (UK)']");
    private final By prepare_broadcast_as_draft = By.xpath("//*[@data-testid='type-outer-container']");
    private final By prepare_broadcast_As_draft_checkbox = By.xpath("//*[@type='checkbox']");
    private final By select_template_label = By.xpath("//*[@data-testid='templates-label']");
    private final By search_by_template_input_field = By.xpath("//input[@placeholder='Search by template id']");
    private final By search_icon = By.xpath("//*[@data-testid='SearchIcon']");
    private final By next_CTA = By.xpath("//*[normalize-space()='Next']");
    private final By dropdownArrow2 = By.xpath("(//*[@data-testid='ExpandMoreIcon'])[2]");
    private final By dropdownArrow3 = By.xpath("(//*[@data-testid='ExpandMoreIcon'])[3]");
    private final By testQuick_template = By.xpath("//*[@data-testid='image-container']");


    public void validateBroadCastFromApps(){
        clickOnElement(apps_from_menu);
        waitForVisibilityOfElement(greeting_and_away);
        scrollToElement(broadcast_icon);
        Assert.assertTrue(driver.findElement(broadcast_from_apps).getText().contains("Broadcast"));
        Assert.assertTrue(driver.findElement(broadCast_description_from_apps).getText().contains("Use WhatsApp broadcasts to message multiple contacts together – for transactional or marketing messages."));

    }

    public void navigateToBroadcastFromApps(){
        clickOnElement(broadcast_from_apps);
        waitForTime(6000);
        waitForVisibilityOfElement(broad_Cast_title);
    }
    public void checkBroadCastScreen(){
        Assert.assertTrue(assertElementDisplayed(back_arrow_into_broadcast));
        Assert.assertTrue(driver.findElement(broad_Cast_title).getText().contains("Broadcast"));
        Assert.assertTrue(driver.findElement(broad_cast_title_description).getText().contains("Send a WhatsApp template message to all or part of your contact list at once"));
        waitForVisibilityOfElement(new_broadcast_CTA);
//        Assert.assertTrue(driver.findElements(new_broadcast_CTA).size() > 1);
        scrollToElement(select_by_date);
        Assert.assertTrue(driver.findElement(select_by_date).getText().contains("Select by Date"));
        ElementsValidator(select_a_status,search_input_field,grid_view,grid_view,list_view);

    }
    public void checkNavigateBackIntoBroadcastScreen(){
        clickOnElement(back_arrow_into_broadcast);
        Assert.assertTrue(assertElementDisplayed(broadcast_from_apps));
    }
    private void validateLocatorsWIthTexts(By by , String text){
            scrollToElement(by);
            System.out.println(by + "======> " + driver.findElement(by).getText());
            Assert.assertTrue(assertElementDisplayed(by));
            Assert.assertTrue(driver.findElement(by).getText().contains(text));

    }
    public void checkCreateBroadcastScreen(){
        clickOnElement(new_broadcast_CTA);
        waitForTime(9000);
        waitForVisibilityOfElement(create_broadcast_title);
        validateLocatorsWIthTexts(create_broadcast_title,"Create Broadcast");
        validateLocatorsWIthTexts(create_broadcast_description,"Create new broadcast to start using it");
        validateLocatorsWIthTexts(create_broadcast_broadcast_details,"Broadcast Details");
        validateLocatorsWIthTexts(create_broadcast_broadcast_details_description,"Name your broadcast and select the language and template.");
        scrollToElement(broadcast_name_input);
        Assert.assertTrue(driver.findElement(broadcast_name_input).getAttribute("value").contains("broadcast_"));
        scrollToElement(select_language_input);
        Assert.assertTrue(driver.findElement(select_language_input).getAttribute("value").contains("English (UK)"));
        scrollToElement(prepare_broadcast_As_draft_checkbox);
        validateLocatorsWIthTexts(prepare_broadcast_as_draft,"Prepare broadcast as draft?");
        scrollToElement(search_by_template_input_field);
        Assert.assertTrue(driver.findElement(search_by_template_input_field).getAttribute("placeholder").contains("Search by template id"));
        Assert.assertTrue(assertElementDisplayed(search_icon));
        scrollToElement(select_template_label);
        validateLocatorsWIthTexts(select_template_label,"Select Template");
        scrollToElement(next_CTA);
        Assert.assertTrue(assertElementDisplayed(next_CTA));
        validateLocatorsWIthTexts(create_broadcast_recipient_selection,"Recipient Selection");
        validateLocatorsWIthTexts(create_broadcast_recipient_selection_description,"Select your broadcast targets here");
        Assert.assertTrue(assertElementDisplayed(dropdownArrow2));
        validateLocatorsWIthTexts(create_broadcast_schedule_or_send_broadcast,"Schedule or Send Broadcast");
        validateLocatorsWIthTexts(create_broadcast_schedule_or_send_broadcast_description,"Send your broadcast or schedule it here");
        Assert.assertTrue(assertElementDisplayed(dropdownArrow3));
    }
    public void selectTemplate(){
        scrollToElement(searchByTemplate_input_field);
        sendTextToInputField("test_quick" , searchByTemplate_input_field);
        waitForTime(5000);
        scrollToElement(testQuick_template);
        clickOnElement(testQuick_template);
        scrollToElement(next_CTA);
        clickOnElement(next_CTA);
    }
    private final By recipient_selection_title = By.xpath("//*[normalize-space()='Recipient Selection']");
    private final By select_target_here = By.xpath("//*[normalize-space()='Select your broadcast targets here']");
    private final By reset_target_CTA = By.xpath("//button[normalize-space()='Reset Targets']");
    private final By all_contact_option = By.xpath("//*[normalize-space()='All Contacts']");
    private final By contacts_option = By.xpath("(//button[normalize-space()='Contacts'])[1]");
    private final By Last_assigned_to_agent_option = By.xpath("//button[normalize-space()='Last Assigned to Agent']");
    private final By Customer_created_option = By.xpath("//button[normalize-space()='Customer Created']");
    private final By All_closed_chats_option = By.xpath("//*[normalize-space()='All Closed Chats']");
    private final By Tags_option = By.xpath("(//button[normalize-space()='Tags'])[1]");
    private final By Last_assigned_to_teams_option = By.xpath("//button[normalize-space()='Last Assigned to Teams']");
    private final By Country_option = By.xpath("//button[normalize-space()='Country']");
    private final By All_unread_chats_option = By.xpath("//*[normalize-space()='All Unread Chats']");
    private final By Custom_fields_option = By.xpath("//button[normalize-space()='Custom Fields']");
    private final By Last_activity_option = By.xpath("//button[normalize-space()='Last Activity']");
    private final By whatsapp_title = By.xpath("//*[normalize-space()='WhatsApp']");
    private final By Filter_opted_out_option = By.xpath("//button[normalize-space()='Filter Opted Out']");
    private final By Select_do_not_target_option = By.xpath("//*[normalize-space()='Select Do Not Target']");
    private final By Tags_not_target_option = By.xpath("(//button[normalize-space()='Tags'])[2]");
    private final By contacts_not_target_option = By.xpath("(//button[normalize-space()='Contacts'])[2]");
    private final By add_rounded_icon = By.xpath("//*[@data-testid='AddRoundedIcon']");
    private final By select_contacts_Screen_title = By.xpath("(//*[normalize-space()='Select Contacts'])[2]");
    private final By Template_variables = By.xpath("(//*[normalize-space()='Template Variables'])[2]");
    private final By upload_image_CTA = By.xpath("//button[normalize-space()='Upload image']");
    private final By first_image = By.xpath("//*[@aria-label='kingston-negroni-720x720-primary1-ef87562fea8240de92dd09c36457a8c2.webp']");
    private final By select_image = By.xpath("//button[normalize-space()='Select']");
    private final By X_Close = By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-dflwta' and @type='button'])[7]");
    private final By select_agent = By.xpath("(//*[normalize-space()='Select Agent'])[2]");
    private final By search_on = By.xpath("//*[@placeholder='Search']");
    private final By select_tags = By.xpath("(//*[normalize-space()='Select Tags'])[2]");
    private void uploadImage(){
        scrollToElement(Template_variables);
        scrollToElement(upload_image_CTA);
        clickOnElement(upload_image_CTA);
        clickOnElement(first_image);
        scrollToElement(select_image);
        clickOnElement(select_image);
    }
    private void validateRecipientScreen(){
        waitForVisibilityOfElement(recipient_selection_title);
        ElementsValidator(select_target_here,reset_target_CTA,all_contact_option,contacts_option,Last_assigned_to_agent_option,
                Customer_created_option,All_closed_chats_option,Tags_option,Last_assigned_to_teams_option,Country_option,
                All_unread_chats_option,Custom_fields_option,Last_activity_option,whatsapp_title,Filter_opted_out_option,
                Select_do_not_target_option,Tags_not_target_option,contacts_not_target_option);
    }
    private void selectContact(String contact){
        scrollToElement(contacts_option);
        WebElement add_sign_of_contacts = driver.findElement(contacts_option).findElement(By.xpath("..")).findElement(add_rounded_icon);
        add_sign_of_contacts.click();
        waitForVisibilityOfElement(select_contacts_Screen_title);
        sendTextToInputField(contact,By.xpath("//input[@placeholder='Search']"));
        waitForVisibilityOfElement(By.xpath("//*[normalize-space()='" + contact + "']"));
        clickOnElement(By.xpath("//*[normalize-space()='" + contact + "']"));
        clickOnElement(By.xpath("//button[normalize-space()='Add to Filters']"));
    }
    private void validateLastAgent(){
        scrollToElement(Last_assigned_to_agent_option);
        WebElement add_assigned_to_agent_option = driver.findElement(By.xpath("(//*[@data-testid='AddRoundedIcon'])[2]"));
        add_assigned_to_agent_option.click();
        waitForVisibilityOfElement(X_Close);
        Assert.assertTrue(assertElementDisplayed(search_on));
        Assert.assertTrue(assertElementDisplayed(select_agent));
        clickOnElement(X_Close);
    }
    private void validateTags(){
        scrollToElement(Tags_option);
        WebElement add_tags = driver.findElement(By.xpath("(//*[@data-testid='AddRoundedIcon'])[3]"));
        add_tags.click();
        waitForVisibilityOfElement(X_Close);
        Assert.assertTrue(assertElementDisplayed(search_on));
        Assert.assertTrue(assertElementDisplayed(select_tags));
        clickOnElement(X_Close);
    }
    public void completeRecipientScreen(String contact){
        validateRecipientScreen();
        validateLastAgent();
        validateTags();
        selectContact(contact);
        uploadImage();
        scrollToElement(next_CTA);
        clickOnElement(By.xpath("//button[normalize-space()='Next']"));
        scrollToElement(By.xpath("//*[normalize-space()='Send Now']"));
        clickOnElement(By.xpath("//*[normalize-space()='Send Now']"));
        waitForVisibilityOfElement(By.xpath("//*[normalize-space()='Continue']"));
        clickOnElement(By.xpath("//*[normalize-space()='Continue']"));
    }
}
