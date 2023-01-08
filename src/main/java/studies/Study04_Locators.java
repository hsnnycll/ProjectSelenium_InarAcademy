package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Study04_Locators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // It is id name which can use with # in cssSelector
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Hasan");

        // This is regular expression in as a cssSelector
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.id("chkboxOne")).click();

        Thread.sleep(1000);

        //It is contains? method actually,
        driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
    }
}
