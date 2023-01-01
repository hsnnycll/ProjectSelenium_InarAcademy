package demos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver", "C:/Users/hsnny/workspace/drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/");
        String str = driver.getCurrentUrl();
        String str1 =driver.getTitle();
        System.out.println("Test 1:".concat(str));
        System.out.println("Title of page: " + str1);
        Thread.sleep(2000);
        driver.quit();
    }
}