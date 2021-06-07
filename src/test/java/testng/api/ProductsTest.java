package testng.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ithillel.api.ApiClient;
import com.ithillel.api.models.Product;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static com.ithillel.api.ApiClient.SUCCESS;
import static com.ithillel.utils.DataProvider.getRandomString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

@Slf4j
public class ProductsTest {

    private ApiClient apiClient = new ApiClient();


    @SneakyThrows
    @Test
    public void createProduct() {
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(new File("src/test/resources/product.json"), Product.class);
        System.out.println(objectMapper.writeValueAsString(product));
        product.setName(getRandomString());
        log.debug(product.getName());
        // Category category = new Category();
        // category.setName("SUPER");
        // category.setLocation("location");
        // product.setCategory(category);
        // product.setManufacturer("VENDOR");
        apiClient.post("/products/new", product);
        Product createdProduct = apiClient.get("/products/" + product.getName()).getObject(".", Product.class);
        assertThat(product).isEqualTo(createdProduct);
    }

    @Test
    public void productsListTest() {
        List<Product> products = apiClient.get("/products")
                .getList(".", Product.class);
        assertThat(products).allMatch(p -> p.getCategory() != null);
    }

    @Test
    public void checkProductId() {
        apiClient.request()
                .get("/products")
                .then()
                .statusCode(SUCCESS)
                .body("category.id", everyItem(is(not(0))));
    }
}