package avocado;

import PageBase.PageBase;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P12RulesPage extends PageBase {
    public P12RulesPage(WebDriver driver) {
        super(driver);
    }
    private final By rulesFromMenu = By.xpath("(//*[normalize-space()='Rules'])[2]");
    private final By rulesIconFromMenu = By.xpath("//*[@data-testid='RuleOutlinedIcon']");
    private final By rulesDescriptionFromMenu = By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-1ezpj7n'])[4]");
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
        driver.findElement(By.xpath("(//*[@data-testid='CloseIcon'])[1]")).click();

    }
    private void scrollAndSendText(By by , String text){
        scrollToElement(by);
        sendTextToInputField(text , by);
    }
}
