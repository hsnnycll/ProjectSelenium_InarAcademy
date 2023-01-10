package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Study10_UpdatedDropdown {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement selectNumberOfPerson = driver.findElement(By.id("divpaxinfo"));
        selectNumberOfPerson.click();

        int i = 0;
        while (i < 4) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }

        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(selectNumberOfPerson.getText(), "5 Adult");

        driver.quit();
    }
}
