package demos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/hsnny/workspace/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        String str = driver.getCurrentUrl();
        String str1 =driver.getTitle();
        System.out.println("Test 1:".concat(str));
        System.out.println("Title of page: " + str1);
        Thread.sleep(2000);
        driver.quit();
    }
}
