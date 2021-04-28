import com.ithillel.driver.WebDriverFactory;
import com.ithillel.pages.Product;
import com.ithillel.utils.Button;
import com.ithillel.utils.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OpenPageTest {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(ConfigProvider.BASE_URL);
        WebElement element = driver.findElement(By.cssSelector(".product-order__block.product-order__block--buy > a"));
        By locator = null;
        String xpath="//button[text()='Каталог товаров' and contains(@class,'home-category-button')]";
        Button button1 = new Button(element);
        //Button button2 = new Button( driver,  locator);
        //Button button3 = new Button( driver, xpath);


    }
}