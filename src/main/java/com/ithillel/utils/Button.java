package com.ithillel.utils;

import org.awaitility.Awaitility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Button {


    private WebElement buttonElem;

    public Button(WebElement element) {
        buttonElem = element;
    }

    public Button(WebDriver driver, By locator) {
        buttonElem = driver.findElement(locator);
    }

    public Button(WebDriver driver, String xpath) {
        buttonElem = driver.findElement(By.xpath(xpath));
    }


    public void click() throws InterruptedException {
        Awaitility.await()
                .atMost(10, TimeUnit.SECONDS)
                .ignoreExceptions()
                .untilTrue(new AtomicBoolean(buttonElem.isDisplayed()));
        Thread.sleep(1000);  // просто ждем еще дополнительно 1 сек
        buttonElem.click();
    }

    public void doubleClick() throws InterruptedException {
        Awaitility.await()
                .atMost(10, TimeUnit.SECONDS)
                .ignoreExceptions()
                .untilTrue(new AtomicBoolean(buttonElem.isDisplayed()));

        buttonElem.click();
        Thread.sleep(50);
        buttonElem.click();
    }

    public void stubbornClick() throws InterruptedException {
        Awaitility.await()
                .atMost(10, TimeUnit.SECONDS)
                .ignoreExceptions()
                .untilTrue(new AtomicBoolean(buttonElem.isDisplayed()));
        do {
            buttonElem.click();
            Thread.sleep(50);
        } while (buttonElem.isDisplayed());
    }

    public boolean isClickable() {
        return buttonElem.isDisplayed() && buttonElem.isEnabled();
    }
}
