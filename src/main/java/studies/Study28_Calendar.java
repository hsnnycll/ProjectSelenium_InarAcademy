package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Study28_Calendar {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.path2usa.com/travel-companion/");

        WebElement date = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']"));
        date.click();

        List<WebElement> dates = driver.findElements(By.cssSelector(".flatpickr-day.nextMonthDay"));

        for (int i = 0; i < dates.size(); i++) {
            String text = dates.get(i).getText();
            if (text.equalsIgnoreCase("5")){
                dates.get(i).click();
                break;
            }
        }
    }
}
