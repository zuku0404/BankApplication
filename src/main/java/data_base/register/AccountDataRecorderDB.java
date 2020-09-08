package data_base.register;

import account.User;
import data_base.ConnectionUtil;

import java.sql.*;

public class AccountDataRecorderDB {
    public void sendAccountDateToServer(User user) {
        {
            String userData = "Insert into account (PASSWORD) values (?)";
            Connection connection = ConnectionUtil.createConnection();
            try {

                PreparedStatement ps = connection.prepareStatement(userData, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getPassword());
                ps.addBatch();
                ps.executeBatch();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();

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
