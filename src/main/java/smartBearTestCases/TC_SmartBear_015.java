package smartBearTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static smartBearTestCases.TC_SmartBear_004.validLoginSmartBear;
import static smartBearTestCases.TC_SmartBear_013.enterTheInfosSmartBear;

public class TC_SmartBear_015 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        validLoginSmartBear(driver);

        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();

        enterTheInfosSmartBear(driver);

        String valueOfCustomerNameBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).getAttribute("value");

        driver.findElement(By.className("btn_light")).click();

        driver.findElement(By.cssSelector("#ctl00_menu > li:nth-child(1) > a")).click();
        String customerName = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[2]")).getText();

        Assert.assertEquals(customerName, valueOfCustomerNameBox);
        driver.close();

        System.out.println("TEST CASE : PASS");
    }
}
