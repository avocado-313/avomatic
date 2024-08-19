package PageBase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageBase {
    public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }
    private final By logout_icon_from_settings = By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[8]");
    private final By input_email = By.xpath("(//input[@id=':r0:'])[1]");
    private final By profile_icon_from_menu = By.xpath("//button[@aria-label='Profile']");
    private final By logout_dropdown_from_settings = By.xpath("//p[normalize-space()='Logout']");
    public final By apps_from_menu = By.xpath("//a[@aria-label='Apps']//*[name()='svg']");
    public final By greeting_and_away = By.xpath("//p[normalize-space()='Greetings & Away']");
    public void logout(){
        Actions actions = new Actions(driver);
        waitForTime(6000);
        driver.navigate().to("https://test.app.avocad0.dev/settings/account/profile");
        try {
            clickOnElement(logout_dropdown_from_settings);
        }catch (Exception e){
            refreshDriver(driver.getCurrentUrl(), profile_icon_from_menu);
            waitForTime(25000);
            clickOnElement(logout_dropdown_from_settings);
        }
        Assert.assertTrue(assertElementDisplayed(input_email));
    }

    public void clickOnElement(By by) {
        waitForVisibilityOfElement(by);
        driver.findElement(by).click();

    }

    public void submitElement(By by) {
        waitForVisibilityOfElement(by);
        driver.findElement(by).submit();

    }

    public void waitForVisibilityOfElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitForVisibilityOfWebElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForInVisibilityOfElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public Boolean assertElementDisplayed(By by) {
        waitForVisibilityOfElement(by);
        return driver.findElement(by).isDisplayed();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public void scrollToElement(By element) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", driver.findElement(element));
    }

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500);");
    }

    public void scrollToEndOfScreen() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }


    public Boolean checkLocalizationByReference(By by, String Eng, String arb, By reference, String ReferenceEnglishText) {
        if (driver.findElement(reference).getText().contains(ReferenceEnglishText)) {
            driver.findElement(reference).getText();
            return driver.findElement(by).getText().contains(Eng);
        } else {
            driver.findElement(reference).getText();
            return driver.findElement(by).getText().contains(arb);
        }


    }



    public void clickOnElementUsingJavaScript(By by) {
        waitForVisibilityOfElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].dispatchEvent(new Event('click'));", driver.findElement(by));
        System.out.println("element clicked using JS");
    }

    public void sendTextToInputField(String text, By by) {
        waitForVisibilityOfElement(by);
        clearInputField(by);
        driver.findElement(by).sendKeys(text);
    }


    public void sendTextWithotClear(String text, By by) {
        waitForVisibilityOfElement(by);
        driver.findElement(by).sendKeys(text);
    }

    public void clearInputField(By by) {
        driver.findElement(by).clear();
    }

    public void doubleClickOnAnElement(By by) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(by)).perform();
    }

    public void validateErrorMessage(By inputField, By secondInput, By Message) {
        scrollToElement(inputField);
        clickOnElement(inputField);
        clickOnElement(secondInput);
        Assert.assertTrue(assertElementDisplayed(Message));
    }

    public void clickOnElementIdUsingJS(String id) {
        WebElement CheckboxElement = driver.findElement(By.id(id));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", CheckboxElement);
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void clickOnElementXpathUsingJS(String xpath) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.getStackTrace();
        }
        WebElement svgElement = driver.findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", svgElement);
    }

    public void selectByIndexFromDropDownList(By by, String index) {
        WebElement selectElement = driver.findElement(by);
        Select select = new Select(selectElement);
        select.selectByIndex(Integer.parseInt(index));
    }

    public void sendKeysWithJs(By by, String text) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value = arguments[1];", driver.findElement(by), text);
    }

    public String generateRandomNumber() {
        Random random = new Random();

        // First digit can be 0, 1, 2, or 5
        int firstDigit = random.nextInt(3);  // Generates a random number between 0 and 2
        String formattedNumber = String.valueOf(firstDigit);

        // Rest of the digits (8 digits in total)
        for (int i = 0; i < 8; i++) {
            int digit = random.nextInt(10);  // Generates a random number between 0 and 9
            formattedNumber += digit;
        }
        System.out.println("+201" + formattedNumber);

        return "1" + formattedNumber;
    }


    public static String generateRandomDigits(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length should be greater than 0");
        }

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Generates a random digit (0 to 9)
            stringBuilder.append(digit);
        }

        return stringBuilder.toString();
    }
    public static int generateIntRandomDigits(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length should be greater than 0");
        }

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Generates a random digit (0 to 9)
            stringBuilder.append(digit);
        }

        return Integer.parseInt(stringBuilder.toString());
    }




    public int extractAndConvertToInt(String input) {
        String[] parts = input.split("\\D+");

        for (String part : parts) {
            if (!part.isEmpty()) {
                try {
                    return Integer.parseInt(part);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Part is not a valid integer.");
                    return 0;
                }
            }
        }
        System.err.println("Error: No numeric value found in the input.");
        return 0;
    }

    public int getCurrentHour() {
        LocalTime currentTime = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
        String formattedHour = currentTime.format(formatter);
        int currentHour = Integer.parseInt(formattedHour);
        System.out.println(currentHour);
        return currentHour;
    }

    public int nextDay() {
        LocalDate today = LocalDate.now();
        LocalDate nextDay = today.plusDays(1);
        int nextDayAsInt = nextDay.getDayOfMonth();
        System.out.println("Next day as an integer: " + nextDayAsInt);
        return nextDayAsInt;
    }

    public double extractNumber(String input) {
        Pattern pattern = Pattern.compile("\\n([\\d.]+) SAR");
        Matcher matcher = pattern.matcher(input);

        // Find the first match in the input text
        if (matcher.find()) {
            // Extract the matched value and convert it to a double
            String matchedValue = matcher.group(1);
            return Double.parseDouble(matchedValue);
        } else {
            // Handle the case where no match is found
            System.out.println("No value found in the input text: " + input);
            return 0.0; // Or throw an exception, depending on your requirements
        }
    }

    public void refreshDriver(String url , By by) {
        driver.navigate().refresh();
        waitForPageToLoad(url);
        waitForVisibilityOfElement(by);

    }

    private void waitForPageToLoad(String url) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToWindowByIndex(int numberOfWindows) {
        String originalWindowHandle = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));  // Adjust the expected number of windows as needed
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.remove(originalWindowHandle);
        String newWindowHandle = windowHandles.iterator().next();
        driver.switchTo().window(newWindowHandle);
    }

    public void waitForTime(int timeIntoMilSec) {
        try {
            Thread.sleep(timeIntoMilSec);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    public void ElementsValidator(By... screenLocators) {
        for (By screenLocator : screenLocators) {
            scrollToElement(screenLocator);
            Assert.assertTrue(assertElementDisplayed(screenLocator));
        }
    }

    public void selectFromListByText(By by , String text){
            scrollToElement(by);
            clickOnElement(by);
            By optionLocator = By.xpath("//*[@text contains(text(), ' " + text + " ')]");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        try {
            optionElement.click();
        }catch (Exception e){
            scrollToElement(optionLocator);
            optionElement.click();
        }
    }

    public void SelectWorkspace(By by ,String text){
        clickOnElement(by);

        By optionLocator = By.xpath("//*[@role='option' and contains(text(), ' " + text + " ')]");

        // Wait for the option to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));

        // Click on the option to select it
        try {
            optionElement.click();
        }catch (Exception e){
            scrollToElement(optionLocator);
            optionElement.click();
        }


    }


}
