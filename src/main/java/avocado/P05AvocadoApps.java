package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class P05AvocadoApps extends PageBase {
    public P05AvocadoApps(WebDriver driver) {
        super(driver);
    }
    private final By apps_from_menu = By.xpath("//a[@aria-label='Apps']//*[name()='svg']");
    private final By greeting_and_away = By.xpath("//p[normalize-space()='Greetings & Away']");
    private final By greeting_title = By.xpath("//*[@data-testid='title']");
    private final By greetings_description = By.xpath("//*[@data-testid='description']");
    private final By greeting_message_arrow = By.xpath("(//*[@data-testid='ExpandMoreIcon'])[2]");
    private final By working_hours_arrow = By.xpath("(//*[@data-testid='ExpandMoreIcon'])[1]");
    private final By greeting_message_title_after_arrow = By.xpath("(//*[@data-testid='label'])[1]");
    private final By greeting_message_toggle = By.xpath("//*[@data-testid='greeting-switch-button']");
    private final By message_input = By.xpath("(//*[@placeholder='Type your message...'])[1]");
    public void navigateToGreetingScreen(){
        scrollToElement(apps_from_menu);
        clickOnElement(apps_from_menu);
        waitForVisibilityOfElement(greeting_and_away);
        scrollToElement(greeting_and_away);
        clickOnElement(greeting_and_away);
    }
    public void validateGreetingsScreen(){
        try {
            waitForVisibilityOfElement(greeting_title);
        }catch (Exception e){
            waitForTime(5000);
            waitForVisibilityOfElement(greeting_title);
        }
        Assert.assertTrue(driver.findElement(greeting_title).getText().contains("Greeting and Away Messages"));
        Assert.assertTrue(driver.findElement(greetings_description).getText().contains("Set your greeting/away messages to be sent to customers inside/outside working hours."));
    }
    public void validateGreetingMessageComponent(){
        scrollToElement(greeting_message_arrow);
        clickOnElement(greeting_message_arrow);
        waitForVisibilityOfElement(greeting_message_title_after_arrow);
        Assert.assertTrue(assertElementDisplayed(greeting_message_title_after_arrow));
    }
    public void sendGreetingMessage(){
        clickOnElement(greeting_message_toggle);
        sendTextToInputField("welcome from Avocado test automation",message_input);
        clickOnElement(By.xpath("(//*[normalize-space()='Save'])[2]"));
    }
    public void setWorkingHours(String starting_hour_AM,String ending_hour_PM){
        clickOnElement(working_hours_arrow);
        waitForVisibilityOfElement(By.xpath("//*[@data-testid='switch-button']"));
        List<WebElement> working_days_toggle = driver.findElements(By.xpath("//*[@data-testid='switch-button']"));
        for(int i = 0 ; i < working_days_toggle.size();i++){
            scrollToElement(By.xpath("(//*[@data-testid='switch-button'])[" +(i+1) + "]"));
            clickOnElement(By.xpath("(//*[@data-testid='switch-button'])[" +(i+1) + "]"));
            clickOnElement(By.xpath("(//*[@data-testid='open-hour'])[" +(i+1) + "]"));
            clickOnElement(By.xpath("(//li[normalize-space()='AM'])[" +1 + "]"));
            scrollToElement(By.xpath("(//li[normalize-space()='" + starting_hour_AM + "'])[1]"));
            clickOnElement(By.xpath("(//li[normalize-space()='" + starting_hour_AM + "'])[1]"));
            scrollToElement(By.xpath("//li[normalize-space()='30']"));
            clickOnElement(By.xpath("//li[normalize-space()='30']"));
            clickOnElement(By.xpath("//p[normalize-space()='Sunday']"));
            clickOnElement(By.xpath("(//*[@data-testid='close-hour'])[" +(i+1) + "]"));
            clickOnElement(By.xpath("(//li[normalize-space()='PM'])[" +1 + "]"));
            scrollToElement(By.xpath("(//li[normalize-space()='" + ending_hour_PM + "'])[1]"));
            clickOnElement(By.xpath("(//li[normalize-space()='" + ending_hour_PM + "'])[1]"));
            scrollToElement(By.xpath("//li[normalize-space()='30']"));
            clickOnElement(By.xpath("//li[normalize-space()='30']"));
            clickOnElement(By.xpath("//p[normalize-space()='Sunday']"));
        }
        clickOnElement(By.xpath("(//*[normalize-space()='Reset'])[1]"));

    }
}
