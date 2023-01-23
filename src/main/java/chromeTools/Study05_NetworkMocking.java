package chromeTools;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.fetch.Fetch;

import java.time.Duration;
import java.util.Optional;

public class Study05_NetworkMocking {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
        devTools.addListener(Fetch.requestPaused(), request ->
        {
            if (request.getRequest().getUrl().contains("shetty")){
                String mockedURL = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
                System.out.println(mockedURL);
                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedURL), Optional.of(request.getRequest().getMethod()),
                        request.getRequest().getPostData(), Optional.empty(), Optional.empty()));
            }else {
                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()),
                        request.getRequest().getPostData(), Optional.empty(), Optional.empty()));
            }
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo");
        driver.findElement(By.xpath("//button[normalize-space()='Virtual Library']")).click();

        System.out.println(driver.findElement(By.cssSelector("p")).getText());
    }
}
