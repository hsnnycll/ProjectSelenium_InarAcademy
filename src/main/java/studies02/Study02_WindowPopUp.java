package studies02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Study02_WindowPopUp {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        //driver.get("https://the-internet.herokuapp.com");

        //handling window authentication popup -->"https://username:password@siteURL"
        driver.get("https://admin:admin@the-internet.herokuapp.com");
        driver.findElement(By.xpath("//a[normalize-space()='Basic Auth']")).click();

    }
}
