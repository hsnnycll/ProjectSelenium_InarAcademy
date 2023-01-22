package chromeTools;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.emulation.Emulation;

import java.time.Duration;
import java.util.Optional;

public class Study01_MobileEmulatorTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hsnny\\workspace\\drivers\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        DevTools devTools = driver.getDevTools();

        devTools.createSession();

        //send commands to CDP Methods-> CDP Methods will invoke and get access to Chrome dev tools
        devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Library']")).click();
    }
}
