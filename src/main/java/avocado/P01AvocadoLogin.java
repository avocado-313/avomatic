package avocado;

import PageBase.PageBase;
import Utilities.Utilities;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class P01AvocadoLogin extends PageBase {
    public P01AvocadoLogin(WebDriver driver) {
        super(driver);
    }

    private final By input_email = By.xpath("//input[@id='email']");
    private final By input_password = By.xpath("(//input[@id = 'password'])[1]");
    private final By login_to_your_account_label = By.xpath("//*[normalize-space() = 'Login to your account']");
    private final By mottasl_logo = By.xpath("//img[@alt='Azeer']");
    private final By remember_me_label = By.xpath("(//*[@class='MuiStack-root css-1r5to7m'][normalize-space()='Remember me'])");
    private final By login_CTA = By.xpath("(//button[@type='button'][normalize-space()='Login'])");
    private final By forget_password_link = By.xpath("//a[normalize-space()='Forgot Password?']");
    private final By dont_have_an_account_register = By.xpath("//a[normalize-space()='Signup']");
    private final By language = By.xpath("(//img)[2]");
    private final By workspace_dropdown = By.xpath("//input[contains(@class, 'MuiAutocomplete-input')]");
    private final By reset_link = By.xpath("//button[normalize-space() = 'Send Reset Link']");
    private final By forget_password_label = By.xpath("//*[normalize-space()='Reset Password']");
    private final By login_From_forget_password = By.xpath("//a[normalize-space()='Login']");
    private final By avocado_logo_from_home = By.xpath("//img[@alt='avocado icon']");

    //locator for account health popup
    // Popup container (works for Red & Yellow)
    private By accountHealthPopup =
            By.xpath("(//p[contains(.,'Account health is')])[2]");


    // Close icon (top-right ❌)
    private By accountHealthPopupClose =
            By.xpath("(//button[normalize-space()='❌'])[2]");

    //locator for subscription popuo
    // Subscription Expiry popup container
    private By subscriptionExpiryPopup =
            By.xpath("(//p[contains(.,'Your subscription')])[1]");


    // Close button inside Subscription popup
    private By subscriptionExpiryClose =
            By.xpath("(//button[normalize-space()='❌'])[1]");


    public void validateLoginScreenLocators(String email,String password,String workspace) {
        waitForVisibilityOfElement(input_password);
//        waitForTime(6000);
        ElementsValidator(login_to_your_account_label,input_email,input_password,login_CTA,forget_password_link,dont_have_an_account_register,language, remember_me_label);
        validateScreenTexts();
        validateForgetPasswordScreen();
        scrollToElement(input_email);
        sendTextToInputField(email,input_email);
        scrollToElement(input_password);
        sendTextToInputField(password,input_password);
        clickOnElement(input_password);
        waitForVisibilityOfElement(workspace_dropdown);
        ElementsValidator(workspace_dropdown);
        waitForTime(5000);
        driver.findElement(workspace_dropdown).sendKeys(Keys.ARROW_DOWN);
        waitForTime(5000);
        System.out.println("down clicked");
        driver.findElement(By.xpath("//*[normalize-space()='" + workspace+ "']")).click();
        waitForTime(5000);
        clickOnElement(login_CTA);
        waitForVisibilityOfElement(avocado_logo_from_home);
    }
    private Boolean validateElementsTexts(String text , By by){
        scrollToElement(by);
        System.out.println(driver.findElement(by).getText());
        return driver.findElement(by).getText().contains(text);
    }
    private void validateScreenTexts(){
        validateElementsTexts("Sign in to your account",login_to_your_account_label);
        validateElementsTexts("Remember me",remember_me_label);
        validateElementsTexts("Register",dont_have_an_account_register);
        validateElementsTexts("Forgot Password?",forget_password_link);
        validateElementsTexts("Login",login_CTA);

    }

    private void validateForgetPasswordScreen(){
        scrollToElement(forget_password_link);
        clickOnElement(forget_password_link);
        waitForTime(7000);
        Assert.assertTrue(assertElementDisplayed(forget_password_label));
        Assert.assertTrue(assertElementDisplayed(reset_link));
        clickOnElement(login_From_forget_password);
        Assert.assertTrue(assertElementDisplayed(forget_password_link));
    }

    public void loginToAvocado(String email,String password,String workspace){
        waitForVisibilityOfElement(input_password);
        ElementsValidator(login_to_your_account_label,input_email,input_password,login_CTA,forget_password_link,dont_have_an_account_register,language,remember_me_label);
        scrollToElement(input_email);
        sendTextToInputField(email,input_email);
        scrollToElement(input_password);
        sendTextToInputField(password,input_password);
        clickOnElement(input_password);
        waitForTime(10000);
        waitForVisibilityOfElement(workspace_dropdown);
        clickOnElement(workspace_dropdown);
        ElementsValidator(workspace_dropdown);
        waitForTime(5000);
        driver.findElement(workspace_dropdown).sendKeys(Keys.ARROW_DOWN);
        waitForTime(5000);
        System.out.println("down clicked");
        driver.findElement(By.xpath("//*[normalize-space()='" + workspace+ "']")).click();
        waitForTime(7000);
        clickOnElement(login_CTA);
        waitForTime(12000);
        waitForVisibilityOfElement(avocado_logo_from_home);
        Utilities.removeThirdPartyBanners(driver);
        handlePopupsPostLogin();
    }


    private void closePopupWithRetry(
            By popupLocator,
            By closeBtnLocator,
            String popupName,
            int maxRetries
    ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                if (driver.findElements(popupLocator).isEmpty()) {
                    System.out.println(popupName + " popup not present. No action needed.");
                    return;
                }

                WebElement popup = driver.findElement(popupLocator);

                if (!popup.isDisplayed()) {
                    System.out.println(popupName + " popup already hidden.");
                    return;
                }

                System.out.println("Attempt " + attempt + ": Closing " + popupName + " popup");

                WebElement closeBtn = wait.until(
                        ExpectedConditions.elementToBeClickable(closeBtnLocator)
                );

                // 🔑 JS click to bypass overlay & animation
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].click();", closeBtn
                );

                // 🔑 Wait until popup disappears
                wait.until(
                        ExpectedConditions.invisibilityOfElementLocated(popupLocator)
                );

                System.out.println(popupName + " popup closed successfully.");
                return;

            } catch (Exception e) {
                System.out.println(
                        popupName + " popup close failed on attempt "
                                + attempt + ". Retrying..."
                );
                waitForTime(500);
            }
        }

        System.out.println(
                popupName + " popup could not be closed after "
                        + maxRetries + " attempts. Continuing test."
        );
    }
    private void handlePopupsPostLogin() {

        closePopupWithRetry(
                accountHealthPopup,
                accountHealthPopupClose,
                "Account Health",
                5
        );

        closePopupWithRetry(
                subscriptionExpiryPopup,
                subscriptionExpiryClose,
                "Subscription Expiry",
                3
        );
    }







}
