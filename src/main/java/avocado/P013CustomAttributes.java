package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class P013CustomAttributes extends PageBase {
    public P013CustomAttributes(WebDriver driver) {
        super(driver);
    }
    private final By customAttributeTitleFromApps = By.xpath("//*[normalize-space()='Custom Attributes']");
    private final By customAttributeDescFromApps = By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-1ezpj7n'])[6]");
    private final By customAttributeHeader = By.xpath("//*[@data-testid='title']");
    private final By customAttributeDesc = By.xpath("//*[@data-testid='description']");
    private final By backArrow = By.xpath("//*[@data-testid='ArrowBackIosNewRoundedIcon']");
    private final By createCustomAttribute = By.xpath("//*[@data-testid='button-add-new-custom-attribute']");
    private final By xCloseCTA = By.xpath("//*[@data-testid='CloseIcon']");
    private final By displayedNameTitle = By.xpath("(//*[normalize-space()='Display name'])[1]");
    private final By keyTitle = By.xpath("(//*[normalize-space()='Key'])[1]");
    private final By descriptionTitle = By.xpath("//*[normalize-space()='Description']");
    private final By typeTitle = By.xpath("(//*[normalize-space()='Type'])[1]");
    private final By cancelCTA = By.xpath("//*[@data-testid='button-add-new-cancel']");
    private final By addCustom = By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-16pzsl3'])[1]");
    private final By nameInput = By.xpath("//*[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq']");
    private final By descInput = By.xpath("(//*[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMultiline css-u36398'])[1]");
    private final By threeDots = By.xpath("//*[@data-testid='MoreVertIcon']");
    private final By deleteCTA = By.xpath("//*[@data-testid='undefined-1']");
    private final By confirmDelete = By.xpath("//*[@data-testid='deleted-modal-deleted-btn']");

    public void checkCustomAttributesFromApps(){
        clickOnElement(apps_from_menu);
        waitForVisibilityOfElement(greeting_and_away);
        scrollToElement(customAttributeTitleFromApps);
        Assert.assertTrue(driver.findElement(customAttributeDescFromApps).getText().contains("Establish and oversee unique descriptors to enhance the information associated with assets, extending their meaning beyond stand."));
    }
    public void navigateToCustomAttributes(){
        clickOnElement(customAttributeTitleFromApps);
        waitForVisibilityOfElement(customAttributeHeader);
    }
    public void checkCustomAttributesScreen(){
        waitForVisibilityOfElement(customAttributeHeader);
        Assert.assertTrue(driver.findElement(customAttributeHeader).getText().contains("Custom Attributes"));
        Assert.assertTrue(driver.findElement(customAttributeDesc).getText().contains("Establish and oversee unique descriptors to enhance the information associated with assets, extending their meaning beyond stand."));
        Assert.assertTrue(assertElementDisplayed(backArrow));
        Assert.assertTrue(driver.findElement(createCustomAttribute).getText().contains("Add Custom Attribute"));

    }
    public void validateCreateCustomAttributeTemplate(){
        clickOnElement(createCustomAttribute);
        waitForVisibilityOfElement(displayedNameTitle);
        ElementsValidator(typeTitle,keyTitle,descriptionTitle,cancelCTA,xCloseCTA);
    }
    public void fillCreateCustomAttributesTemplate(){
        scrollToElement(nameInput);
        sendTextToInputField("input" + generateRandomDigits(5),nameInput);
        scrollToElement(descInput);
        waitForTime(5000);
        clickOnElement(descInput);
        sendTextToInputField("description" + generateRandomDigits(5),descInput);
        scrollToElement(cancelCTA);
        clickOnElement(addCustom);
    }
    public void deleteCustomAttributes(){
        waitForVisibilityOfElement(threeDots);
        clickOnElement(threeDots);
        clickOnElement(deleteCTA);
        clickOnElement(confirmDelete);

    }

}
