package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class P013CustomAttributes extends PageBase {
    public P013CustomAttributes(WebDriver driver) {
        super(driver);
    }
    private final By customAttributeTitleFromApps = By.xpath("//*[normalize-space()='Custom Attributes']");
    private final By customAttributeDescFromApps = By.xpath("//p[contains(normalize-space(.), 'Establish and oversee unique descriptors')]");
    private final By customAttributeHeader = By.xpath("//*[@data-testid='title']");
    private final By customAttributeDesc = By.xpath("//*[@data-testid='description']");
    private final By backArrow = By.xpath("//*[@data-testid='ArrowBackIosNewRoundedIcon']");
    private final By createCustomAttribute = By.xpath("//*[@data-testid='button-add-new-custom-attribute']");
    private final By xCloseCTA = By.xpath("//*[@data-testid='CloseIcon']");
    private final By displayedNameTitle = By.xpath("(//*[normalize-space()='Display name'])[1]");
//    private final By keyTitle = By.xpath("(//*[normalize-space()='Key'])[1]");
    private final By descriptionTitle = By.xpath("//*[normalize-space()='Description']");
    private final By typeTitle = By.xpath("(//*[normalize-space()='Type'])[1]");
    private final By cancelCTA = By.xpath("//*[@data-testid='button-add-new-cancel']");
    private final By addCustom = By.xpath("//button[.//div[ contains(text(),'Add Custom Attribute') or contains(text(),'Adding Custom Attribute...') or contains(text(),'Custom Attribute added') or contains(text(),'Error')]]");
    private final By nameInput = By.xpath("//input[@aria-label='custom-attribute-name']");
    private final By descInput = By.xpath("//*[@data-testid='input-add-new-description']");
    private final By threeDots = By.xpath("(//*[@data-testid='actions-button'])[1]");
    private final By deleteCTA = By.xpath("//*[@data-testid='undefined-1']");
    private final By confirmDelete = By.xpath("//*[@data-testid='deleted-modal-deleted-btn']");
    private final By editCTA = By.xpath("//*[@data-testid='undefined-0']");
    private final By editHeader = By.xpath("//*[@data-testid='custom-attribute-header-title']");
    private final By updateCTA = By.xpath("//button[.//div[contains(text(), 'Update') or contains(text(), 'Updated') or contains(text(), 'Updating') or contains(text(), 'Error')]]");
    private final By searchInput = By.xpath("//*[@placeholder='Search Attributes']");

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
        ElementsValidator(typeTitle,descriptionTitle,cancelCTA,xCloseCTA);
    }
    public void fillCreateCustomAttributesTemplate() throws InterruptedException {
        scrollToElement(nameInput);
        sendTextToInputField("input" + generateRandomDigits(5),nameInput);
        scrollToElement(descInput);
        waitForTime(5000);
//        clickOnElement(descInput);
//        sendTextToInputField("description" + generateRandomDigits(5),descInput);
        scrollToElement(cancelCTA);
        clickOnElement(addCustom);
        Thread.sleep(5000);
    }

    public void editAttribute() throws InterruptedException {
        waitForVisibilityOfElement(threeDots, 30);
        clickOnElement(threeDots);
        clickOnElement(editCTA);
        waitForVisibilityOfElement(editHeader,60);
        scrollToElement(nameInput);
        driver.findElement(nameInput).sendKeys(Keys.CONTROL + "a");
        driver.findElement(nameInput).sendKeys(Keys.DELETE);
        sendTextToInputField("test" + generateRandomDigits(5),nameInput);
        clickOnElement(updateCTA);
        Thread.sleep(5000);


    }
    public void searchAttribute() throws InterruptedException {
        waitForVisibilityOfElement(customAttributeHeader);
        sendTextToInputField("test", searchInput);
        Thread.sleep(5000);

    }
    public void deleteCustomAttributes() throws InterruptedException {
        waitForVisibilityOfElement(threeDots, 30);
        clickOnElement(threeDots);
        clickOnElement(deleteCTA);
        clickOnElement(confirmDelete);
        Thread.sleep(5000);

    }

}
