package Base;
import Utilities.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static Utilities.ExtentReportManager.*;


public class BaseTest {
    public WebDriver driver;
    public String remote = System.getProperty("remote");

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void startDriverSession(@Optional("chrome") String browser) {
        try {
            initializeDriver(browser);
            startReporting();
        } catch (Exception e) {
            throw new RuntimeException("Failed to start WebDriver session", e);
        }
    }

    private void initializeDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                if(Objects.equals(remote, "true")) {
                    
                    options.addArguments("--headless=new");
                    chromeDeviceScale(options);

                    Map<String, Object> deviceMetrics = new HashMap<>();
                    deviceMetrics.put("width", 1920);
                    deviceMetrics.put("height", 1080);
                    deviceMetrics.put("pixelRatio", 0.6);  // Scale factor
                    Map<String, Object> mobileEmulation = new HashMap<>();
                    mobileEmulation.put("deviceMetrics", deviceMetrics);
                    mobileEmulation.put("userAgent", "Mozilla/5.0 ...");
                    options.setExperimentalOption("mobileEmulation", mobileEmulation);

                    driver = new ChromeDriver(options);
                    Map<String, Object> coordinates = new HashMap<>();
                    coordinates.put("latitude", 31.2156);
                    coordinates.put("longitude", 29.9553);
                    coordinates.put("accuracy", 100);
                    ((ChromeDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
                    driver = new ChromeDriver(options);
                }else {
                    chromeDeviceScale(options);
                    driver = new ChromeDriver(options);
                }
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        configureDriver();
    }

    private void configureDriver() {



        if(!Objects.equals(remote, "true"))driver.manage().window().maximize();

        driver.get(ReadProperties.URL);
    }
    private void chromeDeviceScale(ChromeOptions options){
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 1920);
        deviceMetrics.put("height", 1080);
        deviceMetrics.put("pixelRatio", 1.0);  // Scale factor
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 ...");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
    }



    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) throws IOException {
        ExtentReportManager.beforeMethod(method);
    }
    @AfterMethod(alwaysRun = true )
    public void A_takeScreenShot(ITestResult result) throws IOException, InterruptedException {
        takeScreenshot(result,driver);
        System.out.println("screenshot captured");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
        flushReport();
        System.out.println("Report path is here:  " + reportName );

    }
}
