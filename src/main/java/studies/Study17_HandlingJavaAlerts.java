package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Study17_HandlingJavaAlerts {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String name = "hasan";
        driver.findElement(By.id("name")).sendKeys(name);

        driver.findElement(By.id("alertbtn")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss();
    }
}
