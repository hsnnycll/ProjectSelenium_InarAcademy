package smartBearTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static smartBearTestCases.TC_SmartBear_004.validLoginSmartBear;

public class TC_SmartBear_011 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        validLoginSmartBear(driver);

        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();

        String[] addressInformations = {"Hasan Yucel", "Cıragan", "Istanbul", "Marmara", "35000"};

        List<WebElement> addressList = driver.findElements(By.cssSelector("input[style$='width:200px;']"));
        addressList.remove(addressList.size() - 1);

        for (int i = 0; i < addressList.size(); i++) {
            addressList.get(i).sendKeys(addressInformations[i]);
            Assert.assertEquals(addressInformations[i], addressList.get(i).getAttribute("value"));
        }

        driver.quit();
        System.out.println("TEST CASE : PASS");

    }
}
