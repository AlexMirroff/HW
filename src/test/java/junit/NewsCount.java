//package junit;
//
//import com.ithillel.pages.News;
//import junit.UITest;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;
//import org.junit.runners.Parameterized.Parameter;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RunWith(Parameterized.class)
//public class NewsCount extends UITest {
//
//    @Parameters(name = "course={0}, ExpectedCount={1}")
//    public static List<Object[]> data() {
//        return Arrays.asList(new Object[][]{
//                {"Front-End", 4},
//                {"QA", 3},
//                {"PM", 3},
//                {"Маркетинг", 7}
//        });
//    }
//
//    @Parameter
//    public String course;
//    @Parameter(1)
//    public int ExpectedCount;
//
//    @Test
//    public void CheckNewsCount() {
//        News news = new News(driver);
//        news.open();
//        news.chooseCouse(course);
//        Assert.assertEquals(ExpectedCount, news.getActualCount());
//    }
//}
