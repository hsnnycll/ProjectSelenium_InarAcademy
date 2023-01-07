package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Study01_Locators {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement userNameInput = driver.findElement(By.id("inputUsername"));
        userNameInput.sendKeys("Hasan");

        WebElement passwrodInput = driver.findElement(By.name("inputPassword"));
        passwrodInput.sendKeys("wrongpassword");

        WebElement loginButton = driver.findElement(By.className("signInBtn"));
        loginButton.click();

        String invalidPassword = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(invalidPassword);
    }
}
