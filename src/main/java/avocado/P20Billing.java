package avocado;

import PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.testng.*;

import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

public class P20Billing extends PageBase {
    public P20Billing(WebDriver driver) {
        super(driver);
    }
    private final By BillingIconFromSideMenu = By.xpath("//button[@value='Billing']//*[name()='svg']");
    private final By BillingTitle = By.xpath("//*[@data-testid='title']");
    private final By BillingDescription = By.xpath("//*[@data-testid='description']");
    private final By BillingDashboardCTA = By.xpath("//button[normalize-space() = 'Billing Dashboard']");
    private final By DashboardLabel = By.xpath("//*[normalize-space() = 'Subscription Details']");


    public void navigateAndValidateBillingScreen() {
        clickOnElement(BillingIconFromSideMenu);
        waitForVisibilityOfElement(BillingTitle);
        Assert.assertTrue(driver.findElement(BillingTitle).getText().contains("Subscription Management"), "Page title mismatch!");
        Assert.assertTrue(driver.findElement(BillingDescription).getText().contains("Manage and review your subscription and billing details."), "Sub-heading mismatch!");
        try {
            ElementsValidator(BillingDashboardCTA, DashboardLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final By UsageReportTab = By.xpath("//p[normalize-space()='Usage Report']");
    private final By NotificationTab = By.xpath("//p[normalize-space()='Notification Settings']");
    private final By BillingIcon = By.xpath("//*[name()='path' and contains(@d,'M11 21H5c-')]");
    private final By UsageIcon = By.xpath("//*[name()='path' and contains(@d,'M17 4h3v16')]");
    private final By NotificationIcon = By.xpath("//*[name()='path' and contains(@d,'M12 22c1.1')]");
    private final By CreditStatus = By.xpath("//p[normalize-space()='Credit Status']");
    private final By CurrentSubscriptionPlan = By.xpath("//*[normalize-space()='Current Subscription Plan']");
    private final By SubscriptionPlan = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-1du7yop'])[1]");
    private final By RenwalPlan = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-1du7yop'])[2]");
    private final By Invoices = By.xpath("//p[normalize-space()='Invoices']");
    private final By SearchInvoice = By.xpath("//input[@placeholder='Search invoices']");
    private final By InvoiceSort = By.xpath("//div[normalize-space()='Newest']");
    private final By InvoiceStatus = By.xpath("//div[normalize-space()='All']");
    private final By AddCredit = By.xpath("//button[normalize-space()='Add Credit']");
    private final By AddCreditHeading = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-g5ppc8']");
    private final By AddCreditSubHeading = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1e17j98']");
    private final By DebitCreditOption = By.xpath("//p[normalize-space()='Debit/Credit Cards']");
    private final By DebitCreditOptionDescription = By.xpath("//p[contains(text(),'Empower your business operations with our platform')]");
    private final By BankTransferOption = By.xpath("//p[normalize-space()='Bank Transfer']");
    private final By BankTransferOptionDescription = By.xpath("//p[contains(text(),'Streamline your payments with our easy online bank')]");
    private final By TransferAccepted = By.xpath("//p[normalize-space() = '(All Bank Transfers Accepted)']");
    private final By OnlineDebitCredit = By.xpath("(//input[@type='radio'])[1]");
    private final By AddFundDescription = By.xpath("//p[@data-testid='modal-title']//following::p[@data-testid='modal-subtitle']");
    private final By EnterCredit = By.xpath("//p[normalize-space()='Enter credit']");
    private final By CreditName = By.xpath("//p[normalize-space()='Credit']");
    private final By FundOpt1 = By.xpath("//button[normalize-space()='20']");
    private final By FundOpt2 = By.xpath("//button[normalize-space()='50']");
    private final By FundOpt3 = By.xpath("//button[normalize-space()='100']");
    private final By FundOpt4 = By.xpath("//button[normalize-space()='200']");
    private final By FundOpt5 = By.xpath("//button[normalize-space()='500']");
    private final By VatInfo = By.xpath("//p[normalize-space()='VAT Information']");
    private final By VatInfoDescription = By.xpath("//p[contains(text(),'15% VAT will be applied to the selected amount. Fo')]");
    private final By UsageCredits = By.xpath("//p[normalize-space()='Usage Credits']");
    private final By UsageCreditsDescription = By.xpath("//p[contains(text(),'These are the credits you are purchasing to use ac')]");
    private final By PaymentlinkText = By.xpath("//p[normalize-space()='Payment link']");
    private final By PaymentLinkIcon = By.xpath("//div[@class='MuiStack-root css-b2jard']//*[name()='svg']");
    private final By PaymentLinkDescription = By.xpath("//p[contains(text(),'Link is active for 48 hours. You can pay now or la')]");
    private final By AmountTest = By.xpath("//p[normalize-space()='Amount']");
    private final By AmountValue = By.xpath("//p[normalize-space()='20.00 USD']");
    private final By LinkText = By.xpath("//p[normalize-space()='Link']");
    private final By CopyLinkText = By.xpath("//div[@class='MuiStack-root css-1r5to7m']//p[@class='MuiTypography-root MuiTypography-body1 css-1u8csdu'][normalize-space()='Copy']");
    private final By PayNowCTA = By.xpath("//button[normalize-space()='Pay now']");
    private final By PayLaterCTA = By.xpath("//button[normalize-space()='Pay later']");
    private final By invoiceNotfunded = By.xpath("//tbody/tr[1]/td[8]/div[1]/span[1]");


    public void checkBillingDashboard() {
        ElementsValidator(BillingDashboardCTA, UsageReportTab, NotificationTab, UsageIcon, NotificationIcon, CreditStatus, AddCredit, CurrentSubscriptionPlan, SubscriptionPlan,
                RenwalPlan, Invoices, SearchInvoice, InvoiceSort, InvoiceStatus);
    }

    public void testBillingDashboardVisibleAndClickable() {
        waitForTime(2000);
        waitForVisibilityOfElement(BillingDashboardCTA);
        checkBillingDashboard();
        waitForTime(20000);
        waitForVisibilityOfElement(BillingIcon);
        Assert.assertTrue(assertElementDisplayed(BillingIcon), "Billing icon should be visible");
        Assert.assertTrue(assertElementDisplayed(BillingDashboardCTA), "Billing Dashboard should be visible.");
        Assert.assertTrue(assertElementEnabled(BillingDashboardCTA), "Billing Dashboard should be clickable.");
        clickOnElement(BillingDashboardCTA);
        Assert.assertTrue(assertElementDisplayed(DashboardLabel), "Subscription Details dashboard should be visible");
    }


    private final By InvoiceId = By.xpath("//td[normalize-space()='INV-000443']");

    public void validateInvoiceSearch() {
        waitForTime(3000);
        scrollToElement(SearchInvoice);
        waitForVisibilityOfElement(SearchInvoice);
        waitForTime(1000);
        clickOnElement(SearchInvoice);
        sendTextToInputField("INV-000443", SearchInvoice);
        waitForVisibilityOfElement(InvoiceId);
        scrollToElement(InvoiceId);
        waitForTime(2000);
        assertElementDisplayed(By.xpath("//th[normalize-space() ='Invoice ID']"));
        assertElementDisplayed(InvoiceId);
        clickOnElement(SearchInvoice);
        waitForTime(2000);
        driver.findElement(SearchInvoice).sendKeys(Keys.CONTROL + "a");
        driver.findElement(SearchInvoice).sendKeys(Keys.BACK_SPACE);
        waitForTime(3000);

    }

    public void validateInvoiceSort() {
        scrollToElement(InvoiceSort);
        clickOnElement(InvoiceSort);
        waitForTime(2000);
        assertElementDisplayed(By.xpath("//li[normalize-space()='Oldest']"));
        assertElementDisplayed(By.xpath("//li[normalize-space()='Newest']"));
        clickOnElement(By.xpath("//li[normalize-space()='Newest']"));
        scrollToElement(By.xpath("//li[normalize-space()='Newest']"));
        scrollToElement(By.xpath("//th[normalize-space()='Date']"));
        try {
            sortedNewList();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


  public void sortedNewList() throws ParseException {
      // Extract all displayed dates
      List<WebElement> dateElements = driver.findElements(By.xpath("(//table/tbody/tr/td[2])[2]"));

      List<Date> extractedDates = new ArrayList<>();
      SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");

      for (WebElement element : dateElements) {
          String dateText = element.getText().trim();

          // Validate if the text is a valid date before parsing
          if (isValidDate(dateText, dateFormat)) {
              try {
                  Date date = dateFormat.parse(dateText);
                  extractedDates.add(date);
              } catch (ParseException e) {
                  System.out.println("Skipping invalid date entry (ParseException): " + dateText);
              }
          } else {
              System.out.println("Skipping non-date entry: " + dateText);
          }
      }

      // Check if dates are sorted in descending order
      List<Date> sortedDates = new ArrayList<>(extractedDates);
      Collections.sort(sortedDates, Collections.reverseOrder()); // Sorting in descending order

      if (extractedDates.equals(sortedDates)) {
          System.out.println("Validation Passed: Dates are sorted from newest to oldest.");
      } else {
          System.out.println("Validation Failed: Dates are NOT sorted correctly.");
      }
  }


    private boolean isValidDate(String dateStr, SimpleDateFormat dateFormat) {
        try {
            dateFormat.setLenient(false);
            dateFormat.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public void validateInvoiceStatus() {
        waitForVisibilityOfElement(InvoiceStatus);
        scrollToElement(InvoiceStatus);
        waitForTime(2000);
        clickOnElement(InvoiceStatus);
        waitForTime(2000);
        assertElementDisplayed(By.xpath("//li[normalize-space()='All']"));
        assertElementNotDisplayed(By.xpath("//li[normalize-space()='Not Funded']"));
        assertElementNotDisplayed(By.xpath("//li[normalize-space()='Funded']"));
        assertElementDisplayed(By.xpath("//li[normalize-space()='Cancelled']"));
        assertElementDisplayed(By.xpath("//li[normalize-space()='On Hold']"));
        assertElementDisplayed(By.xpath("//li[normalize-space()='Failed']"));
        waitForTime(3000);
        invoiceDopdownStatus();
    }


    public void invoiceDopdownStatus() {
        clickOnElement(By.xpath("//li[normalize-space()='Not Funded']"));
        waitForVisibilityOfElement(invoiceNotfunded);
        scrollToElement(invoiceNotfunded);
        waitForTime(3000);
        assertElementDisplayed(invoiceNotfunded);
    }



    // Online payment flow starts from here

    public void checkAddCreditPopUp(){
        ElementsValidator(AddCreditHeading, AddCreditSubHeading, DebitCreditOption, DebitCreditOptionDescription,BankTransferOption,BankTransferOptionDescription,
                TransferAccepted);

    }


    public void checkaddFundPopUp() {
        List<By> elements = Arrays.asList(
                AddFundpopup, AddFundDescription, EnterCredit, CreditName,
                FundOpt1, FundOpt2, FundOpt3, FundOpt4, FundOpt5,
                VatInfo, VatInfoDescription, UsageCredits, UsageCreditsDescription
        );

        for (By element : elements) {
            int attempts = 0;
            while (attempts < 3) { // Retry up to 3 times
                try {
                    if (assertElementDisplayed(element)) {
                        System.out.println("Element is visible: " + element);
                        break;
                    }
                } catch (StaleElementReferenceException e) {
                    System.out.println("Attempt " + (attempts + 1) + ": Element is stale, retrying...");
                    attempts++;
                }
            }
        }
    }



    public void checkPaymentPopUp(){
        ElementsValidator(PaymentlinkText, PaymentLinkIcon , PaymentLinkDescription,AmountTest,
                AmountValue, LinkText, CopyLinkText, PayNowCTA, PayLaterCTA );
    }



    private final By FatooraCardHolderName = By.xpath("//input[@id='cardholdername']");
    private final By FatooraCardNumber = By.xpath("//input[@id='cardnumber']");
    private final By FatooraMonthYear = By.xpath("//input[@id='expirationdate']");
    private final By FatooraCVV = By.xpath("//input[@id='securitycode']");
    private final By FatooraPayNowCTA = By.xpath("//div[@class='card-no-container align-center card-bottom-container']//following::button[@type='button']");
    private final By PaymentSubmit = By.xpath("//input[@value='Submit']");
    private final By DeleteIconPaymentLinks = By.xpath("//tbody//tr//td//button[@type='button']//*[name()='svg']");
    private final By DeleteButtonCTAPaymentLinks = By.xpath("//span[normalize-space()='Delete link']");
    private final By UsageReportSection = By.xpath("//p[normalize-space()='Usage Reports']");
    private final By YearDropdownFilter = By.xpath("//div[@role='combobox']");
    private final By StartingBalanceCard = By.xpath("//p[normalize-space()='Starting Balance']");
    private final By TopUpCard = By.xpath("//p[normalize-space()='Top-up']");
    private final By UsageCreditCard = By.xpath("//p[normalize-space()='Usage Credits']");
    private final By EndingBalanceCard = By.xpath("//p[normalize-space()='Ending Balance']");
    private final By TopUPDropdown = By.xpath("(//*[name()='svg'][@focusable='false'])[5]");
    private final By UsageCreditDropDown = By.xpath("(//*[name()='svg'][@focusable='false'])[6]");
    private final By UsageDetail = By.xpath("//p[normalize-space()='Usage Details']");
    private final By UsageDetailDescp = By.xpath("//p[normalize-space()='Know your complete usage report here']");
    private final By AgentSection = By.xpath("//p[normalize-space()='Fair Use Charges - Agents']");
    private final By TeamSection = By.xpath("//p[normalize-space()='Fair Use Charges - Teams']");
    private final By APICallsSection = By.xpath("//p[normalize-space()='Fair Use Charges - API Calls']");
    private final By Conversationcharges = By.xpath("//p[normalize-space()='Conversation Charges']");
    private final By FairUseConversation = By.xpath("//p[normalize-space()='Fair Use Conversation Charges']");
    private final By NotoficationHeading = (By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1ayun90']"));
    private final By NotificationDescp = By.xpath("//p[contains(text(),'Set up alerts and manage notification preferences ')]");
    private final By AddBalanceNotify = By.xpath("//input[@type='number']");
    private final By AddEmailNotify = By.xpath("//*[@type='email']");
    private final By SaveSettingCTA = By.xpath("//div[@class='MuiStack-root css-1o97oe']/span[text()='Save Settings']");
    private final By errorMessage = By.xpath("//p[normalize-space()='Limit is required']");
    private final By EmailErrorMessage = By.xpath("//p[normalize-space()='Email is required']");


    public void myfatooraInvoice(String text, String no, String date, String num){
        clickOnElement(PayNowCTA);
        switchToWindowByIndex(2);
        try {
            waitForVisibilityOfElement(By.xpath("//p[normalize-space()='How would you like to pay?']"));
            waitForTime(1000);
        }catch (Exception e){
            e.getStackTrace();
        }
        clickOnElement(FatooraCardHolderName);
        sendTextToInputField(text, FatooraCardHolderName);
        clickOnElement(FatooraCardNumber);
        sendTextToInputField(String.valueOf(no), FatooraCardNumber);
        clickOnElement(FatooraMonthYear);
        sendTextToInputField(date,FatooraMonthYear);
        clickOnElement(FatooraCVV);
        sendTextToInputField(String.valueOf(num), FatooraCVV);
        clickOnElement(FatooraPayNowCTA);
        waitForTime(10000);

        // Switch to outer iframe first
        WebElement outerIframe = driver.findElement(By.xpath("//iframe[@title='3D Secure']"));
        driver.switchTo().frame(outerIframe);

        // Now switch to the inner iframe
        WebElement iframe = driver.findElement(By.xpath("//iframe[@name='redirectTo3ds1Frame']"));
        driver.switchTo().frame(iframe);
        System.out.println("Switched to iframe successfully!");
        clickOnElement(PaymentSubmit);
        waitForTime(2000);
        switchToOrginalTab();

    }

    private final By AddFundpopup = By.xpath("//div[@role='presentation']//div[@role='presentation']/..//p[@data-testid='modal-title']");


    public void onlinePaymentFlow(){

        clickOnElement(AddCredit);
        waitForInVisibilityOfElement(OnlineDebitCredit);
        checkAddCreditPopUp();
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        assertElementDisplayed(AddFundpopup);
        checkaddFundPopUp();
        waitForTime(5000);
        waitForVisibilityOfElement(FundOpt1);

        try {
            WebElement element = driver.findElement(By.xpath("//button[normalize-space()='20']"));
            element.click();
        } catch (StaleElementReferenceException e) {
            WebElement element = driver.findElement(By.xpath("//button[normalize-space()='20']")); // Re-locate the element
            element.click();
        }

        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        waitForTime(3000);
        checkPaymentPopUp();

    }


    public void onlinePaymentPayNowflow(){
        onlinePaymentFlow();
        myfatooraInvoice( " test test", "5453010000095539", "12/25", "300" );
    }


    public void onlinePaymentPayLaterFlow(){
        onlinePaymentFlow();
        waitForTime(3000);
        clickOnElement(PayLaterCTA);
        scrollToElement(By.xpath("//span[normalize-space()='Pending']"));
        assertElementDisplayed(By.xpath("//span[normalize-space()='Pending']"));
        assertElementEnabled(By.xpath("//tbody/tr/td[6]/div[1]//following::p[normalize-space()='Pay now']"));
    }



    public void deletePaymenticon() {
        clickOnElement(DeleteIconPaymentLinks);
        assertElementNotDisplayed(By.xpath("//p[@data-testid='modal-title']"));
//        assertElementDisplayed(By.xpath("//p[@data-testid='modal-subtitle']"));
        assertElementDisplayed(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-gm1lhg']//following::p[@class='MuiTypography-root MuiTypography-body1 css-fyl6am']"));
        clickOnElement(DeleteButtonCTAPaymentLinks);
        assertElementNotDisplayed(By.xpath("//p[normalize-space()='Payment links']"));
    }


    public void checkdeleteicon() {

        By deleteIconLocator = DeleteIconPaymentLinks;
        
        if (isElementPresent(driver, deleteIconLocator)) {
            deletePaymenticon();
            waitForTime(3000);
            System.out.println("Delete icon found and clicked.");
        } else {
            System.out.println("Delete icon not found. Proceeding to the next step...");
        }
        waitForTime(5000);

    }
    private boolean isElementPresent(WebDriver driver, By locator) {

        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    //********************* Usage Report Tab ****************************


    public void checkUsageReport() {
        clickOnElement(UsageReportTab);
        waitForTime(2000);
        ElementsValidator(UsageReportSection, YearDropdownFilter, StartingBalanceCard , TopUpCard , UsageCreditCard , EndingBalanceCard,TopUPDropdown,UsageCreditDropDown);
    }


    public void checkTopUPCard() {
        clickOnElement(TopUPDropdown);
        assertElementDisplayed(By.xpath("//p[@data-testid='modal-title'][normalize-space()='Top-up']"));
        assertElementDisplayed(By.xpath("//p[normalize-space()='Know your complete Top-up report here']"));
        assertElementDisplayed(By.xpath("//p[normalize-space()='Top-Up Logs']"));
    }


    public void checkUsageCreditCard() {
        clickOnElement(UsageCreditDropDown);
        ElementsValidator(UsageDetail, UsageDetailDescp, AgentSection, TeamSection, APICallsSection,Conversationcharges, FairUseConversation);

    }


    public void checkNotification(String email) {
        clickOnElement(NotificationTab);
        waitForVisibilityOfElement(NotoficationHeading);
        assertElementDisplayed(NotoficationHeading);
        assertElementDisplayed(NotificationDescp);
        waitForTime(2000);
        clickOnElement(AddBalanceNotify);
        waitForTime(1000);
        jsclearInputfiels(AddBalanceNotify);
        sendTextToInputField(generateRandomDigits(2), AddBalanceNotify);
        clickOnElement(AddEmailNotify);
        waitForTime(1000);
        jsclearInputfiels(AddEmailNotify);
        sendTextToInputField(email, AddEmailNotify);
        waitForTime(2000);
        clickOnElement(SaveSettingCTA);

    }


    public void checkNotificationEmpty(){
        clickOnElement(NotificationTab);
        waitForVisibilityOfElement(NotoficationHeading);
        clickOnElement(AddBalanceNotify);
        sendTextToInputField("test", AddBalanceNotify);
        waitForTime(1000);
        jsclearInputfiels(AddBalanceNotify);
        waitForTime(2000);
        driver.findElement(AddBalanceNotify).sendKeys(Keys.TAB);
        waitForTime(2000);
        waitForVisibilityOfElement(errorMessage);
        assertElementDisplayed((errorMessage));
        System.out.println(driver.findElement(errorMessage).getText());
        Assert.assertEquals(driver.findElement( errorMessage).getText(), "Limit is required", "Error message mismatch!");

        clickOnElement(AddEmailNotify);
        driver.findElement(AddEmailNotify).sendKeys(Keys.CONTROL + "a");
        driver.findElement(AddEmailNotify).sendKeys(Keys.BACK_SPACE);
        waitForTime(2000);
        driver.findElement(AddEmailNotify).sendKeys(Keys.TAB);
        waitForTime(2000);
        waitForVisibilityOfElement(EmailErrorMessage);
        assertElementDisplayed((EmailErrorMessage));
        System.out.println(driver.findElement(EmailErrorMessage).getText());
        Assert.assertEquals(driver.findElement( EmailErrorMessage).getText(), "Email is required", "Error message mismatch!");
        waitForTime(2000);
        assertElementNotDisplayed(SaveSettingCTA);

    }

}
