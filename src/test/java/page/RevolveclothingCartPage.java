package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class RevolveclothingCartPage extends AbstractPage{
    private static final String selectedProductPageUrl = "https://www.revolve.com/r/ShoppingBag.jsp?navsrc=header";



    @FindBy(xpath = "/html/body/div[2]/main/div/div/div[3]/div[3]/div/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div[3]/a")
    private WebElement updateButton;

    public RevolveclothingCartPage(WebDriver driver)
    {
        super(driver);
    }

    public RevolveclothingCartPage openPage()
    {
        driver.get(selectedProductPageUrl);
        return this;
    }

    public int countOfItemsInCart()
    {
        List<WebElement> itemsInCart = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
                        .xpath("//*[@id='bag_item_VANX-UZ2_Mens_4_Womens_5_5']")));
        return itemsInCart.size();
    }

    public RevolveclothingCartPage changeQuantityOfProductInCart()
    {
        WebElement editButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("/html/body/div[2]/main/div/div/div[3]/div[3]/div/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[4]/a")));
        editButton.click();
        WebElement selectQuantity = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("/html/body/div[2]/main/div/div/div[3]/div[3]/div/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div[2]/label/select")));
        new Select(driver.findElement(By
                .xpath("/html/body/div[2]/main/div/div/div[3]/div[3]/div/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div[2]/label/select")))
                .selectByVisibleText("3");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(updateButton));
        updateButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.invisibilityOf(updateButton));
        return this;
    }

    public String getQuantityOfProduct()
    {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("/html/body/div[2]/main/div/div/div[3]/div[3]/div/div[1]/div[2]/div/div[3]/div[1]/div[1]/div[4]/span[5]/span")));
        return driver.findElement(By
                .xpath("/html/body/div[2]/main/div/div/div[3]/div[3]/div/div[1]/div[2]/div/div[3]/div[1]/div[1]/div[4]/span[5]/span"))
                .getText();
    }

}
