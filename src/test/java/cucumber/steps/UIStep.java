package cucumber.steps;

import com.ithillel.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class UIStep {

    protected final WebDriver driver = WebDriverFactory.getDriver();
}
