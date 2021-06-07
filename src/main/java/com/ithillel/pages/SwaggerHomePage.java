package com.ithillel.pages;

import com.ithillel.utils.ConfigProvider;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.ithillel.utils.WaitUtils.waitUntilElementIsVisible;

@Data
public class SwaggerHomePage extends Page {

    @FindBy(xpath = "//h2[contains(text(),'Please sign in')]")
    private WebElement h2;

    @FindBy(css = "#username")
    private WebElement usernameField;

    @FindBy(css = "#password")
    private WebElement passField;

    @FindBy(css = "body > div > form > button")
    private WebElement singInBtn;

    @FindBy(css = "#home > div > div > div > button")
    private WebElement swaggerUI_Btn;

    @FindBy(css = ".alert.alert-danger")
    private WebElement loginErrorDiv;


    public SwaggerHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(ConfigProvider.API_URL + ":" + ConfigProvider.API_PORT);
        ensureOpen();
    }

    @Override
    public void ensureOpen() {
        waitUntilElementIsVisible(super.driver, h2);
    }
}
