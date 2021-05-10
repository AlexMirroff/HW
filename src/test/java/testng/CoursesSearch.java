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
                {"front end", new String[]{"3", "Front-End Pro", "Front-End Basic", "ІТ Recruitment"}},
                {"qa", new String[]{"4", "QA Automation", "QA Manual", "QA Automation — Python", "Сертификация ISTQB для тестировщиков"}},
                {"java", new String[]{"3", "Java Elementary", "Introduction Java", "Java Enterprise"}},
                {"frontend", new String[]{"1", "Front-End Basic"}},
                {"дизайн", new String[]{"2", "Основы дизайна", "UI/UX Design"}}
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

        int wait = 100;

        while (true) {  // если к-во найденных результатов равно ожидаемым выходим из цыкла
            if (homePage.getFoundItems().size() == Integer.parseInt(expectedItemsText[0])) break;
            else {
                if (wait <= 30000) {
                    try {
                        Thread.sleep(wait); // если не равно, то ждем в течении 30 сек, проверяя через каждые 0,1 сек
                    } catch (InterruptedException e) {
                    }
                    wait += 100;
                } else {
                    //не нашли ожидаемое к-во в течении 30 сек и тут получим AssertionError
                    Assert.assertEquals(homePage.getFoundItems().size(), Integer.parseInt(expectedItemsText[0]));
                }
            }
        }
        String[] itemsText = homePage.getItemsText();
        for (int i = 0; i < itemsText.length; i++) {
            Assert.assertEquals(itemsText[i], expectedItemsText[i + 1]);
        }
        log.debug("Actual result: " + Arrays.asList(itemsText));
        homePage.getCoursesMenu().click(); // закрываем меню чтобы вернуться в исходное состояние
    }
}
