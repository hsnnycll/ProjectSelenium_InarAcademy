package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Study05_Locators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String name = "Hasan";
        String password = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);

        driver.findElement(By.id("chkboxOne")).click();

        driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
        Thread.sleep(2000);

        String text = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(text, "You are successfully logged in.");

        String text1 = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
        Assert.assertEquals(text1, "Hello " + name + ",");

        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        Thread.sleep(1000);
        driver.close();

    }

    public static String getPassword(WebDriver driver) throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();

        //Please use temporary password 'rahulshettyacademy' to Login.
        String[] passwordArray = passwordText.split("'");
        String password = passwordArray[1].split("'")[0];

        return password;
    }
}
