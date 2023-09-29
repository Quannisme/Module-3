package code.utill;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static String jdbcURL =
            "jdbc:mysql://localhost:3306/final2?useSSL=false";
    private static String username = "root";
    private static String password = "123456";
    public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
        java.sql.Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL,
                username, password);
        System.out.println(connection);
        System.out.println("oke");
        return connection;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        getConnection();
    }
}
