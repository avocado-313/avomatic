package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P24WebPhone extends PageBase {
    public P24WebPhone(WebDriver driver) {
        super(driver);
    }

    private final By WebPhoneIcon = By.xpath("//*[@aria-label=\"Web Phone\"]");

    public void checkWebPhoneIcon() {
        waitForVisibilityOfElement(WebPhoneIcon);
        driver.findElement(WebPhoneIcon);
    }
}