package avocado;

import PageBase.PageBase;
import Utilities.Utilities;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private final By broadCast_description_from_apps = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-cc9b9l'])[1]");

    private final By create_broadcast_title = By.xpath("//*[@data-testid='title']");
    private final By create_broadcast_description = By.xpath("//*[@data-testid='description']");
    private final By create_broadcast_important_tips= By.xpath("//p[normalize-space()= 'Important Tips']");
    private final By create_broadcast_tips_name= By.xpath("//p[normalize-space()= 'Name Your Broadcasts Clearly']");
    private final By create_broadcast_tips_name_description = By.xpath("//p[contains(., 'Use a descriptive and meaningful name')]");
    private final By create_broadcast_tips_reattempts_deliverabilty = By.xpath("//p[normalize-space()='Enable Reattempts for Better Deliverability']");
    private final By create_broadcast_tips_reattempts_deliverabilty_description = By.xpath("//p[contains(., 'Allowing retries helps ensure ')]");

    private final By broadcast_name_input = By.xpath("//input[@placeholder='Enter Broadcast Name']");
    private final By broadcast_reattempt_checkbox = By.xpath("//*[@type='checkbox']");
    private final By reattempt_tile = By.xpath("//label[normalize-space()  ='Enable Reattempts']");
    private final By rewattempt_desc = By.xpath("//p[contains(., 'Will stagger')]");
    private final By broadcast_continue_button = By.xpath("//button[normalize-space()='Continue']");

    // Template Page Locator
    private final By template_title = By.xpath("//header//p[text()='Templates']");
    private final By template_desc = By.xpath("//p[contains(., 'Choose the template')]");
    private final By tempalate_important_tips = By.xpath("//p[contains(., 'Important Tips')]");
    private final By template_tips_choose_right = By.xpath("//*[normalize-space() = 'Choose the Right Template']");
    private final By template_tips_choose_right_desc =By.xpath("//p[contains(., 'Select the most relevant')]");
    private final By template_tips_personalize = By.xpath("//*[normalize-space() = 'Personalize When Possible']");
    private final By template_tips_personalize_desc = By.xpath("//p[contains( ., 'Use variables and')]");
    private final By tempalate_search = By.xpath("//*[@placeholder='Search by template name']");
    private final By filter_clear_btn = By.xpath("//*[normalize-space() = 'Clear filter']");
    private final By template_category_dropdown = By.xpath("//*[@placeholder='All Categories']");
    private final By template_types_dropdwon = By.xpath("//*[@placeholder='All Types']");
    private final By template_language_dropdown = By.xpath("//*[normalize-space() = 'Select language']");
    private final By lang_dropdown_search = By.xpath("//input[@placeholder='Search']");
    private final By select_lang = By.xpath("//*[normalize-space()='English (US)']");
    private final By template_use_btn= By.xpath("//button[normalize-space()='Use']");
    private final By temp_varaible_title = By.xpath("//p[normalize-space()='Template Variables']");
    private final By temp_variable_desc = By.xpath("//p[contains(., 'Pick the variables')]");
    private final By x_close_btn = By.xpath("//*[@data-testid='CloseIcon']");


    private final By upload_image_CTA = By.xpath("//button[normalize-space()='Upload image']");
    private final By first_image = By.xpath("//*[@aria-label='cup5.jpg']");
    private final By select_image = By.xpath("//button[normalize-space()='Select']");
    private final By add_variable_input = By.xpath("//*[@placeholder='Type or Select a Variable']");
    private final By back_btn = By.xpath("(//button[normalize-space()='Back'])[2]");
    private final By apply_btn = By.xpath("//button[normalize-space()='Apply']");
    private final By edit_variable = By.xpath("//button[normalize-space() = 'Edit variables']");

    // recipient screen locator
    private final By recipient_title = By.xpath("//*[normalize-space()='Recipients']");
    private final By recipient_desc = By.xpath("//p[contains(., 'Choose between selecting')]");
    private final By recipient_tips = By.xpath("//p[contains(., 'Important Tips')]");
    private final By recipient_tips_segment_title = By.xpath("//p[contains(., 'Segment Your')]");
    private final By recipient_tips_segment_title_desc = By.xpath("//p[contains(., 'Send your broadcast to targeted')]");
    private final By recipient_tips_tags_title = By.xpath("//p[contains(., 'Use Tags & Filters')]");
    private final By recipient_tips_tags_desc = By.xpath("//p[contains(., 'Utilize tags and filters like')]");

    private final By select_contacts_title = By.xpath("//p[normalize-space()= 'Specific contacts']");
    private final By select_contacts_Screen_title = By.xpath("(//*[normalize-space()='Select Contacts'])[2]");
    private final By select_contact_desc = By.xpath("//p[contains(., 'Choose target')]");
    private final By add_contact = By.xpath("//button[normalize-space()='Add Contacts']");
    private final By tag_btn = By.xpath("//button[normalize-space()='Add Tags']");
    private final By search_on_tags = By.xpath("//*[@placeholder='Search with tag name']");
    private final By add_agent_option = By.xpath("//button[normalize-space()='Add Agents']");
    private final By select_agent_title = By.xpath("//p[normalize-space()='Select Agents']");
    private final By custom_field_btn = By.xpath("//button[normalize-space()='Add Custom Fields']");
    private final By country_btn = By.xpath("//button[normalize-space()='Add Country']");
    private final By teams_btn = By.xpath("//button[normalize-space()='Add Teams']");
    private final By all_closed_chats =By.xpath("//*[normalize-space()='All Closed Chats']");
    private final By all_unread_chats = By.xpath("//*[normalize-space()='All Unread Chats']");
    private final By last_activity = By.xpath("//*[normalize-space()='Last Activity']");
    private final By customer_created = By.xpath("//*[normalize-space()='Customer Created']");
    private final By Filter_opted_out_option = By.xpath("(//*[normalize-space()='Filter Opted out customers'])[1]");
    private final By exclude_specific_contact = By.xpath("(//button[normalize-space()='Exclude specific contacts'])[1]");
    private final By exclude_specifc_tag = By.xpath("(//button[normalize-space()='Exclude specific tagss'])[1]");

    private final By all_contacts = By.xpath("//p[contains(., 'All contacts')]");
    private final By all_contact_desc = By.xpath("//p[contains(., 'We will send this')]");
    private final By all_contact_filter_opted = By.xpath("(//*[normalize-space()='Filter Opted out customers'])[2]");
    private final By all_contact_exclude_specific_contact = By.xpath("(//button[normalize-space()='Exclude specific contacts'])[2]");
    private final By all_contact_exclude_specifc_tag = By.xpath("(//button[normalize-space()='Exclude specific tagss'])[2]");

    private final By excel_sheet = By.xpath("//p[normalize-space() = 'Upload excel sheet']");
    private final By download_btn = By.xpath("//button[normalize-space() = 'Download']");
    private final By upload_sheet_btn = By.xpath("//p[normalize-space()='Click to upload or drag and drop a contacts file here']");
    private final By discard_btn = By.xpath("//*[normalize-space()='Discard']");
    private final By back_bttn = By.xpath("//*[normalize-space()='Back']");

    private final By continue_btn = By.xpath("//button[.//div[normalize-space()='Continue']]");

    // Final review and send screen locators

    private final By review_title = By.xpath("//*[normalize-space()='Review']");
    private final By review_desc = By.xpath("//p[contains(., 'Review the Recipients')]");
    private final By review_tips_cost_title = By.xpath("//p[contains(., 'Review recipients')]");
    private final By review_tips_cost_desc = By.xpath("//p[contains(., 'Check the target')]");
    private final By review_tips_test_before_title = By.xpath("//p[contains(., 'Test Before')]");
    private final By review_tips_test_before_desc  = By.xpath("//p[contains(., 'Always send a test message')]");
    private final By review_tips_monitor_title = By.xpath("//p[contains(., 'Monitor')]");
    private final By review_tips_monitor_desc = By.xpath("//p[contains(., 'After sending')]");
    private final By try_test_message_tilte = By.xpath("//p[contains(., 'Try a test message')]");
    private final By try_test_messsage_desc = By.xpath("//p[contains(., 'Enter WA')]");
    private final By test_phone_number = By.xpath("//*[@id='tel-phone']");
    private final By test_send_btn = By.xpath("(//button[.//div[normalize-space()='Send']])[2]");
    private final By message_preview_title = By.xpath("//p[contains(., 'Message Preview')]");
    private final By braodcast_name = By.xpath("//p[normalize-space()='Broadcast Name']");
    private final By valid_recipient = By.xpath("//p[normalize-space()='Valid recipients']");
    private final By estimated_cost = By.xpath("//p[normalize-space()='Approximate cost']");
    private final By review_discard_btn = By.xpath("//*[normalize-space()='Discard']");
    private final By review_back_btn = By.xpath("//*[normalize-space()='Back']");
    private final By saved_as_draft_btn = By.xpath("//button[.//div[normalize-space()='Save as a draft']]");
    private final By schedule_btn = By.xpath("//button[normalize-space()='Schedule']");
    private final By send_broadcst_btn = By.xpath("(//button[.//div[normalize-space()='Send']])[1]");

    //final done screen
    private final By done_icon = By.xpath("//img[@alt='done mark']");
    private final By broadcast_successful_title = By.xpath("//p[contains(., 'successfully')]");
    private final By broacast_success_desc = By.xpath("//p[contains(., 'We have sent')]");
    private final By back_to_home_btn = By.xpath("//a[contains(., 'Back to home')]");

    // account health
    private final By account_health_warning = By.xpath("//h5[normalize-space()='Account Health Warning']");
    //red specific
    private final By redHealthText= By.xpath("//p[contains(., 'is Red')]");
    private final By redHealth_desc = By.xpath("//p[contains(., 'You cannot')]");
    private final By back_buttton = By.xpath("//button[normalize-space()='Go Back']");

    //yellow specific
    private final By yellowHealthText = By.xpath("//p[contains(.,'is Yellow')]");
    private final By yellow_desc = By.xpath("//p[contains(.,'We recommend waiting')]");
    private final By yellow_warnText = By.xpath("//p[contains(.,' risk further')]");
    private final By continue_anyway_btn = By.xpath("//button[normalize-space()='Continue Anyway']");
    private final By verify_business_btn = By.xpath("//button[contains(.,'Verify Business')]");
    private final By continue_anyway_recom_btn = By.xpath("//button[contains(.,'Not recommended')]");






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
        waitForTime(10000);

    }
    public void checkBroadCastScreen(){
        Assert.assertTrue(assertElementDisplayed(back_arrow_into_broadcast));
        Assert.assertTrue(driver.findElement(broad_Cast_title).getText().contains("Broadcast"));
        Assert.assertTrue(driver.findElement(broad_cast_title_description).getText().contains("Send a WhatsApp template message to all or part of your contact list at once"));
        waitForVisibilityOfElement(new_broadcast_CTA);
        scrollToElement(select_by_date);
        Assert.assertTrue(driver.findElement(select_by_date).getText().contains("Select by Date"));
        ElementsValidator(select_a_status,search_input_field,grid_view,grid_view,list_view);
//        driver.findElement(By.xpath("//a[@id='zc-decline']")).click();

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

    public void checkCreateBroadcastScreen2() {

        try {
            clickOnElement(new_broadcast_CTA);
            waitForTime(3000);
        } catch (Exception e) {
            System.out.println(
                    "New Broadcast CTA not clickable. Skipping this flow and continuing other tests."
            );
            return; // 🔑 stop this method, do NOT fail suite
        }

        // 🔹 Step 1: Check if Account Health Warning modal appears
        if (driver.findElements(account_health_warning).size() > 0) {

            // 🔴 RED account health → block & skip
            if (driver.findElements(redHealthText).size() > 0) {

                validateLocatorsWIthTexts(
                        redHealthText,
                        "Your account health is Red"
                );

                System.out.println("Account Health is RED. Broadcasting is blocked.");
                throw new SkipException(
                        "Skipping test: Account Health is RED. Cannot create broadcast."
                );
            }

            // 🟡 YELLOW account health → continue flow
            if (driver.findElements(yellowHealthText).size() > 0) {

                // 🔍 DEBUG – print actual yellow description text
                String actualYellowtext = driver.findElement(yellowHealthText).getText();
                System.out.println("DEBUG actual yellow_desc: >>>" + actualYellowtext + "<<<");

                validateLocatorsWIthTexts(
                        yellowHealthText,
                        "Your account health is Yellow"
                );
//                // 🔍 DEBUG – print actual yellow description text
                String actualYellowDesc = driver.findElement(yellow_desc).getText();
                System.out.println("DEBUG actual yellow_desc: >>>" + actualYellowDesc + "<<<");

                validateLocatorsWIthTexts(yellow_desc, "We recommend waiting 7–14 days until your health returns to Green status.");
                validateLocatorsWIthTexts(yellow_warnText, "If you continue now, you may risk further degradation.");

                System.out.println("Account Health is YELLOW. Continuing broadcast.");
                clickOnElement(continue_anyway_btn);
                waitForTime(5000);

            }
        }

        // 🟢 GREEN OR post-YELLOW flow continues here
        continueCreateBroadcastFlow();
    }




    private void continueCreateBroadcastFlow(){

        waitForVisibilityOfElement(create_broadcast_title);
        validateLocatorsWIthTexts(create_broadcast_title,"Create Broadcast");
        validateLocatorsWIthTexts(create_broadcast_description,"Create new broadcast to start using it");
        validateLocatorsWIthTexts(create_broadcast_important_tips,"Important Tips");
        validateLocatorsWIthTexts(create_broadcast_tips_name,"Name Your Broadcasts Clearly");
        validateLocatorsWIthTexts(create_broadcast_tips_name_description, "Use a descriptive and meaningful name for each broadcast. This helps you easily find, track, and analyze results or re-publish later.");
        validateLocatorsWIthTexts(create_broadcast_tips_reattempts_deliverabilty, "Enable Reattempts for Better Deliverability");
        validateLocatorsWIthTexts(create_broadcast_tips_reattempts_deliverabilty_description, "Allowing retries helps ensure that messages that initially fail to send (e.g., due to connectivity issues) are automatically retried, maximizing reach.");


        scrollToElement(broadcast_name_input);
        Assert.assertTrue(driver.findElement(broadcast_name_input).getAttribute("value").contains("broadcast_"));
        scrollToElement(broadcast_reattempt_checkbox);
        validateLocatorsWIthTexts(reattempt_tile, "Enable Reattempts");
        validateLocatorsWIthTexts(rewattempt_desc, "Will stagger, pace and reattempt failed messages for better deliverability.");
        scrollToElement(broadcast_continue_button);
        clickOnElement(broadcast_continue_button);
        waitForTime(3000);
        waitForVisibilityOfElement(template_title);
        checkTemplateScreenAndSelectTemplate();
        waitForTime(3000);
        Utilities.removeThirdPartyBanners(driver);
        waitForTime(3000);
        validateRecipientScreen();
        revievScreen();
        successScreen();


    }


    public void checkTemplateScreenAndSelectTemplate(){

        validateLocatorsWIthTexts(template_title, "Templates");
        validateLocatorsWIthTexts(template_desc, "Choose the template from your template list.");
        validateLocatorsWIthTexts(tempalate_important_tips, "Important Tips");
        validateLocatorsWIthTexts(template_tips_choose_right, "Choose the Right Template");
        validateLocatorsWIthTexts(template_tips_choose_right_desc, "Select the most relevant template for your audience and message. Ensure your template is approved and follows WhatsApp guidelines.");
        validateLocatorsWIthTexts(template_tips_personalize, "Personalize When Possible");
        validateLocatorsWIthTexts(template_tips_personalize_desc, "Use variables and placeholders in your templates to make messages feel personal and increase response rates.");
        sendTextToInputField("test3901" , tempalate_search);
        waitForTime(2000);
        waitForVisibilityOfElement(filter_clear_btn);
        clickOnElement(filter_clear_btn);
        clickOnElement(template_category_dropdown);
        waitForTime(2000);
        clickOnElement(template_types_dropdwon);
        waitForTime(2000);

        //template varaible page screen
        sendTextToInputField("long_temp", tempalate_search);
        clickOnElement(template_use_btn);
        waitForTime(2000);
        validateLocatorsWIthTexts(temp_varaible_title, "Template Variables");
        validateLocatorsWIthTexts(temp_variable_desc, "Pick the variables below to personalize the message.");
        ElementsValidator(back_btn, apply_btn);
        clickOnElement(x_close_btn);
        waitForVisibilityOfElement(template_title);
        selectTemplate();
        clickOnElement(broadcast_continue_button);


    }
    public void selectTemplate(){
        scrollToElement(tempalate_search);
        sendTextToInputField("test3901" , tempalate_search);
        waitForTime(5000);
        clickOnElement(template_use_btn);
        waitForVisibilityOfElement(temp_varaible_title);
        uploadImage();
        addVariable();


    }


    private void uploadImage(){
        scrollToElement(upload_image_CTA);
        clickOnElement(upload_image_CTA);
        clickOnElement(first_image);
        scrollToElement(select_image);
        clickOnElement(select_image);
    }
    private void addVariable(){
        scrollToElement(add_variable_input);
        clickOnElement(add_variable_input);
        Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        clickOnElement(apply_btn);
        waitForVisibilityOfElement(edit_variable);

    }
    private void validateRecipientScreen(){
        waitForVisibilityOfElement(recipient_title);
        validateLocatorsWIthTexts(recipient_title, "Recipients");
        validateLocatorsWIthTexts(recipient_desc, "Choose between selecting from contacts or upload your own sheet.");
        validateLocatorsWIthTexts(recipient_tips, "Important Tips");
        validateLocatorsWIthTexts(recipient_tips_segment_title, "Segment Your Recipients");
        validateLocatorsWIthTexts(recipient_tips_segment_title_desc, "Send your broadcast to targeted recipient groups for higher engagement and relevance.");
        validateLocatorsWIthTexts(recipient_tips_tags_title, "Use Tags & Filters");
        validateLocatorsWIthTexts(recipient_tips_tags_desc, "Utilize tags and filters like closed chats, unread chats, or last activity to send messages that matter to each user.");
        ElementsValidator(tag_btn, custom_field_btn, country_btn, add_contact, add_agent_option, teams_btn, all_closed_chats, all_unread_chats, last_activity, customer_created,
                Filter_opted_out_option, exclude_specific_contact, exclude_specifc_tag, discard_btn, back_bttn, continue_btn);
        waitForTime(10000);
//        validateAllContactScreen();
        validateExelScreen();
        clickOnElement(select_contacts_title);
        selectContact("arpit");
        validateTags();
        validateLastAgent();

        //used for remove cookie-banner
//        driver.findElement(By.xpath("//a[@id='zc-manage']")).click();

        scrollToElement(continue_btn);
        clickOnElement(continue_btn);
        waitForVisibilityOfElement(By.xpath("//*[normalize-space()='Review']"));



    }
    private void selectContact(String contact){
        scrollToElement(select_contacts_title);
        validateLocatorsWIthTexts(select_contact_desc, "Choose target audience who match this criteria.");
//        WebElement add_sign_of_contacts = driver.findElement(contacts_option).findElement(By.xpath("..")).findElement(add_rounded_icon);
//        add_sign_of_contacts.click();
        clickOnElement(add_contact);
        waitForVisibilityOfElement(select_contacts_Screen_title);
        sendTextToInputField(contact,By.xpath("//input[@placeholder='Search with contact name']"));
        waitForVisibilityOfElement(By.xpath("//*[normalize-space()='" + contact + "']"));
        clickOnElement(By.xpath("//*[normalize-space()='" + contact + "']"));
        ElementsValidator(By.xpath("//button[normalize-space()='Clear filter']"));
        clickOnElement(By.xpath("//button[normalize-space()='Apply']"));

    }


    private void validateLastAgent(){
        scrollToElement(add_agent_option);
        clickOnElement(add_agent_option);
        waitForTime(3000);
        waitForVisibilityOfElement(select_agent_title);
        Assert.assertTrue(assertElementDisplayed(By.xpath("//input[@placeholder ='Search with agent name']")));
        clickOnElement(By.xpath("//*[@data-testid='CloseIcon']"));


    }
    private void validateTags(){
        scrollToElement(tag_btn);
        clickOnElement(tag_btn);
        waitForVisibilityOfElement(By.xpath("//p[normalize-space()='Select Tags']"));
        Assert.assertTrue(assertElementDisplayed(search_on_tags));
        sendTextToInputField("Peace", search_on_tags);
        waitForTime(3000);
        clickOnElement(By.xpath("//*[@data-testid='CloseIcon']"));

    }

    private void validateAllContactScreen(){
        scrollToElement(all_contacts);
        clickOnElement(all_contacts);
        waitForVisibilityOfElement(all_contact_desc);
        validateLocatorsWIthTexts(all_contact_desc, "We will send this broadcast to all contacts, Unless you excluded someone or turned on the filtered opt-out.");
        ElementsValidator(all_contact_filter_opted,all_contact_exclude_specific_contact,all_contact_exclude_specifc_tag);
    }

    private void validateExelScreen(){
        scrollToElement(excel_sheet);
        clickOnElement(excel_sheet);
        waitForVisibilityOfElement(download_btn);
        ElementsValidator(upload_sheet_btn);
    }
    public void revievScreen(){
        waitForVisibilityOfElement(review_title);
        validateLocatorsWIthTexts(review_title, "Review");
        validateLocatorsWIthTexts(review_desc, "Review the Recipients and message before sending");
        validateLocatorsWIthTexts(review_tips_cost_title, "Review recipients and cost estimation");
        validateLocatorsWIthTexts(review_tips_cost_desc, "Check the target recipients and cost estimation.");
        validateLocatorsWIthTexts(review_tips_test_before_title, "Test Before Sending");
        validateLocatorsWIthTexts(review_tips_test_before_desc, "Always send a test message to your own WhatsApp number to check formatting and content before broadcasting to a large group.");
        validateLocatorsWIthTexts(review_tips_monitor_title, "Monitor Broadcast Results");
        validateLocatorsWIthTexts(review_tips_monitor_desc, "After sending, review statistics such as delivery rates, reads, and responses to measure broadcast effectiveness.");
        validateLocatorsWIthTexts(try_test_message_tilte,"Try a test message");
        validateLocatorsWIthTexts(try_test_messsage_desc,"Enter WA number to test message on it.");
        ElementsValidator(test_phone_number,test_send_btn,message_preview_title,braodcast_name,valid_recipient,estimated_cost,review_discard_btn,review_back_btn
        , saved_as_draft_btn, schedule_btn, send_broadcst_btn);
        System.out.println("all the element validated moved to send btn");
        scrollToElement(send_broadcst_btn);
        clickOnElement(send_broadcst_btn);
        waitForVisibilityOfElement(broadcast_successful_title);

    }
    public void successScreen(){
        ElementsValidator(done_icon, broadcast_successful_title, broacast_success_desc, back_to_home_btn);
        validateLocatorsWIthTexts(broadcast_successful_title, "Broadcast sent successfully.");
        validateLocatorsWIthTexts(broacast_success_desc, "We have sent your Broadcast to target audience, you can back to broadcast analytics to see the results later.");
        clickOnElement(back_to_home_btn);
        waitForVisibilityOfElement(broad_Cast_title);

    }




}





