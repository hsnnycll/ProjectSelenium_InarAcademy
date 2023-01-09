package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Study09_DynamicDropdown {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement selectFromWhere = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        selectFromWhere.click();

        // Parent to child xpath
        driver.findElement(By.xpath("//div['@id=glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value = 'DEL']")).click();
        Assert.assertEquals(selectFromWhere.getAttribute("value"), "Delhi (DEL)");

        driver.findElement(By.xpath("(//a[@value = 'BOM'])[2]")).click();
        Assert.assertEquals(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getAttribute("value"), "Mumbai (BOM)");

        driver.quit();
    }
}
