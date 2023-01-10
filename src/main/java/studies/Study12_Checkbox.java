package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Study12_Checkbox {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement option1 = driver.findElement(By.id("checkBoxOption1"));
        option1.click();
        Assert.assertTrue(option1.isSelected());

        option1.click();
        Assert.assertFalse(option1.isSelected());

        int numberOfCheckbox = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        Assert.assertEquals(numberOfCheckbox, 3);

        driver.quit();
    }
}
