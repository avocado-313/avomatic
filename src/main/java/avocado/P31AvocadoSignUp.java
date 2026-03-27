package avocado;

import PageBase.PageBase;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import jakarta.mail.*;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.search.FlagTerm;

import java.util.*;


import java.util.regex.Matcher;
import java.util.regex.Pattern;




import java.time.Duration;

public class P31AvocadoSignUp extends PageBase {
    public P31AvocadoSignUp(WebDriver driver) {
        super(driver);
    }

    private final By mottaslLabel = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1kq6k1d']");
    private final By signIntoLabel = By.xpath("//*[normalize-space() = 'Login to your account']");
    private final By dont_have_an_account_register = By.xpath("//a[normalize-space()='Signup']");
    private final By mottaslLogo= By.xpath("//img[@alt='Azeer']");
    private final By registerLanguage = By.xpath("(//img)[2]");
    private final By errormessage = By.xpath("//p[@class='MuiFormHelperText-root MuiFormHelperText-sizeMedium MuiFormHelperText-contained css-19iu1dn']");
    private final By registerHeader = By.xpath("//*[normalize-space() = 'Create your free account']");
    private final By registerDesc = By.xpath("//*[normalize-space() = 'No card required. Try mottasl today.']");
    private final By nameInput = By.xpath("//input[@id='full_name']");
    private final By businessInput = By.xpath("//input[@id='display_name']");
    private final By emailInput = By.xpath("(//input[@id='email'])[1]");
    private final By passwordInput = By.xpath("//input[@id='platform_credentials']");
    private final By confirmPasswordInput = By.xpath("//input[@id='confirm_password']");
    private final By eyeButton = By.xpath("(//*[@data-testid='VisibilityIcon'])[1]");
    private final By phoneNumber = By.xpath("//*[@id='tel-phone']");
    private final By signUpCta= By.xpath("//button[.//div[text()='Sign up']]");
    private final By haveAnAccount = By.xpath("(//*[normalize-space() = 'Login'])[1]");
    private final By now_and_later_cta = By.xpath("//*[normalize-space()='Login now and verify later']");
    private final  By emailBanner = By.xpath("(//*[normalize-space() = 'Please confirm your email address to complete the signup process'])[1]");
    private final By avocado_logo_from_home = By.xpath("//img[@alt='avocado icon']");
    private final By input_email = By.xpath("(//input[@id='email'])[2]");
    private final By input_password = By.xpath("(//input[@id = 'password'])[1]");
    private final By workspace_dropdown = By.xpath("//input[contains(@class, 'MuiAutocomplete-input')]");
    private final By login_CTA = By.xpath("(//button[@type='button'][normalize-space()='Login'])");
    private final By mailIcon = By.xpath("//*[@src='https://assets.avocad0.dev/sdk/envelope-open-fill.svg']");
    private final By first_and_login_cta = By.xpath("//*[normalize-space()='Verify first and Login']");


    Actions action = new Actions(driver);

    public void validateRegisterScreen()  {
        waitForVisibilityOfElement(signIntoLabel);
        scrollToElement(dont_have_an_account_register);
        clickOnElement(dont_have_an_account_register);
        waitForTime(10000);
        ElementsValidator(mottaslLogo, registerLanguage, registerHeader, registerDesc, nameInput,businessInput
        , emailInput, passwordInput,confirmPasswordInput,eyeButton, phoneNumber, signUpCta, haveAnAccount);
//        testEmailAlreadyExistValidation("tech@avocad0.dev", "tech@123", "8874023329");
        clickOnElement(haveAnAccount);





    }
    public void registerAccount_withoutVerification(String pass,String confirmPass, String mobile) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        waitForVisibilityOfElement(signIntoLabel,30);
        scrollToElement(dont_have_an_account_register);
        clickOnElement(dont_have_an_account_register);
        sendTextToInputField("test" + generateRandomDigits(5), nameInput);
        sendTextToInputField("testBusiness" + generateRandomDigits(3),businessInput);
        sendTextToInputField("test.auto" + generateRandomDigits(4)+"@gmail.com", emailInput);
        sendTextToInputField(pass,passwordInput);
        clickOnElement(eyeButton);
        sendTextToInputField(confirmPass, confirmPasswordInput);

