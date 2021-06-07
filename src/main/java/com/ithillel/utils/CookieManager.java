package com.ithillel.utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieManager {

    public static void setSessionCookie(WebDriver driver, String sessionId) {
        driver.get(ConfigProvider.BASE_URL);
        driver.manage().deleteAllCookies();
        driver.manage().addCookie(new Cookie("JSESSIONID", sessionId));
    }
}
