import com.thulerproducts.dao.ProductDAO;
import com.thulerproducts.models.Product;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        Product p = new Product();
        p.setName("Camiseta São Paulo");
        p.setDescription("Camiseta São Paulo 2024 - P");
        p.setValue(new BigDecimal(339));

        Product p2 = new Product();
        p2.setName("Casaco São Paulo");
        p2.setDescription("Casaco Corta Vento São Paulo 2023 - P");
        p2.setValue(new BigDecimal(219.99));

        Product p3 = new Product();
        p3.setName("Regata São Paulo");
        p3.setDescription("Regata São Paulo 2023 Basquete - P");
        p3.setValue(new BigDecimal(119.99));

        dao.insert(p);
        dao.insert(p2);
        dao.insert(p3);

    }

}
