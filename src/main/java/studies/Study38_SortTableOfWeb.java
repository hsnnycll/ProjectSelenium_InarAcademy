package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Study38_SortTableOfWeb {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        Assert.assertTrue(originalList.equals(sortedList));

        List<String> price = elementsList.stream().filter(s -> s.getText().contains("Beans"))
                .map(s -> getPriceVeggie(s)).collect(Collectors.toList());
        price.forEach(a -> System.out.println(a));
    }

    private static String getPriceVeggie(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
