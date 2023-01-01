package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/hsnny/workspace/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");

        //  //*[@id="searchInput"]
        WebElement searchInputBoxWebElement = driver.findElement(By.xpath("//*[@id='searchInput']"));
        searchInputBoxWebElement.sendKeys("Turkey");

        Thread.sleep(2000);
        // //*[@id="search-form"]/fieldset/button/i
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='search-form']/fieldset/button/i"));
        searchButton.click();
        Thread.sleep(2000);
        String currentPageURL = driver.getCurrentUrl();

        if (currentPageURL.equalsIgnoreCase("https://tr.wikipedia.org/wiki/Turkey")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }
}