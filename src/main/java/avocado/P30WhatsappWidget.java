package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P30WhatsappWidget extends PageBase {
    public P30WhatsappWidget(WebDriver driver) {
        super(driver);
    }

    private final By whatsappWidgetTitleFromApps = By.xpath("(//*[normalize-space()='WhatsApp Widget'])[2]");
    private final By whatsappWidgetSubTitleFromApps = By.xpath("//*[normalize-space()='Give customers a way to reach you on WhatsApp from your website.']");
    private final By whatsappWidgetHeader = By.xpath("//*[@data-testid='title' and contains(text(), 'Click-to-Chat Button')]");
    private final By whatsappWidgetDesc = By.xpath("//*[@data-testid='description' and contains(text(), 'Give customers a way to reach you on WhatsApp, Facebook or Instagram.')]");
    private final By chatBubbleSection = By.xpath("//*[normalize-space()='Chat Bubble']");
    private final By chatBubbleDropDownDesc = By.xpath("//*[@id=\":re:-label\"]");
    private final By chatBubbleDropDownButton = By.xpath("(//*[@data-testid=\"ArrowDropDownIcon\"])[1]");
    private final By chatBubbleColorOption1 = By.xpath("(//*[normalize-space()='Bubble Background Color'])[1]"); //If Default Selected then only work
    private final By chatBubbleUploadCta = By.xpath("//*[@class=\"MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary css-17vlwd\"]");
    private final By chatHeaderSection = By.xpath("//*[normalize-space()= 'Chat Header']");
    private final By chatHeaderNameField = By.xpath("//*[@id=\":rh:-label\"]");
    private final By chatHeaderCationField = By.xpath("//*[@id=\":ri:-label\"]");
    private final By chatBubbleColorOption2 = By.xpath("(//*[normalize-space()='Bubble Background Color'])[2]");//If Previous one not present then it will work otherwise remove [2]

    private final By chatHeaderChangeCta = By.xpath("//*[@class=\"MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary css-17vlwd\"]");
    private final By welcomeMessageHeader = By.xpath("//*[normalize-space() = 'Welcome Message']");
    private final By welcomeMessageTextBox = By.xpath("(//*[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMultiline css-u36398\"])[1]");
    private final By clickToChatButtonHeader = By.xpath("(//*[normalize-space() = 'Click-to-Chat Button'])[2]");
    private final By buttonTextInputBox = By.xpath("(//*[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[3]");
    private final By buttonBackgroundColorCta = By.xpath("//*[@class=\"MuiButtonBase-root css-nfbhn5\"]");
    private final By preFilledMessageHeader = By.xpath("//*[normalize-space() = 'Pre filled message']");
    private final By preFilledMessageDesc = By.xpath("//*[normalize-space() = 'You can select the default position of the chat button using the settings below.']");
    private final By preFilledMessageInputBox = By.xpath("//*[@id=\":rac:\"]");
    private final By positionAndVisibilityHeader = By.xpath("//*[normalize-space() = 'Position & Visibility']");
    private final By positionAndVisibilityDesc = By.xpath("//*[normalize-space() = 'You can select the default position of the chat button using the settings below.']");
    private final By webText = By.xpath("(//*[normalize-space() = 'Web'])[2]");
    private final By webCheckBox = By.xpath("(//*[@class=\"PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3\"])[1]");
    private final By webDropDownBoxAlignmentText = By.xpath("//*[@id=\":rad:-label\"]");
    private final By webDropDownInputText = By.xpath("//*[@id=\":rad:\"]");
    private final By webMarginBottom = By.xpath("//*[@id=\":raf:\"]");
    private final By webMarginRight = By.xpath("//*[@id=\":rag:\"]");
    private final By mobileText = By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1 css-ov0xvz\"])[2]");
    private final By mobileCheckBox = By.xpath("(//*[@class=\"PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3\"])[2]");
    private final By mobileDropDownBoxAlignmentText = By.xpath("//*[@id=\":rah:-label\"]");
    private final By mobileDropDownInputText = By.xpath("//*[@id=\":rah:\"]");
    private final By mobileMarginBottom = By.xpath("//*[@id=\":raj:\"]");
    private final By mobileMarginRight = By.xpath("//*[@id=\":rak:\"]");
    private final By saveCtaButton = By.xpath("//*[normalize-space() = 'Save & View Embed code']");
    private final By previewText1 = By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1 css-1erbx20\"])[1]");
    private final By previewText2 = By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1 css-1erbx20\"])[2]");
    private final By previewText3 = By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1 css-1erbx20\"])[3]");
    private final By previewChatPoweredBy = By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1 css-1erbx20\"])[4]");

    public void checkWhatsAppWidgetFromApps() {
        clickOnElement(apps_from_menu);
        waitForVisibilityOfElement(greeting_and_away);
        scrollToElement(whatsappWidgetTitleFromApps);
        Assert.assertTrue(driver.findElement(whatsappWidgetSubTitleFromApps).getText().contains("Give customers a way to reach you on WhatsApp from your website."));
    }

    public void navigateToWhatsAppWidget() {
        clickOnElement(apps_from_menu);
        clickOnElement(whatsappWidgetTitleFromApps);
        waitForVisibilityOfElement(whatsappWidgetHeader);
    }

    public void checkWhatsAppWidgetScreen() {
        waitForVisibilityOfElement(whatsappWidgetHeader);
        scrollToElement(whatsappWidgetHeader);
        Assert.assertTrue(driver.findElement(whatsappWidgetHeader).getText().contains("Click-to-Chat Button"));
        scrollToElement(whatsappWidgetDesc);
        Assert.assertTrue(driver.findElement(whatsappWidgetDesc).getText().contains("Give customers a way to reach you on WhatsApp, Facebook or Instagram."));
        scrollToElement(chatBubbleSection);
        Assert.assertTrue(driver.findElement(chatBubbleSection).getText().contains("Chat Bubble"));
        scrollToElement(chatHeaderSection);
        Assert.assertTrue(driver.findElement(chatHeaderSection).getText().contains("Chat Header"));
        scrollToElement(welcomeMessageHeader);
        Assert.assertTrue(driver.findElement(welcomeMessageHeader).getText().contains("Welcome Message"));
        scrollToElement(clickToChatButtonHeader);
        Assert.assertTrue(driver.findElement(clickToChatButtonHeader).getText().contains("Click-to-Chat Button"));
        scrollToElement(preFilledMessageHeader);
        Assert.assertTrue(driver.findElement(preFilledMessageHeader).getText().contains("Pre filled message"));
        scrollToElement(positionAndVisibilityHeader);
        Assert.assertTrue(driver.findElement(positionAndVisibilityHeader).getText().contains("Position & Visibility"));
        scrollToElement(saveCtaButton);
        Assert.assertTrue(driver.findElement(saveCtaButton).getText().contains("Save & View Embed code"));
    }
}
