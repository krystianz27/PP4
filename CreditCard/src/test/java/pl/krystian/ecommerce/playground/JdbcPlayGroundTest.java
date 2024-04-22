package pl.krystian.ecommerce.playground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.krystian.ecommerce.catalog.Product;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class JdbcPlayGroundTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void itSetupDB() {
        var dropTableIfExists = "DROP TABLE `product_catalog__products` IF EXISTS";
        jdbcTemplate.execute(dropTableIfExists);

        var createTableSql = "CREATE TABLE `product_catalog__products` (" +
                "`id` varchar(255) NOT NULL," +
                "`name` varchar(255) NOT NULL," +
                "`price` DECIMAL(12,2)," +
                "PRIMARY KEY (id)" +
                ");";

        jdbcTemplate.execute(createTableSql);
    }

    @Test
    void selectMyNameViaDB() {
        var date = jdbcTemplate.queryForObject(
                "select now() my_date",
                String.class
        );
        assert  date.contains("2024");
    }

    @Test
    void itCreatesTable() {
        var dropTableIfExists = "DROP TABLE `product_catalog__products` IF EXISTS";
        jdbcTemplate.execute(dropTableIfExists);

        var createTableSql = "CREATE TABLE `product_catalog__products` (" +
                "`id` varchar(255) NOT NULL," +
                "`name` varchar(255) NOT NULL," +
                "`price` DECIMAL(12,2)," +
                "PRIMARY KEY (id)" +
                ")";

        jdbcTemplate.execute(createTableSql);
    }

    @Test
    void itCountsProductsWhenNoProducts() {
        var countSql= "select count(*) from `product_catalog__products`";
        int productsCount = jdbcTemplate.queryForObject(countSql, Integer.class);

        assertThat(productsCount).isEqualTo(0);
    }

    @Test
    void itAllowsToInsertElement() {
        var insertSql = "INSERT INTO `product_catalog__products` (id, name, price) " +
                "VALUES " +
                "()";
        jdbcTemplate.execute(insertSql);

    }
    @Test
    void itAllowsToInsertDynamicElements() {
        var insertSql = "INSERT INTO `product_catalog__products` (id, name, price) " +
                "VALUES " +
                "(?, ?, ?)";

        var product = new Product(UUID.randomUUID(), "Product1", "Desc1");
        product.changePrice(BigDecimal.TEN);

        jdbcTemplate.update(insertSql, product.getId(), product.getName(), product.getPrice());

        var countSql= "select count(*) from `product_catalog__products`";
        int productsCount = jdbcTemplate.queryForObject(countSql, Integer.class);

        assertThat(productsCount).isEqualTo(1);
    }


    @Test
    void selectForProducts(){
        var insertSql = "INSERT INTO `product_catalog__products` (id, name, price) " +
                "VALUES " +
                "(?, ?, ?)";
        jdbcTemplate.execute(insertSql);

        var selectSql = "SELECT * from `product_catalog__products` where id = ?";

        Product myProduct = jdbcTemplate.queryForObject(
                selectSql,
                new Object[]{"product_1"},
                (rs, i) -> {
                    var myResult = new Product(
                            UUID.randomUUID(),
                            rs.getString("name"),
                            rs.getString("name")
                    );
                    myResult.changePrice(BigDecimal.valueOf(rs.getDouble("price")));

                    return myResult;
                }
        );

        assertThat(myProduct.getName()).isEqualTo("Product1");
    }
}
