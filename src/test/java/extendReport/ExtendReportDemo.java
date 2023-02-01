package extendReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtendReportDemo {

    ExtentReports extent;

    @BeforeTest
    public void config(){
        String path = "C:\\Users\\hsnny\\workspace\\selenium.project\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Hasan Yucel");
    }

    @Test
    public void  initialDemo(){

        ExtentTest test = extent.createTest("InitialDemo");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        driver.quit();
        //test.fail("Result do not match");
        extent.flush();
    }
}
