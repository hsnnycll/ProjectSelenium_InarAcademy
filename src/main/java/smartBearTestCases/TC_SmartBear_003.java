package smartBearTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static smartBearTestCases.TC_SmartBear_001.loginSmartBear;

public class TC_SmartBear_003 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/" +
                "Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");

        String userName = "Tester123";
        String password = "test";

        loginSmartBear(driver, userName, password);

        String text = driver.findElement(By.className("error")).getText();

        driver.close();

        Assert.assertEquals(text, "Invalid Login or Password.");
        System.out.println("TEST CASE : PASS");

    }
}
