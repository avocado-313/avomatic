package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.internal.annotations.IBaseBeforeAfter;

import static com.google.gson.internal.bind.TypeAdapters.URL;

public class P03AvocadoWorkSpace extends PageBase {
    public P03AvocadoWorkSpace(WebDriver driver) {
        super(driver);
    }

    private final By profile_from_side_menu = By.xpath("//*[@aria-label= 'Profile']");
    private final By profile_from_profile_menu = By.xpath("(//p[normalize-space()='Profile'])[1]");
    private final By profile_icon_from_profile_menu = By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-colorSecondary MuiSvgIcon-fontSizeMedium css-v5fipd'])[3]");
//    private final By settings_title_into_profile_screen = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-1hxh1sq'])[1]");//karim
    private final By settings_title_into_profile_screen = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1pnptap']");
//    private final By settings_subTitle_from_profile_screen = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-190tmhz'])[1]"); // Karim
    private final By settings_subTitle_from_profile_screen= By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-v9escn']");
    private final By profile_section = By.xpath("//p[normalize-space()='Profile']");
//    private final By agent_profile_title_from_profile_screen = By.xpath("(//h6[normalize-space()='Agent Profile'])[1]");
    private final By workspace_profile_from_side_menu = By.xpath("(//p[normalize-space()='Workspace Profile'])[1]");
    private final By upload_photo_CTA = By.xpath("(//button[normalize-space()='Upload image'])[1]");
    private final By agents_frm_side_menu = By.xpath("(//p[normalize-space()='Agents'])[1]");
    private final By teams_from_side_menu = By.xpath("(//p[normalize-space()='Teams'])[1]");
    private final By contact_name_input = By.xpath("//input[@aria-label='name']");
    private final By select_flag_arrow = By.xpath("(//div[@class='arrow'])[1]");  // Karim
//    private final By mobile_number_input = By.xpath("(//input[@placeholder='(555) 555-5555'])[1]");  // Karim
    private final By mobile_number_input = By.xpath("//input[@placeholder='91']");
    private final By select_language_arrow = By.xpath("//svg[contains(@class, 'MuiSelect-icon')]");
    private final By select_country_arrow = By.xpath("//div[contains(@class, 'flag-dropdown') and @style='border-radius: 8px 0px 0px 8px; height: 45px; border: none; top: 1px; left: 1px;']");
    private final By address_text_input = By.xpath("(//div[@class='MuiFormControl-root css-1s22ywu'])[3]");
    private final By change_password = By.xpath("(//button[normalize-space()='Change'])[1]");
    private final By current_password_input = By.xpath("(//input[@type='password'])[2]");
    private final By new_password_input = By.xpath("(//input[@type='password'])[3]");
    private final By cancel_CTA = By.xpath("//button[normalize-space()='Cancel']");
    private final By change_password_CTA = By.xpath("(//button[normalize-space()='Change'])[2]");
    private final By work_space_profile_title_from_workspace = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-1eut295'])[1]");
    private final By work_space_profile_subTitle_from_workspace = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-roeert'])[1]");
    private final By profile_upload_image_title = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3'])[1]");
    private final By upload_workspace_image_CTA = By.xpath("//button[normalize-space()='Upload Image']");
    private final By email_input = By.xpath("(//input[@type='text'])[2]");
    private final By organization_name_input = By.xpath("(//*[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[2]");
    private final By legal_name_input = By.xpath("(//*[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[2]");
    private final By i_icon = By.xpath("(//*[name()='svg'][@aria-label='Timezone selected here will be used by the rules, greetings away messages and other modules'])[1]");
//    private final By business_time_zone_title = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-wje1bd'])[1]");  //karim
    private final By business_time_zone_title = By.xpath("//p[normalize-space()='Business Timezone']");  // syed
    private final By select_time_zone = By.xpath("(//fieldset[contains(@class, 'MuiOutlinedInput-notchedOutline')])[4]");


    private final By update_workspace_CTA = By.xpath("//span[normalize-space()='Update']");
    private final By update_CTA = By.xpath("(//span[normalize-space()='Update'])[1]");

