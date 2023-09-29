package codegym.vn.mvcdemo.repository;

import codegym.vn.mvcdemo.model.Category;
import codegym.vn.mvcdemo.model.Product;
import codegym.vn.mvcdemo.util.Constants;
import codegym.vn.mvcdemo.util.DatabaseConnection;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {
    private CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    @Override
    public void add(Product product) {
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.CREATE_PRODUCT);
                ){
            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getQuantity());
            statement.setLong(4, product.getPrice());
            statement.setDate(5, new Date(product.getDateRelease().getTime()));
            statement.setInt(6, product.getCategory().getId());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addList(List<Product> products) {
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.CREATE_PRODUCT);
            connection.setAutoCommit(false);
            for (Product product: products) {
                statement.setInt(1, product.getId());
                statement.setString(2, product.getName());
                statement.setInt(3, product.getQuantity());
                statement.setLong(4, product.getPrice());
                statement.setDate(5, new Date(product.getDateRelease().getTime()));
                statement.setInt(6, product.getCategory().getId());
                statement.executeUpdate();
            }
            connection.commit();
        } catch (ClassNotFoundException|SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void delete(Product product) {
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.DELETE_PRODUCT_BY_ID);
        ){
            statement.setInt(1, product.getId());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.FIND_PRODUCT_BY_ID);
        ){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                long price = resultSet.getLong("price");
                java.util.Date dateRelease = new java.util.Date(resultSet.getDate("date_release").getTime());
                int categoryId = resultSet.getInt("category_id");
                Category category = categoryRepository.findById(categoryId);
                product = new Product(id, name, quantity, price, dateRelease, category);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void update(Product product) {
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_PRODUCT);
        ){
            statement.setInt(6, product.getId());
            statement.setString(1, product.getName());
            statement.setInt(2, product.getQuantity());
            statement.setLong(3, product.getPrice());
            statement.setDate(4, new Date(product.getDateRelease().getTime()));
            statement.setInt(5, product.getCategory().getId());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.FIND_ALL_PRODUCT);
        ){
            ResultSet resultSet = statement.executeQuery();
            Product product;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                long price = resultSet.getLong("price");
                java.util.Date dateRelease = new java.util.Date(resultSet.getDate("date_release").getTime());
                int categoryId = resultSet.getInt("category_id");
                Category category = categoryRepository.findById(categoryId);
                product = new Product(id, name, quantity, price, dateRelease, category);
                products.add(product);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public List<Product> searchByName(String productName) {
        List<Product> products = new ArrayList<>();
        try (
                Connection connection = DatabaseConnection.getConnection();
                CallableStatement statement = connection.prepareCall(Constants.SEARCH_PRODUCT_BY_STORE_PROCEDURE);
                ){
            statement.setString(1, "%" + productName + "%");
            statement.registerOutParameter(2, Types.INTEGER);
            ResultSet resultSet = statement.executeQuery();
            int count = statement.getInt(2);
            System.out.println("Count: " + count);
            Product product;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                long price = resultSet.getLong("price");
                java.util.Date dateRelease = new java.util.Date(resultSet.getDate("date_release").getTime());
                int categoryId = resultSet.getInt("category_id");
                Category category = categoryRepository.findById(categoryId);
                product = new Product(id, name, quantity, price, dateRelease, category);
                products.add(product);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    @Override
    public void deleteAllByIds(String[] ids) {
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.DELETE_PRODUCT_BY_ID);
            connection.setAutoCommit(false);
            for (String id: ids) {
                statement.setInt(1, Integer.parseInt(id));
                statement.executeUpdate();
            }
            connection.commit();
        } catch (ClassNotFoundException|SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public List<Product> findAllWithPaging(int page, int record) {
        List<Product> products = new ArrayList<>();
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.FIND_ALL_PRODUCT_PAGING);
        ){
            statement.setInt(1, record);
            statement.setInt(2, (page - 1) * record);
            ResultSet resultSet = statement.executeQuery();
            Product product;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                long price = resultSet.getLong("price");
                java.util.Date dateRelease = new java.util.Date(resultSet.getDate("date_release").getTime());
                int categoryId = resultSet.getInt("category_id");
                Category category = categoryRepository.findById(categoryId);
                product = new Product(id, name, quantity, price, dateRelease, category);
                products.add(product);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public int countAllProduct() {
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.COUNT_ALL_PRODUCT);
        ){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
