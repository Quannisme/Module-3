package codegym.vn.mvcdemo.util;

public class Constants {
    public static final String FIND_ALL_CATEGORY = "Select * from category";
    public static final String FIND_CATEGORY_BY_ID = "Select * from category " +
            "where id = ?";
    public static final String FIND_ALL_PRODUCT = "select * from product";
    public static final String FIND_ALL_PRODUCT_PAGING = "select * from product LIMIT ? OFFSET ?";
    public static final String FIND_PRODUCT_BY_ID = "select * from product where id = ?";
    public static final String CREATE_PRODUCT = "insert into product values(?,?,?,?,?,?)";
    public static final String UPDATE_PRODUCT = "update product set name = ?, quantity = ?," +
            "price = ?, date_release = ?, category_id = ? where id = ?";
    public static final String DELETE_PRODUCT_BY_ID = "delete from product where id = ?";
    public static final String SEARCH_PRODUCT_BY_STORE_PROCEDURE = "{call findProduct(?, ?)}";
    public static final String COUNT_ALL_PRODUCT = "Select count(1) from Product";
}