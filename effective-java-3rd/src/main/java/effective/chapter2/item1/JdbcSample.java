package effective.chapter2.item1;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class JdbcSample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        Connection connection =
                DriverManager.getConnection("url", "root", "root");
    }
}
