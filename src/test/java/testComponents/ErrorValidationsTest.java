package testComponents;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectsAndFactoryImplementationTests.CartPage;
import pageObjectsAndFactoryImplementationTests.ProductCatalogue;

import java.util.List;

public class ErrorValidationsTest extends BaseTest{

    @Test(groups = {"ErrorHandling"})
    public void LoginErrorValidation(){

        landingPage.loginApplication("anshika@gmail.com", "Iamki000");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    }

    @Test
    public void ProductErrorValidation() {

        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");

        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
    }
}
