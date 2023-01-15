package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Study22_WindowHandles {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        String text = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
        String email = text.split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(email);
    }
}
