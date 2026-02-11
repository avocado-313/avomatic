package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P26ChatClosing extends PageBase {

    public P26ChatClosing(WebDriver driver) {
        super(driver);
    }
    private final By apps_from_menu = By.xpath("//a[@aria-label='Apps']//*[name()='svg']");
    private final By chat_closing_icon = By.xpath("//*[@data-testid='CheckCircleOutlineIcon']");
    private final By chat_closing_from_apps = By.xpath("//a[.//p[normalize-space()='Chat Closing Summary']]");
    private final By chat_closing_description_from_apps = By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-cc9b9l'])[11]");
    private final By back_cta_from_close_screen = By.xpath("//button[@data-testid='back-button']");
    private final By close_reason_title = By.xpath("//p[normalize-space() = 'Chat closing summary']");
    private final By close_reason_desc = By.xpath("//p[contains(., 'Log enables users')]");
    private final By reasons_btn = By.xpath("//p[normalize-space()='Reasons']");
    private final By settings_btn = By.xpath("//p[normalize-space()='Settings']");
    private final By elipsis_btn = By.xpath("(//button[@data-testid='actions-button'])[1]");

    //Setting Page
    private final By settings_activate = By.xpath("//p[contains(., 'Activate Closure')]");
    private final By activate_desc = By.xpath("//p[contains(., 'User will get ')]");
    private final By madatory_title = By.xpath("//p[contains(., 'Mandatory fields')]");
    private final By main_checkbox = By.xpath("(//*[@type='checkbox'])[2]");
    private final By main_reason_title = By.xpath("//p[contains(., 'Main Reason')]");
    private final By main_reason_desc = By.xpath("//p[contains(., 'User must choose')]");
    private final By summary_title = By.xpath("//p[contains(., 'Written')]");
    private final By summary_desc = By.xpath("//p[contains(., 'User must type')]");
    private final By summary_checkbox = By.xpath("(//*[@type='checkbox'])[3]");



    // Create close reason
    private final By create_btn = By.xpath("//*[normalize-space()='Create reason']");
    private final By title = By.xpath("//p[normalize-space()='Add Reason']");
    private final By x_btn = By.xpath("//*[@data-testid='CloseIcon']");
    private final By input_category = By.xpath("//input[@id='reason-category']");
    private final By input_reason = By.xpath("//input[@placeholder='e.g. problem has been solved']");
    private final By add_cta = By.xpath("//button[.//div[normalize-space()='Add new reason']]");
    private final By discard_cta = By.xpath("//button[normalize-space()='Discard']");

    // Edit Close Reason
    private final By edit_btn = By.xpath("//*[@data-testid='action-button-label-0']");
    private final By update_title = By.xpath("//p[normalize-space()='Update Reason']");
    private final By update_cta = By.xpath("//button[.//div[normalize-space()='Update Reason']]");
    private final By cancel_cta = By.xpath("//button[normalize-space()='Cancel']");

    //Delete Close Reason
    private final By delete_btn = By.xpath("//*[@data-testid='action-button-label-1']");
    private final By del_title = By.xpath("//*[@data-testid='delete-confirm-title']");
    private final By del_desc = By.xpath("//p[contains(., 'Are you sure')]");
    private final By del_btn = By.xpath("//*[@data-testid='deleted-modal-deleted-btn']");
    private final By del_cancel = By.xpath("//*[@data-testid='deleted-modal-cancel-btn']");


    public void validateChatCloseReasonFromApps(){
        clickOnElement(apps_from_menu);
        waitForVisibilityOfElement(greeting_and_away);
        scrollToElement(chat_closing_icon);
        Assert.assertTrue(driver.findElement(chat_closing_from_apps).getText().contains("Chat Closing Summary"));
        Assert.assertTrue(driver.findElement(chat_closing_description_from_apps).getText().contains("The Conversation Closure Log enables users to document reasons and summaries for ending chats, aiding in record-keeping, compliance, and insights for future reviews"));
//        clickOnElement(chat_closing_from_apps);
        clickOnElement(chat_closing_from_apps);
        waitForTime(5000);
        Assert.assertTrue(assertElementDisplayed(back_cta_from_close_screen));
        validateCloseReasonScreen();
    }
    private void validateLocatorsWIthTexts(By by , String text){
        scrollToElement(by);
        System.out.println(by + "======> " + driver.findElement(by).getText());
        Assert.assertTrue(assertElementDisplayed(by));
        Assert.assertTrue(driver.findElement(by).getText().contains(text));

    }

    private void validateCloseReasonScreen(){
        ElementsValidator(close_reason_title, close_reason_desc,back_cta_from_close_screen, reasons_btn, settings_btn);
        validateLocatorsWIthTexts(close_reason_title, "Chat closing summary");
        validateLocatorsWIthTexts(close_reason_desc, "Log enables users to document reasons and summaries for ending chats.");
        clickOnElement(settings_btn);
        waitForVisibilityOfElement(settings_activate);
        validateSettingpage();


    }
    private void validateSettingpage(){
        ElementsValidator(settings_activate, activate_desc, madatory_title,main_reason_title, main_reason_desc,summary_title,summary_desc);
        validateLocatorsWIthTexts(activate_desc,"User will get a popup with input fields to fill it with chat closure reason.");
        validateLocatorsWIthTexts(madatory_title, "Mandatory fields");
        validateLocatorsWIthTexts(main_reason_title, "Main Reason");
        validateLocatorsWIthTexts(main_reason_desc, "User must choose a reason from the pre-defined list while closing the chat.");
        validateLocatorsWIthTexts(summary_title, "Written Summary");
        validateLocatorsWIthTexts(summary_desc, "User must type a summary while closing the chat.");
        clickOnElement(reasons_btn);
        waitForVisibilityOfElement(close_reason_title);

    }

    public void validateCreateCloseReason(){
        clickOnElement(create_btn);
        waitForVisibilityOfElement(title);
        ElementsValidator(x_btn, input_reason, input_category,discard_cta,add_cta);
        sendTextToInputField("testcategory" + generateRandomDigits(4), input_category);
        driver.findElement(input_category).sendKeys(Keys.ENTER);
        sendTextToInputField("testreason" + generateRandomDigits(3),input_reason);
        clickOnElement(add_cta);
        waitForTime(10000);
        System.out.println("close reason created....");
        waitForVisibilityOfElement(elipsis_btn);

    }

    public void validateEditCloseReason(){
        clickOnElement(elipsis_btn);
        waitForVisibilityOfElement(edit_btn);
        clickOnElement(edit_btn);
        waitForVisibilityOfElement(update_title);
        driver.findElement(input_reason).sendKeys(Keys.CONTROL + "a");
        driver.findElement(input_reason).sendKeys(Keys.DELETE);
        sendTextToInputField("reasonsss", input_reason);
        ElementsValidator(cancel_cta);
        clickOnElement(update_cta);
        waitForTime(5000);
        System.out.println("close reason updated....");
        validateDeleteCloseReason();
    }

    private void validateDeleteCloseReason(){
        clickOnElement(elipsis_btn);
        waitForVisibilityOfElement(edit_btn);
        clickOnElement(delete_btn);
        waitForVisibilityOfElement(del_title);
        validateLocatorsWIthTexts(del_desc, "Are you sure you want to delete the reason");
        ElementsValidator(del_cancel);
        clickOnElement(del_btn);
        waitForTime(5000);
        System.out.println("close reason deleted....");
        waitForVisibilityOfElement(close_reason_title);
    }



}
