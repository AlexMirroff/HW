package junit;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import static com.ithillel.driver.WebDriverFactory.setupDriver;

@Slf4j
public class UITest {

    public UITest() {
        setupDriver();
    }

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
