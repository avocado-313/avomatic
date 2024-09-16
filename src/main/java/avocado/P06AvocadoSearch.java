package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class P06AvocadoSearch extends PageBase {
    public P06AvocadoSearch(WebDriver driver) {
        super(driver);
    }
    private final By search_icon_from_menu = By.xpath("//div[@aria-label='Search']//*[name()='svg']");
    private final By search_title = By.xpath("(//h5[normalize-space()='Search'])[1]");
    private final By x_close = By.xpath("//*[@data-testid='search-close-icon']");
    private final By new_chat_icon = By.xpath("//button[normalize-space()='+ New Chat']");
    private final By phrase_outside_search_container = By.xpath("//p[normalize-space()='Please select one contact from the chats sidebar.']");
    private final By message_tab_title = By.xpath("//p[normalize-space()='Messages']");
    private final By contact_tab_title = By.xpath("//p[normalize-space()='Contacts']");
    private final By contact_tab_icon = By.xpath("(//*[name()='path'])[15]");
    private final By message_tab_icon = By.xpath("(//*[name()='path'])[14]");
    private final By search_icon_into_input_search = By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-16ecze4'])[2]");
    private final By search_input = By.xpath("//input[@placeholder='Search chats']");
    private final By direction_dropdown = By.xpath("//input[@placeholder='Direction']");
    private final By direction_dropdown_arrow = By.xpath("(//*[@data-testid='ArrowDropDownIcon'])[1]");
    private final By incoming_from_direction = By.xpath("//*[normalize-space()='Incoming']");
    private final By outgoing_from_direction = By.xpath("//*[normalize-space()='Outgoing']");
    private final By message_type_dropdown = By.xpath("//input[@placeholder='Message type']");
    private final By message_type_dropdown_arrow = By.xpath("(//*[@data-testid='ArrowDropDownIcon'])[2]");
    private final By text_from_message_type_dropdown = By.xpath("//*[normalize-space()='Text']");
    private final By image_from_message_type_dropdown = By.xpath("//*[normalize-space()='Image']");
    private final By video_from_message_type_dropdown = By.xpath("//*[normalize-space()='Video']");
    private final By document_from_message_type_dropdown = By.xpath("//*[normalize-space()='Document']");
    private final By last_activity = By.xpath("(//*[normalize-space()='Last activity'])[1]");
    private final By last_activity_dropdown = By.xpath("(//*[@data-testid='ArrowDropDownIcon'])[3]");
    private final By calender_title = By.xpath("//*[@role='presentation' and @class='rdp-caption_label']");
    private final By chats_from_contacts = By.xpath("//input[@placeholder='Chat status']");
    private final By Tags_from_contacts = By.xpath("(//*[normalize-space()='Tags'])[1]");
    private final By Last_activity_from_contacts = By.xpath("(//*[normalize-space()='Last activity'])[1]");
    private final By Assigned_to_from_contacts = By.xpath("//input[@placeholder='Assigned to']");



    public void validateSearchXClose(){
        clickOnElement(search_icon_from_menu);
        waitForVisibilityOfElement(search_title);
        waitForVisibilityOfElement(x_close);
        clickOnElement(x_close);
        waitForTime(5000);
    }
    public void validateSearchClosedOnceClickingOutsideSearchContainer(){
        clickOnElement(search_icon_from_menu);
        clickOnElement(search_icon_from_menu);
        waitForVisibilityOfElement(search_title);
        waitForVisibilityOfElement(x_close);
        WebElement elem = driver.findElement(phrase_outside_search_container).findElement(By.xpath("..")).findElement(By.xpath(".."));
        new Actions(driver).moveToElement(elem).moveByOffset(38, 24).click().perform();
        waitForVisibilityOfElement(new_chat_icon);
    }
    public void validateSearchScreen(){
        clickOnElement(search_icon_from_menu);
        waitForVisibilityOfElement(search_title);
        waitForTime(5000);
        ElementsValidator(message_tab_icon,message_tab_title,contact_tab_icon,contact_tab_title,search_icon_into_input_search);
    }
    public void validateMessageTab(){
        validateDirectionDropdown();
        validateMessageTypeDropdown();
    }
    private void validateDirectionDropdown(){
        waitForVisibilityOfElement(direction_dropdown);
        selectOptions(1,incoming_from_direction,outgoing_from_direction);
        clickOnElement(direction_dropdown_arrow);
        waitForVisibilityOfElement(incoming_from_direction);
        ElementsValidator(incoming_from_direction,outgoing_from_direction);

    }
    private void validateMessageTypeDropdown(){
        waitForVisibilityOfElement(message_type_dropdown);
        clickOnElement(message_type_dropdown_arrow);
        waitForVisibilityOfElement(text_from_message_type_dropdown);
        ElementsValidator(text_from_message_type_dropdown,image_from_message_type_dropdown,video_from_message_type_dropdown);
//        selectOptions(2,text_from_message_type_dropdown,image_from_message_type_dropdown,video_from_message_type_dropdown,document_from_message_type_dropdown);
    }
    public void validateLastActivity(){
        waitForVisibilityOfElement(last_activity);
        clickOnElement(last_activity_dropdown);
        waitForVisibilityOfElement(calender_title);
        clickOnElement(By.xpath("//button[@name='previous-month']"));
        clickOnElement(By.xpath("(//button[@name='day'])[1]"));
        clickOnElement(By.xpath("(//button[@name='day'])[10]"));
        clickOnElement(By.xpath("(//*[normalize-space()='Search'])[4]"));

    }
    private void selectOptions(int elm,By... elements ){
        By arrow  = By.xpath("(//*[@data-testid='ArrowDropDownIcon'])[" + elm + "]");
        waitForVisibilityOfElement(arrow);
        for (By element : elements) {
            if(elm<=1) clickOnElement(arrow);
            scrollToElement(element);
            clickOnElement(element);
            if(elm<=1)driver.findElement(By.xpath("(//*[@data-testid='CloseIcon'])[1]")).click();
        }

    }
    public void validateContactsTab(){
        clickOnElement(contact_tab_title);
        waitForVisibilityOfElement(chats_from_contacts);
        ElementsValidator(chats_from_contacts,Tags_from_contacts,Last_activity_from_contacts,Assigned_to_from_contacts);
        clickOnElement(message_tab_title);
    }

}
