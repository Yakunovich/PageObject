package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RevolveclothingProductPage extends AbstractPage {
    private  static final String selectedProductURL = "https://www.revolve.com/vans-classic-slip-on/dp/VANX-UZ2/?d=Womens&page=1&lc=4&itrownum=1&itcurrpage=1&itview=05&bneEl=false";

    @FindBy(xpath = "//*[@id='size-ul']/li[1]/label")
    private WebElement sizeButton;

    @FindBy(xpath = "//*[@id='addtobagbutton']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id='ntf_dialog_close']")
    private WebElement closeBannerButton;

    @FindBy(xpath = "//*[@id='bag_item_VANX-UZ2_Mens_4_Womens_5_5']")
    private List<WebElement> itemsInCart;

    public RevolveclothingProductPage(WebDriver driver)
    {
        super(driver);
    }

    public RevolveclothingProductPage openPage()
    {
        driver.get(selectedProductURL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(closeBannerButton));
        closeBannerButton.click();
        return this;
    }

    public RevolveclothingProductPage addProductToCart()
    {
        sizeButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
        return this;
    }

    public RevolveclothingCartPage getRevolveclothingCartPage()
    {
        return new RevolveclothingCartPage(driver);
    }

}
