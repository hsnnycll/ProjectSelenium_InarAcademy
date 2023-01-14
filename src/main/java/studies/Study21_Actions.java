package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Study21_Actions {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        Actions a = new Actions(driver);
        WebElement move1 = driver.findElement(By.id("twotabsearchtextbox"));
        a.moveToElement(move1).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        WebElement move2 = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        a.moveToElement(move2).contextClick().build().perform();

    }
}
