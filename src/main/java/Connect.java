import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    public static Connection createConnect() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/aplikaBankowa", "sa", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
