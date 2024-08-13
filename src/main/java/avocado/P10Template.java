package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P10Template extends PageBase {
    public P10Template(WebDriver driver) {
        super(driver);
    }
    private final By template_title = By.xpath("//*[@data-testid='title']");
    private final By template_sub_title = By.xpath("//*[@data-testid='description']");
    private final By submit_template_CTA = By.xpath("//*[@data-testid='header-create-submit-templates-button2']");
    private final By sync_template = By.xpath("//*[@data-testid='header-sync-templates-button1']");
    private final By back_arrow = By.xpath("//*[@data-testid='ArrowBackIosNewRoundedIcon']");
    private final By template_from_apps = By.xpath("//p[normalize-space()='Templates']");
    private final By template_id_input_field = By.xpath("//*[@placeholder='Template ID']");
    private final By template_description_input_field = By.xpath("//*[@placeholder='Description (Optional)']");
    private final By category_title = By.xpath("//*[normalize-space()='Category']");
    private final By marketing_category = By.xpath("//*[normalize-space()='Marketing']");
    private final By utility_category = By.xpath("//*[normalize-space()='Utility']");
    private final By language_selection = By.xpath("//*[normalize-space()='Language']");
    private final By select_language_input = By.xpath("//*[@placeholder='Select a Language']");
    private final By allow_category_change = By.xpath("//*[@data-testid='MainForm-allow_category_change-label']");
    private final By allow_category_change_toggle = By.xpath("//*[@type='checkbox']");
    private final By media_title = By.xpath("//*[@data-testid='MainForm-media_type-label']");
    private final By none_media = By.xpath("(//*[normalize-space()='None'])[1]");
    private final By image_media = By.xpath("(//*[normalize-space()='Image'])[1]");
    private final By video_media = By.xpath("(//*[normalize-space()='Video'])[1]");
    private final By docs_media = By.xpath("(//*[normalize-space()='Docs'])[1]");
    private final By body_text = By.xpath("(//*[normalize-space()='Body Text'])[1]");
    private final By add_footer_text = By.xpath("//*[@placeholder='Add Footer Text']");
    private final By buttons = By.xpath("//*[normalize-space()='Buttons']");
    private final By none_buttons = By.xpath("(//*[normalize-space()='None'])[3]");
    private final By CTA_Buttons = By.xpath("//*[@data-testid='button-type-cta']");
    private final By quick_replies_button = By.xpath("//*[@data-testid='button-type-quick-reply']");
    private final By whats_app_message_preview = By.xpath("//*[@data-testid='preview-whatsapp-msg']");

    private void validateCreateTemplateElements(){
        ElementsValidator(template_title,template_sub_title,template_id_input_field,template_description_input_field,
                category_title,marketing_category,utility_category,language_selection,select_language_input,
                allow_category_change,media_title,none_media,image_media,video_media,docs_media,body_text,
                add_footer_text,buttons,none_buttons,CTA_Buttons, quick_replies_button,whats_app_message_preview);
    }
    public void validateTemplateFromApps(){
        clickOnElement(apps_from_menu);
        waitForVisibilityOfElement(greeting_and_away);
        scrollToElement(template_from_apps);
        Assert.assertTrue(driver.findElement(template_from_apps).getText().contains("Templates"));
    }
    public void validateTemplateScreen(){
        validateTemplateFromApps();
        clickOnElement(template_from_apps);
        waitForVisibilityOfElement(template_title);
        Assert.assertTrue(driver.findElement(template_title).getText().contains("Templates"));
        Assert.assertTrue(driver.findElement(template_sub_title).getText().contains("Manage your WhatsApp templates here."));
        ElementsValidator(back_arrow , submit_template_CTA);


    }
    public void validateCreateTemplateScreen(){
        clickOnElement(submit_template_CTA);
        waitForVisibilityOfElement(template_id_input_field);
        validateCreateTemplateElements();
    }
}
