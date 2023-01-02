package smartBearTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static smartBearTestCases.TC_SmartBear_004.validLoginSmartBear;

public class TC_SmartBear_005 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        validLoginSmartBear(driver);

        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_btnCheckAll\"]")).click();

        List<WebElement> checkList = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));

        for (int i = 0; i < checkList.size(); i++) {
            Assert.assertTrue(checkList.get(i).isSelected());
        }
        driver.close();

        System.out.println("TEST CASE : PASS");


    }
}
