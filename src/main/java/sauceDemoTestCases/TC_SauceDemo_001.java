package sauceDemoTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TC_SauceDemo_001 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String userName = "standard_user";
        String password = "secret_sauce";
        loginSauceDemo(driver, userName, password);

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
        driver.quit();

        System.out.println("TEST : PASS");

    }

    public static void loginSauceDemo(WebDriver driver, String userName, String password){

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }
}
