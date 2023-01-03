package smartBearTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static smartBearTestCases.TC_SmartBear_004.validLoginSmartBear;
import static smartBearTestCases.TC_SmartBear_013.enterTheInfosSmartBear;

public class TC_SmartBear_014 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        validLoginSmartBear(driver);

        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();

        enterTheInfosSmartBear(driver);

        driver.findElement(By.className("btn_light")).click();

        String text = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText();

        Assert.assertEquals(text, "New order has been successfully added.");
        driver.close();

        System.out.println("TEST CASE : PASS");
    }
}
