package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Study02_Locators {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.linkText("Forgot your password?")).click();

        //It can be also -----> "//input[@placeholder='Name']"
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[1]")).sendKeys("Hasan");

        //It is a little different from xpath ------> "input[placeholder='Email]"
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("hsn@mail.com");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();

        //It is the same element as above ------> "//input[@type='text'][2]"
        //This is another way of access to element with cssSelector -----> "//input[@type='text']:nth-child(3)"
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("ycl@mail.com");

    }
}
