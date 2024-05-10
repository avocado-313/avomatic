package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Set;


import java.util.List;

public class P07AvocadoMedia extends PageBase {
    public P07AvocadoMedia(WebDriver driver) {
        super(driver);
    }

    private final By media_icon_from_label = By.xpath("//a[@aria-label='Media Library']//*[name()='svg']");
    private final By media_library_title = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-1hxh1sq'])[1]");
    private final By upload_media = By.xpath("//input[@type='file']");
    private final By caption_input = By.xpath("(//input[@type='text'])[3]");
    private final By upload_media_CTA = By.xpath("//button[normalize-space()='Upload']");
    private final By all_tab = By.xpath("//*[normalize-space()='All']");
    private final By three_dots_action_btn = By.xpath("//button[@data-testid='actions-button']");
    private final By delete_video = By.xpath("//button[normalize-space()='Delete']");
    private final By confirm_delete_msg = By.xpath("//*[@data-testid='delete-confirm-title']");
    private final By size_warning_logo = By.xpath("//*[@data-testid='WarningAmberRoundedIcon']");
    private final By search_icon = By.xpath("(//*[@data-testid='SearchIcon'])[2]");
    private final By search_input = By.xpath("//input[@placeholder='Search']");
    private final By list_view = By.xpath("//button[@data-testid='button-list-view']");
    private final By grid_view = By.xpath("//button[@data-testid='button-grid-view']");
    private final By apps_title = By.xpath("//*[normalize-space()='Apps']");
    private final By backArrow = By.xpath("//*[@data-testid='ArrowBackIosNewRoundedIcon']");
    private final By download = By.xpath("(//*[@class='text-white hover:!text-red-500 cursor-pointer'])[1]");
    private final By share_CTA = By.xpath("(//*[@class='text-white hover:!text-red-500 cursor-pointer'])[2]");
    private final By close_media_CTa = By.xpath("(//*[@class='text-white hover:!text-red-500 cursor-pointer'])[3]");
    private final By copied_Label = By.xpath("//*[normalize-space()='Copied']");
    private final By first_Date = By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-1a31dtv'])[2]");
    private final By second_Date = By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-1a31dtv'])[4]");
    private final By oldest_selection = By.xpath("(//*[normalize-space()='Oldest'])[1]");
    private final By latest_selection = By.xpath("(//*[normalize-space()='Latest'])[1]");
    private final By sortBy = By.id("sort-by-label");

    String currentDir = System.getProperty("user.dir");
    String oneMbFileName = "1mb.mp4";
    String tenMbFileName = "10mb.mp4";
    String documentName = "pdf.pdf";
    String imageName = "avocad0.jpg";
    String audioName = "audio.mp3";
    String file_path = currentDir + "//images//";

    public void validateUploadMediaFunctionality() {
        uploadMedia("Images", "Video", "Documents", "Audio");
        Assert.assertTrue(driver.findElement(all_tab).getAttribute("aria-selected").equalsIgnoreCase("true"));
        validateTabsSwitching("Images", "Audio", "Video", "Documents", "All");
    }

    public void validateMediaDeletedSuccessfully(String fileName) {
        scrollToElement(three_dots_action_btn);
        waitForTime(5000);
        clickOnelement(three_dots_action_btn);
        waitForVisibilityOfElement(delete_video);
        clickOnelement(delete_video);
        waitForVisibilityOfElement(confirm_delete_msg);
        Assert.assertTrue(assertElementDisplayed(confirm_delete_msg));
        Assert.assertTrue(driver.findElement(confirm_delete_msg).getText().contains(fileName));
        driver.findElement(By.xpath("//button[@data-testid='deleted-modal-deleted-btn']")).click();
        System.out.println("media deleted successfully.....");
    }

    public void validateMediaAcceptsLessThan10MbFiles() {
        clickOnelement(media_icon_from_label);
        waitForVisibilityOfElement(media_library_title);
        driver.findElement(upload_media).sendKeys(file_path + tenMbFileName);
        waitForVisibilityOfElement(size_warning_logo);
        Assert.assertTrue(assertElementDisplayed(By.xpath("//*[normalize-space()='The size of this file is more than 10MB']")));
        clickOnelement(By.xpath("(//*[normalize-space()='Cancel'])[2]"));
    }

    private void validateSearchFunctionality(String search) {
        scrollToElement(search_icon);
        sendTextToInputField(search, search_input);
        waitForTime(5000);
        waitForVisibilityOfElement(By.xpath("//*[@role='img']"));
        Assert.assertTrue(assertElementDisplayed(By.xpath("//*[normalize-space()='" + search + "']")));
    }

