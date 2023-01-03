package smartBearTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TC_SmartBear_007 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/" +
                "Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String userName = "Tester";
        String password = "test";

        WebElement userNameInput = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userNameInput.sendKeys(userName);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordInput.sendKeys(password);

        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_btnCheckAll\"]")).click();

        List<WebElement> afterChecked = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));

        for (int i = 0; i < afterChecked.size(); i++) {
            Assert.assertTrue(afterChecked.get(i).isSelected());
        }

        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();

        List<WebElement> afterUnchecked = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));

        for (int i = 0; i < afterUnchecked.size(); i++) {
            Assert.assertFalse(afterUnchecked.get(i).isSelected());
        }

        System.out.println("TEST CASE : PASS");
        driver.close();
    }
}
