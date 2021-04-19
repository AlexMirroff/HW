package com.ithillel.driver;

import org.openqa.selenium.WebDriver;

public class CloseDriverHook implements Runnable {

    private final WebDriver driver;

    public CloseDriverHook(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void run() {
        driver.quit();
    }
}