package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Study29_JavaScriptExecutorDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += Integer.parseInt(values.get(i).getText());
        }

        WebElement text = driver.findElement(By.xpath("//div[@class='totalAmount']"));
        int totalAmount = Integer.parseInt(text.getText().split(":")[1].trim());

        Assert.assertEquals(sum, totalAmount);

        driver.quit();

    }
}
