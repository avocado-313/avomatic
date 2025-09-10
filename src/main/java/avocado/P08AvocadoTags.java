package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class P08AvocadoTags extends PageBase {
    public P08AvocadoTags(WebDriver driver) {
        super(driver);
    }
    private final By apps_from_menu = By.xpath("//a[@aria-label='Apps']//*[name()='svg']");
    private final By tags_icon = By.xpath("//*[@data-testid='LabelOutlinedIcon']");
    private final By tags_from_apps = By.xpath("//a[@href='/apps/tags']");
    private final By tags_description_from_apps = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-cc9b9l'])[7]");
    private final By back_CTA_from_tags_Screen = By.xpath("//button[@data-testid='back-button']");
    private final By tags_description = By.xpath("//*[@data-testid='description']");
    private final By grid_view = By.xpath("(//*[@data-testid='button-grid-view'])[1]");
    private final By Add_new_tag = By.xpath("//button[@type='button' and normalize-space()='Add New Tag']");
    private final By x_close_Tags_screen = By.xpath("//*[@data-testid='CloseIcon']");
    private final By greeting_and_away = By.xpath("//p[normalize-space()='Greetings & Away']");
    private final By tags_title = By.xpath("//*[@data-testid='title-description-container']");
    private final By add_tag_from_tags_card = By.xpath("(//span[normalize-space()='Add Tag'])[1]");
    private final By tags_name_input = By.xpath("//input[@aria-label='tags-name']");
    private final By tags_description_input = By.xpath("//textarea[@aria-label='tags-descriptions']");
    private final By color_text = By.xpath("//*[@data-testid='create-tags-modal-selector-title']");
    private final By select_color_CTA = By.xpath("//*[@data-testid='button-add-new-tag-color']");
    private final By three_dots = By.xpath("//*[@data-testid='MoreHorizIcon']");
    private final By delete_from_three_dots = By.xpath("//button[@data-testid='undefined-2']");
    private final By confirm_delete = By.xpath("//button[@data-testid='deleted-modal-deleted-btn']");
    private final By edit_tag = By.xpath("//button[normalize-space() = 'Edit']");
    private final By update_tag_CTA = By.xpath("//span[normalize-space()='Update Tag']");
    private final By search_tag = By.xpath("//*[@placeholder='Search Tags']");


    public void validateTagsFromApps(){
        clickOnElement(apps_from_menu);
        waitForVisibilityOfElement(greeting_and_away);
        scrollToElement(tags_icon);
        Assert.assertTrue(driver.findElement(tags_from_apps).getText().contains("Tags"));
        Assert.assertTrue(driver.findElement(tags_description_from_apps).getText().contains("Classify & Associate customers based on their attributes using ‘tags’. Segregate & organize different categories of your customer base effectively."));
        clickOnElement(tags_from_apps);
        Assert.assertTrue(assertElementDisplayed(back_CTA_from_tags_Screen));
    }
    public void validateTagsScreen() throws InterruptedException {
        validateTagsFromApps();
        clickOnElement(back_CTA_from_tags_Screen);

        // ensure tag icon is visible and navigate back to Tags
        Assert.assertTrue(assertElementDisplayed(tags_icon));
        scrollToElement(tags_icon);
        clickOnElement(tags_from_apps);

        // wait for the page title to appear
        waitForVisibilityOfElement(tags_title);
        Thread.sleep(8000);
        clickOnElement(tags_description);

        // elements to validate with retry-on-stale logic
        By[] elements = new By[]{
                tags_description,
                tags_title,
                Add_new_tag

        };

        for (By element : elements) {
            int attempts = 0;
            boolean visible = false;
            while (attempts < 3) { // Retry up to 3 times
                try {
                    if (assertElementDisplayed(element)) {
                        System.out.println("Element is visible: " + element);
                        visible = true;
                        break;
                    }
                } catch (org.openqa.selenium.StaleElementReferenceException e) {
                    System.out.println("Attempt " + (attempts + 1) + ": Element is stale, retrying... (" + element + ")");
                } catch (Exception e) {
                    System.out.println("Attempt " + (attempts + 1) + ": Exception while checking element " + element + " - " + e.getMessage());
                }

                attempts++;
                // small pause before retrying to allow DOM to stabilize
                waitForTime(1000);
            }

            if (!visible) {
                Assert.fail("Element not visible after retries: " + element);
            }
        }

        // existing content checks (kept for clarity)
        Assert.assertTrue(driver.findElement(tags_description).getText().contains("Create and Manage Tags here"));
        Assert.assertTrue(driver.findElement(tags_title).getText().contains("Tags"));
        Assert.assertTrue(driver.findElement(Add_new_tag).getText().contains("Add New Tag"));

        // open Add New Tag and verify close button appears
        clickOnElement(Add_new_tag);
        Assert.assertTrue(assertElementDisplayed(x_close_Tags_screen));
    }

    private By selectColor(){
        List<WebElement>bts = driver.findElements(By.xpath("//button[@tabindex='0']"));
        System.out.println("(//button[@tabindex='0'])[" + (bts.size() - generateIntRandomDigits(1) ) + "]");
        return By.xpath("(//button[@tabindex='0'])[" + (bts.size() - generateIntRandomDigits(1) ) + "]");
    }
    public void validateTagCreation(){
        String name = "Tags " +generateRandomDigits(5);
        String desc = "Description  " +generateRandomDigits(5);
        sendTextToInputField(name,tags_name_input);
        sendTextToInputField(desc,tags_description_input);
        Assert.assertTrue(assertElementDisplayed(color_text));
        waitForTime(5000);
        clickOnElement(select_color_CTA);
        By color = selectColor();
        scrollToElement(color);
        waitForTime(2000);
        clickOnElement(color);
        clickOnElement(add_tag_from_tags_card);
//        validateTagCardAfterCreation(name,desc);

    }
    private void validateTagCardAfterCreation(String name , String description){
        waitForVisibilityOfElement(three_dots);
        Assert.assertTrue(assertElementDisplayed(By.xpath("//p[normalize-space()='" + name + "']")));

    }
    public void validateDeleteTag(){
        waitForTime(3000);
        waitForVisibilityOfElement(three_dots);
        clickOnElement(three_dots);
        waitForTime(2000);
        waitForVisibilityOfElement(delete_from_three_dots);
        clickOnElement(delete_from_three_dots);
        waitForVisibilityOfElement(confirm_delete);
        clickOnElement(confirm_delete);
    }
    public void checkNavigateBackFromTags(){
        clickOnElement(back_CTA_from_tags_Screen);
        Assert.assertTrue(assertElementDisplayed(tags_icon));
    }

    public void validateEditTag() throws InterruptedException {
        Thread.sleep(5000);
        waitForVisibilityOfElement(three_dots);
        clickOnElement(three_dots);
        waitForTime(2000);
        waitForVisibilityOfElement(edit_tag);
        clickOnElement(edit_tag);
        clickOnElement(tags_description_input);
        jsclearInputfiels(tags_description_input);
        waitForTime(2000);
        String edit_desc = "Edit  " +generateRandomDigits(5);
        sendTextToInputField(edit_desc,tags_description_input);
        Assert.assertTrue(assertElementDisplayed(color_text));
        waitForTime(5000);
        clickOnElement(select_color_CTA);
        By color = selectColor();
        scrollToElement(color);
        waitForTime(2000);
        clickOnElement(color);
        clickOnElement(update_tag_CTA);
    }

    public void validateTagsSearch(){
        validateTagsFromApps();
        clickOnElement(search_tag);
        sendTextToInputField("Tags",search_tag);
        Assert.assertTrue(assertElementDisplayed(three_dots));
    }

}
