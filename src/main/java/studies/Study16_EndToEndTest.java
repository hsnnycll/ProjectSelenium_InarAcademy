package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Study16_EndToEndTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.spicejet.com/");

        driver.findElement(By.xpath("(//div[@data-testid='to-testID-origin']//input[@type='text'])")).click();

        driver.findElement(By.xpath("//div[contains(text(),'BOM')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'AMD')]")).click();

        driver.findElement(By.cssSelector(".css-1dbjc4n.r-1awozwy.r-19m6qjp.r-156aje7.r-y47klf.r-1phboty.r-1d6rzhh.r-1pi2tsx.r-1777fci.r-13qz1uu")).click();

        String text = driver.findElement(By.xpath("//div[contains(text(),'Select Date')]")).getAttribute("style");

        if (text.contains("0.5")){
            Assert.assertTrue(true);
        }

        driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[7]/div[2]/div")).click();

        driver.quit();

    }
}
