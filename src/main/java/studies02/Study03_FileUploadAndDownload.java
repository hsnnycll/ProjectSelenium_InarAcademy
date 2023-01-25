package studies02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class Study03_FileUploadAndDownload {
    public static void main(String[] args) throws InterruptedException, IOException {

        String downloadPath = System.getProperty("user.dir");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.ilovepdf.com/pdf_to_jpg");
        driver.findElement(By.id("pickfiles")).click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\hsnny\\OneDrive\\Documents\\fileupload.exe");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn")));
        driver.findElement(By.id("processTaskTextBtn")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
//        driver.findElement(By.id("pickfiles")).click();

        Thread.sleep(10000);
        File f = new File(downloadPath + "/ilovepdf_pages-to-jpg.zip");
        if (f.exists()) {
            System.out.println("file downloaded");
            if (f.delete()) {
                System.out.println("file deleted");
            }
        }
    }
}
