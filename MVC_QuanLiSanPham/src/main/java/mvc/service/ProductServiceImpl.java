package mvc.service;

import mvc.model.Product;
import mvc.respository.ProductRepo;
import mvc.respository.ProductRepoImp;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductRepo repo=new ProductRepoImp();
    @Override
    public List<Product> display() {
        return repo.display();
    }

    @Override
    public void add(Product product) {
        repo.add(product);
    }

    @Override
    public boolean edit(Product product) {
        return repo.edit(product);
    }

    @Override
    public void delete(String name) {
        repo.delete(name);
    }

    @Override
    public Product findName(String name) {
        return repo.findName(name);
    }

    @Override
    public Product findId(int id) {
        return repo.findId(id);
    }
}
