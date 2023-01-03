package smartBearTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static smartBearTestCases.TC_SmartBear_004.validLoginSmartBear;

public class TC_SmartBear_010 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        validLoginSmartBear(driver);

        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct > option:nth-child(2)")).click();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).clear();

        String quantity = "100";
        String totalAmount = "6800";
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(quantity);

        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/ol[1]/li[5]/input[2]")).click();
        Thread.sleep(1000);

        String dataTotalAmount = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtTotal\"]")).getAttribute("value");
        Assert.assertEquals(totalAmount, dataTotalAmount);

        driver.quit();
        System.out.println("TEST CASE : PASS");
    }
}