    public void navigateToProfileWorkspace() {
        scrollToElement(profile_from_side_menu);
//        driver.navigate().to(URL + "/settings/workspace/account-profile");
        driver.navigate().to("https://test.app.avocad0.dev" + "/settings/workspace/account-profile");
        clickOnElement(profile_section);



        waitForTime(5000);
//        Assert.assertTrue(assertElementDisplayed(profile_from_profile_menu));
//        Assert.assertTrue(assertElementDisplayed(profile_icon_from_profile_menu));
//        clickOnElement(profile_from_profile_menu);
        waitForVisibilityOfElement(settings_title_into_profile_screen);
    }

    public void validateWorkspaceElements() {
        waitForVisibilityOfElement(settings_title_into_profile_screen);
        ElementsValidator(settings_title_into_profile_screen, settings_subTitle_from_profile_screen,
                 workspace_profile_from_side_menu, upload_photo_CTA, agents_frm_side_menu,
                teams_from_side_menu, select_flag_arrow, mobile_number_input
                , address_text_input, select_country_arrow, change_password);
    }

    String currentDir = System.getProperty("user.dir");
    String file_path = currentDir + "//images//avocad0.jpg";

    public void validateChangePassword() {
        scrollToElement(change_password);
        clickOnElement(change_password);
        waitForVisibilityOfElement(current_password_input);
        ElementsValidator(new_password_input, cancel_CTA);
        sendTextToInputField("123456789", current_password_input);
        sendTextToInputField("Testing@1", new_password_input);
        ElementsValidator(change_password_CTA);
        clickOnElement(cancel_CTA);
        waitForVisibilityOfElement(change_password);
    }

    public void checkWorkSpaceProfile() {
        clickOnElement(workspace_profile_from_side_menu);
        waitForVisibilityOfElement(work_space_profile_subTitle_from_workspace);
        ElementsValidator(work_space_profile_title_from_workspace, profile_upload_image_title
                , upload_workspace_image_CTA, email_input, organization_name_input,
                legal_name_input, i_icon, business_time_zone_title, select_time_zone);
        validateElementsText(work_space_profile_title_from_workspace, "Workspace Profile");
        validateElementsText(work_space_profile_subTitle_from_workspace, "Manage your Workspace settings");
        validateElementsText(profile_upload_image_title, "Profile Photo");
        validateElementsText(business_time_zone_title, "Business Timezone");
        clearInputField(legal_name_input);
        sendTextToInputField("", legal_name_input);
        clearInputField(organization_name_input);
        sendTextToInputField("", organization_name_input);
        uploadWorkSpaceImage();
        selectTimeZone();
        waitForTime(9000);
        clickOnElement(update_workspace_CTA);


    }

    private void selectTimeZone() {
        driver.findElement(select_time_zone).findElement(By.xpath("..")).findElement(By.xpath("..")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("asia/riy");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
    }

    private void uploadWorkSpaceImage() {
        scrollToElement(upload_workspace_image_CTA);
        clickOnElement(upload_workspace_image_CTA);
        waitForTime(4000);
        driver.findElement(By.id("upload-button")).sendKeys(file_path);
       try {
           waitForTime(2000);
           clickOnElement(By.xpath("//button[contains(@class, 'MuiButtonBase-root') and contains(@class, 'css-1sgkwlu')]"));
           clickOnElement(By.xpath("//button[@data-testid='select-attach-file-save-button']"));
           waitForTime(4000);
       }catch (Exception e){
           waitForTime(2000);
           clickOnElement(By.xpath("//button[contains(@class, 'MuiButtonBase-root') and contains(@class, 'css-1sgkwlu')]"));
           clickOnElement(By.xpath("//button[@data-testid='select-attach-file-save-button']"));
           waitForTime(4000);
       }
    }

    private void validateElementsText(By by, String text) {
        scrollToElement(by);
        waitForVisibilityOfElement(by);
        Assert.assertTrue(driver.findElement(by).getText().contains(text));
    }


}
