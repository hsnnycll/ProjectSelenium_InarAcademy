package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Study27_Assignment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String optionValue = driver.findElement(By.id("checkBoxOption2")).getAttribute("value");
        driver.findElement(By.id("checkBoxOption2")).click();

        WebElement selectDropdown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(selectDropdown);
        dropdown.selectByValue(optionValue);

        driver.findElement(By.id("name")).sendKeys(optionValue);
        driver.findElement(By.id("alertbtn")).click();

        String alertText = driver.switchTo().alert().getText();
        String text = alertText.split(",")[0].split(" ")[1];
        Assert.assertEquals(optionValue, text);

    }
}