        sendTextToInputField(mobile,phoneNumber);
        clickOnElement(signUpCta);

// wait for page
        By verifyHeader = By.xpath("//*[contains(text(),'Please verify your email')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyHeader));

// button handling
        By btnLocator = now_and_later_cta;

        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(btnLocator));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", btn);

        btn = wait.until(ExpectedConditions.elementToBeClickable(btnLocator));

        try {
            btn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        }
        waitForVisibilityOfElement(avocado_logo_from_home);


    }


    private void email_verify_Screen() {
        waitForVisibilityOfElement(mottaslLogo, 30);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            WebElement verifyLabelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[normalize-space()='Please verify your email']")));

            WebElement verifyDescriptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[contains(@class,'MuiTypography-root') and contains(text(),'verify your email')]")));

            WebElement firstAndLoginCTA = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[normalize-space()='Verify first and Login']")));

            WebElement nowAndLaterCTA = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[normalize-space()='Login now and verify later']")));

            // Assertions
            Assert.assertTrue(verifyLabelElement.isDisplayed());
            Assert.assertTrue(verifyDescriptionElement.isDisplayed());
            Assert.assertTrue(firstAndLoginCTA.isDisplayed());
            Assert.assertTrue(nowAndLaterCTA.isDisplayed());

        } catch (TimeoutException e) {
            System.out.println("---- ERROR: Element not found. Printing page source for debug ----");
            System.out.println(driver.getPageSource());
            throw e;
        }
    }


    private final By alreadyExist_LoginCTA = By.xpath("(//a[@href='/login?tab=1'])[1]");

    private void testEmailAlreadyExistValidation(String email, String pass, String mobile) {
        sendTextToInputField("test" + generateRandomDigits(5), nameInput);
        sendTextToInputField("testBusiness" + generateRandomDigits(3), businessInput);
        sendTextToInputField(email, emailInput);
        sendTextToInputField(pass, passwordInput);
        clickOnElement(eyeButton);
        sendTextToInputField(mobile, phoneNumber);

        waitForTime(3000);
        clickOnElement(signUpCta);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45)); // CI can be slow

        try {
            // Flexible, case-insensitive XPath
            By errorLocator = By.xpath("//*[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'email already')]");

            // Wait for presence first (element exists in DOM)
            wait.until(ExpectedConditions.presenceOfElementLocated(errorLocator));

            // Wait for visibility (element displayed)
            WebElement errormessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));

            Assert.assertTrue(errormessage.isDisplayed(), "Error message is not displayed!");
            Assert.assertTrue(errormessage.getText().toLowerCase().contains("email already"),
                    "Error message text mismatch!");

            scrollToElement(alreadyExist_LoginCTA);
            clickOnElement(alreadyExist_LoginCTA);
            Assert.assertTrue(assertElementDisplayed(dont_have_an_account_register));

        } catch (TimeoutException e) {
            System.out.println("---- ERROR: Element not found in CI. Printing page source ----");
            System.out.println(driver.getPageSource());
            throw e;
        }
    }








    Actions actions = new Actions(driver);






    public void registerAccount_withVerifyNow(String pass, String phone) {
        try {
            // Gmail config
            String baseEmail = "testing181097@gmail.com";
            String testAlias = "testing181097+" + generateRandomDigits(5) + "@gmail.com";
            String appPassword = "cmyb beyt czrq djby";
            String host = "imap.gmail.com";

            // STEP 1: Connect to mailbox and clean old emails
            Properties props = new Properties();
            props.put("mail.store.protocol", "imaps");
            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect(host, baseEmail, appPassword);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);

            Message[] oldMessages = inbox.getMessages();
            for (Message msg : oldMessages) {
                msg.setFlag(Flags.Flag.DELETED, true);
            }
            inbox.close(true); // expunge deletes
            store.close();

            // STEP 2: Sign up with alias email
            waitForVisibilityOfElement(signIntoLabel, 30);
            scrollToElement(dont_have_an_account_register);
            clickOnElement(dont_have_an_account_register);
            sendTextToInputField("test" + generateRandomDigits(5), nameInput);
            sendTextToInputField("testBusiness" + generateRandomDigits(3), businessInput);
            sendTextToInputField(testAlias, emailInput);
            sendTextToInputField(pass, passwordInput);
            clickOnElement(eyeButton);
            sendTextToInputField(phone, phoneNumber);
            action.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
            waitForTime(10000);
            waitForVisibilityOfElement(mailIcon);
            clickOnElement(first_and_login_cta);

            // STEP 3: Reconnect to mailbox to fetch the new email
            store = session.getStore("imaps");
            store.connect(host, baseEmail, appPassword);
            inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);

            int maxRetries = 6;
            int waitBetweenRetries = 10000;
            Message latestEmail = null;

            for (int i = 0; i < maxRetries; i++) {
                FlagTerm unseenFlagTerm = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
                Message[] messages = inbox.search(unseenFlagTerm);

                if (messages.length > 0) {
                    latestEmail = messages[messages.length - 1];
                    System.out.println("Email found on attempt " + (i + 1));
                    break;
                } else {
                    System.out.println("No email yet... retrying in 10 seconds...");
                    Thread.sleep(waitBetweenRetries);
                }
            }

            if (latestEmail == null) {
                throw new Exception("No new verification email received after retries.");
            }

            // STEP 4: Parse verification link
            Object contentObject = latestEmail.getContent();
            String content = "";

            if (contentObject instanceof Multipart) {
                Multipart multipart = (Multipart) contentObject;
                for (int i = 0; i < multipart.getCount(); i++) {
                    BodyPart bodyPart = multipart.getBodyPart(i);
                    if (bodyPart.isMimeType("text/html")) {
                        content = (String) bodyPart.getContent();
                        break;
                    }
                }
            } else {
                content = contentObject.toString();
            }

            Pattern linkPattern = Pattern.compile("https://test\\.api\\.avocad0\\.dev/v1/auth/verify\\?[^\"'>\\s]+");
            Matcher matcher = linkPattern.matcher(content);
            String verificationLink = null;
            if (matcher.find()) {
                verificationLink = matcher.group(0).replace("&amp;", "&");

                // Remove the closing </a> if it exists
                if (verificationLink.endsWith("</a")) {
                    verificationLink = verificationLink.substring(0, verificationLink.length() - 3); // Remove last 3 characters
                }

                System.out.println("Found verification link: " + verificationLink);
            } else {
                throw new Exception("No verification link found in the email.");
            }

            inbox.close(false);
            store.close();

            // STEP 5: Open the verification link in browser
            driver.get(verificationLink);
            waitForTime(10000);

            // Assert redirected URL
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("test.app.avocad0.dev"), "Should redirect to the app after verification");

            // STEP 6: Wait for redirect to login screen
            waitForVisibilityOfElement(signIntoLabel, 30); // update locator as needed

            // STEP 7: Log in using same email & password
            sendTextToInputField(testAlias, input_email);
            sendTextToInputField(pass, input_password);
            clickOnElement(input_password);
            waitForVisibilityOfElement(workspace_dropdown);
            ElementsValidator(workspace_dropdown);
            waitForTime(3000);
            driver.findElement(workspace_dropdown).sendKeys(Keys.ARROW_DOWN);
            waitForTime(3000);
            actions.pause(Duration.ofSeconds(5)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            waitForTime(3000);
            clickOnElement(login_CTA);
            waitForTime(5000);

            // STEP 8: Verify banner is not visible
            List<WebElement> banners = driver.findElements(By.xpath("//p[contains(text(),'Please confirm your email address')]"));
            Assert.assertTrue(banners.isEmpty(), "Email banner should NOT be visible after verification.");
            System.out.println("Verification of email is done");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Email verification failed: " + e.getMessage());
        }
    }



}

