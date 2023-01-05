package sauceDemoTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static sauceDemoTestCases.TC_SauceDemo_001.loginSauceDemo;

public class TC_SauceDemo_004 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String userName = "standard_user";
        String password = "secret_sauce123";
        loginSauceDemo(driver, userName, password);

        String invalidLogin = "Epic sadface: You can only access '/inventory.html' when you are logged in.";
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")), invalidLogin);
        driver.quit();

        System.out.println("TEST : PASS");
    }
}
