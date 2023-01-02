package smartBearTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TC_SmartBear_001 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/" +
                "Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");

        String userName = "Tester";
        String password = "test";

        loginSmartBear(driver, userName, password);

        String text = driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/table/tbody/tr/td[2]/div[1]")).getText();

        driver.close();

        Assert.assertEquals(text, "Welcome, " + userName + "! | Logout");
        System.out.println("TEST CASE : PASS");

    }

    public static void loginSmartBear(WebDriver driver, String userName, String password){

        WebElement userNameInput = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userNameInput.sendKeys(userName);

        WebElement passwordInput = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordInput.sendKeys(password);

        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
    }
}
