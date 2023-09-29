package codegym.vn.mvcdemo.validate;

import codegym.vn.mvcdemo.model.Product;
import codegym.vn.mvcdemo.service.ProductService;
import codegym.vn.mvcdemo.service.ProductServiceImpl;

public class ProductValidate {
    private ProductService service = new ProductServiceImpl();
    public String validateId(String id) {
        try {
            int temp = Integer.parseInt(id);
            if (temp < 0) {
                return "Id phải lớn hơn 0";
            }
        } catch (Exception e) {
            return "Id phải là số nguyên";
        }
        Product product = service.findById(Integer.parseInt(id));
        if (product != null) {
            return "Id đã tồn tại trong DB";
        }
        return null;
    }
}
