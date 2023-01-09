package studies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Study07_WindowActivities {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.navigate().to("https://rahulshettyacademy.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.quit();
    }
}
