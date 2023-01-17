package studies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Study33_ProxyPluginCookies {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().deleteCookieNamed("asdf");

        driver.get("https://www.google.com/");
    }
}
