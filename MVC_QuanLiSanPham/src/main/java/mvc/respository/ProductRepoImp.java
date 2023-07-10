package mvc.respository;

import mvc.model.Product;

import java.util.*;

public class ProductRepoImp implements ProductRepo{
    private static Map<Integer,Product>productMap;
    static {
        productMap=new HashMap<>();
        productMap.put(1,new Product(1,"Tivi",12000,"Tot","Sony"));
        productMap.put(2,new Product(2,"Tivi",12000,"Toot","Sony"));
        productMap.put(3,new Product(3,"Tivi",12000,"Te","Sony"));
        productMap.put(4,new Product(4,"Tivi",12000,"Tot","Sony"));
        productMap.put(5,new Product(5,"quan",12000,"Tot","Sony"));
    }
    @Override
    public List<Product> display() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void add(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public boolean edit(Product product) {
        if(productMap.containsKey(product.getId())){
            productMap.replace(product.getId(), product);
            return true;
        }else {
            return  false;
        }
    }

    @Override
    public void delete(String name) {
        Iterator<Map.Entry<Integer, Product>> iterator = productMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Product> entry = iterator.next();
            Product product = entry.getValue();
            if (product.getName().equals(name)) {
                iterator.remove();
                break;
            }
        }

        System.out.println(productMap.values());
    }

    @Override
    public Product findName(String name) {
        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            Product product = entry.getValue();
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product findId(int id) {
            return productMap.get(id);
        }
}
