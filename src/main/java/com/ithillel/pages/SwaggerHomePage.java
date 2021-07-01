package com.ithillel.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.ithillel.utils.ConfigProvider.API_PORT;
import static com.ithillel.utils.ConfigProvider.API_URL;

@Data
public class SwaggerHomePage extends Page {

    private SelenideElement h2 = $(By.xpath("//h2[contains(text(),'Please sign in')]"));

    private SelenideElement usernameField = $("#username");

    private SelenideElement passField = $("#password");

    private SelenideElement singInBtn = $("body > div > form > button");

    private SelenideElement swaggerUI_Btn = $("#home > div > div > div > button");

    private SelenideElement loginErrorDiv = $(".alert.alert-danger");


    @Override
    public void open() {
        Selenide.open(API_URL + ":" + API_PORT);
        ensureOpen();
    }

    @Override
    public void ensureOpen() {
        h2.shouldBe(Condition.visible);
    }
}
