package chromeTools;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Study02_CDPCommandsTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hsnny\\workspace\\drivers\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        Map<String, Object> deviceMetrics = new HashMap();
        deviceMetrics.put("width", 600);
        deviceMetrics.put("height", 1000);
        deviceMetrics.put("deviceScaleFactor", 50);
        deviceMetrics.put("mobile", true);

        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Library']")).click();
    }
}
