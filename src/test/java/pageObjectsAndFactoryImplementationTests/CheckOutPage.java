package pageObjectsAndFactoryImplementationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends AbstractComponent {

    WebDriver driver;

    By results = By.cssSelector(".ta-results");

    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;

    @FindBy(xpath = "//button[contains(@class,'ta-item')][1]")
    WebElement selectCountry;

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    WebElement submit;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCountry(String countryName){
        Actions a = new Actions(driver);
        a.sendKeys(country, countryName).build().perform();
        waitForElementToAppear(results);
        selectCountry.click();
    }

    public ConfirmationPage submitOrder(){
        submit.click();
        return new ConfirmationPage(driver);
    }
}
