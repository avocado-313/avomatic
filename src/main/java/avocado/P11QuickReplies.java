package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P11QuickReplies extends PageBase {
    public P11QuickReplies(WebDriver driver) {
        super(driver);
    }
    private final By quick_replies_title_from_apps = By.xpath("(//*[normalize-space()='Quick replies'])[3]");
    private final By quick_replies_description_from_apps = By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-1ezpj7n'])[3]");
    private final By apps_from_menu = By.xpath("//a[@aria-label='Apps']//*[name()='svg']");
    private final By quick_replies_title_fromQuick_replies_screen = By.xpath("//*[@data-testid='title']");
    private final By quick_Replies_description_from_quickReplies_screen = By.xpath("//*[@data-testid='description']");
    private final By quick_replies_icon = By.xpath("//*[@data-testid='QuickreplyOutlinedIcon']");
    private final By create_quick_reply_CTA = By.xpath("//button[normalize-space()='Create Quick Reply']");
    private final By back_CTA_from_quick_replies = By.xpath("//*[@data-testid='ArrowBackIosNewRoundedIcon']");
    private final By search_icon = By.xpath("//*[@data-testid='SearchIcon']");
    private final By search_input = By.xpath("//*[@placeholder='Search']");
    private final By all_types_of_quick_replies_list = By.xpath("//*[@placeholder='All types of Quick Replies']");
    private final By grid_view_icon = By.xpath("//*[@data-testid='GridViewOutlinedIcon']");
    private final By list_view_icon = By.xpath("//*[@data-testid='FormatListBulletedRoundedIcon']");
    private  final By New_normalize_space_title = By.xpath("(//*[normalize-space()='Create New Quick Reply'])[2]");
    private final By short_code_input_field = By.xpath("//*[@data-testid='input-add-short-code']");
    private final By keywords_input_field = By.xpath("//*[@data-testid='input-add-keywords']");
//    private final By keywords_input_field = By.xpath("//*[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused css-1x5jdmq']");
    private final By body_text_input_field = By.xpath("(//*[normalize-space()='Body Text'])[1]");
    private final By available_to_list = By.xpath("//*[@aria-haspopup='listbox']");


    public void validateQuickRepliesFromApps(){
        clickOnElement(apps_from_menu);
        waitForVisibilityOfElement(greeting_and_away);
        scrollToElement(quick_replies_title_from_apps);
        Assert.assertTrue(driver.findElement(quick_replies_description_from_apps).getText().contains("Shortcuts for frequently sent messages and media like images or videos. Respond to customers faster using Quick Replies."));
    }

    public void validateQuickRepliesScreen(){
        clickOnElement(quick_replies_title_from_apps);
        waitForTime(10000);
        waitForVisibilityOfElement(quick_replies_title_fromQuick_replies_screen);
        Assert.assertTrue(driver.findElement(quick_replies_title_fromQuick_replies_screen).getText().contains("Quick Replies"));
        waitForVisibilityOfElement(quick_Replies_description_from_quickReplies_screen);
        Assert.assertTrue(driver.findElement(quick_Replies_description_from_quickReplies_screen).getText().contains("Respond to customers faster by setting pre-composed messages."));
        waitForTime(5000);
        ElementsValidator(back_CTA_from_quick_replies,create_quick_reply_CTA,back_CTA_from_quick_replies,quick_replies_icon,
                search_icon,search_input,all_types_of_quick_replies_list,grid_view_icon,list_view_icon);

    }
    public void validateCreateNewQuickReplyTemplate(){
        clickOnElement(create_quick_reply_CTA);
        waitForVisibilityOfElement(New_normalize_space_title);
        ElementsValidator(short_code_input_field,keywords_input_field,body_text_input_field,available_to_list);
        waitForTime(10000);
        fillQuickReplyForm();
    }

    private void fillQuickReplyForm(){
        try {
            clickOnElement(available_to_list);
            clickOnElement(By.xpath("//*[normalize-space()='All']"));
            clickOnElement(short_code_input_field);
            sendKeysWithJs(short_code_input_field, "quickReplyCode");
            clickOnElement(keywords_input_field);
            sendTextToInputField("keyWord", keywords_input_field);
            clickOnElement(body_text_input_field);
            sendTextToInputField("body", body_text_input_field);
            clickOnElement(By.xpath("//*[normalize-space()='Save']"));
        }catch (Exception e){
            clickOnElement(By.xpath("//*[normalize-space()='Cancel']"));
        }
    }
}
