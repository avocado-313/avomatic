package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyInput;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

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
    private final By body_text = By.xpath("//*[@class ='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-multiline css-1sbjj2w']");
    private final By add_footer_text = By.xpath("//*[@placeholder='Add Footer Text']");
    private final By buttons = By.xpath("//*[normalize-space()='Buttons']");
    private final By none_buttons = By.xpath("//button[@value='none']");
    private final By CTA_Buttons = By.xpath("//*[@data-testid='button-type-cta']");
    private final By quick_replies_button = By.xpath("//*[@data-testid='button-type-quick-reply']");
    private final By whats_app_message_preview = By.xpath("//*[@data-testid='preview-whatsapp-msg']");
    private final By insertVariable = By.xpath("(//*[normalize-space() = 'INSERT VARIABLE {{#}}'])[2]");
    private final By emoji = By.xpath("//*[@data-testid='select-emoji-picker']");
    private final By smileyEmojis = By.xpath("(//*[normalize-space() = 'Smileys & People'])[2]");
    private final By addCta = By.xpath("//button[.//span[contains(text(),'Next')] and .//span[contains(text(),'Saving...')] and .//span[text() = 'Saved'] and .//span[text() = 'Error']]");
    private final By upload_image_CTA = By.xpath("//button[normalize-space() = 'Upload image']");
