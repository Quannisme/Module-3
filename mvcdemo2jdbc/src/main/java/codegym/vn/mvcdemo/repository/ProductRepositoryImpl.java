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
}
