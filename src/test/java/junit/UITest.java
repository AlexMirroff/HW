package junit;

import com.ithillel.driver.WebDriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

@Slf4j
public class UITest {

    protected final WebDriver driver = WebDriverFactory.getDriver();

    @BeforeMethod
    public void testStartedLog(Method method) {
        log.info("Test " + method.getName() + " started");
    }

    @AfterMethod
    public void testFinishedLog(ITestResult result) {
        String status;
        if (result.getStatus() == 1) status = "SUCCESS";
        else status = "FAIL";
        log.info("Test " + result.getMethod().getMethodName() + " finished with result " + status + "\n");
    }
}
