package com.ithillel.driver;

import com.ithillel.utils.ConfigProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.ithillel.utils.ConfigProvider.IMPLICIT_WAIT;
import static java.util.concurrent.TimeUnit.SECONDS;


public class WebDriverFactory {

    private static final String BROWSER = System.getProperty("browser");

    private static WebDriver driver;

    public static WebDriver getDriver() {
        String browserType = BROWSER != null ? BROWSER : ConfigProvider.BROWSER;
        WebDriver driver = getDriver(Browser.valueOf(browserType.toUpperCase()));
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, SECONDS);
        Runtime.getRuntime().addShutdownHook(new Thread(new CloseDriverHook(driver)));
        return driver;
    }

    public static WebDriver getDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            case OPERA:
                return getOperaDriver();
            case SAFARI:
                return getSafariDriver();
            default:
                throw new IllegalArgumentException("Wrong browser type provided. Choices are: chrome, firefox");
        }
    }

    private static WebDriver getChromeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            //  driver = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--ignore-certificate-errors");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    private static WebDriver getFirefoxDriver() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    private static WebDriver getOperaDriver() {
        if (driver == null) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
        return driver;
    }

    private static WebDriver getSafariDriver() {
        if (driver == null) {
            System.setProperty("webdriver.safari.driver", "here have to be some safari path");
            //  WebDriverManager не поддерживает Safari, потому вернем его инстанс как есть
            driver = new SafariDriver();
        }
        return driver;
    }
}