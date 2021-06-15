package testng.api;

import com.ithillel.api.models.User;
import com.ithillel.api.ApiClient;
import com.ithillel.pages.SwaggerHomePage;
import junit.UITest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class UsersTest extends UITest {

    private ApiClient apiClient = new ApiClient();


    private final User user1 = new User("userName156", true, "ROLE_USER", "GrfnonOBHRg");
    private final User user2 = new User("Кириллический пользователь", true, "ROLE_USER", "кириллический пароль");
    private final User user3 = new User("dfghr fg5h 41654hr4", true, "ROLE_ADMIN", "  654ghjk tfg6 ");
    private final User user4 = new User("4xfg651FD541s 5h", true, "ROLE_USER", "65xf46n54xf6g54");

    private final User user5 = new User("userName156", true, "ROLE_ADMIN", "invalid pass");
    private final User user6 = new User("4xfg6516541s 5h", false, "ROLE_USER", "65xf46n54xf6g54");
    private final User user7 = new User("", true, "ROLE_USER", "65xf46n54xf6g54");
    private final User user8 = new User("xgnxdfg", true, "", "dfbhdgnjf");
    private final User user9 = new User("ukfy41651", true, "fjmgfhj", "dfbhdgnjf");
    private final User user10 = new User("userName156", true, "ROLE_USER", "");


    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                {user1},
             //   {user2},
                {user3},
                {user4}
        };
    }

    @DataProvider
    public Object[][] invalidData() {
        return new Object[][]{
                {user5},
                {user6},
                {user7},
                {user8},
                {user9},
                {user10}
        };
    }

    @Test(dataProvider = "validData", priority = 1, groups = {"api"})
    public void createUser(User user) {
        apiClient.post("/users/new", user);
        User createdUser = apiClient.get("/users/" + user.getUsername()).getObject(".", User.class);
        assertThat(user).isEqualTo(createdUser);
    }

    @Test(dataProvider = "validData", priority = 2, groups = {"api"}, dependsOnMethods = "createUser")
    public void authCreatedUsers(User user) {
        SwaggerHomePage swaggerHomePage = new SwaggerHomePage(driver);
        swaggerHomePage.open();
        swaggerHomePage
                .getUsernameField()
                .sendKeys(user.getUsername());
        swaggerHomePage
                .getPassField()
                .sendKeys(user.getPassword());
        swaggerHomePage.getSingInBtn().click();
        driver.manage().deleteAllCookies();
        assertThat(swaggerHomePage.getSwaggerUI_Btn().isDisplayed()).isTrue();
    }

    @Test(dataProvider = "invalidData", priority = 3, groups = {"api"})
    public void authInvalidCredentials(User user) {
        SwaggerHomePage swaggerHomePage = new SwaggerHomePage(driver);
        swaggerHomePage.open();
        swaggerHomePage
                .getUsernameField()
                .sendKeys(user.getUsername());
        swaggerHomePage
                .getPassField()
                .sendKeys(user.getPassword());
        swaggerHomePage.getSingInBtn().click();
        driver.manage().deleteAllCookies();
        assertThat(swaggerHomePage.getH2().isDisplayed()).isTrue();
    }

    @Test(dataProvider = "validData", priority = 4, groups = {"api"})
    public void deleteCreatedUsers(User user) {
        apiClient.delete("/users/rm/" + user.getUsername());
        String response = apiClient.getNonExistent("/users/" + user.getUsername());
        assertThat(response).isEmpty();
    }
}
