package sauceDemoTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static sauceDemoTestCases.TC_SauceDemo_001.loginSauceDemo;

public class TC_SauceDemo_010 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String userName = "standard_user";
        String password = "secret_sauce";
        loginSauceDemo(driver, userName, password);

        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.findElement(By.cssSelector("#shopping_cart_container > a")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Hasan");
        driver.findElement(By.id("last-name")).sendKeys("Yucel");
        driver.findElement(By.id("postal-code")).sendKeys("35000");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        String textFinish = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();

        Assert.assertEquals(textFinish, "THANK YOU FOR YOUR ORDER");
        driver.quit();

        System.out.println("TEST : PASS");
    }
}
