package codegym.vn.mvcdemo.service;

import codegym.vn.mvcdemo.model.Product;
import codegym.vn.mvcdemo.repository.ProductRepository;
import codegym.vn.mvcdemo.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository repository = new ProductRepositoryImpl();
    @Override
    public void add(Product product) {
        repository.add(product);
    }

    @Override
    public void addList(List<Product> products) {
        repository.addList(products);
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(Product product) {
        repository.update(product);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> searchByName(String name) {
        return repository.searchByName(name);
    }

    @Override
    public void deleteAllByIds(String[] ids) {
        repository.deleteAllByIds(ids);
    }

    @Override
    public List<Product> findAllWithPaging(int page, int record) {
        return repository.findAllWithPaging(page, record);
    }

    @Override
    public int countAllProduct() {
        return repository.countAllProduct();
    }
}
