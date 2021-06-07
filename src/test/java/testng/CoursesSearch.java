package testng;


import com.ithillel.pages.HomePage;
import junit.UITest;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;


@Slf4j
public class CoursesSearch extends UITest {

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"front end", new String[]{"Front-end Pro", "Front-End Basic", "ІТ Recruitment"}},
                {"qa", new String[]{"QA Automation", "QA Manual", "QA Automation — Python", "Сертификация ISTQB для тестировщиков"}},
                {"java", new String[]{"Java Elementary", "Introduction Java", "Java Enterprise"}},
                {"frontend", new String[]{"Front-End Basic"}},
                {"дизайн", new String[]{"Основы дизайна", "UI/UX Design"}}
        };
    }

    @Test
    public void homePageOpen() {

        HomePage homePage = new HomePage(driver);
        log.debug("Opening homepage...");
        homePage.open();
        Assert.assertTrue(homePage.getCoursesMenu().isDisplayed());
        log.debug("Homepage opened");
    }

    @Test(dependsOnMethods = "homePageOpen", dataProvider = "data")
    public void courseSearch(String input, String[] expectedItemsText) {
        HomePage homePage = new HomePage(driver);
        log.debug("Input: \"" + input + "\"\tExpected result: " + Arrays.asList(expectedItemsText));
        homePage.getCoursesMenu().click();
        homePage.getCoursesSearchField().clear();
        homePage.getCoursesSearchField().sendKeys(input);


        for (int i = 1; i <= 300; i++) {  // если к-во найденных результатов равно ожидаемым выходим из цыкла
            if (homePage.getFoundItems().size() == expectedItemsText.length) break;
            else {
                if (i < 300) {
                    try {
                        Thread.sleep(100); // если не равно, то ждем в течении 30 сек, проверяя через каждые 0,1 сек
                    } catch (InterruptedException e) {
                    }
                } else {
                    //не нашли ожидаемое к-во в течении 30 сек и тут получим AssertionError
                    Assert.assertEquals(homePage.getFoundItems().size(), Integer.parseInt(expectedItemsText[0]));
                }
            }
        }
        String[] itemsText = homePage.getItemsText();
        homePage.getCoursesMenu().click(); // закрываем меню чтобы вернуться в исходное состояние
        for (int i = 0; i < itemsText.length; i++) {
            Assert.assertEquals(itemsText[i], expectedItemsText[i]);
        }
        log.debug("Actual result: " + Arrays.asList(itemsText));
    }
}
