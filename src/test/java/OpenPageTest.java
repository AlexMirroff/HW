import com.ithillel.driver.WebDriverFactory;
import com.ithillel.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;

public class OpenPageTest {


    public static void main(String[] args) {
        WebDriver driver = new WebDriverFactory().getDriver();
        driver.get(ConfigProvider.BASE_URL);
    }
}
