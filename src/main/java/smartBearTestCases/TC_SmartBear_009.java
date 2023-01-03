package smartBearTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static smartBearTestCases.TC_SmartBear_004.validLoginSmartBear;

public class TC_SmartBear_009 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        validLoginSmartBear(driver);

        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();

        String text = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(text, "Order");

        System.out.println("TEST CASE : PASS");
        driver.close();
    }
}
