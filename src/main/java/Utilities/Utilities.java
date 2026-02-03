package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Utilities {
    public static String captureScreenshot(String imagePath , WebDriver driver) throws IOException , NullPointerException {
        TakesScreenshot camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        Files.move(screenshot.toPath(), Paths.get(imagePath), StandardCopyOption.REPLACE_EXISTING);

        return imagePath;

    }


    // ✅ ADD THIS METHOD
    public static void removeThirdPartyBanners(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "document.querySelectorAll('[class*=\"useitful\"], [id*=\"useitful\"], [class*=\"banner\"]').forEach(e => e.remove());" +
                            "document.querySelectorAll('iframe').forEach(frame => {" +
                            "  try { frame.remove(); } catch(e) {}" +
                            "});" +
                            "var observer = new MutationObserver(function() {" +
                            "  document.querySelectorAll('[class*=\"useitful\"], [id*=\"useitful\"], iframe').forEach(e => e.remove());" +
                            "});" +
                            "observer.observe(document.body, { childList: true, subtree: true });"
            );

        } catch (Exception ignored) {
            // Banner may not exist
        }
    }

}

