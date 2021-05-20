package com.ithillel.pages;

import com.ithillel.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.ithillel.utils.WaitUtils.waitUntilElementIsVisible;


public class HomePage extends Page {


    @FindBy(css = "div.section-content > div > svg")
    private WebElement logo;

    @FindBy(css = "#coursesMenuDesktopTrigger")
    private WebElement coursesMenu;

    @FindBy(css = "#coursesMenuSearchField > input")
    private WebElement coursesSearchField;

    @FindBy(css = ".search-panel_screen.-result > div > ul > li > a > div > p")
    private List<WebElement> foundItems;


    public WebElement getCoursesSearchField() {
        return coursesSearchField;
    }

    public WebElement getCoursesMenu() {
        return coursesMenu;
    }

    public List<WebElement> getFoundItems() {
        return foundItems;
    }

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(ConfigProvider.BASE_URL);
        ensureOpen();
    }

    @Override
    public void ensureOpen() {
        waitUntilElementIsVisible(super.driver, logo);
    }

    public String[] getItemsText() {
        String[] itemsText = new String[getFoundItems().size()];
        for (int i = 0; i < getFoundItems().size(); i++) {
            itemsText[i] = getFoundItems().get(i).getText();
        }
        return itemsText;
    }


}
