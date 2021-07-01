package com.ithillel.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.ithillel.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.ithillel.utils.WaitUtils.waitUntilElementIsVisible;


public class HomePage extends Page {


    private SelenideElement logo = $("div.section-content > div > svg");

    private SelenideElement coursesMenu = $("ul.site-nav-menu_list > li:nth-child(2)");

    private SelenideElement coursesSearchField = $("#coursesMenuSearchField > input");

    @FindBy(css = "")
    private ElementsCollection foundItems = $$(".search-panel_screen.-result > div > ul > li > a > div > p");


    public SelenideElement getCoursesSearchField() {
        return coursesSearchField;
    }

    public SelenideElement getCoursesMenu() {
        return coursesMenu;
    }

    public ElementsCollection getFoundItems() {
        return foundItems;
    }


    @Override
    public void open() {
        Selenide.open("/");
        ensureOpen();
    }

    @Override
    public void ensureOpen() {
        logo.shouldBe(Condition.visible);
    }

    public String[] getItemsText() {
        String[] itemsText = new String[getFoundItems().size()];
        for (int i = 0; i < getFoundItems().size(); i++) {
            itemsText[i] = getFoundItems().get(i).getText();
        }
        return itemsText;
    }
}
