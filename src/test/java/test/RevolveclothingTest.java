package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.RevolveclothingProductPage;

public class RevolveclothingTest {
    private WebDriver driver;
    private final String newQuantityOfProduct = "3";

    @BeforeMethod(alwaysRun = true)
    public void driverInitiate(){
        System.setProperty("webdriver.chrome.driver","C:\\\\chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--window-size=1200,800");
        driver = new ChromeDriver(option);
    }

    @Test
    public void addShoesToCartTest() throws InterruptedException {
        int countOfProductsInCart = new RevolveclothingProductPage(driver)
                .openPage()
                .addProductToCart()
                .getRevolveclothingCartPage()
                .openPage()
                .countOfItemsInCart();
        Assert.assertTrue(countOfProductsInCart>0);
    }

    @Test
    public void changeQuantityOfProductsInCart() throws InterruptedException {
        String quantityOfProductInCart = new RevolveclothingProductPage(driver)
                .openPage()
                .addProductToCart()
                .getRevolveclothingCartPage()
                .openPage()
                .changeQuantityOfProductInCart()
                .getQuantityOfProduct();
        Assert.assertTrue(quantityOfProductInCart.contains(newQuantityOfProduct));
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}