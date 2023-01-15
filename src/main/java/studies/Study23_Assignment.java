package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Study23_Assignment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.cssSelector("a[href='/windows']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        String text1 = driver.findElement(By.xpath("//h3[normalize-space()='New Window']")).getText();
        System.out.println(text1);

        driver.switchTo().window(parentId);
        String text2 = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
        System.out.println(text2);

        driver.quit();

    }
}
