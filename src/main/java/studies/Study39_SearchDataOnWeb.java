package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class Study39_SearchDataOnWeb {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<String> price;
        do {
            List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
            price = elementsList.stream().filter(s -> s.getText().contains("Rice"))
                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList());
            if (price.size() < 1){
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
            price.forEach(a -> System.out.println(a));
        }while (price.size() < 1);
    }
    private static String getPriceVeggie(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
