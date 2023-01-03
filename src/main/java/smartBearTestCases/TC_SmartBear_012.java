package smartBearTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

import static smartBearTestCases.TC_SmartBear_004.validLoginSmartBear;

public class TC_SmartBear_012 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        validLoginSmartBear(driver);

        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();

        ArrayList<String> infosOfCard = new ArrayList<>();
        infosOfCard.add("85692147852365471236");
        infosOfCard.add("11/26");

        WebElement selectTypeOfCard = driver.findElement(By.cssSelector("input[value='MasterCard']"));
        selectTypeOfCard.click();

        WebElement numberOfCardBox = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6"));
        numberOfCardBox.sendKeys(infosOfCard.get(0));

        WebElement expireDateOfCard = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]"));
        expireDateOfCard.sendKeys(infosOfCard.get(1));

        Assert.assertTrue(selectTypeOfCard.isSelected());
        Assert.assertEquals(infosOfCard.get(0), numberOfCardBox.getAttribute("value"));
        Assert.assertEquals(infosOfCard.get(1), expireDateOfCard.getAttribute("value"));

        driver.quit();
        System.out.println("TEST CASE : PASS");

    }
}
