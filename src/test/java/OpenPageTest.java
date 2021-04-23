import com.ithillel.driver.WebDriverFactory;
import com.ithillel.utils.ConfigProvider;
import com.ithillel.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.ithillel.utils.WaitUtils.waitUntilElementIsClickable;

public class OpenPageTest {


    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(ConfigProvider.BASE_URL);
        WebElement appleButton = driver.findElement(
                By.xpath("//button[text()='Каталог товаров' and contains(@class,'home-category-button')]"));
        waitUntilElementIsClickable(driver, appleButton);
        //appleButton.click();
    }
}