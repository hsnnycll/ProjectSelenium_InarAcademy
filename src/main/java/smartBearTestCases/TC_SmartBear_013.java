package smartBearTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static smartBearTestCases.TC_SmartBear_004.validLoginSmartBear;

public class TC_SmartBear_013 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        validLoginSmartBear(driver);

        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();

        enterTheInfosSmartBear(driver);

        driver.findElement(By.cssSelector("input[value='Reset']")).click();

        Assert.assertEquals("", driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).getAttribute("value"));
        Assert.assertEquals("", driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).getAttribute("value"));

        driver.close();
        System.out.println("TEST CASE : PASS");
    }

    public static void enterTheInfosSmartBear(WebDriver driver){

        String quantity = "100";
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(quantity);

        String[] addressInformations = {"Hasan Yucel", "Cıragan", "Istanbul", "Marmara", "35000"};

        List<WebElement> addressList = driver.findElements(By.cssSelector("input[style$='width:200px;']"));
        addressList.remove(addressList.size() - 1);

        for (int i = 0; i < addressList.size(); i++) {
            addressList.get(i).sendKeys(addressInformations[i]);
        }

        ArrayList<String> infosOfCard = new ArrayList<>();
        infosOfCard.add("8569214785236");
        infosOfCard.add("11/26");

        driver.findElement(By.cssSelector("input[value='MasterCard']")).click();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(infosOfCard.get(0));
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]")).sendKeys(infosOfCard.get(1));
    }
}
