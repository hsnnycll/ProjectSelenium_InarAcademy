package sauceDemoTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static sauceDemoTestCases.TC_SauceDemo_001.loginSauceDemo;

public class TC_SauceDemo_006 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String userName = "standard_user";
        String password = "secret_sauce";
        loginSauceDemo(driver, userName, password);

        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[text()='Add to cart']"));
        for (WebElement button:addToCartButtons) {
            button.click();
        }
        WebElement cartButton = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));

        int numbersOfCart = Integer.parseInt(cartButton.getText());
        Assert.assertEquals(numbersOfCart, addToCartButtons.size());

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        List<WebElement> listOfProducts = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertEquals(numbersOfCart, listOfProducts.size());

        driver.quit();


    }
}
