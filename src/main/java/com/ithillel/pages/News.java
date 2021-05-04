package com.ithillel.pages;

import com.ithillel.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.ithillel.utils.WaitUtils.waitUntilElementIsVisible;

public class News extends Blog {


    @FindBy(xpath = "//li[contains(a, 'новости школы')]")
    private WebElement newsBtn;

    @FindBy(xpath = "//h1[text()='Новости школы']")
    private WebElement h1;

    @FindBy(css = ".tags__filter.tags__filter--theme.custom-dropdown")
    private WebElement listBtn;

    @FindBy(css = ".tags__filter.tags__filter--theme.custom-dropdown > div > span")
    private List<WebElement> coursesList;

    @FindBy(css = "div.tags__list-wrapper > ul > li")
    private List<WebElement> newsItems;

    private int newsActualCount;


    public News(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(ConfigProvider.BASE_BLOG_URL);
        newsBtn.click();
        ensureOpen();
    }

    @Override
    public void ensureOpen() {
        waitUntilElementIsVisible(super.driver, h1);
    }

    public void chooseCouse(String course) {
        listBtn.click();
        for (WebElement el : coursesList) {
            if (el.getText().equals(course)) {
                el.click();

                try {
                    Thread.sleep(1000);
                    // тут просто ждем пока произойдет рендер элементов,
                    // что бы не взялось случайно к-во из вкладки "Все"
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getActualCount() {
        newsActualCount = newsItems.size();
        System.out.println(newsActualCount);
        return newsActualCount;
    }
}
