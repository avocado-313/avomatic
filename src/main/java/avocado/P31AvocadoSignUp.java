package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class P31AvocadoSignUp extends PageBase {
    public P31AvocadoSignUp(WebDriver driver) {
        super(driver);
    }

    private final By mottaslLabel = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1kq6k1d']");
    private final By signIntoLabel = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-6f19s']");
    private final By dont_have_an_account_register = By.xpath("//a[normalize-space()='Register']");
    private final By registerLogo= By.xpath("//*[@src='https://assets.avocad0.dev/sdk/mottasl_orange.png']");
    private final By registerLanguage = By.xpath("(//img)[2]");
    private final By registerHeader = By.xpath("//*[normalize-space() = 'Create your free account']");
    private final By registerDesc = By.xpath("//*[normalize-space() = 'No card required. Try mottasl today.']");
    private final By nameInput = By.xpath("(//*[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[1]");
    private final By businessInput = By.xpath("(//*[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[2]");
    private final By emailInput = By.xpath("(//*[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[3]");
    private final By passwordInput = By.xpath("//*[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2']");
    private final By eyeButton = By.xpath("//*[@data-testid='VisibilityIcon']");
    private final By phoneNumber = By.xpath("//*[@name='phoneNumber']");
    private final By signUpCta= By.xpath("//*[normalize-space() = 'Sign up']");
    private final By haveAnAccount = By.xpath("//*[normalize-space() = 'Login']");
    private final By avocado_logo_from_home = By.xpath("//img[@alt='avocado icon']");

    Actions action = new Actions(driver);

    public void validateRegisterScreen(){
        waitForVisibilityOfElement(signIntoLabel);
        scrollToElement(dont_have_an_account_register);
        clickOnElement(dont_have_an_account_register);
        ElementsValidator(registerLogo, registerLanguage, registerHeader, registerDesc, nameInput,businessInput
        , emailInput, passwordInput,eyeButton, phoneNumber, signUpCta, haveAnAccount);
        scrollToElement(haveAnAccount);
        clickOnElement(haveAnAccount);
        Assert.assertTrue(assertElementDisplayed(dont_have_an_account_register));



    }
    public void registerAccount(String pass, String mobile)  {
        waitForVisibilityOfElement(signIntoLabel,30);
        scrollToElement(dont_have_an_account_register);
        clickOnElement(dont_have_an_account_register);
        sendTextToInputField("test" + generateRandomDigits(5), nameInput);
        sendTextToInputField("testBusiness" + generateRandomDigits(3),businessInput);
        sendTextToInputField("test.auto" + generateRandomDigits(4)+"@gmail.com", emailInput);
        sendTextToInputField(pass,passwordInput);
        clickOnElement(eyeButton);
        sendTextToInputField(mobile,phoneNumber);
        action.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        waitForVisibilityOfElement(avocado_logo_from_home);
    }
}
