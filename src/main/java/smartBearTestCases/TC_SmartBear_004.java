package smartBearTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TC_SmartBear_004 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        validLoginSmartBear(driver);

        String text = driver.findElement(By.tagName("h1")).getText();

        driver.close();

        Assert.assertEquals(text, "Web Orders");
        System.out.println("TEST CASE : PASS");
    }

    public static void validLoginSmartBear(WebDriver driver){

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
    }
}
