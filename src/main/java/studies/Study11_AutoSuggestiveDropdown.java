package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Study11_AutoSuggestiveDropdown {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("fre");

        List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"ui-id-1\"]/li"));
        for (WebElement option:options) {
            if (option.getText().equalsIgnoreCase("French Polynesia")){
                option.click();
                break;
            }
        }
        driver.quit();
    }
}
