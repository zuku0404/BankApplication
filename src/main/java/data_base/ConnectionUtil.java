package data_base;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/aplikaBankowaa", "sa", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
