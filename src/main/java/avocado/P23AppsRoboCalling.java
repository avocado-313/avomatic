package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P23AppsRoboCalling extends PageBase {
    public P23AppsRoboCalling(WebDriver driver) {super(driver);}

    private final By RoboCallingAppText = By.xpath("(//*[normalize-space()='Robo Calling App'])[3]");
    private final By AppsFromMenu = By.xpath("//a[@aria-label='Apps']//*[name()='svg']");
    private final By AppsPageTitle = By.xpath("//*[@data-testid=\"title\"]");

    public void checkRoboCallingAppText(){
        clickOnElement(AppsFromMenu);
        waitForVisibilityOfElement(AppsPageTitle);
        clickOnElement(RoboCallingAppText);
    }

}
