import com.ithillel.driver.WebDriverFactory;
import com.ithillel.utils.ConfigProvider;
import com.ithillel.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class GetTeachersList {


    public static void main(String[] args) {


        WebDriver driver = new WebDriverFactory().getDriver();

        driver.get(ConfigProvider.BASE_URL);

        driver.findElement(By.cssSelector("#coursesMenuDesktopTrigger")).click();
        driver.findElement(By.cssSelector("#coursesMenuControlPanel > ul > li:nth-child(2) > button")).click();
        driver.findElement(By.cssSelector("div.courses-nav-screen.-subcats.-active > div > ul > li:nth-child(1) > button")).click();
        driver.findElement(By.cssSelector("ul.courses-nav-list.-active > li:nth-child(1) > div > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("#coursesMenuDesktopTrigger")).click();
        driver.findElement(By.cssSelector("h2")).click(); // просто кликаем на заголовок чтобы свернуть меню которое может быть открыто


        int scrooledPixels = 0;
        Object windowHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");  //берем высоту страницы в пикселях
        int windowHeightInt = ((Number) windowHeight).intValue(); // приводим обьект который вернул js к int

        do {
            try {
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
                WebElement element = driver.findElement(By.cssSelector("#swiper-coaches"));
                WebDriverWait wait = new WebDriverWait(driver, 2);
                wait.until(ExpectedConditions.visibilityOf(element));
                if (element != null) {
                    break;                  // выходим из цикла если нашли блок с учетелями
                }
            } catch (NoSuchElementException | TimeoutException e) {   //NoSuchElementException падает все же и теперь могу словить и обработать, хотя раньше неловился
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)");  // если не нашли, то скролим на 800 пикселей
                scrooledPixels += 800;
            }
        } while (scrooledPixels <= windowHeightInt);  // выходим из цикла когда доскролим до конца страницы

        List<WebElement> teachers = driver.findElements(By.cssSelector("span.coach-card_name"));

        for (WebElement el : teachers) {
            System.out.println(el.getAttribute("textContent"));
        }
    }
}