    private void validateGridAndListView() {
        if (driver.findElement(grid_view).getAttribute("aria-pressed").contains("true")) {
            clickOnelement(list_view);
            waitForVisibilityOfElement(By.xpath("//*[normalize-space()='Created by']"));
            Assert.assertTrue(assertElementDisplayed(By.xpath("//*[normalize-space()='Created by']")));
            Assert.assertTrue(assertElementDisplayed(By.xpath("//*[normalize-space()='Created at']")));
            List<WebElement> created_by = driver.findElements(By.xpath("//*[normalize-space()='Created by']"));
            List<WebElement> created_at = driver.findElements(By.xpath("//*[normalize-space()='Created at']"));
            Assert.assertEquals(created_by.size(), created_at.size());

        }
    }

    private void validateTabsSwitching(String... texts) {
        for (String text : texts) {
            By elem = By.xpath("//*[normalize-space()='" + text + "']");
            clickOnelement(elem);
            waitForTime(1000);
            Assert.assertTrue(driver.findElement(elem).getAttribute("aria-selected").equalsIgnoreCase("true"));
        }
    }

    public void validateNavigateBackFromMediaToApps() {
        scrollToElement(backArrow);
        clickOnelement(backArrow);
        waitForVisibilityOfElement(apps_title);
    }

    public void validateMedia(By media) {
        clickOnelement(media);
        waitForVisibilityOfElement(download);
        clickOnelement(share_CTA);
        waitForVisibilityOfElement(copied_Label);
        clickOnelement(download);
        waitForTime(5000);
        String originalWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                Assert.assertTrue(driver.getCurrentUrl().contains("download"));
                driver.close();
                driver.switchTo().window(originalWindow);
                waitForVisibilityOfElement(share_CTA);
                System.out.println("navigating back to original screen...");
                clickOnelement(close_media_CTa);
                waitForVisibilityOfElement(media_library_title);

            }


        }
    }

    private void uploadMedia(String... medias) {
        for (String media : medias) {
            clickOnelement(media_icon_from_label);
            waitForVisibilityOfElement(media_library_title);
            switch (media) {
                case "Video":
                    genericMediaSelection(media, oneMbFileName);
                    break;
                case "Documents":
                    genericMediaSelection(media, documentName);
                    break;
                case "Images":
                    genericMediaSelection(media, imageName);
                    break;
                case "Audio":
                    genericMediaSelection(media, audioName);
                    break;
                default:
                    System.out.println("can't find media!");
                    break;

            }
            validateTabsSwitching("All");
        }
    }

    private void genericMediaSelection(String media, String file_name) {
        driver.findElement(upload_media).sendKeys(file_path + file_name);
        waitForVisibilityOfElement(caption_input);
        sendTextToInputField("first " + media + "uploaded", caption_input);
        clickOnelement(upload_media_CTA);
        waitForTime(18000);
        validateTabsSwitching(media);
        validateMedia(By.xpath("//*[@role='img']"));
        validateGridAndListView();
        if (media.equalsIgnoreCase("Images")) validateSortingFunctionality();
        validateSearchFunctionality(file_name);
        validateMediaDeletedSuccessfully(file_name);
        waitForTime(5000);
        driver.findElement(search_input).clear();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER);
        driver.navigate().refresh();
        waitForTime(3000);
    }

    public  boolean compareDates(String dateStr1, String dateStr2) {
        String[] possibleFormats = {
                "MMM dd, yyyy . hh:mm a",
                "MM/dd/yyyy hh:mm:ss a",
                "yyyy-MM-dd HH:mm:ss"
        };

        for (String format : possibleFormats) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            try {
                Date date1 = dateFormat.parse(dateStr1);
                Date date2 = dateFormat.parse(dateStr2);
                return date1.after(date2);
            } catch (ParseException e) {
                System.out.println(e.getStackTrace());
            }
        }

        return false;

    }





    private void validateSortingFunctionality() {
        clickOnelement(sortBy);
        clickOnelement(latest_selection);
        scrollToElement(first_Date);
        waitForTime(5000);
        try {
            Assert.assertTrue(compareDates(driver.findElement(first_Date).getText(), driver.findElement(second_Date).getText()));
        }catch (Exception e){
            System.out.println(e);
        }
        scrollToElement(sortBy);
        clickOnelement(oldest_selection);
        waitForTime(10000);
        scrollToElement(first_Date);
        Assert.assertFalse(compareDates(driver.findElement(first_Date).getText(), driver.findElement(second_Date).getText()));
        System.out.println("here we validated sorting functionality");

    }


}
