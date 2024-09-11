package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P01AvocadoLogin extends PageBase {
    public P01AvocadoLogin(WebDriver driver) {
        super(driver);
    }

    private final By input_email = By.xpath("(//input[@id=':r0:'])[1]");
    private final By input_password = By.xpath("(//input[@id=':r1:'])[1]");
    private final By sign_into_your_account_label = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-6f19s'])[1]");
    private final By mottasl_logo = By.xpath("//img[@alt='avocado']");
    private final By mottasl_3_label = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-1kq6k1d'])[1]");
    private final By a_trello_product_label = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-u9tiro'])[1]");
    private final By remember_me_label = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-roeert'][normalize-space()='Remember me'])[2]");
    private final By login_CTA = By.xpath("(//button[@type='button'][normalize-space()='Login'])[2]");
    private final By forget_password_link = By.xpath("(//a[@class='MuiTypography-root MuiTypography-body1 css-1s5scvf'][normalize-space()='Forgot Password?'])[2]");
    private final By dont_have_an_account_register = By.xpath("//a[normalize-space()='Register']");
    private final By language = By.xpath("(//img)[2]");
    private final By workspace_dropdown = By.xpath("//input[contains(@class, 'MuiAutocomplete-input')]");
    private final By reset_link = By.xpath("//div[@class='MuiStack-root css-un5fie']");
    private final By forget_password_label = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-6f19s'])[1]");
    private final By login_From_forget_password = By.xpath("//a[normalize-space()='Login']");
    private final By avocado_logo_from_home = By.xpath("//img[@alt='avocado icon']");
    public void validateLoginScreenLocators(String email,String password,String workspace) {
        waitForVisibilityOfElement(input_password);
        ElementsValidator(mottasl_logo,mottasl_3_label,a_trello_product_label,sign_into_your_account_label,input_email,input_password,remember_me_label,login_CTA,forget_password_link,dont_have_an_account_register,language);
        validateScreenTexts();
        validateForgetPasswordScreen();
        validateRegisterScreen();
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
        validateElementsTexts("Sign in to your account",sign_into_your_account_label);
        validateElementsTexts("Mottasl 3.0",mottasl_3_label);
        validateElementsTexts("A Twerlo Product",a_trello_product_label);
        validateElementsTexts("Remember me",remember_me_label);
        validateElementsTexts("Register",dont_have_an_account_register);
        validateElementsTexts("Forgot Password?",forget_password_link);
        validateElementsTexts("Login",login_CTA);

    }

    private void validateForgetPasswordScreen(){
        scrollToElement(forget_password_link);
        clickOnElement(forget_password_link);
        Assert.assertTrue(assertElementDisplayed(forget_password_label));
        Assert.assertTrue(assertElementDisplayed(reset_link));
        clickOnElement(login_From_forget_password);
        Assert.assertTrue(assertElementDisplayed(forget_password_link));
    }
    private final By create_an_account_label = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-6f19s'])[1]");
    private final By create_account_CTA = By.xpath("//div[@aria-hidden='false']//button[@type='button'][normalize-space()='Create Account']");
    private final By login_from_register = By .xpath("//a[normalize-space()='Login']");
    private void validateRegisterScreen(){
        scrollToElement(dont_have_an_account_register);
        clickOnElement(dont_have_an_account_register);
        ElementsValidator(create_an_account_label,create_account_CTA,login_from_register);
        scrollToElement(login_from_register);
        clickOnElement(login_from_register);
        Assert.assertTrue(assertElementDisplayed(dont_have_an_account_register));
    }
    public void loginToAvocado(String email,String password,String workspace){
        waitForVisibilityOfElement(input_password);
        ElementsValidator(mottasl_logo,mottasl_3_label,a_trello_product_label,sign_into_your_account_label,input_email,input_password,remember_me_label,login_CTA,forget_password_link,dont_have_an_account_register,language);
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
        waitForTime(7000);
        clickOnElement(login_CTA);
        waitForVisibilityOfElement(avocado_logo_from_home);
    }
    public void test(){
        System.out.println("nothing!");
    }



}
