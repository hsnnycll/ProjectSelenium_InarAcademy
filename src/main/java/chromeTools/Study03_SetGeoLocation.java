package chromeTools;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Study03_SetGeoLocation {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> coordinates = new HashMap<>();
        coordinates.put("latitude", 48);
        coordinates.put("longitude", 2);
        coordinates.put("accuracy", 1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);

        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();

        String head = driver.findElement(By.cssSelector("h1[data-uia='hero-title']")).getText();
        System.out.println(head);

    }
}
