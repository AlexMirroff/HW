package com.ithillel.pages;

import com.ithillel.utils.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.ithillel.utils.WaitUtils.waitUntilElementIsVisible;

public class Blog extends Page {


    public Blog(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        super.driver.get(ConfigProvider.BASE_BLOG_URL);
        ensureOpen();
    }

    @Override
    public void ensureOpen() {
        WebElement el = driver.findElement(By.cssSelector(".page-header__wrapper > a"));
        waitUntilElementIsVisible(super.driver, el);
    }
}
