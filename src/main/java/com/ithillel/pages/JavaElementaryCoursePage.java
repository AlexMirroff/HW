//package com.ithillel.pages;
//
//import com.ithillel.utils.ConfigProvider;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import java.util.List;
//import static com.ithillel.utils.WaitUtils.waitUntilElementIsVisible;
//
//public class JavaElementaryCoursePage extends CoursePage {
//
//    private static final String COURSE_TITLE_XPATH="//span[@class='course-descriptor_header-text']/strong";
//    private static final String COURSE_RATE_XPATH="//span[@class='course-rating_average']";
//    private static final String COURSE_DESCRIPTION_XPATH="//p[@class='course-description_p']";
//    private static final String COURSE_GOALS_XPATH="//ul[@class='unordered-list -extra-margin']/li";
//
//
//
//    public JavaElementaryCoursePage(WebDriver driver) {
//        super(driver);
//    }
//
//    @Override
//    public void open() {
//        super.driver.get(ConfigProvider.BASE_URL + "courses/java-elementary-kiev");
//        ensureOpen();
//    }
//
//    @Override
//    public void ensureOpen() {
//        WebElement el = driver.findElement(By.xpath("//h1[@class='course-descriptor_header']"));
//        waitUntilElementIsVisible(super.driver, el);
//    }
//
//    @Override
//    public String getCourseTitle() {
//        return driver.findElement(By.xpath(COURSE_TITLE_XPATH)).getText();
//    }
//
//    @Override
//    public String getCourseRate() {
//        String courseRate = driver.findElement(By.xpath(COURSE_RATE_XPATH)).getText();
//        courseRate = courseRate.replace("\"", "").trim();
//        return courseRate;
//    }
//
//    @Override
//    public String getCourseDescription() {
//        String courseDescription = driver.findElement(By.xpath(COURSE_DESCRIPTION_XPATH)).getText();
//        courseDescription = courseDescription.replace("\"", "").trim();
//        return courseDescription;
//    }
//
//    @Override
//    public String[] getCourseGoals() {
//        List<WebElement> elements = driver.findElements(By.xpath(COURSE_GOALS_XPATH));
//        String[] courseGoals = new String[elements.size()];
//        for (int i = 0; i < elements.size(); i++) {
//            courseGoals[i] = elements.get(i).getText();
//            courseGoals[i] = courseGoals[i].replace("\"", "").trim();
//        }
//        return courseGoals;
//    }
//}
