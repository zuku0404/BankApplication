package data_base;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

    private ConnectionUtil(){}
    private static String url = "jdbc:h2:~/aplikaBankowaa";
    private static String user = "sa";
    private static String password = "";

    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
