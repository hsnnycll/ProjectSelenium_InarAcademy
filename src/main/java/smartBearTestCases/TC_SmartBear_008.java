package smartBearTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static smartBearTestCases.TC_SmartBear_004.validLoginSmartBear;

public class TC_SmartBear_008 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        validLoginSmartBear(driver);

        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_btnCheckAll\"]")).click();

        driver.findElement(By.className("btnDeleteSelected")).click();

        String text = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderMessage\"]")).getText();
        Assert.assertEquals(text, "List of orders is empty. In order to add new order use this link.");

        System.out.println("TEST CASE : PASS");
        driver.close();
    }
}
