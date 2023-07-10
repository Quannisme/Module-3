package mvc.respository;

import mvc.model.Product;

import java.util.List;

public interface ProductRepo {
    List<Product>display();
    void add(Product product);
    boolean edit(Product product);
    void delete(String name);
    Product findName(String name);
    Product findId(int id);
}
