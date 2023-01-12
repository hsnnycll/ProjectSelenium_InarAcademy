package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Study14_DisabledEnabled {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.spicejet.com/");

        driver.findElement(By.xpath("(//*[name()='circle'])[3]")).click();
        String text = driver.findElement(By.xpath("//div[contains(text(),'Select Date')]")).getAttribute("style");

        driver.quit();

        if (text.contains("1")){
            Assert.assertTrue(true);
            System.out.println("It is enabled");
        }
    }
}
