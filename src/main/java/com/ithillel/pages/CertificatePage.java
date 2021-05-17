package com.ithillel.pages;

import com.ithillel.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.ithillel.utils.WaitUtils.waitUntilElementIsVisible;


public class CertificatePage extends Page {


    @FindBy(xpath = "//h1[contains(text(),'Проверка сертификата')]")
    private WebElement h1;

    @FindBy(css = "#certificateCheckForm > div > input")
    private WebElement certificateInput;

    @FindBy(css = "#certificateCheckForm > div > button")
    private WebElement certificateBtn;

    @FindBy(xpath = "//p[contains(text(),'Сертификат не найден')]")
    private WebElement certificateCheckMsg;

    public WebElement getCertificateCheckMsg() {
        return certificateCheckMsg;
    }

    public WebElement getCertificateInput() {
        return certificateInput;
    }

    public CertificatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(ConfigProvider.BASE_SERTIFICATE_URL);
        ensureOpen();
    }

    @Override
    public void ensureOpen() {
        waitUntilElementIsVisible(super.driver, h1);
    }

    public void checkCertificate(String input) {
        certificateInput.sendKeys(input);
        certificateBtn.click();
        waitUntilElementIsVisible(super.driver, getCertificateCheckMsg());
    }
}
