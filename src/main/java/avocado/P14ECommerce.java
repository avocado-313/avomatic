package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class P14ECommerce extends PageBase {
    public P14ECommerce(WebDriver driver) {
        super(driver);
    }
    private final By ECommerceIconFromSIdeMenu = By.xpath("//*[@data-testid='ShoppingCartIcon']");
    private final By EcommerceDescription = By.xpath("//*[@data-testid='description']");
    private final By manageYourStoreLabel = By.xpath("//*[normalize-space()='Manage your store']");
    private final By manageCTA = By.xpath("//button[normalize-space()='Manage']");

    public void checkECommerceScreen(){
        clickOnElement(ECommerceIconFromSIdeMenu);
        waitForVisibilityOfElement(ECommerceTitle);
        Assert.assertTrue(driver.findElement(ECommerceTitle).getText().contains("E-commerce Apps"));
        Assert.assertTrue(driver.findElement(EcommerceDescription).getText().contains("Integrate your business with leading e-commerce platforms to streamline your operations"));
        try {
            ElementsValidator(manageCTA, manageYourStoreLabel);
        }catch (Exception e){
            e.getStackTrace();
        }
    }




}
