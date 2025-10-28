package avocado;

import PageBase.PageBase;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class P12RulesPage extends PageBase {
    public P12RulesPage(WebDriver driver) {
        super(driver);
    }
    private final By rulesFromMenu = By.xpath("(//*[normalize-space()='Rules'])[2]");
    private final By rulesIconFromMenu = By.xpath("//*[@data-testid='RuleOutlinedIcon']");
    private final By rulesDescriptionFromMenu = By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-cc9b9l'])[4]");
    private final By createNewRules = By.xpath("(//*[@data-testid='create-rule-button'])[1]");
    private final By rulesDescriptionFromRules = By.xpath("//*[@data-testid='description']");
//    private final By rulesTitleFromTitle = By.xpath("//*[normalize-space()='Rules']");
    private final By backArrowFromRules = By.xpath("//*[@data-testid='ArrowBackIosNewRoundedIcon']");
    private final By Active = By.xpath("//*[normalize-space()='Active']");
    private final By Disabled = By.xpath("//*[normalize-space()='Disabled']");
    private final By modalTitle = By.xpath("//*[@data-testid='modal-title']");
    private final By modalSubTitle = By.xpath("//*[@data-testid='modal-subtitle']");
    private final By ruleNameInput = By.xpath("(//*[@type='text'])[2]");
    private final By rulesDescriptionInput = By.xpath("(//*[@type='text'])[3]");
    private final By ifTextBox = By.xpath("//*[@aria-label='if-textbox']");
    private final By selectTagDropdown = By.xpath("//*[@data-testid='then-actions-item-rhs-select-tag']");
    private final By closeModalView = By.xpath("//*[@data-testid='CloseIcon']");
    private final By cancel = By.xpath("//*[normalize-space()='Cancel']");
    private final By chevrons = By.xpath("//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium MuiSelect-icon MuiSelect-iconOutlined css-16pr791']");
    String dropdown = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium MuiSelect-icon MuiSelect-iconOutlined css-16pr791'])[";
    private final By textInMessage = By.xpath("//*[normalize-space()='Text in Message']");
    private final By equalTo = By.xpath("//*[normalize-space()='Equal to']");
    private final By createNEwRuleCTA = By.xpath("//*[normalize-space()='Create New Rule']");
    private final By createNEwRuleCTA1 = By.xpath("(//*[normalize-space()='Create New Rule'])[2]");
    private final By rules_Channel = By.xpath("//*[@data-testid='channel-input']");
    private final By thenLabel = By.xpath("//*[normalize-space() = 'Then']");

    private final By action_Button = By.xpath("(//*[@data-testid='actions-button'])[1]");
    private final By delete_CTA = By.xpath("//*[@data-testid='active-rules-action-labels-button-1']");
    private final By deleteTitle = By.xpath("//*[@data-testid='delete-confirm-title']");
    private final By confirmDelete = By.xpath("//*[@data-testid='deleted-modal-deleted-btn']");


    public void checkRulesFromApp(){
        clickOnElement(apps_from_menu);
        waitForVisibilityOfElement(greeting_and_away);
        scrollToElement(rulesFromMenu);
        Assert.assertTrue(driver.findElement(rulesDescriptionFromMenu).getText().contains("Establish rules for both incoming and outgoing messages. Let our rules engine simplify your life, automating workflows so you can dedicate time to what truly matters."));
        Assert.assertTrue(assertElementDisplayed(rulesIconFromMenu));

    }
    public void navigateToRules(){
        clickOnElement(apps_from_menu);
        waitForVisibilityOfElement(greeting_and_away);
        scrollToElement(rulesFromMenu);
        clickOnElement(rulesFromMenu);
//        waitForVisibilityOfElement(rulesTitleFromTitle);
        waitForTime(5000);
    }
    public void checkCreateRulesScreen(){
        ElementsValidator(backArrowFromRules,createNewRules,rulesDescriptionFromRules, Active,Disabled);
//        Assert.assertTrue(driver.findElement(rulesTitleFromTitle).getText().contains("Rules"));
        Assert.assertTrue(driver.findElement(rulesDescriptionFromRules).getText().contains("Automatically take actions on events in your workspace"));

    }

    public void checkCreateRuleModalElements(){
        clickOnElement(createNewRules);
        waitForVisibilityOfElement(modalTitle);
        Assert.assertTrue(driver.findElement(modalTitle).getText().contains("Create New Rule"));
        Assert.assertTrue(driver.findElement(modalSubTitle).getText().contains("Manage team by renaming it, change its description and adding or removing of team members."));
        waitForTime(5000);
        ElementsValidator(ruleNameInput,rulesDescriptionInput,ifTextBox);
        for(int i = 0 ; i < driver.findElements(chevrons).size();i++){
            ElementsValidator(By.xpath("(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium MuiSelect-icon MuiSelect-iconOutlined css-16pr791'])[" + (i+1) + "]"));
        }
        ElementsValidator(selectTagDropdown);
        scrollToElement(cancel);
        clickOnElement(cancel);
        waitForVisibilityOfElement(createNewRules);

    }


    public void createNewRule(){
        clickOnElement(createNewRules);
        waitForVisibilityOfElement(modalTitle);
        scrollAndSendText(ruleNameInput,"ruleTitle");
        scrollAndSendText(rulesDescriptionInput,"rule description");
//        scrollToElement((By.xpath(dropdown + "1]")));
//        waitForTime(2000);
//        driver.findElement(By.xpath(dropdown + "1]")).click();
//        waitForTime(2000);
//        driver.findElement(textInMessage).click();
//        waitForTime(2000);
//        scrollToElement((By.xpath(dropdown + "2]")));
//        waitForTime(2000);
//        clickOnElement(By.xpath(dropdown + "2]"));
//        waitForTime(2000);
//        driver.findElement(equalTo).click();
//        waitForTime(2000);
        scrollToElement(createNEwRuleCTA);
        driver.findElement(By.xpath("//*[@data-testid='create-rule-modal-close-button']")).click();

    }
    private void scrollAndSendText(By by , String text){
        scrollToElement(by);
        sendTextToInputField(text , by);
    }

    public void newRuleCreation(String agent){
        clickOnElement(createNewRules);
        waitForVisibilityOfElement(modalTitle);
        scrollAndSendText(ruleNameInput, generateRandomDigits(5));
        scrollAndSendText(rulesDescriptionInput, generateRandomDigits(6));
        Assert.assertTrue(driver.findElement(rules_Channel).getText().contains("WhatsApp"));
        By whenDropdown = By.xpath("//*[@data-testid='select-when-triggers-items-lhs']");
        clickOnElement(whenDropdown);
        // When condition
        By whenOption = By.xpath("//li[contains(text(), 'Incoming Message')]");
        clickOnElement(whenOption);
        By inDropdown = By.xpath("//*[@data-testid='select-when-triggers-items-rhs']");
        clickOnElement(inDropdown);
        By inOption = By.xpath("//li[contains(text(), 'Closed Chat')]");
        clickOnElement(inOption);
        scrollToElement(ifTextBox);
        By ifDropdown = By.xpath("//*[@data-testid='if-condition-lhs']");
        clickOnElement(ifDropdown);
        action.pause(Duration.ofSeconds(5)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        By operatorDropdoon = By.xpath("//*[@data-testid='if-conditions-operators']");
        clickOnElement(operatorDropdoon);
        By operatorOption = By.xpath("//li[contains(text(), 'Equal to')]");
        clickOnElement(operatorOption);
        By condDropdown = By.xpath("//*[@data-testid='If-conditions-rhs-message-types']");
        clickOnElement(condDropdown);
        By condOption = By.xpath("//li[contains(text(), 'Text')]");
        clickOnElement(condOption);
        scrollToElement(thenLabel);
        By thenDropdown = By.xpath("//*[@data-testid='then-action-item-lhs']");
        clickOnElement(thenDropdown);
        By thenOption = By.xpath("//li[contains(text(), 'Assign Chat')]");
        clickOnElement(thenOption);
        waitForTime(2000);
        By inputAgent = By.xpath("//*[@placeholder='Select Agent']");
        scrollAndSendText(inputAgent, agent);
        driver.findElement(inputAgent).sendKeys(Keys.ARROW_UP);
//        driver.findElement(inputAgent).sendKeys(Keys.ARROW_UP);
        driver.findElement(inputAgent).sendKeys(Keys.ENTER);

//        action.pause(Duration.ofSeconds(10)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);

        waitForTime(2000);
        scrollToElement(createNEwRuleCTA1);
        clickOnElement(createNEwRuleCTA1);
        waitForTime(2000);
//        Assert.assertTrue(driver.findElement());





    }


    public void deleteRule(){
        waitForVisibilityOfElement(action_Button);
        clickOnElement(action_Button);
        clickOnElement(delete_CTA);
        waitForVisibilityOfElement(deleteTitle);
        clickOnElement(confirmDelete);
        waitForTime(2000);
    }

    Actions action = new Actions(driver);
}
