package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Study03_Locators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(1000);

        //It is the another way of the xpath
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("05555555555");

        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

        System.out.println(driver.findElement(By.cssSelector("form p")).getText());


    }
}
