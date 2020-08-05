import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class AccounDataRecorderDB {
    public void sendAccountDateToServer(User user) {
        {
            String userData = "Insert into account values (?,?,?,?,?)";
            Connection connection = Connect.createConnect();
            try {
                PreparedStatement ps = connection.prepareStatement(userData);
                ps.setString(1, Long.toString(user.getPesel().getNumber()));
                ps.setString(2, user.getPassword());
                ps.setDouble(3, user.getAccount().getCash());
                ps.setString(4, user.getAccount().getNumber());
                ps.setString(5, user.getLogin());
                ps.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
