package studies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Study18_ImplicitlyAndExplicitlyWait {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String[] neededProducts = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
        addItems(driver, neededProducts);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));

        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
        String textPromo = driver.findElement(By.cssSelector("span.promoInfo")).getText();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(textPromo);

        //driver.quit();
    }

    public static void addItems(WebDriver driver, String[] neededProducts){

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<String> listOfNeededProducts = Arrays.asList(neededProducts);

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            String productName = products.get(i).getText().split("-")[0].trim();
            if (listOfNeededProducts.contains(productName)){
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                count++;
                if (count == neededProducts.length){
                    break;
                }
            }
        }
    }
}
