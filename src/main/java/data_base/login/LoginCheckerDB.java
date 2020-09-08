package data_base.login;

import data_base.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCheckerDB {
    public int checkLogin(String login) {
        String downloadLogs = " SELECT id from users WHERE login = ? ";
        Connection connection = ConnectionUtil.createConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(downloadLogs);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
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
        return 0;
    }
}