//    private final By image = By.xpath("//input[@name='image']");

    private final By enter_Variable = By.xpath("//*[normalize-space() = 'Enter the variable 1']");
    private final By submit_ReviewCTA = By.xpath("//button[.//span[contains(text(),'Submit for review')] and .//span[contains(text(),'Saving...')] and .//span[text() = 'Saved'] and .//span[text() = 'Error']]");



    Actions actions = new Actions(driver);
    String currentDir = System.getProperty("user.dir");
    String file_path = currentDir + "//images//avocad0.jpg";

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

    public void validateCreateNewTemplate() throws InterruptedException {
//        clickOnElement(submit_template_CTA);
        sendTextToInputField("test" + generateRandomDigits(5), template_id_input_field);
        sendTextToInputField("testing template" + generateRandomDigits(3), template_description_input_field);
        clickOnElement(marketing_category);
        clickOnElement(language_selection);
        waitForVisibilityOfElement(select_language_input);
        driver.findElement(select_language_input).sendKeys(Keys.CONTROL + "a");
        driver.findElement(select_language_input).sendKeys(Keys.DELETE);
        sendTextToInputField("English", select_language_input);

        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        clickOnElement(none_media);
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys("This teemplate only for testing purpose").perform();
//        clickOnElement(insertVariable);
        clickOnElement(emoji);
        waitForVisibilityOfElement(smileyEmojis);
        clickOnElement(By.xpath("(//img[@alt='smiling face with 3 hearts'])[1]"));
//        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
//        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys("Powered_By_Mottasl!");

        actions.pause(Duration.ofSeconds(4)).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        clickOnElement(addCta);
        Thread.sleep(5000);

    }
    private final By buttonTitle = By.xpath("//*[normalize-space() = 'Button 1']");
    private final By buttonDisplayed = By.xpath("//*[normalize-space() = 'Button display text']");
    private final By textInput = By.xpath("//input[@placeholder='Text']");
    private final By addButton = By.xpath("//*[@data-testid='add-quick-reply-btn']");

    private void validateQuickRepliesButtonElements(){
        ElementsValidator(buttonTitle, buttonDisplayed, textInput, addButton);

    }
    public void validateMediaAndVariableTemplate() throws InterruptedException {
//        clickOnElement(submit_template_CTA);
        waitForVisibilityOfElement(template_id_input_field);
        sendTextToInputField("test" + generateRandomDigits(4), template_id_input_field);
        sendTextToInputField("testing template" + generateRandomDigits(3), template_description_input_field);
        clickOnElement(marketing_category);
        clickOnElement(language_selection);
        waitForVisibilityOfElement(select_language_input);
        driver.findElement(select_language_input).sendKeys(Keys.CONTROL + "a");
        driver.findElement(select_language_input).sendKeys(Keys.DELETE);
        sendTextToInputField("English", select_language_input);

        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        clickOnElement(image_media);
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys("This teemplate only for testing purpose").perform();
        clickOnElement(insertVariable);
        clickOnElement(emoji);
        waitForVisibilityOfElement(smileyEmojis);
        clickOnElement(By.xpath("(//img[@alt='smiling face with 3 hearts'])[1]"));
//        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
//        sendTextToInputField("Powered_By_Mottasl", add_footer_text);
        clickOnElement(none_buttons);
        clickOnElement(addCta);
        waitForVisibilityOfElement(enter_Variable);
        clickOnElement(upload_image_CTA);
        actions.pause(Duration.ofSeconds(5)).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        clickOnElement(By.xpath("//button[normalize-space() = 'Select']"));
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys("abcd").perform();
        clickOnElement(submit_ReviewCTA);
        Thread.sleep(5000);

    }

    public void validateQuickReplyButtonTemplate() throws InterruptedException {
//        clickOnElement(submit_template_CTA);
        waitForVisibilityOfElement(template_id_input_field);
        sendTextToInputField("test" + generateRandomDigits(4), template_id_input_field);
        sendTextToInputField("testing template" + generateRandomDigits(3), template_description_input_field);
        clickOnElement(utility_category);
        clickOnElement(language_selection);
        waitForVisibilityOfElement(select_language_input);
        driver.findElement(select_language_input).sendKeys(Keys.CONTROL + "a");
        driver.findElement(select_language_input).sendKeys(Keys.DELETE);
        sendTextToInputField("English", select_language_input);

        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        clickOnElement(image_media);
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys("This template only for testing purpose").perform();
        clickOnElement(insertVariable);
        clickOnElement(emoji);
        waitForVisibilityOfElement(smileyEmojis);
        clickOnElement(By.xpath("(//img[@alt='smiling face with 3 hearts'])[1]"));
//        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
//        sendTextToInputField("Powered_By_Mottasl", add_footer_text);

        clickOnElement(quick_replies_button);
        waitForVisibilityOfElement(buttonDisplayed);
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys("Test").perform();


        clickOnElement(addCta);
        waitForVisibilityOfElement(enter_Variable);
        clickOnElement(upload_image_CTA);
        actions.pause(Duration.ofSeconds(5)).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        clickOnElement(By.xpath("//button[normalize-space() = 'Select']"));
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys("abcd").perform();
        clickOnElement(submit_ReviewCTA);
        Thread.sleep(5000);

    }

    private final By phoneTitle = By.xpath("(//*[normalize-space() = 'Phone number'])[2]");
    private final By phoneInput = By.xpath("//*[@placeholder='Enter phone number']");
    private final By phoneText = By.xpath("//*[@placeholder='Text']");
    private final By addBtnCTA = By.xpath("//button[normalize-space() = '+ Add Button']");
    private final By staticUrl = By.xpath("//*[normalize-space() = 'Static Link']");
    private final By enterURl = By.xpath("(//*[@placeholder='Enter URL Here'])[1]");
    private  final By staticText = By.xpath("(//*[@placeholder='Text'])[2]");
    private final By dynamicURl = By.xpath("//*[normalize-space() = 'Dynamic Link']");
    private  final By dynamicText = By.xpath("(//*[@placeholder='Text'])[3]");
    private final By uploadVideoCta = By.xpath("(//*[normalize-space() = 'Upload video'])[3]");






    public void validateCTATemplate() throws InterruptedException {
//        clickOnElement(submit_template_CTA);
        waitForVisibilityOfElement(template_id_input_field);
        sendTextToInputField("test CTA" + generateRandomDigits(4),template_id_input_field);
        sendTextToInputField("Test desc." +generateRandomDigits(3),template_description_input_field);
        clickOnElement(utility_category);
        clickOnElement(language_selection);
        waitForVisibilityOfElement(select_language_input);
        driver.findElement(select_language_input).sendKeys(Keys.CONTROL + "a");
        driver.findElement(select_language_input).sendKeys(Keys.DELETE);
        sendTextToInputField("English", select_language_input);
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        clickOnElement(video_media);
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys("This template is for testing the automation suites of CTA").perform();
        clickOnElement(insertVariable);
        clickOnElement(emoji);
        waitForVisibilityOfElement(smileyEmojis);
        clickOnElement(By.xpath("(//img[@alt='smiling face with 3 hearts'])[1]"));
//        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        clickOnElement(CTA_Buttons);
        waitForVisibilityOfElement(phoneTitle);
        sendTextToInputField(generateRandomNumber(),phoneInput);
        sendTextToInputField("Call Me",phoneText);
        clickOnElement(addBtnCTA);
        waitForVisibilityOfElement(staticUrl);
        sendTextToInputField("www.google.com",enterURl);
        sendTextToInputField("google",staticText);
        clickOnElement(addBtnCTA);
        waitForVisibilityOfElement(dynamicURl);
        sendTextToInputField("dynamic",dynamicText);
        clickOnElement(addCta);
        waitForVisibilityOfElement(enter_Variable);
        clickOnElement(uploadVideoCta);

        actions.pause(Duration.ofSeconds(5)).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        clickOnElement(By.xpath("//button[normalize-space() = 'Select']"));
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys("abcd").perform();
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys("https://test.app.avoacd0.dev").perform();
        clickOnElement(submit_ReviewCTA);


        Thread.sleep(5000);

    }

    private final By actionCTA = By.xpath("(//*[@data-testid='actions-button'])[1]");
    private final By viewCta = By.xpath("//*[normalize-space() = 'View']");
    private final By addLanguage_CTA = By.xpath("//*[normalize-space()='Add Language']");
    private final By addLanguageTitle = By.xpath("//*[normalize-space()='Add a New Language']");

    public void validateAddLangTemplate() throws InterruptedException {
        clickOnElement(actionCTA);
        waitForVisibilityOfElement(viewCta);
        clickOnElement(addLanguage_CTA);
        waitForVisibilityOfElement(addLanguageTitle);
        Assert.assertTrue(driver.findElement(addLanguageTitle).getText().contains("Add a New Language"));
        clickOnElement(language_selection);
        waitForVisibilityOfElement(select_language_input);
        driver.findElement(select_language_input).sendKeys(Keys.CONTROL + "a");
        driver.findElement(select_language_input).sendKeys(Keys.DELETE);
        sendTextToInputField("English", select_language_input);
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        clickOnElement(addCta);
        waitForVisibilityOfElement(enter_Variable);
        clickOnElement(uploadVideoCta);

        actions.pause(Duration.ofSeconds(5)).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        clickOnElement(By.xpath("//button[normalize-space() = 'Select']"));
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys("abcd").perform();
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys("https://test.app.avoacd0.dev").perform();
        clickOnElement(submit_ReviewCTA);


        Thread.sleep(5000);


    }

    private final By duplicateCTA = By.xpath("//*[normalize-space() = 'Duplicate template']");

    public void duplicateTemplateCreation() throws InterruptedException {
        clickOnElement(actionCTA);
        waitForVisibilityOfElement(viewCta);
        Thread.sleep(2000);
        clickOnElement(duplicateCTA);
        Thread.sleep(2000);
        waitForVisibilityOfElement(template_title);
        driver.findElement(template_id_input_field).sendKeys(Keys.CONTROL + "a");
        driver.findElement(template_id_input_field).sendKeys(Keys.DELETE);
        sendTextToInputField("duplicate Testing" + generateRandomDigits(4), template_id_input_field);

        scrollToElement(addCta);
        clickOnElement(addCta);
        waitForVisibilityOfElement(enter_Variable);
        clickOnElement(uploadVideoCta);

        actions.pause(Duration.ofSeconds(5)).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        clickOnElement(By.xpath("//button[normalize-space() = 'Select']"));
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys("abcd").perform();
        actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys("https://test.app.avoacd0.dev").perform();
        clickOnElement(submit_ReviewCTA);

        waitForVisibilityOfElement(template_sub_title);
        Thread.sleep(5000);

    }

    public void validateDeleteTemplate() throws InterruptedException {
        clickOnElement(actionCTA);
        waitForVisibilityOfElement(viewCta);
        clickOnElement(By.xpath("//*[normalize-space() = 'Delete template']"));
        waitForVisibilityOfElement(By.xpath("//*[normalize-space() = 'Delete Template']"),50);
        clickOnElement(By.xpath("//*[normalize-space() = 'Confirm delete']"));
        Thread.sleep(5000);
    }





}
