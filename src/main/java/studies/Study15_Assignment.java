package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Study15_Assignment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys("hsnycl");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("hsn@mail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("hasan");
        driver.findElement(By.id("exampleCheck1")).click();
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("01012001");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        String text = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        Assert.assertEquals(text,"×\n" + "Success! The Form has been submitted successfully!.");
        driver.quit();

    }
}
